package classe;
import model.*;
import controlleur.*;
import vue.*;
import java.util.*;

public class Conso_mb{
	public String t_mb;
	public float prix_mb;

	public Conso_mb(String t , float prix){
		t_mb = t; 
		prix_mb = prix;
 	}

	public void getConso(Controleur_transition control, Vue_conso v_conso){
		control.rendreCliquable_conso(v_conso.confirm);
	}
}