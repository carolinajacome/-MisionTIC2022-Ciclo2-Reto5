package co.edu.utp.misiontic2022.c2.cjacome.controller;

import java.sql.SQLException;

import java.util.List;

import co.edu.utp.misiontic2022.c2.cjacome.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.c2.cjacome.model.dao.DeudasPorProyectoDao;
import co.edu.utp.misiontic2022.c2.cjacome.model.dao.ProyectoBancoDao;

import co.edu.utp.misiontic2022.c2.cjacome.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.c2.cjacome.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.cjacome.model.vo.DeudasPorProyectoVo;


//CONTROLADOR:
    

public class ReportesController {
    private  ProyectoBancoDao requerimiento_1Dao;
    private DeudasPorProyectoDao requerimiento_2Dao;
    private   ComprasDeLiderDao requerimiento_3Dao;
 
 public ReportesController(){
 
     this.requerimiento_1Dao= new ProyectoBancoDao();
     this.requerimiento_2Dao= new DeudasPorProyectoDao();
     this.requerimiento_3Dao= new ComprasDeLiderDao();

 }
 
 public List<ProyectoBancoVo> consultarproyectosFinanciadosPorBanco(String banco) throws SQLException{
     return this.requerimiento_1Dao.consultarproyectosFinanciadosPorBanco( banco);
 }
 
 public List<DeudasPorProyectoVo> consultarDeudasPorProyecto(double limiteinferior, String order, String form) throws SQLException{
     return this.requerimiento_2Dao.totalAdeudadoPorProyectosSuperioresALimite(limiteinferior, order, form);
 }

 public List <ComprasDeLiderVo> listarProyectosLideresQuemasgastan(int limite,String order, String form) throws SQLException{
    return requerimiento_3Dao.lideresQueMasGastan(limite, order, form);
}

}
