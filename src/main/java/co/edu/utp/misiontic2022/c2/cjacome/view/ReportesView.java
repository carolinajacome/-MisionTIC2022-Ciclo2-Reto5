package co.edu.utp.misiontic2022.c2.cjacome.view;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic2022.c2.cjacome.controller.ReportesController;

import co.edu.utp.misiontic2022.c2.cjacome.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.cjacome.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.cjacome.model.vo.ProyectoBancoVo;

public class ReportesView {

    private String repitaCaracter(Character caracter, Integer veces) {
        var respuesta = "";
        for (int i = 0; i < veces; i++) {
        respuesta += caracter;
        }
        return respuesta;
        }  

public static  ReportesController controlador= new ReportesController();

public  void proyectosFinanciadosPorBanco(String banco) {
    try 
    {
        System.out.println(repitaCaracter('=', 6) + " LISTADO DE PROYECTOS POR BANCO "
        + repitaCaracter('=', 7));
        if (banco != null && !banco.isBlank()) {
        System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
        "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
        System.out.println(repitaCaracter('-', 105));
    List<ProyectoBancoVo> lista1 = controlador.consultarproyectosFinanciadosPorBanco(banco);

    for(ProyectoBancoVo reque :lista1){
         System.out.printf("%3d %-25s %-20s %-15s %7d %-30s %n",
        reque.getID_Proyecto(),
        reque.getConstructora(),
        reque.getCiudad(),
        reque.getClasificacion(),
        reque.getEstrato(),
        reque.getLider()
        );
    }
}
}catch (Exception e){
        System.out.println("Ha ocurrido un error"+ e.getMessage());
    }
}

public  void totalAdeudadoPorProyectosSuperioresALimite(Double limiteinferior){

    System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO " + repitaCaracter('=', 1));
    if (limiteinferior != null) {
        System.out.println(String.format("%3s %15s", "ID", "VALOR "));
        System.out.println(repitaCaracter('-', 29));

        try {
            var listaDeudas = controlador.consultarDeudasPorProyecto(limiteinferior,"","");

            for (DeudasPorProyectoVo proyecto : listaDeudas) {
                System.out.printf("%3d %,15.1f %n", proyecto.getID(), proyecto.getValor());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    /*try {  
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
        + repitaCaracter('=', 1));
       if (limiteinferior != null) {
        System.out.println(String.format("%3s %15s", "ID", "  VALOR "));
        System.out.println(repitaCaracter('-', 29));
    }

    
    List<DeudasPorProyectoVo> lista2 = controlador.consultarDeudasPorProyecto(double Limiteinferior);
      for(DeudasPorProyectoVo reque: lista2){
       System.out.printf("%3d %,15.1f %n",
        reque.getLider(),
        reque.getValor()
        );
        }
    }catch (Exception e){
        System.out.println("Ha ocurrido un error"+ e.getMessage());
        //e.printStackTrace();
    }

}
*/
public  void lideresQueMasGastan(){
    try {

        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
        + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "   VALOR "));
        System.out.println(repitaCaracter('-', 41));

        List<ComprasDeLiderVo> lista3 = controlador.listarProyectosLideresQuemasgastan(0, null, null);
        for(ComprasDeLiderVo reque: lista3){
            System.out.printf("%-25s %,15.1f %n",
      
        reque.getLider(),
        reque.getValor()
        );
        }
    }catch (Exception e){
        System.out.println("Ha ocurrido un error "+ e.getMessage());
    }

}
}

