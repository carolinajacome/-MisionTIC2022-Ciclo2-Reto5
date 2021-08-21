package co.edu.utp.misiontic2022.c2.cjacome.model.vo;

public class ComprasDeLiderVo {
    
        private String Lider;
        private Double Valor;
        private String ID;
       public String getLider() {
            return Lider;
        }

        public void setLider(String lider) {
            Lider = lider;
        }

        public Double getValor() {
            return Valor;
        }

        public void setValor(Double valor) {
            Valor = valor;
        }


        public String getID() {
            return ID;
        }
    
        public void setID(String ID) {
            this.ID = ID;
        }
        @Override
        public String toString() {
            return "ComprasDeLiderVo [Lider=" + Lider + ", Valor=" + Valor + "]";
        }
        
        
        
}
