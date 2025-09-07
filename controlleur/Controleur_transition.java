package controlleur;
import classe.*;
import model.*;
import vue.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.TreeSet; 
import java.util.Vector;
import java.util.Stack;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Properties;
import java.util.UUID;
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

public class Controleur_transition{
	private Vue_transition vueTransition;
	private Vue_rsrv vueReservation;
	private Reservation rsrv;

	private Vue_date vueDate;
	private Date ar;
	private Date de;
	private Date arr;
	private Date dep;
	private Date arrGestion;
	private Date depGestion;

	private Vue_gestion_rs vueGestionRs;
	private Vue_date vueDateGestion;
	private Reservation[] tab_rsrv;
	private int index;

	private Vue_conso vueConso;
	private Sejour[] tab_sej;
	private Sejour sej;
	private Conso_mb[] tab_conso;
	private String[] tab_types;
	private JComboBox<String> menu_choix;
	private int indexS;

	private Vue_rsrv vueReservationV;
	private Vue_gestion_rs vueGestionV;
	private Reservation[] tab_rsrvV;
	private Sejour[] tab_sejV;

	public Controleur_transition(Vue_transition v_trans, Vue_rsrv v_rsrv){
		vueTransition = v_trans;
		vueReservation = v_rsrv;
		rsrv = v_rsrv.rsrv;
	}

	public Controleur_transition(Vue_transition v_trans, Vue_date v_d){
		vueTransition = v_trans;
		vueDate = v_d;
		ar = vueDate.getDateArrivee();
		de = vueDate.getDateDepart();
		arr = vueTransition.getDateArrivee();
		dep = vueTransition.getDateDepart();
	}

	public Controleur_transition(Vue_gestion_rs v_gest, Vue_date v_d, Reservation[] tab_r, Reservation r, int i){
		vueGestionRs = v_gest;
		vueDateGestion = v_d;
		tab_rsrv = tab_r;
		rsrv = r;
		arrGestion = vueDateGestion.getDateArrivee();
		depGestion = vueDateGestion.getDateDepart();
		index = i;
	}

	public Controleur_transition(Vue_gestion_rs v_gest, Vue_conso v_c, Sejour[] tab_s, Sejour s, int i, Conso_mb[] tab_c, String[] tab_t, JComboBox<String> m_choix){
		vueGestionRs = v_gest;
		vueConso = v_c;
		tab_sej = tab_s;
		sej = s;
		indexS = i;
		tab_conso = tab_c;
		tab_types = tab_t;
		menu_choix = m_choix;
	}

	public Controleur_transition(Vue_rsrv v_r, Vue_gestion_rs v_gest, Reservation[] r, Sejour[] s){
		vueReservationV = v_r;
		vueGestionV = v_gest;
		tab_rsrvV = r;
		tab_sejV = s;

		rendreCliquable_validation(vueReservationV.validation);
	}

	public void rendreCliquable_gestion_date(JLabel label){
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));

		label.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				arrGestion.setDate(rsrv.date_r_d);
				depGestion.setDate(rsrv.date_r_f);

				vueDateGestion.updateAffichage(arrGestion, depGestion);
				vueDateGestion.setVisible(true);
			}
		});
	}

	public void rendreCliquable_trans(JButton item){
		item.addActionListener(e -> {
			vueTransition.setVisible(false);

			rsrv.updateReservation(vueTransition.getDateArrivee(), vueTransition.getDateDepart(), vueTransition.getClient(), vueTransition.getHotel(), vueTransition.getTabChambre(), rsrv.statut_r);
			vueReservation.updateInfos(rsrv);

			vueReservation.setVisible(true);
		});
	}

	public void rendreCliquable_dates(JLabel label){
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));

		label.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				ar.setDate(vueTransition.getDateArrivee());
				de.setDate(vueTransition.getDateDepart());

				vueDate.updateAffichage(ar, de);
				vueDate.setVisible(true);
			}
		});
	}

	public void rendreCliquable_date(JButton item){
		item.addActionListener(e -> {
			vueDate.setVisible(false);

			arr.setDate(vueDate.getDateArrivee().jr, vueDate.getDateArrivee().mois, vueDate.getDateArrivee().annee);
			dep.setDate(vueDate.getDateDepart().jr, vueDate.getDateDepart().mois, vueDate.getDateDepart().annee);

			vueTransition.updateAffichage(arr,dep);
		});
	}

	public void rendreCliquable_validation(JButton item){
		item.addActionListener(e -> {
			vueReservationV.setVisible(false);
	
			if(vueReservationV.confirm.isSelected()){
				new_tab_sej();
				tab_sejV[tab_sejV.length-1] = vueReservationV.rsrv.add_r();
			}
	
			else{ 
				new_tab_rsrv();
				tab_rsrvV[tab_rsrvV.length-1] = vueReservationV.rsrv;
			}

			vueGestionV.updateAffichage(tab_rsrvV, tab_sejV);
			vueGestionV.setVisible(true);
		});
	}

	public void rendreCliquable_date_modif(JButton item){
		item.addActionListener(e -> {
			vueDate.setVisible(false);

			arr.setDate(vueDate.getDateArrivee().jr, vueDate.getDateArrivee().mois, vueDate.getDateArrivee().annee);
			dep.setDate(vueDate.getDateDepart().jr, vueDate.getDateDepart().mois, vueDate.getDateDepart().annee);

			vueTransition.updateAffichage(arr,dep);
		});
	}

	public void rendreCliquable_gestion_conso(JButton item){
		item.addActionListener(e -> {
			vueConso.setVisible(true);
		});
	}

	public void rendreCliquable_conso(JButton item){
		item.addActionListener(e -> {
			vueConso.setVisible(false);

			Conso_mb conso = find_conso(tab_types, (String)menu_choix.getSelectedItem());
			sej.add_conso_mb(conso);
			tab_sej[indexS] = sej;
		
			vueGestionRs.updateAffichage(tab_sej);
		});
	}

	public void rendreCliquable_gestion(JButton item){
		item.addActionListener(e -> {
			vueDateGestion.setVisible(false);

			rsrv.date_r_d.setDate(vueDateGestion.getDateArrivee());
			rsrv.date_r_f.setDate(vueDateGestion.getDateDepart());
			tab_rsrv[index] = rsrv;
		
			vueGestionRs.updateAffichage(tab_rsrv);
		});
	}

	public Conso_mb find_conso(String[] choices, String type){
		ArrayUtils auj = new ArrayUtils();
		int index = auj.indexOf(choices, type);
		return tab_conso[index];
	} 

    	public void new_tab_rsrv() {
		Reservation[] newRsrv = new Reservation[tab_rsrvV.length+1];
		System.arraycopy(tab_rsrvV, 0, newRsrv, 0, tab_rsrvV.length);
		tab_rsrvV = newRsrv;
        } 

    	public void new_tab_sej() {
		Sejour[] newSej = new Sejour[tab_sejV.length+1];
		System.arraycopy(tab_sejV, 0, newSej, 0, tab_sejV.length);
		tab_sejV = newSej;
        }
}