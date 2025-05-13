import javax.swing.*;
import java.util.*;
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

	JLabel fleche_g;
	JLabel mois_an;
	JLabel fleche_d;
	
	JLabel[] jour;
	JLabel space;

	JButton confirm;

	public Vue_date(Date a, Date d){
		arr = a;
		dep = d;

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

		fleche_g = new JLabel("<html> <br> &lt &emsp <br> <br> </html>");
		fleche_g.setFont(new Font("Georgia", Font.BOLD, 14));
		selection.add(fleche_g);

		mois_an = new JLabel("<html> <br> &ensp "+arr.mois+" "+arr.annee+" <br> <br> </html>");
		mois_an.setFont(new Font("Georgia", Font.PLAIN, 14));
		selection.add(mois_an);

		fleche_d = new JLabel("<html> <br> &emsp > <br> <br> </html>");
		fleche_d.setFont(new Font("Georgia", Font.BOLD, 14));
		selection.add(fleche_d);

		selection.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)selection.getPreferredSize().getHeight()));
		calendar.add(selection);

		sep.setBackground(new Color(200,200,200));
		sep.setPreferredSize(new Dimension((int)t_scr.getWidth(), 1));
		sep.setMinimumSize(new Dimension((int)t_scr.getWidth(), 1));
		sep.setMaximumSize(new Dimension((int)t_scr.getWidth(), 1));
		calendar.add(sep);

		jours.setLayout(new GridLayout(5,7));
		jours.setBackground(new Color(240,240,240));

		jour = jours_calendar();
		for(int i = 0; i<jour.length; i++){
			jours.add(jour[i], Component.CENTER_ALIGNMENT);
		}
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

	public JLabel[] jours_calendar(){
		JLabel[] nb_jours_m = new JLabel[31];

		for(int i = 0; i<nb_jours_m.length; i++){
			if(i<=arr.nb_jours())nb_jours_m[i] = new JLabel("<html> &emsp "+ (i+1)+" </html>");
			else nb_jours_m[i] = new JLabel(" ");
			nb_jours_m[i].setFont(new Font("Georgia", Font.PLAIN, 14));
		}

		return nb_jours_m;
	}
}