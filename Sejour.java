import java.util.*;
import java.lang.*;

public class Sejour{
	public Reservation rsrvt;
	public Conso_mb[] consos;
	private int index = 0;

        public Sejour(Reservation rsrvt) {
        	this.rsrvt = rsrvt;
		this.consos = new Conso_mb[0]; 
    	}  

    	public void add_conso_mb(Conso_mb conso) {
		if(index >= consos.length){
			Conso_mb[] newC = new Conso_mb[consos.length+1];
			System.arraycopy(consos, 0, newC, 0, consos.length);
			consos = newC;
		}
		consos[index] = conso;
		index++;
    	}

    	public float fct() { 
        	float prix = 0;
		for(int i = 0; i<rsrvt.chmb_r.length; i++){
			prix += rsrvt.chmb_r[i].prix_ch;
		}
		for(int i = 0; i<consos.length; i++){
			prix += consos[i].prix_mb;	
		}
		return prix;
    	} 
}
