package classe;
import model.*;
import vue.*;
import controlleur.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.lang.*;

public class Sejour extends Reservation{
	public Conso_mb[] consos;
	private int index = 0;

    	public Sejour(Reservation rsrv, int stt) {
         	super(rsrv.date_r_d, rsrv.date_r_f, rsrv.client, rsrv.hotel, rsrv.chmb_r, stt);
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
        	float prix = this.prix_r[prix_r.length-1];
		for(int i = 0; i<consos.length; i++){
			prix += consos[i].prix_mb;	
		}
		return prix;
        }

	public void setControleurAnnule(Controleur_gestion control, JButton button, Vue_gestion_rs v_gest){
		control.rendreCliquable_statut_annule(button);
	} 
}
        

