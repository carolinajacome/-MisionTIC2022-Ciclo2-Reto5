package co.edu.utp.misiontic2022.c2.cjacome.view;
import co.edu.utp.misiontic2022.c2.cjacome.model.vo.DeudasPorProyectoVo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ProyectosDeudoresTableModel extends AbstractTableModel  {
    private List<DeudasPorProyectoVo> deudas;

    public ProyectosDeudoresTableModel() {
        deudas = new ArrayList<DeudasPorProyectoVo>();
    }
    
    public void llenarLista(List<DeudasPorProyectoVo> lista){
        this.deudas = lista;
    }
    
    public DeudasPorProyectoVo getProyecto(int row){
        return deudas.get(row);
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           //case 0:
             //  return "ID";
           case 0:
               return "ID";
           case 1:
               return "Valor";
           default :
               return "";
       }
       
    }
    
    @Override
    public int getRowCount() {
        return deudas.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var informacion = deudas.get(row);

        switch (column) {
            //case 0:
              //  return informacion.getID();
            case 0:
                return informacion.getID();
            case 1:
                return informacion.getValor();
            default:
                return "";

        }
    }   
}
