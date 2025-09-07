package model;
import vue.*;
import controlleur.*;
public class Model_transition{
	public Model_transition(){}

	public void getDate(Controleur_transition control, Vue_date v_date){
		control.rendreCliquable_date_modif(v_date.confirm);
	}
}