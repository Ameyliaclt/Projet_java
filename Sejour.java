impot java.util.*;

public class Sejour{
    Reservation rsrvt;
    public Sejour() {
         this.rsrvt = null;
          }

    public Sejour(Reservation rsrvt) {
         this.rsrvt = rsrvt; 
         }

    public Reservation getRsrvt() {
         return rsrvt; 
         } 

         public void setRsrvt(Reservation rsrvt) { 
        this.rsrvt = rsrvt; 
        }

    public Sejour add_sej() { 
        return new Sejour();
        } 

    public Conso_mb add_conso_mb() { 
        return new Conso_mb();
        }

    public float fct() { 
        return 0.0 ; 
        } 
}
        


