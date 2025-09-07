package vue;
import classe.*;
import controlleur.*;
import model.*;
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
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Graphics;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.geom.RoundRectangle2D;
import java.lang.Object;
import java.awt.geom.RectangularShape;

public class Vue_date extends JFrame{
	Date arr;
	Date dep;
	Date arr_set;

	JPanel main = new JPanel(); //Panel principal.
	JPanel dates = new JPanel(); //Panel qui affiche les dates en haut.
	JPanel calendar = new JPanel(); //Panel qui affiche le calendrier intéractif de choix des dates.
	JPanel selection = new JPanel(); //Panel qui contient le < mois annee >.
	JPanel sep = new JPanel(); //Séparateur.
	JPanel jours = new JPanel(); //Panel des jours à choisir.
	JPanel button = new JPanel(); //Panel qui contient le bouton de confirmation.

	JLabel du;
	JLabel d_arr;
	JLabel au;
	JLabel d_dep;

	public JLabel fleche_g;
	JLabel mois;
	JLabel an;
	public JLabel fleche_d;
	
	JLabel[] jour;
	JLabel space;

	public JButton confirm;
	Controleur_transition controlleur;

	public Vue_date(Date a, Date d, Date a_s){
		arr = a;
		dep = d;
		arr_set = a_s;

		Model_date model = new Model_date();

		Dimension t_scr = Toolkit.getDefaultToolkit().getScreenSize();

		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.setBackground(new Color(240,240,240));

		dates.setLayout(new FlowLayout(FlowLayout.LEFT));
		dates.setBackground(new Color(240,240,240));

		du = new JLabel("<html> <br> &emsp Du &ensp </html>");
		du.setFont(new Font("Georgia", Font.PLAIN, 14));
		dates.add(du);

		d_arr = new JLabel("<html> <br>"+arr.jr+" "+arr.mois+" "+arr.annee+" </html>");
		d_arr.setFont(new Font("Georgia", Font.PLAIN, 14));
		dates.add(d_arr);

		au = new JLabel("<html> <br> &ensp Au &ensp </html>");
		au.setFont(new Font("Georgia", Font.PLAIN, 14));
		dates.add(au);

		d_dep = new JLabel("<html> <br>"+dep.jr+" "+dep.mois+" "+dep.annee+" </html>");
		d_dep.setFont(new Font("Georgia", Font.PLAIN, 14));
		dates.add(d_dep);

		dates.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)dates.getPreferredSize().getHeight()));
		main.add(dates);
	
		calendar.setLayout(new BoxLayout(calendar, BoxLayout.Y_AXIS));
		calendar.setBackground(new Color(240,240,240));
		calendar.setBorder(new EmptyBorder((int)((double)t_scr.getHeight()*0.02), (int)((double)t_scr.getWidth()*0.02), (int)((double)t_scr.getHeight()*0.02), (int)((double)t_scr.getWidth()*0.02)));

		selection.setLayout(new FlowLayout(FlowLayout.CENTER));
		selection.setBackground(new Color(240,240,240));

		String tab_mois = arr.mois;
		int tab_an = arr.annee;

		fleche_g = new JLabel("<html> <br> &lt &emsp <br> <br> </html>");
		fleche_g.setFont(new Font("Georgia", Font.BOLD, 14));
		selection.add(fleche_g);

		mois = new JLabel("<html> <br> &ensp "+tab_mois+" <br> <br> </html>");
		mois.setFont(new Font("Georgia", Font.PLAIN, 14));
		selection.add(mois);

		an = new JLabel("<html> <br> &ensp "+tab_an+" <br> <br> </html>");
		an.setFont(new Font("Georgia", Font.PLAIN, 14));
		selection.add(an);

		fleche_d = new JLabel("<html> <br> &emsp > <br> <br> </html>");
		fleche_d.setFont(new Font("Georgia", Font.BOLD, 14));
		selection.add(fleche_d);
		Controleur_setDate controlc = new Controleur_setDate(this, tab_mois, tab_an, fleche_g, fleche_d, arr_set);
		arr.getFlecheg(controlc, this);
		model.getFleched(controlc, this);

		selection.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)selection.getPreferredSize().getHeight()));
		calendar.add(selection);

		sep.setBackground(new Color(200,200,200));
		sep.setPreferredSize(new Dimension((int)t_scr.getWidth(), 1));
		sep.setMinimumSize(new Dimension((int)t_scr.getWidth(), 1));
		sep.setMaximumSize(new Dimension((int)t_scr.getWidth(), 1));
		calendar.add(sep);

		jours = create_jours(tab_mois, tab_an);
		calendar.add(jours, Component.CENTER_ALIGNMENT);

		main.add(calendar);
		
		button.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button.setBackground(new Color(240,240,240));

		confirm = new JButton("Confirmer");
		confirm.setFont(new Font("Georgia", Font.PLAIN, 14));
		confirm.setBackground(new Color(245,245,245));
		confirm.setFocusPainted(false);
		button.add(confirm);

		space = new JLabel("<html> &emsp <br> <br> </html>");
		space.setFont(new Font("Georgia", Font.BOLD, 14));
		button.add(space);

		button.setMaximumSize(new Dimension((int)t_scr.getWidth(), ((int)selection.getPreferredSize().getHeight())));
		main.add(button);

		this.getContentPane().add(main);
	}

	public JPanel create_jours(String tab_mois, int tab_an){
		JPanel nb_jours = new JPanel();

		nb_jours.setLayout(new GridLayout(5,7));
		nb_jours.setBackground(new Color(240,240,240));

		jour = jours_calendar();
		for(int i = 0; i<jour.length; i++){
			nb_jours.add(jour[i], Component.CENTER_ALIGNMENT);
			Controleur_setDate control = new Controleur_setDate(d_arr, d_dep, tab_mois, tab_an, jour[i], jour, arr, dep, arr_set);
			this.getJour(control, jour[i]);
		}

		return nb_jours;
	}

	public JLabel[] jours_calendar(){
		JLabel[] nb_jours_m = new JLabel[35];

		for(int i = 0; i<nb_jours_m.length; i++){
			if(i<arr.nb_jours())nb_jours_m[i] = new JLabel("<html> &emsp "+ (i+1)+" </html>");
			else nb_jours_m[i] = new JLabel(" ");
			nb_jours_m[i].setFont(new Font("Georgia", Font.PLAIN, 14));
		}

		return nb_jours_m;
	}

	public void getJour(Controleur_setDate control, JLabel label){
		control.setClicable(label);
	}

	public Date getDateArrivee(){
		ArrayUtils aum = new ArrayUtils();
		int index = aum.indexOf(arr.tab_mois, arr.mois);
		return new Date(this.arr.jr, index, this.arr.annee, this.arr.heure, this.arr.minute);
	}

	public Date getDateDepart(){
		ArrayUtils aum = new ArrayUtils();
		int index = aum.indexOf(dep.tab_mois, dep.mois);
		return new Date(this.dep.jr, index, this.dep.annee, this.dep.heure, this.dep.minute);
	}

	public void updateAffichage(Date a, Date d){
		arr = a;
		dep = d;

		d_arr.setText("<html> <br>"+arr.jr+" "+arr.mois+" "+arr.annee+" </html>");
		d_dep.setText("<html> <br>"+dep.jr+" "+dep.mois+" "+dep.annee+" </html>");

		String tab_mois = arr.mois;
		int tab_an = arr.annee;

		mois.setText("<html> <br> &ensp "+tab_mois+" <br> <br> </html>");
		an.setText("<html> <br> &ensp "+tab_an+" <br> <br> </html>");
	
		calendar.remove(jours);
		jours = create_jours(tab_mois, tab_an);
		calendar.add(jours, Component.CENTER_ALIGNMENT);
		calendar.revalidate();
		calendar.repaint();

		this.revalidate();	
		this.repaint();
	}

	public void updateAffichage(String m, int anne){
		String tab_mois = m;
		int tab_an = anne;

		mois.setText("<html> <br> &ensp "+tab_mois+" <br> <br> </html>");
		an.setText("<html> <br> &ensp "+tab_an+" <br> <br> </html>");
	
		calendar.remove(jours);
		jours = create_jours(tab_mois, tab_an);
		calendar.add(jours, Component.CENTER_ALIGNMENT);
		calendar.revalidate();
		calendar.repaint();

		this.revalidate();	
		this.repaint();
	}
}