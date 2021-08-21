package co.edu.utp.misiontic2022.c2.cjacome.view;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import co.edu.utp.misiontic2022.c2.cjacome.model.vo.ComprasDeLiderVo;

public class GastosTableModel extends AbstractTableModel  {
    private List<ComprasDeLiderVo> compras;
    
    public GastosTableModel(){
        compras = new ArrayList<ComprasDeLiderVo>();
    }
    
    
     public void llenarLista(List<ComprasDeLiderVo> lista){
        this.compras = lista;
    }
    
    public ComprasDeLiderVo getProyecto(int row){
        return compras.get(row);
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
          // case 0:
            //   return "ID";
           case 0:
               return "Valor";
           case 1:
               return "Lider";
           default :
               return "";
       }
       
    }

    @Override
    public int getRowCount() {
        return compras.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var informacion = compras.get(row);

        switch (column) {
//case 0:
  //              return informacion.getID();
            case 0:
                return informacion.getValor();
            case 1:
                return informacion.getLider();
            default:
                return "";

        }
    }   
}
