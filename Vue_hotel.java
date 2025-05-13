import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import java.awt.geom.RoundRectangle2D;
import java.lang.Object;
import java.awt.geom.RectangularShape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Vue_hotel extends JFrame {
	Hotel mod;
	Hotel_model ht;
	JLabel lab;
	JButton butt;

	//Composants de la barre menu
	JMenuBar bar = new JMenuBar();
	JLabel titre;
	JMenu dest = new JMenu("Destinations");
	JMenu selct = new JMenu("Nos sélections");
	JMenu sav = new JMenu("En savoir plus");
	JMenuItem sav_i = new JMenuItem("Questions fréquentes/règlement");
	JMenuItem rec_dest1 = new JMenuItem("Voyagez en Asie");
	JMenuItem rec_dest2 = new JMenuItem("Voyagez en Europe");
	JMenuItem rec_dest3 = new JMenuItem("Voyagez en Afrique");
	JMenuItem rec_selct1 = new JMenuItem("Nos Chambres familliales");
	JMenuItem rec_selct2 = new JMenuItem("Nos Chambres solo pour vous");
	JMenuItem rec_selct3 = new JMenuItem("Nos suites luxueuses");
	
	//Panel construction de la page
	JPanel entete = new JPanel();
	JPanel deroul = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel filtre = new JPanel();
	JPanel mt_legl = new JPanel();
	
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int largeur = (int)dim.getWidth();
	int hauteur = (int)dim.getHeight();
	public void refreshConnectionStatus() {
        // Met à jour le bouton de connexion avec le statut actuel
        SessionUtil.updateConnectionStatus(butt);
    }
	
	
public Vue_hotel(Hotel md, Hotel_model hotel){
	mod = md;
	ht = hotel;

	//insertion du logo + composants de la barre de menu
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
	SessionUtil.updateConnectionStatus(butt);
    this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowActivated(WindowEvent e) {
        refreshConnectionStatus();
        }
    });
	
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
	sav.add(sav_i);
	bar.add(Box.createVerticalStrut(0));
	bar.add(butt);
	butt.setFont(new Font("Georgia",Font.PLAIN,12));
	bar.add(Box.createHorizontalStrut(15));
	bar.setPreferredSize(new Dimension(90, 91));
	
	//création entete de la page 
	entete = createImagePanel(hotel.photo_entete, 1350, 250, mod.getNom(), 60, Color.WHITE);
	entete.setPreferredSize(new Dimension(1350, 200));	
	
	JPanel main_centre = new JPanel();
	filtre.setLayout(new BoxLayout(filtre, BoxLayout.Y_AXIS));
	filtre.setBorder(BorderFactory.createTitledBorder("Filtres"));
	JCheckBox cb1 = new JCheckBox("Aimer des touristes");
	cb1.setBackground(Color.WHITE);
	cb1.setFocusPainted(false);
	JCheckBox cb2 = new JCheckBox("Luxe");
	cb2.setBackground(Color.WHITE);
	cb2.setFocusPainted(false);
	JCheckBox cb3 = new JCheckBox("Culture");
	cb3.setBackground(Color.WHITE);
	cb3.setFocusPainted(false);
	JCheckBox cb4 = new JCheckBox("Moderne");
	cb4.setBackground(Color.WHITE);
	cb4.setFocusPainted(false);
	
	String[] categories = { "Tous", "Chambre simple", "Chambre double","Suite","Suite présidentielle" };
	JComboBox<String> combinaisons = new JComboBox<>(categories);
	combinaisons.setMaximumSize(new Dimension(150, 25));
	combinaisons.setBackground(Color.WHITE);
	JLabel txt_Cc = new JLabel("Catégorie de chambre :");
	filtre.add(cb1);
	filtre.add(cb2);
	filtre.add(cb3);
	filtre.add(cb4);
	filtre.add(Box.createVerticalStrut(10));
	filtre.add(txt_Cc);
	filtre.add(combinaisons);
	filtre.add(Box.createVerticalStrut(10));
	filtre.setBackground(Color.WHITE);

	deroul.setPreferredSize(new Dimension(1350, 6100));
	JScrollPane d_scrollPane = new JScrollPane(deroul);
	d_scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	d_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	d_scrollPane.getVerticalScrollBar().setUnitIncrement(12);
	d_scrollPane.setPreferredSize(new Dimension(800,1000));
	UIManager.put("ScrollBar.width", 12); 
	deroul.setBackground(hotel.Color_background);
	JPanel Main_chambre = new JPanel();
	Main_chambre.setLayout(new BoxLayout(Main_chambre, BoxLayout.Y_AXIS));
	Main_chambre.setBorder(new EmptyBorder(25, 15, 0, 25));		
	Main_chambre.setBackground(hotel.Color_background);

	// Création des tableaux pour le filtre
	String[] categories_ch = new String[hotel.photo_hotel.length];	
	for (int i = 0; i < hotel.photo_hotel.length; i++) {
		categories_ch[i] = hotel.type_ch[i]; 
	}

	// Préparer les checkboxes pour le filtrage
	JCheckBox[] checkboxesThemes = {cb1, cb2, cb3, cb4};

	// Créer et initialiser le contrôleur de filtre	
	FiltreController filtreController = new FiltreController(
		Main_chambre,          // Le panel qui contiendra les chambres
		checkboxesThemes,      // Les checkbox pour les thèmes
		combinaisons,          // Le combobox des catégories
		hotel.photo_hotel,           // Les noms des images
		categories_ch,         // Les catégories des chambres
		hotel.theme_ch, 			  //themes précis
		hotel.theme_fil             // Les thèmes des chambres filtrée
	);


	deroul.add(Main_chambre);

	
	main_centre.setLayout(new BorderLayout());
	main_centre.add(filtre, BorderLayout.WEST);
	main_centre.add(d_scrollPane, BorderLayout.CENTER);	
	main_centre.setPreferredSize(new Dimension(1350, 1000));

	//création des mentions bas de pages 
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
	mt_legl.setBackground(new Color(240,240,240));	
	
	//Panel Principal
	JPanel mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	mainPanel.add(entete, BorderLayout.NORTH);
	mainPanel.add(main_centre,BorderLayout.CENTER);
	mainPanel.add(mt_legl, BorderLayout.SOUTH);
	
	//scroll 		
	UIManager.put("ScrollBar.width", 0); 

	JScrollPane scrollPane = new JScrollPane(mainPanel);
	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	scrollPane.setPreferredSize(new Dimension(1350,768));
	scrollPane.getVerticalScrollBar().setUnitIncrement(12);

	this.setPreferredSize(new Dimension(largeur,hauteur));
	this.setContentPane(scrollPane);
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
class RoundBorder implements Border{
	private int r;
	private Color col;
	RoundBorder(int r, Color col){
		this.r = r;
		this.col = col;
	}
    			
	public Insets getBorderInsets(Component c){
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
	}
    			
	public boolean isBorderOpaque(){
        return true;
	}
    			
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
		g.setColor(this.col);
        g.drawRoundRect(x, y, width-1, height-1, r, r);
	}
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
	public JMenuItem get_sacv(){
		return sav_i;
	}
}
