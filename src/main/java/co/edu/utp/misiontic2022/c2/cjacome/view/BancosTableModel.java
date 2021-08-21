package co.edu.utp.misiontic2022.c2.cjacome.view;


import co.edu.utp.misiontic2022.c2.cjacome.model.vo.ProyectoBancoVo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BancosTableModel extends AbstractTableModel {
 
   

    
private List<ProyectoBancoVo> listaBancos;
    
        public BancosTableModel(List<ProyectoBancoVo> listaBancos) {
            this.listaBancos = listaBancos;
        }
    
        public void agregarInformacion(ProyectoBancoVo proyecto) {
            listaBancos.add(proyecto);
            fireTableDataChanged();
        }
        
        public ProyectoBancoVo cargarProyecto(int row){
            return listaBancos.get(row);
        }
    
        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Constructora";
                case 1:
                    return "Ciudad";
                case 2:
                    return "Clasificación";
                case 3:
                    return "Estrato";
                  case 4:
                    return "Líder";
    
            }
            return null;
        }
    
        @Override
        public int getRowCount() {
            return listaBancos.size();
        }
    
        @Override
        public int getColumnCount() {
            return 5;
        }
    
        @Override
        public Object getValueAt(int fila, int columna) {
            var informacion = listaBancos.get(fila);
    
            switch (columna) {
                case 0:
                    return informacion.getConstructora();
                case 1:
                    return informacion.getCiudad();
                case 2:
                    return informacion.getClasificacion();
                case 3:
                    return informacion.getEstrato();
                case 4:
                return informacion.getLider();
    
            }
            return "";
        }
     
    



}
