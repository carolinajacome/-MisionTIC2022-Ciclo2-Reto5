package co.edu.utp.misiontic2022.c2.cjacome.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.cjacome.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.c2.cjacome.util.JDBCUtilities;


public class ProyectoBancoDao {
    
    public List<ProyectoBancoVo> consultarproyectosFinanciadosPorBanco(String banco) throws SQLException {
        List<ProyectoBancoVo> respuesta = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            var query ="SELECT p.ID_Proyecto ID, p.Constructora, p.Ciudad, p.Clasificacion,t.Estrato, l.Nombre||' '||l.Primer_Apellido||' '|| l.Segundo_Apellido LIDER"
            + " FROM Proyecto p "
            + " join Tipo t ON (p.ID_Tipo= t.ID_Tipo)"
            + " join Lider l ON (p.ID_Lider= l.ID_Lider)"
            + " WHERE p.Banco_Vinculado =(?)"
            + " ORDER BY p.Fecha_Inicio DESC, Ciudad ASC ,Constructora";
             
            stmt = conn.prepareStatement(query);
            stmt.setString(1, banco);
            rset = stmt.executeQuery();

            while(rset.next()){
                var vo = new ProyectoBancoVo();
                vo.setID_Proyecto(rset.getInt("ID"));
                vo.setConstructora(rset.getString("Constructora"));
                vo.setClasificacion(rset.getString("Clasificacion"));
                vo.setCiudad(rset.getString("Ciudad"));
                vo.setEstrato(rset.getInt("Estrato"));
                vo.setLider(rset.getString("Lider"));
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

    public List<String> nombreBancos() throws SQLException{
        var listaBancos = new ArrayList<String>();
        
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try {
            
            var query = "SELECT Banco_Vinculado BANCO"
                    +" FROM proyecto p"
                    +" GROUP BY Banco_Vinculado";
            
            stmt = conn.prepareStatement(query);
            rset = stmt.executeQuery();
            
            while(rset.next()){
                var banco = rset.getString("BANCO");
                
                listaBancos.add(banco);
            }
            
            
        }finally {
            
            if(rset != null){
                rset.close();
            }
            
            if(stmt != null){
                stmt.close();
            }
            
            if(conn != null){
                conn.close();
            }
            
        }
        
        
        
        return listaBancos;
    }
}
