package co.edu.utp.misiontic2022.c2.cjacome;

import co.edu.utp.misiontic2022.c2.cjacome.model.dao.DeudasPorProyectoDao;
//import co.edu.utp.misiontic2022.c2.cjacome.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.cjacome.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.cjacome.view.ReportesView;
//import co.edu.utp.misiontic2022.c2.cjacome.model.dao.ProyectosDao;
//import co.edu.utp.misiontic2022.c2.cjacome.model.vo.ProyectosVo;
//import co.edu.utp.misiontic2022.c2.cjacome.view.ReportesView;


import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.cjacome.util.JDBCUtilities;
public class App 
{
    public static void main( String[] args )
    {
        var reportesview= new ReportesView();
        reportesview.proyectosFinanciadosPorBanco("Conavi");

        var view2 = new ReportesView();
        view2.totalAdeudadoPorProyectosSuperioresALimite(50_000d);

        var view3 = new ReportesView();
        view3.lideresQueMasGastan();
    }
}
