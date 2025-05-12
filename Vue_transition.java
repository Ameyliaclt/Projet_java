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

public class Vue_transition extends JFrame{
	Hotel h;
	Chambre[] ch;
	Client clt;
	Date ar;
	Date de;

	JPanel main = new JPanel();
	JPanel sep = new JPanel();
	JPanel details_vue = new JPanel();

	JPanel choix_h = new JPanel();
	JPanel details_h = new JPanel();
	JPanel sep_h = new JPanel();

	JPanel sep1 = new JPanel();
	JPanel choix_d = new JPanel();
	JPanel details_d = new JPanel();

	JPanel sep2 = new JPanel();
	JPanel recap_p = new JPanel();
	JPanel sep_p = new JPanel();
	
	JPanel confirm = new JPanel();

	JLabel title_vue;
	JLabel title_h;
	JLabel title_d;

	JLabel clock;
	JLabel arr_h;
	JLabel dep_h;

	JLabel perso;
	JLabel nb_a;
	JLabel nb_e;

	JLabel calendar;
	JLabel arr_d;
	JLabel sep_d;
	JLabel dep_d;

	JButton confirmer;

	public Vue_transition(Hotel ht, Chambre[] cha, Date a, Date d, Client c){
		h = ht;
		ch = cha;
		ar = a;
		de = d;
		clt = c;

		Dimension t_scr = Toolkit.getDefaultToolkit().getScreenSize();

		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.setBackground(Color.WHITE);

		title_vue = new JLabel("<html> <br> &emsp Réservation "+ch[0].thm_ch+"<br> <br> </html>");
		title_vue.setFont(new Font("Georgia", Font.PLAIN, 16));
		title_vue.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		main.add(title_vue);

		sep.setBackground(new Color(240,240,240));
		sep.setPreferredSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep.setMaximumSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep.setMinimumSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		main.add(sep);

		details_vue.setLayout(new BoxLayout(details_vue, BoxLayout.Y_AXIS));
		details_vue.setBackground(Color.WHITE);

		choix_h.setLayout(new BoxLayout(choix_h, BoxLayout.Y_AXIS));
		choix_h.setBackground(Color.WHITE);

		title_h = new JLabel("<html> <br> &emsp Choisissez vos horaires d'arrivée et de départ <br> <br> </html>");
		title_h.setFont(new Font("Georgia", Font.PLAIN, 14));
		title_h.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		choix_h.add(title_h);

		details_h.setLayout(new FlowLayout(FlowLayout.LEFT));
		details_h.setBackground(Color.WHITE);

		JLabel space_h = new JLabel("<html> &ensp </html>");
		space_h.setFont(new Font("Georgia", Font.PLAIN, 12));
		details_h.add(space_h);
		ImageIcon icon_clock = new ImageIcon("Projet_poo_images//clock_icon.png");
		Image ico_clock = icon_clock.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		clock = new JLabel(new ImageIcon(ico_clock));
		details_h.add(clock);
		details_h.revalidate();

		arr_h = new JLabel("<html> &ensp Arrivée 12h00 &emsp </html>");
		arr_h.setFont(new Font("Georgia", Font.PLAIN, 12));
		details_h.add(arr_h);
		details_h.revalidate();

		sep_h.setBackground(new Color(220,220,220));
		sep_h.setPreferredSize(new Dimension(2, 20));
		sep_h.setMaximumSize(new Dimension(2, 20));
		details_h.add(sep_h);
		details_h.revalidate();

		dep_h = new JLabel("<html> &ensp Départ 12h00 </html>");
		dep_h.setFont(new Font("Georgia", Font.PLAIN, 12));
		details_h.add(dep_h);
		details_h.revalidate();

		details_h.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)details_h.getPreferredSize().getHeight()));

		choix_h.add(details_h);
		choix_h.revalidate();

		details_vue.add(choix_h);

		sep1.setBackground(new Color(240,240,240));
		sep1.setPreferredSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep1.setMaximumSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep1.setMinimumSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep1.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		details_vue.add(sep1);

		choix_d.setLayout(new BoxLayout(choix_d, BoxLayout.Y_AXIS));
		choix_d.setBackground(Color.WHITE);

		title_d = new JLabel("<html> <br> &emsp Choisissez vos dates d'arrivée et de départ <br> <br> </html>");
		title_d.setFont(new Font("Georgia", Font.PLAIN, 14));
		title_d.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		choix_d.add(title_d);

		details_d.setLayout(new FlowLayout(FlowLayout.LEFT));
		details_d.setBackground(Color.WHITE);

		JLabel space_d = new JLabel("<html> &ensp </html>");
		space_d.setFont(new Font("Georgia", Font.PLAIN, 12));
		details_d.add(space_d);
		ImageIcon icon_calendar = new ImageIcon("Projet_poo_images//calendar_icon.png");
		Image ico_calendar = icon_calendar.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		calendar = new JLabel(new ImageIcon(ico_calendar));
		details_d.add(calendar);

		arr_d = new JLabel("<html> &ensp Arrivée 17 mai 2025 &emsp </html>");
		arr_d.setFont(new Font("Georgia", Font.PLAIN, 12));
		details_d.add(arr_d);

		sep_d = new JLabel("<html> --> </html>");
		sep_d.setFont(new Font("Georgia", Font.PLAIN, 12));
		details_d.add(sep_d);

		dep_d = new JLabel("<html> &ensp Départ 18 mai 2025 </html>");
		dep_d.setFont(new Font("Georgia", Font.PLAIN, 12));
		details_d.add(dep_d);

		details_d.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)details_d.getPreferredSize().getHeight()));
		choix_d.add(details_d);
		details_vue.add(choix_d);

		sep2.setBackground(new Color(240,240,240));
		sep2.setPreferredSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep2.setMaximumSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep2.setMinimumSize(new Dimension((int)t_scr.getWidth()*3, 1));
		sep2.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		details_vue.add(sep2);

		recap_p.setLayout(new FlowLayout(FlowLayout.LEFT));
		recap_p.setBackground(Color.WHITE);

		JLabel space_p = new JLabel("<html> &ensp </html>");
		space_p.setFont(new Font("Georgia", Font.PLAIN, 12));
		recap_p.add(space_p);
		perso = new JLabel(new ImageIcon("Projet_poo_images//person_icon.png"));
		recap_p.add(perso);

		int[] nb_p = nb_pe();
		nb_a = new JLabel("<html> &ensp "+nb_p[0]+" adultes &emsp </html>");
		nb_a.setFont(new Font("Georgia", Font.PLAIN, 12));
		recap_p.add(nb_a);

		sep_p.setBackground(new Color(220,220,220));
		sep_p.setPreferredSize(new Dimension(2, 20));
		sep_p.setMaximumSize(new Dimension(2, 20));
		recap_p.add(sep_p);

		nb_e = new JLabel("<html> &ensp "+nb_p[1]+" enfants &emsp </html>");
		nb_e.setFont(new Font("Georgia", Font.PLAIN, 12));
		recap_p.add(nb_e);

		recap_p.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)recap_p.getPreferredSize().getHeight()));
		details_vue.add(recap_p);

		confirm.setLayout(new BoxLayout(confirm, BoxLayout.X_AXIS));
		confirm.setBackground(Color.WHITE);

		confirmer = new JButton("Confirmer");
		confirmer.setFont(new Font("Georgia", Font.PLAIN, 12));
		confirmer.setBackground(new Color(245,245,245));
		confirmer.setFocusPainted(false);
		confirm.add(confirmer);

		confirm.setMinimumSize(new Dimension((int)((double)t_scr.getWidth()*2), (int)details_d.getPreferredSize().getHeight()));
		details_vue.add(confirm);
		main.add(details_vue);

		this.getContentPane().add(main);
	}

	public int[] nb_pe(){
		int nb[] = {0, 0};

		for(int i = 0; i <ch.length; i++){
			if((ch[i].t_ch.compareTo("Chambre double")) == 0){
				nb[0] += 2;
				nb[1] += 1;
			}
			
			else{
				nb[0] += 2;
			}
		}
	
		return nb;
	}
}