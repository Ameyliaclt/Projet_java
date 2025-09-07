package model;
import vue.*;
import controlleur.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Model_date{
	public Model_date(){}

	public void getFleched(Controleur_setDate control, Vue_date v_date){
		control.setClicableCalendar_fleche(v_date.fleche_d, true);
	}
}