package co.edu.utp.misiontic2022.c2.cjacome.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import co.edu.utp.misiontic2022.c2.cjacome.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.cjacome.util.JDBCUtilities;


public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> totalAdeudadoPorProyectosSuperioresALimite(double limiteinferior, String order, String form) throws SQLException {
        List<DeudasPorProyectoVo> respuesta = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            var query ="SELECT c.ID_Proyecto ID, sum(mc.Precio_Unidad*c.Cantidad) VALOR"
            + " FROM Compra c  "
            + " join MaterialConstruccion mc on (c.ID_MaterialConstruccion)=mc.ID_MaterialConstruccion "
            + " JOIN Proyecto p ON (c.ID_Proyecto= p.ID_Proyecto)"
            + " WHERE (c.Pagado='No') "
            + " GROUP BY c.ID_Proyecto "
            + " HAVING  sum(mc.Precio_Unidad*c.Cantidad)>? "
            + " ORDER BY VALOR Desc ";
             
            stmt = conn.prepareStatement(query);
            stmt.setDouble(1, limiteinferior);
            rset = stmt.executeQuery();
            while(rset.next()){
                var vo = new DeudasPorProyectoVo();
                vo.setID(rset.getInt("ID"));
                vo.setValor(rset.getDouble("VALOR"));
                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }  
}
