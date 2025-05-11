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

public class Vue_pays extends JFrame{
	JPanel main = new JPanel(); //Panel principal (scroll).
	JPanel p1 = new JPanel(); //Panel pour l'entête.
	JPanel p2 = new JPanel(){
		//Fonction pour dessiner le background du panel pour le contenu.
		@Override
		protected void paintComponent(Graphics graph){
			super.paintComponent(graph);
			if(back != null){
				graph.drawImage(back, 0, 0, getWidth()+4, getHeight(), this);
			}
		}
	}; //Panel pour le contenu.
	JPanel p3 = new RoundedPanel(20); //Panel Hôtel.
	JPanel p4 = new JPanel();

	JLabel n_pays; //Label pour le texte de l'entête.
	JLabel nom; //Label pour le texte du nom de l'hôtel.
	JLabel info_h; //Label pour le texte des infos de l'hôtel.
	JLabel esp; //Label pour entrer l'espace au dessus du nom de l'hôtel.
	
	//Outils pour l'image de l'hôtel.
	BufferedImage photo; 
	Image photo1;
	JLabel photo2;
	
	//Outils pour l'image de fond du panel d'entête. 
	BufferedImage fond;
	JLabel fond2;
 
	//Image de fond du panel de contenu.
	BufferedImage back;

	JMenuBar bar = new JMenuBar();
	JLabel titre;
	JButton butt;
	JMenu dest = new JMenu("Destinations");
	JMenu selct = new JMenu("Nos sélections");
	JMenu sav = new JMenu("En savoir plus");
	JMenuItem rec_dest1 = new JMenuItem("Voyagez en Asie");
	JMenuItem rec_dest2 = new JMenuItem("Voyagez en Europe");
	JMenuItem rec_dest3 = new JMenuItem("Voyagez en Afrique");

	JMenuItem rec_selct1 = new JMenuItem("Nos Chambres familliales");
	JMenuItem rec_selct2 = new JMenuItem("Nos Chambres solo pour vous");
	JMenuItem rec_selct3 = new JMenuItem("Nos suites luxueuses");

	JPanel mt_legl = new JPanel();

	Hotel ho;
	Pays pa;

	public Vue_pays(Hotel h1, Pays p){
		//Grand titre de la fenêtre.
		super(h1.pays_h);
		ho = h1;
		pa = p;

		//Stockage des dimensions de l'écran.
		Dimension t_scr = Toolkit.getDefaultToolkit().getScreenSize();

		bar.setPreferredSize(new Dimension(90,91));

		ImageIcon icon = new ImageIcon("images//icone_site.png");
		Image image = icon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		JLabel iconLabel = new JLabel(new ImageIcon(image));
	
		titre = new JLabel("RoomBloom");
		titre.setForeground(new Color(0,0,0));
		titre.setFont(new Font("Georgia", Font.ITALIC, 20));

		butt = new JButton("Me connecter/ M'inscrire");
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
		
		bar.add(sav);
		sav.setFont(new Font("Georgia", Font.PLAIN, 12));

		bar.add(Box.createVerticalStrut(0));
		bar.add(butt);
		butt.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(15));
		
		main.setLayout(new BorderLayout());
		p1.setLayout(new BorderLayout());
		p1.setBorder(BorderFactory.createLineBorder(p.col, 2));
		p1.setBackground(p.col);

		//Création de l'image de fond du panel d'entête. 
		try{
			fond = ImageIO.read(new File(p.path_fond));
		}
		catch(IOException ex){
			ex.printStackTrace();
			System.out.println("Image error.");
		}

		fond2 = new JLabel(new ImageIcon(fond));
		fond2.setLayout(new BorderLayout());
		
		//Création du texte de l'entête.
		n_pays = new JLabel(""+title(),SwingConstants.CENTER);
		n_pays.setForeground(p.col3);
		n_pays.setFont(new Font("Georgia", Font.BOLD, 40));
		n_pays.setHorizontalAlignment(SwingConstants.CENTER);
		n_pays.setVerticalAlignment(SwingConstants.CENTER);

		fond2.add(n_pays, BorderLayout.CENTER);
		p1.add(fond2, BorderLayout.CENTER);
		p1.setPreferredSize(new Dimension((int)t_scr.getWidth(), (int)((double)t_scr.getHeight()*0.4)));

		main.add(p1, BorderLayout.NORTH);

		p2.setLayout(new GridLayout(1,1));

		//Création de l'image du panel du contenu.
		try{
			back = ImageIO.read(new File(p.path_back));
			
		}
		catch(IOException ex){
			ex.printStackTrace();
			System.out.println("Image error.");
		}
		p2.setOpaque(false); //Pour mettre l'image en arrière plan.
		
		//Création du panel de l'hôtel. 
		p3.setLayout(new BorderLayout());
		p3.setBackground(Color.WHITE);
		p3.setPreferredSize(new Dimension((int)((double)(t_scr.getHeight()*0.3+t_scr.getWidth()*0.5)), (int)((double)t_scr.getHeight()*0.3)));
	
		int w = (int)((double)(t_scr.getHeight()*0.3+t_scr.getWidth()*0.5));
		int h = (int)((double)t_scr.getHeight()*0.3);
		p3.setBorder(new RoundBorder(20,p.col2));
		
		//Création de l'image de l'hôtel.
		try{
			photo = ImageIO.read(new File(p.path_photo));
			double width = (double)t_scr.getHeight()*0.3;
			photo1 = photo.getScaledInstance((int)width,(int)width,Image.SCALE_SMOOTH);
		}
		catch(IOException ex){
			ex.printStackTrace();
			System.out.println("Image error.");
		}
		photo2 = new JLabel(new ImageIcon(photo1));
		p3.add(photo2, BorderLayout.WEST);
		p3.revalidate();

		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		p4.setBackground(Color.WHITE);

		//Création du texte descriptif de l'hôtel.
		esp = new JLabel("<html> <br> </html>");
		esp.setFont(new Font("Georgia", Font.PLAIN, 10));
		p4.add(esp);
		nom = new JLabel("<html> &emsp "+h1.nm_h+"<br> <br> <br> </html>");
		nom.setFont(new Font("Georgia", Font.PLAIN, 25));
		p4.add(nom);

		info_h = new JLabel("<html> &emsp &ensp Adresse de l'hôtel : &emsp "+h1.ad_p_h+"<br> <br> &emsp &ensp Contactez l'hôtel : &emsp &nbsp "+h1.ad_m_h+"<br> <br> &emsp &ensp Appelez l'hôtel : &emsp &ensp &nbsp "+h1.num_t_h+"</html>");
		info_h.setFont(new Font("Georgia", Font.PLAIN, 15));
		p4.add(info_h);

		double width = (double)t_scr.getWidth()*0.5;
		double height = (double)t_scr.getHeight()*0.3;
		p4.setPreferredSize(new Dimension((int)width,(int)height));
		p3.revalidate();
		
		p3.add(p4, BorderLayout.CENTER);
		p2.add(p3);
		//Modification de la taille et de l'aspect du panel de contenu. 
		double p_width = (double)t_scr.getWidth()*0.11;
		double p_height = (double)t_scr.getHeight()*0.12;
		p2.setBorder(new EmptyBorder((int)p_height,(int)p_width, (int)p_height, (int)p_width));
		p2.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()), (int)((double)t_scr.getHeight()*0.6)));
		main.add(p2, BorderLayout.CENTER);

		mt_legl.setLayout(new GridLayout(4,4));
		ImageIcon icon_mt = new ImageIcon("images//icone_site.png");
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
		mt_legl.setBackground(Color.LIGHT_GRAY);

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
	
	public String title(){
		String text = "Découvrez ";

		if(ho.pays_h == "Islande") text += "l'"+ho.pays_h;
		else if((ho.pays_h == "France")||(ho.pays_h == "Thaïlande")) text += "la "+ho.pays_h;
		else text += "le "+ho.pays_h;

		return text;
	}
	
    public void setControlleur(NavControlleur controlleur) {        
        controlleur.rendreCliquable(nom);
    }
	
	public JLabel gettitre(){
		return titre;
	}
	
	public JMenuItem getRecDest1() {
		return rec_dest1;
	}
	public JMenuItem getRecDest2() {
		return rec_dest2;
	}
	public JMenuItem getRecDest3() {
		return rec_dest3;
	}
	public JButton getButt() {
		return butt;
	}
	public JMenuItem getrec_selct1() {
		return rec_selct1;
	}
	public JMenuItem getrec_selct2() {
		return rec_selct2;
	}
	public JMenuItem getrec_selct3() {
		return rec_selct3;
	}
}
