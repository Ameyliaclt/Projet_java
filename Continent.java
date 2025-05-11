import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Continent extends JFrame {
    Model_prjt mod;
	Continent_model ct;
    JLabel lab;
    JButton butt;
	private JLabel nom_p1;
	private JLabel nom_p2;

    JMenuBar bar = new JMenuBar(); 
	JLabel titre;
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
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int largeur = (int)dim.getWidth();
	int hauteur = (int)dim.getHeight();

public Continent(Model_prjt md,Continent_model continent) {
    super("Voyagez en Asie");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setLayout(new BorderLayout());

    mod = md;
	ct = continent;

    // BARRE DE MENU
    ImageIcon icon = new ImageIcon("images//icone_site.png"); 
	Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	JLabel iconLabel = new JLabel(new ImageIcon(image));
	titre = new JLabel("RoomBloom");
	//p_vue_prcp controleur = new p_vue_prcp(this, mod);
	//p_vue_prcp.rendreJLabelCliquable(titre, controleur);
	titre.setForeground(new Color(0, 0, 0));
	titre.setFont(new Font("Georgia", Font.ITALIC, 20));
	butt = new JButton("Me connecter/ M'inscrire");
	butt.setBackground(new Color(245,245,245));
	butt.setFocusPainted(false);
	
	JPanel separator = new JPanel();
	separator.setPreferredSize(new Dimension(2, 40));
	separator.setMaximumSize(new Dimension(2, 40));
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
	butt.setFont(new Font("Georgia",Font.PLAIN,12));
	bar.add(Box.createHorizontalStrut(15));
	bar.setPreferredSize(new Dimension(90, 91));

    // PANELS
    Color gold = new Color(184, 134, 11);
    Color kiki = new Color(190, 175, 160);

    // Haut
    JPanel p1 = createImagePanel("images//"+continent.entete, 1360, 275, continent.nom_continent, 60, Color.WHITE);
	p1.setPreferredSize(new Dimension(1350, 275));
    p1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

    // Bas
    JPanel pBottom = new JPanel(new GridLayout(1, 2, 150, 100));
    pBottom.setBorder(BorderFactory.createEmptyBorder(25, 200, 20, 200));
    pBottom.setBackground(Color.GRAY);

    JPanel pLeft = new JPanel();
	ImageIcon icon_pays = new ImageIcon("images//"+continent.photo_pays[0]);
	Image img_pays = icon_pays.getImage().getScaledInstance(400, 340, Image.SCALE_SMOOTH);
	JLabel fond_1 = new JLabel(new ImageIcon(img_pays));
    fond_1.setLayout(new BorderLayout());
	nom_p1 = new JLabel(continent.nom_pays[0],SwingConstants.CENTER);
	nom_p1.setForeground(gold);
	nom_p1.setFont(new Font("Georgia", Font.ITALIC, 35));
	nom_p1.setHorizontalAlignment(SwingConstants.CENTER);
	nom_p1.setVerticalAlignment(SwingConstants.CENTER);
	fond_1.add(nom_p1, BorderLayout.CENTER);
	fond_1.setBackground(Color.GRAY);
	pLeft.add(fond_1);
	pLeft.setBackground(Color.GRAY);
	
	JPanel pRight = new JPanel();
	ImageIcon icon_pays_1 = new ImageIcon("images//"+continent.photo_pays[1]);
	Image img_pays_1 = icon_pays_1.getImage().getScaledInstance(400, 340, Image.SCALE_SMOOTH);
	JLabel fond_2 = new JLabel(new ImageIcon(img_pays_1));
    fond_2.setLayout(new BorderLayout());
	nom_p2 = new JLabel(continent.nom_pays[1],SwingConstants.CENTER);
	nom_p2.setForeground(gold);
	nom_p2.setFont(new Font("Georgia", Font.ITALIC, 35));
	nom_p2.setHorizontalAlignment(SwingConstants.CENTER);
	nom_p2.setVerticalAlignment(SwingConstants.CENTER);
	fond_2.add(nom_p2, BorderLayout.CENTER);
	pRight.add(fond_2);
    pRight.setBackground(Color.GRAY);


    pBottom.add(pLeft);
    pBottom.add(pRight);
	
	//mention bas de page 
	mt_legl.setLayout(new GridLayout(4,4));
	ImageIcon icon_mt = new ImageIcon("C://Users//ameyl//Desktop//POO projet//images//icone_site.png"); 
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
	JLabel texte_ml_9 = new JLabel("Voyager en Afrique");
	JLabel texte_ml_10 = new JLabel("Nous contacter");
	JLabel texte_ml_11 = new JLabel("Instagram : @RoomBloom_fr");
	JLabel texte_ml_12 = new JLabel("Facebook : @RoomBloom_fr");
	JLabel texte_ml_13 = new JLabel("X : @RoomBloom_fr");
	mt_legl.add(new JLabel(" "));//l0,col0
	mt_legl.add(texte_ml_1);//l0,col1
	mt_legl.add(texte_ml_4);//l0,col2
	mt_legl.add(texte_ml_6);//l0,col3
	mt_legl.add(texte_ml_10);//l0,col4
	
	mt_legl.add(new JLabel(" "));//l1,col0
	mt_legl.add(texte_ml_2);//l1,col1
	mt_legl.add(texte_ml_5);//l1,col2
	mt_legl.add(texte_ml_7);//l1,col3
	mt_legl.add(texte_ml_11);//l1,col4
	
	mt_legl.add(iconLabel_mt);//l2,col0
	mt_legl.add(texte_ml_3);//l2,col1
	mt_legl.add(new JLabel(" "));//l2,col2
	mt_legl.add(texte_ml_8);//l2,col3
	mt_legl.add(texte_ml_12);//l1,col4
	
	mt_legl.add(new JLabel(" "));//l3,col0
	mt_legl.add(new JLabel(" "));//l3,col1
	mt_legl.add(new JLabel(" "));//l3,col2
	mt_legl.add(texte_ml_9);//l3,col3
	mt_legl.add(texte_ml_13);//l1,col4
	mt_legl.setBackground(Color.LIGHT_GRAY);

	JPanel main_Panel = new JPanel();
	main_Panel.setLayout(new BorderLayout());
	main_Panel.add(p1, BorderLayout.NORTH);
	main_Panel.add(pBottom, BorderLayout.CENTER);
    main_Panel.add(mt_legl, BorderLayout.SOUTH);
	
	UIManager.put("ScrollBar.width", 0); 
	JScrollPane scrollPane = new JScrollPane(main_Panel);
	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	scrollPane.setPreferredSize(new Dimension(1350,768));
	scrollPane.getVerticalScrollBar().setUnitIncrement(12);
	this.setContentPane(scrollPane);
	
	this.setPreferredSize(new Dimension(largeur,hauteur));
}
private JPanel createImagePanel(String imagePath, int width, int height, String text, int fontSize, Color textColor) {
	ImageIcon icon = new ImageIcon(imagePath);
    Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    JLabel imageLabel = new JLabel(new ImageIcon(img));
	imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    imageLabel.setLayout(new BorderLayout());

    JLabel textLabel = new JLabel(text, SwingConstants.CENTER);
    textLabel.setForeground(textColor);
    textLabel.setFont(new Font("Georgia", Font.ITALIC, fontSize));
    textLabel.setHorizontalAlignment(SwingConstants.CENTER);
    textLabel.setVerticalAlignment(SwingConstants.CENTER);

    imageLabel.add(textLabel, BorderLayout.CENTER);

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(imageLabel, BorderLayout.CENTER);
    return panel;
}
	public JLabel getLabelPays_1() {
		return nom_p1;
	}
	public JLabel getLabelPays_2() {
		return nom_p2;
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
	public JLabel gettitre(){
		return titre;
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
