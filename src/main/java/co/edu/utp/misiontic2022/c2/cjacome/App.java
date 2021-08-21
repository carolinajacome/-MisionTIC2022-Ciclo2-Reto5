package co.edu.utp.misiontic2022.c2.cjacome;


import co.edu.utp.misiontic2022.c2.cjacome.view.ReportesView;

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
