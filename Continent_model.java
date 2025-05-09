import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Continent_model{
	String[] photo_pays;
	String entete;
	String [] nom_pays;
	String nom_continent;

	public Continent_model(String[] photo_p, String photo_e, String[] nm_p, String nm_c){
		photo_pays = photo_p;
		entete = photo_e;
		nom_pays = nm_p;
		nom_continent = nm_c;
	}
}