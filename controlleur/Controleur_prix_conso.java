package controlleur;
import classe.*;
import model.*;
import vue.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controleur_prix_conso implements ActionListener{
	private JLabel prix;
	private JComboBox<String> menu_choix;
	private String[] types_conso;
	private Conso_mb[] choix;

	public Controleur_prix_conso(JLabel p, JComboBox<String> menu, String[] types, Conso_mb[] list){
		prix = p;
		menu_choix = menu;
		types_conso = types;
		choix = list;
	}

	public void actionPerformed(ActionEvent e){
		Conso_mb conso = find_conso(types_conso, (String)menu_choix.getSelectedItem());
		prix.setText("<html> <br> &emsp "+conso.prix_mb+"€ <br> <br> </html>");
	}

	public Conso_mb find_conso(String[] choices, String type){
		ArrayUtils auj = new ArrayUtils();
		int index = auj.indexOf(choices, type);
		return choix[index];
	}
}