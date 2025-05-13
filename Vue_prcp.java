import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.geom.RoundRectangle2D;
import java.lang.Object;
import java.awt.geom.RectangularShape;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Vue_prcp extends JFrame {
	Model_prjt mod;
	JButton butt;
	JLabel titre;
	JButton butt_mb;
	Vue_Resultats_Recherche vueResultat;

	//Composants de la barre menu
	JMenuBar bar = new JMenuBar();
	JMenu dest = new JMenu("Destinations");
	JMenu selct = new JMenu("Nos sélections");
	JMenu sav = new JMenu("En savoir plus");
	JMenuItem sav_i = new JMenuItem("Questions fréquentes/règlement");
	JMenuItem rec_dest1 = new JMenuItem("Voyagez en Asie");
	JMenuItem rec_dest2 = new JMenuItem("Voyagez en Europe");
	JMenuItem rec_dest3 = new JMenuItem("Voyagez en Afrique");
	JMenuItem rec_selct1 = new JMenuItem("Nos Chambres insolites");
	JMenuItem rec_selct2 = new JMenuItem("Nos suites luxueuses");
	JMenuItem rec_selct3 = new JMenuItem("Nos Chambres familliales");
	JMenuItem rec_selct4 = new JMenuItem("Nos Chambres solo pour vous");
	
	//Panel construction de la page
	JPanel entete = new JPanel();
	JPanel bar_rech = new JPanel();
	JPanel apercu = new JPanel();
	RoundedPanel membre = new RoundedPanel(20);
	JPanel mt_legl = new JPanel();
		
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int largeur = (int)dim.getWidth();
	int hauteur = (int)dim.getHeight();
	public void refreshConnectionStatus() {
        // Met à jour le bouton de connexion avec le statut actuel
        SessionUtil.updateConnectionStatus(butt);
    }
public Vue_prcp(Model_prjt mode, Vue_Resultats_Recherche v_r){
	mod = mode;
	vueResultat = v_r;
	
	//insertion du logo + composants de la barre de menu
	ImageIcon icon = new ImageIcon("images//icone_site.png"); 
	Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	JLabel iconLabel = new JLabel(new ImageIcon(image));
	titre = new JLabel("RoomBloom");
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
	selct.add(rec_selct4);
	rec_selct4.setFont(new Font("Georgia", Font.PLAIN, 12));

	
	bar.add(sav);
	sav.setFont(new Font("Georgia", Font.PLAIN, 12));
	sav.add(sav_i);
	bar.add(Box.createVerticalStrut(0));
	bar.add(butt);
	butt.setFont(new Font("Georgia",Font.PLAIN,12));
	bar.add(Box.createHorizontalStrut(15));
	bar.setPreferredSize(new Dimension(90, 91));
	
	//création entete de la page 
	entete = createImagePanel("images//voyage_2.png", 1350, 321, "Trouvez votre séjour", 60, Color.BLACK);
	entete.setPreferredSize(new Dimension(1350, 321));	
	//barre de recherche
	JTextField br_ch = new JTextField();
	br_ch.setPreferredSize(new Dimension(300, 30));
	br_ch.setText("Rechercher...");
	br_ch.setForeground(Color.GRAY);
	SearchFieldController searchController = new SearchFieldController(br_ch, "Rechercher...", Color.GRAY, Color.BLACK);
    br_ch.addFocusListener(searchController);
	br_ch.setBorder(BorderFactory.createCompoundBorder(
	BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
    BorderFactory.createEmptyBorder(0, 10, 0, 0)));
	JButton butt_rch = new JButton("🔍");
	butt_rch.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
	butt_rch.setBackground(Color.WHITE);
	butt_rch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	// Ajout écouteur d'évenement au bouton rech
	butt_rch.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String termeRecherche = br_ch.getText();
        // Recherche que si le texte non null
        if (!termeRecherche.isEmpty() && !termeRecherche.equals("Rechercher...")) {            
            butt_rch.setEnabled(false);
            
            // Créer un JDialog pour montrer la progression
            final JDialog loading = new JDialog();
            loading.setUndecorated(true);
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel label = new JLabel("Chargement en cours...", SwingConstants.CENTER);
            JProgressBar progressBar = new JProgressBar();
            progressBar.setIndeterminate(true);
            panel.add(label, BorderLayout.CENTER);
            panel.add(progressBar, BorderLayout.SOUTH);
            loading.getContentPane().add(panel);
            loading.pack();
            loading.setLocationRelativeTo(Vue_prcp.this);
            loading.setSize(200, 100);
            
            // Afficher la boîte de dialogue de chargement
            SwingUtilities.invokeLater(() -> {
                loading.setVisible(true);
            });
            
            // Exécuter le chargement en arrière-plan
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    // Mettre à jour les données de la vue résultat
                    vueResultat.setMotsCles(termeRecherche);
                    return null;
                }
                
                @Override
                protected void done() {
                    try {
                        // Fermer la boîte de dialogue de chargement
                        loading.dispose();
                        
                        // Filtrer les chambres avec le nouveau terme de recherche
                        vueResultat.filtrerChambres();
                        
                        // Afficher la vue des résultats
                        vueResultat.setVisible(true);
						Vue_prcp.this.dispose();
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        loading.dispose();
                        
                        JOptionPane.showMessageDialog(Vue_prcp.this, 
                            "Une erreur est survenue lors du chargement des résultats: " + ex.getMessage(), 
                            "Erreur", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        // Réactiver le bouton une fois terminé
                        butt_rch.setEnabled(true);
                    }
                }
            };
            
            // Démarrer le worker
            worker.execute();
            
        } else {
            // Afficher un message si la recherche est vide
            JOptionPane.showMessageDialog(Vue_prcp.this, 
                "Veuillez entrer un terme de recherche", 
                "Recherche vide", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
});

	//rend la touche entrée -> clique butt_rech
	br_ch.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        butt_rch.doClick();
    }
	});
	
	JPanel rech_p = new JPanel(new BorderLayout());
	rech_p.add(br_ch, BorderLayout.CENTER);
	rech_p.add(butt_rch, BorderLayout.EAST);
	bar_rech.add(rech_p);
	bar_rech.setBackground(new Color(229,178,185));
	bar_rech.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

	//Corps de la page
	//Panel aperçu hotels
	apercu.setLayout(new FlowLayout(FlowLayout.LEFT));
	apercu.setPreferredSize(new Dimension(1350,221));
	
	//Panel membre
	JPanel Main_membre_p = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel ct_texte_m = new JPanel();
	JLabel texte_mb = new JLabel("<html>Adhérez au programme !<br></html>");
	JLabel texte_mb1 = new JLabel("<html>En devenant membre vous pourrez recevoir plus d'offres et de promotion sur vos voyages !</html>");
	ct_texte_m.add(texte_mb);
	ct_texte_m.add(new JLabel(" "));
	ct_texte_m.add(texte_mb1);
	ct_texte_m.setLayout(new BoxLayout(ct_texte_m, BoxLayout.Y_AXIS));
	ct_texte_m.setBackground(Color.LIGHT_GRAY);
	
	butt_mb = new JButton("Devenir membre ?");	
	butt_mb.setBackground(new Color(245,245,245));
	butt_mb.setFocusPainted(false);
	
	texte_mb.setFont(new Font("Georgia", Font.BOLD,20));
	texte_mb1.setFont(new Font("Georgia",Font.ITALIC,15));
	butt_mb.setFont(new Font("Georgia", Font.ITALIC,15));
	
	membre.setLayout(new GridLayout(1, 2, 7, 7));
	membre.add(ct_texte_m);
	membre.add(butt_mb);     
	membre.setBackground(Color.LIGHT_GRAY);
	membre.setPreferredSize(new Dimension(1200, 120));
	membre.setBorder(new RoundBorder(20,Color.BLACK));
	
	Main_membre_p.add(membre);
	Main_membre_p.setBorder(new EmptyBorder(0, 40, 0, 0));
	
	//Panel d'espacement 
	JPanel esp = new JPanel();
	esp.setPreferredSize(new Dimension(1350, 250));
	
	//bas de page
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
	mt_legl.setBackground(Color.LIGHT_GRAY);  

	//création des Panels composants la page 
	JPanel TopContainer = new JPanel();
    TopContainer.setLayout(new BoxLayout(TopContainer, BoxLayout.Y_AXIS));
	TopContainer.add(entete);
	TopContainer.add(bar_rech);
	JPanel CenterContainer = new JPanel();
	CenterContainer.setLayout(new BoxLayout(CenterContainer, BoxLayout.Y_AXIS));
	CenterContainer.add(apercu);
	CenterContainer.add(Main_membre_p);
	CenterContainer.add(esp);
	
	//Panel Principal
	JPanel mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	mainPanel.add(TopContainer, BorderLayout.NORTH);
	mainPanel.add(CenterContainer, BorderLayout.CENTER);
	mainPanel.add(mt_legl, BorderLayout.SOUTH);

	//scroll 		
	UIManager.put("ScrollBar.width", 0); 

	JScrollPane scrollPane = new JScrollPane(mainPanel);
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
	public JButton getButt_m(){
		return butt_mb;
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
