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

public class Vue_gestion_rs extends JFrame{
	Reservation[] rsrv;
	Sejour[] sej;

	JPanel main = new JPanel();
	JPanel content = new JPanel();

	JMenuBar bar = new JMenuBar();
	JMenu dest = new JMenu("Destinations");
	JMenu selct = new JMenu("Nos sélections");
	JMenu sav = new JMenu("En savoir plus");
	JMenuItem rec_dest1 = new JMenuItem("Voyagez en Asie");
	JMenuItem rec_dest2 = new JMenuItem("Voyagez en Europe");
	JMenuItem rec_dest3 = new JMenuItem("Voyagez en Afrique");

	JMenuItem rec_selct1 = new JMenuItem("Nos chambres insolites");
	JMenuItem rec_selct2 = new JMenuItem("Nos suites luxueuses");
	JMenuItem rec_selct3 = new JMenuItem("Nos chambres familiales");
	JMenuItem rec_selct4 = new JMenuItem("Nos chambres solo pour vous");

	JPanel rs = new JPanel();
	JLabel title_gestion;
	JPanel[] reservation;
	JPanel[] sejour;

	JPanel mt_legl = new JPanel();

	Dimension t_scr = Toolkit.getDefaultToolkit().getScreenSize();

	public Vue_gestion_rs(Reservation[] r){
		rsrv = r;
	
		bar.setPreferredSize(new Dimension(90,91));

		ImageIcon icon = new ImageIcon("Projet_poo_images//icone_site.png");
		Image image = icon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		JLabel iconLabel = new JLabel(new ImageIcon(image));
	
		JLabel titre = new JLabel("RoomBloom");
		titre.setForeground(new Color(0,0,0));
		titre.setFont(new Font("Georgia", Font.ITALIC, 20));

		JButton butt = new JButton("Me connecter/ M'inscrire");
		butt.setBackground(new Color(245,245,245));
		butt.setFocusPainted(false);

		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(2,40));
		separator.setMaximumSize(new Dimension(2,40));
		separator.setBackground(Color.GRAY);
		
		this.setJMenuBar(bar);
		bar.setBackground(Color.WHITE);
		bar.add(Box.createHorizontalStrut(15));

		bar.add(iconLabel);
		bar.add(Box.createHorizontalStrut(10));
	
		bar.add(titre);
		bar.add(Box.createHorizontalStrut(25));

		bar.add(separator);
		bar.add(Box.createHorizontalStrut(25));

		bar.add(dest);
		dest.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(rec_dest1);
		rec_dest1.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(new JSeparator(SwingConstants.HORIZONTAL));
		dest.add(rec_dest2);
		rec_dest2.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(new JSeparator(SwingConstants.HORIZONTAL));
		dest.add(rec_dest3);
		rec_dest3.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(10));

		bar.add(selct);
		selct.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(10));
		selct.add(rec_selct1);
		rec_selct1.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct2);
		rec_selct2.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct3);
		rec_selct3.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct4);
		rec_selct4.setFont(new Font("Georgia", Font.PLAIN, 12));
		
		bar.add(sav);
		sav.setFont(new Font("Georgia", Font.PLAIN, 12));

		bar.add(Box.createVerticalStrut(0));
		bar.add(butt);
		butt.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(15));
		
		main.setLayout(new BorderLayout());
		main.setBackground(new Color(241,250,247));
		content.setLayout(new BorderLayout());
		content.setBackground(new Color(241,250,247));

		title_gestion = new JLabel("<html> <br> &emsp Détails de vos réservations et séjours : <br> <br> </html>");
		title_gestion.setFont(new Font("Georgia", Font.PLAIN, 20));
		content.add(title_gestion, BorderLayout.NORTH);

		rs.setLayout(new GridLayout(r.length, 1, (int)((double)t_scr.getWidth()*0.5), (int)((double)t_scr.getHeight()*0.02)));
		rs.setBackground(new Color(241,250,247));
		rs.setBorder(new EmptyBorder((int)((double)t_scr.getHeight()*0.02), (int)((double)t_scr.getWidth()*0.05), (int)((double)t_scr.getHeight()*0.1), (int)((double)t_scr.getWidth()*0.05)));

		reservation = create_jpanel();
		for(int i = 0; i<reservation.length; i++){
			if(rsrv[i].statut_r.compareTo("attente")==0) rs.add(reservation[i]);
		}

		content.add(rs, BorderLayout.CENTER);
		rs.setPreferredSize(new Dimension((int)t_scr.getWidth(), (int)rs.getPreferredSize().getHeight()));

		main.add(content, BorderLayout.CENTER);
	
		mt_legl.setLayout(new GridLayout(4,4));
		ImageIcon icon_mt = new ImageIcon("Projet_poo_images//icone_site.png");
		Image image_mt = icon_mt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel iconLabel_mt = new JLabel(new ImageIcon(image_mt));
		
		JLabel texte_ml_1 = new JLabel("RoomBloom");
		JLabel texte_ml_2 = new JLabel("97 rue George Leclerc");
		JLabel texte_ml_3 = new JLabel("33800 Bordeaux");
		JLabel texte_ml_4 = new JLabel("Accueil");
		JLabel texte_ml_5 = new JLabel("En savoir plus");
		JLabel texte_ml_6 = new JLabel("Où voyager ?");
		JLabel texte_ml_7 = new JLabel("Voyager en Europe");

		JLabel texte_ml_8 = new JLabel("Voyager en Asie");
		//texte_ml_8.addActionListener(asieController);

		JLabel texte_ml_9 = new JLabel("Voyager en Afrique");
		JLabel texte_ml_10 = new JLabel("Nous contacter");
		JLabel texte_ml_11 = new JLabel("Instagram : @RoomBloom_fr");
		JLabel texte_ml_12 = new JLabel("Facebook : @RoomBloom_fr");
		JLabel texte_ml_13 = new JLabel("X : @RoomBloom_fr");

		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_1);
		mt_legl.add(texte_ml_4);
		mt_legl.add(texte_ml_6);
		mt_legl.add(texte_ml_10);
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_2);
		mt_legl.add(texte_ml_5);
		mt_legl.add(texte_ml_7);
		mt_legl.add(texte_ml_11);

		mt_legl.add(iconLabel_mt);
		mt_legl.add(texte_ml_3);
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_8);
		mt_legl.add(texte_ml_12);
		
		mt_legl.add(new JLabel(" "));
		mt_legl.add(new JLabel(" "));
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_9);
		mt_legl.add(texte_ml_13);
		mt_legl.setBackground(new Color(240, 240, 240));

		main.add(mt_legl, BorderLayout.SOUTH);
		//Création de la scrollPane. 
		UIManager.put("ScrollBar.width", 0); 
		JScrollPane scroll = new JScrollPane(main);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.getVerticalScrollBar().setBlockIncrement(64);
		scroll.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()), (int)((double)t_scr.getHeight())));

		
		this.getContentPane().add(scroll);
	}

	public Vue_gestion_rs(Sejour[] s){
		sej = s;
	
		bar.setPreferredSize(new Dimension(90,91));

		ImageIcon icon = new ImageIcon("Projet_poo_images//icone_site.png");
		Image image = icon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		JLabel iconLabel = new JLabel(new ImageIcon(image));
	
		JLabel titre = new JLabel("RoomBloom");
		titre.setForeground(new Color(0,0,0));
		titre.setFont(new Font("Georgia", Font.ITALIC, 20));

		JButton butt = new JButton("Me connecter/ M'inscrire");
		butt.setBackground(new Color(245,245,245));
		butt.setFocusPainted(false);

		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(2,40));
		separator.setMaximumSize(new Dimension(2,40));
		separator.setBackground(Color.GRAY);
		
		this.setJMenuBar(bar);
		bar.setBackground(Color.WHITE);
		bar.add(Box.createHorizontalStrut(15));

		bar.add(iconLabel);
		bar.add(Box.createHorizontalStrut(10));
	
		bar.add(titre);
		bar.add(Box.createHorizontalStrut(25));

		bar.add(separator);
		bar.add(Box.createHorizontalStrut(25));

		bar.add(dest);
		dest.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(rec_dest1);
		rec_dest1.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(new JSeparator(SwingConstants.HORIZONTAL));
		dest.add(rec_dest2);
		rec_dest2.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(new JSeparator(SwingConstants.HORIZONTAL));
		dest.add(rec_dest3);
		rec_dest3.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(10));

		bar.add(selct);
		selct.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(10));
		selct.add(rec_selct1);
		rec_selct1.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct2);
		rec_selct2.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct3);
		rec_selct3.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct4);
		rec_selct4.setFont(new Font("Georgia", Font.PLAIN, 12));
		
		bar.add(sav);
		sav.setFont(new Font("Georgia", Font.PLAIN, 12));

		bar.add(Box.createVerticalStrut(0));
		bar.add(butt);
		butt.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(15));
		
		main.setLayout(new BorderLayout());
		main.setBackground(new Color(241,250,247));
		content.setLayout(new BorderLayout());
		content.setBackground(new Color(241,250,247));

		title_gestion = new JLabel("<html> <br> &emsp Détails de vos réservations et séjours : <br> <br> </html>");
		title_gestion.setFont(new Font("Georgia", Font.PLAIN, 20));
		content.add(title_gestion, BorderLayout.NORTH);

		rs.setLayout(new GridLayout(s.length, 1, (int)((double)t_scr.getWidth()*0.5), (int)((double)t_scr.getHeight()*0.02)));
		rs.setBackground(new Color(241,250,247));
		rs.setBorder(new EmptyBorder((int)((double)t_scr.getHeight()*0.02), (int)((double)t_scr.getWidth()*0.05), (int)((double)t_scr.getHeight()*0.1), (int)((double)t_scr.getWidth()*0.05)));

		sejour = create_jpanel_s();
		for(int i = 0; i<sejour.length; i++){
			rs.add(sejour[i]);
		}

		content.add(rs, BorderLayout.CENTER);
		rs.setPreferredSize(new Dimension((int)t_scr.getWidth(), (int)rs.getPreferredSize().getHeight()));

		main.add(content, BorderLayout.CENTER);
	
		mt_legl.setLayout(new GridLayout(4,4));
		ImageIcon icon_mt = new ImageIcon("Projet_poo_images//icone_site.png");
		Image image_mt = icon_mt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel iconLabel_mt = new JLabel(new ImageIcon(image_mt));
		
		JLabel texte_ml_1 = new JLabel("RoomBloom");
		JLabel texte_ml_2 = new JLabel("97 rue George Leclerc");
		JLabel texte_ml_3 = new JLabel("33800 Bordeaux");
		JLabel texte_ml_4 = new JLabel("Accueil");
		JLabel texte_ml_5 = new JLabel("En savoir plus");
		JLabel texte_ml_6 = new JLabel("Où voyager ?");
		JLabel texte_ml_7 = new JLabel("Voyager en Europe");

		JLabel texte_ml_8 = new JLabel("Voyager en Asie");
		//texte_ml_8.addActionListener(asieController);

		JLabel texte_ml_9 = new JLabel("Voyager en Afrique");
		JLabel texte_ml_10 = new JLabel("Nous contacter");
		JLabel texte_ml_11 = new JLabel("Instagram : @RoomBloom_fr");
		JLabel texte_ml_12 = new JLabel("Facebook : @RoomBloom_fr");
		JLabel texte_ml_13 = new JLabel("X : @RoomBloom_fr");

		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_1);
		mt_legl.add(texte_ml_4);
		mt_legl.add(texte_ml_6);
		mt_legl.add(texte_ml_10);
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_2);
		mt_legl.add(texte_ml_5);
		mt_legl.add(texte_ml_7);
		mt_legl.add(texte_ml_11);

		mt_legl.add(iconLabel_mt);
		mt_legl.add(texte_ml_3);
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_8);
		mt_legl.add(texte_ml_12);
		
		mt_legl.add(new JLabel(" "));
		mt_legl.add(new JLabel(" "));
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_9);
		mt_legl.add(texte_ml_13);
		mt_legl.setBackground(new Color(240, 240, 240));

		main.add(mt_legl, BorderLayout.SOUTH);
		//Création de la scrollPane. 
		UIManager.put("ScrollBar.width", 0); 
		JScrollPane scroll = new JScrollPane(main);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.getVerticalScrollBar().setBlockIncrement(64);
		scroll.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()), (int)((double)t_scr.getHeight())));

		
		this.getContentPane().add(scroll);
	}

	public Vue_gestion_rs(Reservation[] r, Sejour[] s){
		rsrv = r;
		sej = s;
	
		bar.setPreferredSize(new Dimension(90,91));

		ImageIcon icon = new ImageIcon("Projet_poo_images//icone_site.png");
		Image image = icon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		JLabel iconLabel = new JLabel(new ImageIcon(image));
	
		JLabel titre = new JLabel("RoomBloom");
		titre.setForeground(new Color(0,0,0));
		titre.setFont(new Font("Georgia", Font.ITALIC, 20));

		JButton butt = new JButton("Me connecter/ M'inscrire");
		butt.setBackground(new Color(245,245,245));
		butt.setFocusPainted(false);

		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(2,40));
		separator.setMaximumSize(new Dimension(2,40));
		separator.setBackground(Color.GRAY);
		
		this.setJMenuBar(bar);
		bar.setBackground(Color.WHITE);
		bar.add(Box.createHorizontalStrut(15));

		bar.add(iconLabel);
		bar.add(Box.createHorizontalStrut(10));
	
		bar.add(titre);
		bar.add(Box.createHorizontalStrut(25));

		bar.add(separator);
		bar.add(Box.createHorizontalStrut(25));

		bar.add(dest);
		dest.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(rec_dest1);
		rec_dest1.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(new JSeparator(SwingConstants.HORIZONTAL));
		dest.add(rec_dest2);
		rec_dest2.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(new JSeparator(SwingConstants.HORIZONTAL));
		dest.add(rec_dest3);
		rec_dest3.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(10));

		bar.add(selct);
		selct.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(10));
		selct.add(rec_selct1);
		rec_selct1.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct2);
		rec_selct2.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct3);
		rec_selct3.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
		selct.add(rec_selct4);
		rec_selct4.setFont(new Font("Georgia", Font.PLAIN, 12));
		
		bar.add(sav);
		sav.setFont(new Font("Georgia", Font.PLAIN, 12));

		bar.add(Box.createVerticalStrut(0));
		bar.add(butt);
		butt.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(15));
		
		main.setLayout(new BorderLayout());
		main.setBackground(new Color(241,250,247));
		content.setLayout(new BorderLayout());
		content.setBackground(new Color(241,250,247));

		title_gestion = new JLabel("<html> <br> &emsp Détails de vos réservations et séjours : <br> <br> </html>");
		title_gestion.setFont(new Font("Georgia", Font.PLAIN, 20));
		content.add(title_gestion, BorderLayout.NORTH);

		rs.setLayout(new GridLayout(r.length+s.length, 1, (int)((double)t_scr.getWidth()*0.5), (int)((double)t_scr.getHeight()*0.02)));
		rs.setBackground(new Color(241,250,247));
		rs.setBorder(new EmptyBorder((int)((double)t_scr.getHeight()*0.02), (int)((double)t_scr.getWidth()*0.05), (int)((double)t_scr.getHeight()*0.1), (int)((double)t_scr.getWidth()*0.05)));

		reservation = create_jpanel();
		for(int i = 0; i<reservation.length; i++){
			if(rsrv[i].statut_r.compareTo("attente")==0) rs.add(reservation[i]);
		}

		sejour = create_jpanel_s();
		for(int i = 0; i<sejour.length; i++){
			rs.add(sejour[i]);
		}

		content.add(rs, BorderLayout.CENTER);
		rs.setPreferredSize(new Dimension((int)t_scr.getWidth(), (int)rs.getPreferredSize().getHeight()));

		main.add(content, BorderLayout.CENTER);
	
		mt_legl.setLayout(new GridLayout(4,4));
		ImageIcon icon_mt = new ImageIcon("Projet_poo_images//icone_site.png");
		Image image_mt = icon_mt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel iconLabel_mt = new JLabel(new ImageIcon(image_mt));
		
		JLabel texte_ml_1 = new JLabel("RoomBloom");
		JLabel texte_ml_2 = new JLabel("97 rue George Leclerc");
		JLabel texte_ml_3 = new JLabel("33800 Bordeaux");
		JLabel texte_ml_4 = new JLabel("Accueil");
		JLabel texte_ml_5 = new JLabel("En savoir plus");
		JLabel texte_ml_6 = new JLabel("Où voyager ?");
		JLabel texte_ml_7 = new JLabel("Voyager en Europe");

		JLabel texte_ml_8 = new JLabel("Voyager en Asie");
		//texte_ml_8.addActionListener(asieController);

		JLabel texte_ml_9 = new JLabel("Voyager en Afrique");
		JLabel texte_ml_10 = new JLabel("Nous contacter");
		JLabel texte_ml_11 = new JLabel("Instagram : @RoomBloom_fr");
		JLabel texte_ml_12 = new JLabel("Facebook : @RoomBloom_fr");
		JLabel texte_ml_13 = new JLabel("X : @RoomBloom_fr");

		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_1);
		mt_legl.add(texte_ml_4);
		mt_legl.add(texte_ml_6);
		mt_legl.add(texte_ml_10);
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_2);
		mt_legl.add(texte_ml_5);
		mt_legl.add(texte_ml_7);
		mt_legl.add(texte_ml_11);

		mt_legl.add(iconLabel_mt);
		mt_legl.add(texte_ml_3);
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_8);
		mt_legl.add(texte_ml_12);
		
		mt_legl.add(new JLabel(" "));
		mt_legl.add(new JLabel(" "));
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_9);
		mt_legl.add(texte_ml_13);
		mt_legl.setBackground(new Color(240, 240, 240));

		main.add(mt_legl, BorderLayout.SOUTH);
		//Création de la scrollPane. 
		UIManager.put("ScrollBar.width", 0); 
		JScrollPane scroll = new JScrollPane(main);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.getVerticalScrollBar().setBlockIncrement(64);
		scroll.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()), (int)((double)t_scr.getHeight())));

		
		this.getContentPane().add(scroll);
	}

	class RoundBorder implements Border{
		private int r;
		private Color col;
    		RoundBorder(int r, Color col) {
        		this.r = r;
			this.col = col;
    		}
    			
		public Insets getBorderInsets(Component c) {
        		return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    		}
    			
		public boolean isBorderOpaque() {
        		return true;
    		}
    			
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.setColor(this.col);
        		g.drawRoundRect(x, y, width-1, height-1, r, r);
    		}
	}

	public JPanel[] create_jpanel(){
		JPanel[] newJPanel = new JPanel[rsrv.length];

		for(int i = 0; i<rsrv.length; i++){
			JPanel r = new RoundedPanel(20);
			JLabel title_r;
			JPanel sep_r = new JPanel();
			JLabel cham_r;
			JLabel horaires;
			JLabel dates;	
			JPanel buttons = new JPanel();
			JButton confirm; 
			JLabel sep_bu;
			JButton annule;
			
			r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
			r.setBackground(Color.WHITE);
			r.setBorder(new RoundBorder(20, new Color(240,240,240)));
		
			title_r = new JLabel("<html> Réservation n°"+(i+1)+" <br> <br> </html>");
			title_r.setFont(new Font("Georgia", Font.PLAIN, 16));
			title_r.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			r.add(title_r);
	
			sep_r.setBackground(new Color(240,240,240));
			sep_r.setPreferredSize(new Dimension((int)t_scr.getWidth(), 1));
			sep_r.setMinimumSize(new Dimension((int)t_scr.getWidth(), 1));
			sep_r.setMaximumSize(new Dimension((int)t_scr.getWidth(), 1));
			r.add(sep_r);

			cham_r = new JLabel(details_cham(i, "Réservation"));
			cham_r.setFont(new Font("Georgia", Font.PLAIN, 14));
			cham_r.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			r.add(cham_r);

			horaires = new JLabel("<html> <br> Horaires : &ensp Arrivée "+rsrv[i].date_r_d.ifZero_h(rsrv[i].date_r_d)+""+rsrv[i].date_r_d.heure+"h"+rsrv[i].date_r_d.ifZero_m(rsrv[i].date_r_d)+""+rsrv[i].date_r_d.minute+" &ensp | &ensp Départ "+rsrv[i].date_r_f.ifZero_h(rsrv[i].date_r_f)+""+rsrv[i].date_r_f.heure+"h"+rsrv[i].date_r_f.ifZero_m(rsrv[i].date_r_f)+""+rsrv[i].date_r_f.minute+" <br> </html>");
			horaires.setFont(new Font("Georgia", Font.PLAIN, 14));
			horaires.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			r.add(horaires);

			dates = new JLabel("<html> <br> Dates : &ensp Arrivée "+rsrv[i].date_r_d.jr+" "+rsrv[i].date_r_d.mois+" "+rsrv[i].date_r_d.annee+" &ensp | &ensp Départ "+rsrv[i].date_r_f.jr+" "+rsrv[i].date_r_f.mois+" "+rsrv[i].date_r_f.annee+"<br> <br> <br> </html>");
			dates.setFont(new Font("Georgia", Font.PLAIN, 14));
			dates.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			r.add(dates);
			
			buttons.setLayout(new FlowLayout(FlowLayout.LEFT));
			buttons.setBackground(Color.WHITE);

			confirm = new JButton("Confirmer");
			confirm.setFont(new Font("Georgia", Font.PLAIN, 12));
			confirm.setBackground(new Color(245,245,245));
			confirm.setFocusPainted(false);
			buttons.add(confirm);
			
			sep_bu = new JLabel("");
			sep_bu.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()*0.008), (int)sep_bu.getPreferredSize().getHeight()));
			sep_bu.setMinimumSize(new Dimension((int)((double)t_scr.getWidth()*0.008), (int)sep_bu.getPreferredSize().getHeight()));
			sep_bu.setMaximumSize(new Dimension((int)((double)t_scr.getWidth()*0.008), (int)sep_bu.getPreferredSize().getHeight()));
			buttons.add(sep_bu);

			annule = new JButton("Annuler");
			annule.setFont(new Font("Georgia", Font.PLAIN, 12));
			annule.setBackground(new Color(245,245,245));
			annule.setFocusPainted(false);
			buttons.add(annule);
			
			buttons.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)buttons.getPreferredSize().getHeight()));
			r.add(buttons);

			r.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)r.getPreferredSize().getHeight()));

			newJPanel[i] = r;
		}

		return newJPanel;
	}

	public JPanel[] create_jpanel_s(){
		JPanel[] newJPanel = new JPanel[sej.length];

		for(int i = 0; i<sej.length; i++){
			JPanel r = new RoundedPanel(20);
			JLabel title_r;
			JPanel sep_r = new JPanel();
			JLabel cham_r;
			JLabel dates;
			JLabel conso_mb;
			JPanel layout = new JPanel();
			JButton ajout_conso;
			
			r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
			r.setBackground(Color.WHITE);
			r.setBorder(new RoundBorder(20, new Color(240,240,240)));
		
			title_r = new JLabel("<html> Séjour n°"+(i+1)+" <br> <br> </html>");
			title_r.setFont(new Font("Georgia", Font.PLAIN, 16));
			title_r.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			r.add(title_r);
	
			sep_r.setBackground(new Color(240,240,240));
			sep_r.setPreferredSize(new Dimension((int)t_scr.getWidth(), 1));
			sep_r.setMinimumSize(new Dimension((int)t_scr.getWidth(), 1));
			sep_r.setMaximumSize(new Dimension((int)t_scr.getWidth(), 1));
			r.add(sep_r);

			cham_r = new JLabel(details_cham(i, "Séjour"));
			cham_r.setFont(new Font("Georgia", Font.PLAIN, 14));
			cham_r.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			r.add(cham_r);

			dates = new JLabel("<html> <br> Dates : &ensp Arrivée "+sej[i].date_r_d.jr+" "+sej[i].date_r_d.mois+" "+sej[i].date_r_d.annee+" à "+sej[i].date_r_d.ifZero_h(sej[i].date_r_d)+""+sej[i].date_r_d.heure+"h"+sej[i].date_r_d.ifZero_m(sej[i].date_r_d)+""+sej[i].date_r_d.minute+" &ensp | &ensp Départ "+sej[i].date_r_f.jr+" "+sej[i].date_r_f.mois+" "+sej[i].date_r_f.annee+" à "+sej[i].date_r_f.ifZero_h(sej[i].date_r_f)+""+sej[i].date_r_f.heure+"h"+sej[i].date_r_f.ifZero_m(sej[i].date_r_f)+""+sej[i].date_r_f.minute+"<br> <br> </html>");
			dates.setFont(new Font("Georgia", Font.PLAIN, 14));
			dates.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			r.add(dates);
		
			conso_mb = new JLabel(details_conso(i));
			conso_mb.setFont(new Font("Georgia", Font.PLAIN, 14));
			conso_mb.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			conso_mb.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()*0.6), (int)((double)t_scr.getHeight()*0.055)));
			conso_mb.setMinimumSize(new Dimension((int)((double)t_scr.getWidth()*0.6), (int)((double)t_scr.getHeight()*0.055)));
			conso_mb.setMaximumSize(new Dimension((int)((double)t_scr.getWidth()*0.6), (int)((double)t_scr.getHeight()*0.055)));
			r.add(conso_mb);

			layout.setLayout(new FlowLayout(FlowLayout.LEFT));
			layout.setBackground(Color.WHITE);
		
			ajout_conso = new JButton("Ajouter une consommation minibar");
			ajout_conso.setFont(new Font("Georgia", Font.PLAIN, 14));
			ajout_conso.setBackground(new Color(245,245,245));
			ajout_conso.setFocusPainted(false);
			layout.add(ajout_conso);
			layout.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)layout.getPreferredSize().getHeight()));
			r.add(layout);

			r.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)r.getPreferredSize().getHeight()));

			newJPanel[i] = r;
		}

		return newJPanel;
	}

	public String details_cham(int i, String type){
		String details = "<html> <br> ";

		if(type.compareTo("Réservation")==0){
			if(rsrv[i].chmb_r.length == 1) details += "Chambre réservée : &ensp ";
			else details += "Chambres réservées : &ensp ";

			for(int j = 0; j<rsrv[i].chmb_r.length-1; j++){
				details += rsrv[i].chmb_r[j].thm_ch+" - ";
			}
			details += rsrv[i].chmb_r[rsrv[i].chmb_r.length-1].thm_ch+" &ensp | &ensp Prix total : ";

			details += rsrv[i].prix_r+" <br> </html>";
		}

		else{
			if(sej[i].chmb_r.length == 1) details += "Chambre réservée : &ensp ";
			else details += "Chambres réservées : &ensp ";

			for(int j = 0; j<sej[i].chmb_r.length-1; j++){
				details += sej[i].chmb_r[j].thm_ch+" - ";
			}
			details += sej[i].chmb_r[sej[i].chmb_r.length-1].thm_ch+" &ensp | &ensp Prix total : ";

			details += sej[i].prix_r+" <br> </html>";
		}	
		
		return details;
	}

	public String details_conso(int i){
		String details_c = "<html> ";

		if(sej[i].consos.length == 1) details_c += "Consommation minibar ajoutée : &ensp ";
		else if(sej[i].consos.length == 0) details_c += "Aucune consommation minibar ajoutée <br> </html>";
		else details_c += "Consommations minibar ajoutées : &ensp ";

		for(int j = 0; j<sej[i].consos.length-1; j++){
			details_c += sej[i].consos[j].t_mb+" "+sej[i].consos[j].prix_mb+" - ";
		}
		details_c += sej[i].consos[sej[i].consos.length-1].t_mb+" &ensp | &ensp Prix total chambres et consommations : ";

		details_c += sej[i].fct()+"<br> <br> <br> </html>";	
		
		return details_c;
	}
}
