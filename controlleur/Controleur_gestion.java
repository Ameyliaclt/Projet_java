package controlleur;
import classe.*;
import model.*;
import vue.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.lang.*;

public class Controleur_gestion{
	private Vue_gestion_rs vueGestion;
	private Vue_gestion_rs vueGestionBis;
	private Reservation[] tab_rsrv;
	private Reservation rsrv;
	private Sejour[] tab_sej;
	private Sejour sej;
	private int index;

	public Controleur_gestion(Vue_gestion_rs v_gest, Reservation[] tab_r, Reservation r, Sejour[] tab_s, int i){
		vueGestion = v_gest;
		tab_rsrv = tab_r;
		rsrv = r;
		tab_sej = tab_s;
		index = i;
	}

	public Controleur_gestion(Vue_gestion_rs v_gest, Reservation[] tab_r, Reservation r, int i){
		vueGestionBis = v_gest;
		tab_rsrv = tab_r;
		rsrv = r;
		index = i;
	}

	public void rendreCliquable_statut_confirm(JButton item){
		item.addActionListener(e -> {
			sej = rsrv.add_r();
			tab_rsrv[index] = rsrv;
	
			this.new_tab_sej();
			tab_sej[tab_sej.length-1] = sej;

			vueGestion.updateAffichage(tab_rsrv, tab_sej);
		});
	}

	public void rendreCliquable_statut_annule(JButton item){
		item.addActionListener(e -> {
			rsrv.supp_r();
			tab_rsrv[index] = rsrv;

			vueGestionBis.updateAffichage(tab_rsrv);
		});
	}  

    	public void new_tab_sej() {
		Sejour[] newSej = new Sejour[tab_sej.length+1];
		System.arraycopy(tab_sej, 0, newSej, 0, tab_sej.length);
		tab_sej = newSej;
        }
}