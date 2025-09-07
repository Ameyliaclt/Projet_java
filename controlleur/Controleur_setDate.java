package controlleur;
import classe.*;
import model.*;
import vue.*;
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

public class Controleur_setDate {
	private JLabel arrivee;
	private JLabel depart;
	private String mois;
	private int an;
	private int jour;
	private Date arr; 
	private Date dep;
	private JLabel click;
	private JLabel[] tab_labels;
	private boolean modeArrival = true;

	private Vue_date vueDateCalendar;
	private String moisC;
	private int anC;
	private JLabel fleche_g;
	private Date arrC;
	private JLabel fleche_d;

	private boolean isFlecheG;

	public Controleur_setDate(JLabel arriv, JLabel depa, String m, int a, JLabel clicked, JLabel[] tab, Date ar, Date de, Date ar_s){
		arrivee = arriv;
		depart = depa;
		mois = m;
		an = a;
		jour = find_label(tab, clicked)+1;
		arr = ar;
		dep = de;
		click = clicked;
		tab_labels = tab;
		arrC = ar_s;

		setClicable(click);
	}

	public Controleur_setDate(Vue_date v_date, String m, int a, JLabel f_g, JLabel f_d, Date ar){
		vueDateCalendar = v_date;
		moisC = m;
		anC = a;
		arrC = ar; 
		fleche_g = f_g; 
		fleche_d = f_d;
	}

	public void setClicable(JLabel label){
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));

		label.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				boolean clickedBeforeDep = (an < dep.annee) || ((an == dep.annee) && (dep.getIntMonth(mois) < dep.getIntMonth(dep.mois))) || ((an == dep.annee) && (dep.getIntMonth(mois) == dep.getIntMonth(dep.mois)) && (jour < dep.jr));
				boolean clickedAfterArr = (an > arr.annee) || ((an == arr.annee) && (arr.getIntMonth(mois) > arr.getIntMonth(arr.mois))) || ((an == arr.annee) && (arr.getIntMonth(mois) == arr.getIntMonth(arr.mois)) && (jour > arr.jr));
				boolean clickedAfterArrSet = (an > arrC.annee) || ((an == arrC.annee) && (arrC.getIntMonth(mois) > arrC.getIntMonth(arrC.mois))) || ((an == arrC.annee) && (arrC.getIntMonth(mois) == arrC.getIntMonth(arrC.mois)) && (jour >= arrC.jr));

				if(modeArrival){
					if(clickedBeforeDep){
						if(clickedAfterArrSet){
							arr.setDate(jour, mois, an);
							modeArrival = false;
						}
					}
					else dep.setDate(jour, mois, an);
				}

				else{
					if(clickedAfterArr) dep.setDate(jour, mois, an);
					else{
						arr.setDate(jour, mois, an);
						modeArrival = true;
					}
				}

				arrivee.setText("<html> <br>"+arr.jr+" "+arr.mois+" "+arr.annee+" </html>");
				depart.setText("<html> <br>"+dep.jr+" "+dep.mois+" "+dep.annee+" </html>");
			}
		});
	}

	public int find_label(JLabel[] tab, JLabel toFind){
		for(int index = 0; index<tab.length; index++){
			if(tab[index].getText().compareTo(toFind.getText())==0) return index;
		}

		return -1;
	}

	public void setClicableCalendar_fleche(JLabel label, boolean isFleched){
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));

		label.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				System.out.println(isFleched+" Valeur ");
				if(isFleched){ 
					String newMoisC;
					newMoisC = arrC.updateMois(moisC, true);
					anC = arrC.updateAnnee(moisC, newMoisC, anC);
					moisC = newMoisC;
					vueDateCalendar.updateAffichage(newMoisC, anC);
				}
				else{ 
					String newMoisC;
					newMoisC = arrC.updateMois(moisC, false);
					int newAnC;
					newAnC = arrC.updateAnnee(moisC, newMoisC, anC);
					if((arrC.getIntMonth(newMoisC) >= arrC.getIntMonth(arrC.mois)) || (newAnC > arrC.annee)){ 
						System.out.println("Je peux retourner en arrière");					
						moisC = newMoisC;
						anC = newAnC;
						vueDateCalendar.updateAffichage(newMoisC, anC);
					}
				}
			}
		});
	}
}