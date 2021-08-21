package co.edu.utp.misiontic2022.c2.cjacome.model.vo;

public class DeudasPorProyectoVo {
    
    private Integer ID;
    private Double Valor;
    private String lider;
   
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }
    public Double getValor() {
        return Valor;
    }
    public void setValor(Double valor) {
        Valor = valor;
    }
    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }
    @Override
    public String toString() {
        return "DeudasPorProyectoVo [ID=" + ID + ", Valor=" + Valor + "]";
    }
    

    
}
