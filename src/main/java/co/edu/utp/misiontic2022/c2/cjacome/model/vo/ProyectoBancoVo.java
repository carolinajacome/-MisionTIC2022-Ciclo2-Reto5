package co.edu.utp.misiontic2022.c2.cjacome.model.vo;

public class ProyectoBancoVo {
   
    private Integer ID_Proyecto;
    private String Constructora;
    private String Ciudad;
    private String Clasificacion;
    private Integer Estrato;
    private String Lider;

   
    public Integer getID_Proyecto() {
        return ID_Proyecto;
    }
    public void setID_Proyecto(Integer iD_Proyecto) {
        ID_Proyecto = iD_Proyecto;
    }
    public String getConstructora() {
        return Constructora;
    }
    public void setConstructora(String constructora) {
        Constructora = constructora;
    }
    public String getCiudad() {
        return Ciudad;
    }
    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }
    public String getClasificacion() {
        return Clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        Clasificacion = clasificacion;
    }
    public Integer getEstrato() {
        return Estrato;
    }
    public void setEstrato(Integer estrato) {
        Estrato = estrato;
    }
    public String getLider() {
        return Lider;
    }
    public void setLider(String lider) {
        Lider = lider;
    }
    @Override
    public String toString() {
        return "ProyectoBancoVo [Ciudad=" + Ciudad + ", Clasificacion=" + Clasificacion + ", Constructora="
                + Constructora + ", Estrato=" + Estrato + ", ID_Proyecto=" + ID_Proyecto + ", Lider=" + Lider + "]";
    }
    


    
   
    
}
