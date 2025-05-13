import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Vue_Resultats_Recherche extends JFrame {
    JPanel panneauChambres;
    JTextField searchField;
    String motsCles;
	JButton titre;
    String[] nomsFichiers;
    String[] categories;
    String[] themes_ch;
    String[] themes_fil;
    Model_prjt mod;
	JPanel entete = new JPanel();
	JPanel mt_legl = new JPanel();

public Vue_Resultats_Recherche(String motsCles, String[] nomsFichiers, String[] categories, String[] themes_ch, String[] themes_fil, Model_prjt mod) {
    this.motsCles = motsCles;
    this.nomsFichiers = nomsFichiers;
    this.categories = categories;
    this.themes_ch = themes_ch;
    this.themes_fil = themes_fil;
    this.mod = mod;    
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int largeur = (int)dim.getWidth();
	int hauteur = (int)dim.getHeight();
	
	//insertion du bouton de retour en haut de la page
	titre = new JButton("Retour à la vue principale");
	titre.setBackground(new Color(229,178,185));
	titre.setForeground(Color.BLACK);
	titre.setFont(new Font("Georgia", Font.ITALIC, 14)); 
	titre.setPreferredSize(new Dimension(200, 30));
	titre.setMargin(new Insets(2, 5, 2, 5));
	titre.setFocusPainted(false);	
	titre.setBorder(new LineBorder(Color.BLACK, 1));
	
	JPanel pan_haut = new JPanel(new BorderLayout());
	pan_haut.add(titre);
	pan_haut.add(titre, BorderLayout.WEST);
	pan_haut.setBackground(new Color(229,178,185));
	
    
	// Création du panneau principal + barre de recherche 
    JPanel mainPanel = new JPanel(new BorderLayout());
	
	entete = createImagePanel("images//voyage_2.png", 1350, 250, "Trouvez votre séjour", 60, Color.BLACK);
	entete.setPreferredSize(new Dimension(1350, 250));	
    
    // Barre de recherche
    JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    searchPanel.setBackground(new Color(229,178,185));
    searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
     
    searchField = new JTextField(motsCles, 20);
	searchField.setForeground(Color.GRAY);
	searchField.setPreferredSize(new Dimension(350,30));
	searchField.setBorder(BorderFactory.createCompoundBorder(
	BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
    BorderFactory.createEmptyBorder(0, 10, 0, 0)));;
     
    JButton searchButton = new JButton("🔍");
    searchButton.setBackground(Color.WHITE);
    searchButton.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
	searchButton.setPreferredSize(new Dimension(40, 30)); 

    
    searchPanel.add(searchField);
    searchPanel.add(searchButton);
        
    panneauChambres = new JPanel();
    panneauChambres.setLayout(new BoxLayout(panneauChambres, BoxLayout.Y_AXIS));
    panneauChambres.setBackground(new Color(245, 245, 245));
        
    // Action du bouton de recherche
    searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            filtrerChambres();
        }
    });
        
    // Action sur la touche Entrée dans le champ de recherche
    searchField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                filtrerChambres();
            }
        }
    });
	JPanel esp = new JPanel();
	esp.setPreferredSize(new Dimension(1350, 250));

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
	
    // Ajout des composants à la fenêtre
	JPanel TopContainer = new JPanel();
    TopContainer.setLayout(new BoxLayout(TopContainer, BoxLayout.Y_AXIS));
	TopContainer.add(pan_haut);
	TopContainer.add(entete);
	TopContainer.add(searchPanel);
    mainPanel.add(TopContainer, BorderLayout.NORTH);
    mainPanel.add(panneauChambres, BorderLayout.CENTER);
	mainPanel.add(mt_legl,BorderLayout.SOUTH);
	
    filtrerChambres();
	UIManager.put("ScrollBar.width", 0); 

	JScrollPane scrollPane_p = new JScrollPane(mainPanel);
	scrollPane_p.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane_p.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	scrollPane_p.setPreferredSize(new Dimension(1350,768));
	scrollPane_p.getVerticalScrollBar().setUnitIncrement(12);

	this.setContentPane(scrollPane_p);
	this.setPreferredSize(new Dimension(largeur,hauteur));
	this.pack();
}

public void setMotsCles(String motsCles) {
    this.motsCles = motsCles;
    this.searchField.setText(motsCles);
}

public void filtrerChambres() {
    panneauChambres.removeAll();
        
    // Récupérer les mots clés
    String keywords = searchField.getText();
        
    // Si la recherche est vide, afficher un message
    if (keywords.isEmpty()) {
        JLabel emptyLabel = new JLabel("Veuillez entrer des termes de recherche");
        emptyLabel.setFont(new Font("Georgia", Font.ITALIC, 16));
        emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panneauChambres.add(Box.createVerticalStrut(50));
        panneauChambres.add(emptyLabel);
        panneauChambres.revalidate();
        panneauChambres.repaint();
        return;
    }
        
    String[] keywordArray = keywords.toLowerCase().split("\\s+");
        
    int chambresAffichees = 0;
        
    // Parcourir toutes les chambres
    for (int i = 0; i < 117; i++) {//ici ou il y a un probleme de tailles askip normalement je met .length
		String texteRecherche = (categories[i] + " " + themes_ch[i] + " " + themes_fil[i]).toLowerCase();
		String typeChambre = categories[i].toLowerCase();
    
		boolean filtreTypeChambre = false;
    
		// Recherche spécifique pour les types de chambres
		if (keywords.toLowerCase().equals("chambre simple") && typeChambre.contains("Chambre simple")) {
			filtreTypeChambre = true;
		} else if (keywords.toLowerCase().equals("chambre double") && typeChambre.contains("Chambre double")) {
			filtreTypeChambre = true;
		} else if (keywords.toLowerCase().equals("suite") && typeChambre.contains("Suite")) {
			filtreTypeChambre = true;
		} else if (keywords.toLowerCase().equals("suite présidentielle") && typeChambre.contains("Suite présidentielle")) {
			filtreTypeChambre = true;
		}
    
		if (filtreTypeChambre) {
			ajouterChambre(i);
			chambresAffichees++;
			continue; 
		}
		
		boolean correspondAuMotsCles = false;
		for (String keyword : keywordArray) {
			if (!keyword.isEmpty() && texteRecherche.contains(keyword)) {
				correspondAuMotsCles = true;
				break;
			}
		}
    
		// Si la chambre correspond aux mots-clés, l'ajouter
		if (correspondAuMotsCles) {
			ajouterChambre(i);
			chambresAffichees++;
		}
	}
        
    // Si aucune chambre n'a été trouvée, afficher un message
    if (chambresAffichees == 0) {
        JLabel noResultsLabel = new JLabel("Aucun résultat trouvé pour: " + keywords);
        noResultsLabel.setFont(new Font("Georgia", Font.ITALIC, 16));
        noResultsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panneauChambres.add(Box.createVerticalStrut(50));
        panneauChambres.add(noResultsLabel);
    }
        
    panneauChambres.revalidate();
    panneauChambres.repaint();
}
    
   // Méthode ajouterChambre optimisée
private void ajouterChambre(int index) {
	//ajout espacement
    if (index > 0 || panneauChambres.getComponentCount() > 0) {
        JPanel spacerPanel = new JPanel();
        spacerPanel.setPreferredSize(new Dimension(1350, 20));
        spacerPanel.setMaximumSize(new Dimension(1350, 20));
        spacerPanel.setBackground(new Color(245, 245, 245));
        panneauChambres.add(spacerPanel);
    }
    
    JPanel spacerPanel_d = new JPanel();
    spacerPanel_d.setPreferredSize(new Dimension(1350, 40));
    spacerPanel_d.setMaximumSize(new Dimension(1350, 40));
    spacerPanel_d.setBackground(new Color(245, 245, 245));
    panneauChambres.add(spacerPanel_d);
    
	//création panel chambre
    RoundedPanel chambrePanel = new RoundedPanel(15);
    chambrePanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    chambrePanel.setBackground(Color.WHITE);
    chambrePanel.setMaximumSize(new Dimension(1000, 250));
    chambrePanel.setPreferredSize(new Dimension(1000, 250));
    chambrePanel.setBorder(new RoundBorder(15, Color.BLACK));
    
    // Utiliser un JLabel avec placeholder en attendant le chargement
    final JLabel iconLabel_ch = new JLabel("Chargement...");
    iconLabel_ch.setPreferredSize(new Dimension(200, 200));
    iconLabel_ch.setHorizontalAlignment(SwingConstants.CENTER);
    
    final String imagePath = "images//" + nomsFichiers[index];
    
    // On utilise un SwingWorker pour charger l'image en arrière-plan
    SwingWorker<ImageIcon, Void> imageLoader = new SwingWorker<ImageIcon, Void>() {
        @Override
        protected ImageIcon doInBackground() throws Exception {
            Image image = ChargementImages.chargerEtRedimensionnerImage(imagePath, 200, 200);
            return new ImageIcon(image);
        }
        
        @Override
        protected void done() {
            try {
                // Met à jour l'affichage 
                ImageIcon icon = get();
                iconLabel_ch.setIcon(icon);
                iconLabel_ch.setText(""); 
                chambrePanel.revalidate();
                chambrePanel.repaint();
            } catch (Exception e) {
                iconLabel_ch.setText("Erreur");
                e.printStackTrace();
            }
        }
    };
    imageLoader.execute();
    
    JPanel texte_ch = new JPanel();
    texte_ch.setLayout(new BoxLayout(texte_ch, BoxLayout.Y_AXIS));
    JLabel titre_ch = new JLabel(categories[index] + " " + themes_ch[index]);
    titre_ch.setFont(new Font("Georgia", Font.ITALIC, 30));
    
    JLabel desc_ch = new JLabel("Description: ");
    desc_ch.setFont(new Font("Georgia", Font.PLAIN, 15));
    
    texte_ch.add(titre_ch);
    texte_ch.add(Box.createVerticalStrut(10));
    texte_ch.add(desc_ch);
    texte_ch.add(Box.createVerticalStrut(20));
    texte_ch.setBackground(Color.WHITE);
    
    // Ajouter l'image au panel de la chambre
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 0.3; 
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(10, 10, 10, 20); 
    chambrePanel.add(iconLabel_ch, gbc);
    
    // Ajouter le panel de texte au panel de la chambre
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 0.7; 
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(10, 20, 10, 10); 
    chambrePanel.add(texte_ch, gbc);
    
    panneauChambres.add(chambrePanel);
  
	//espacement
    JPanel spacerPanel_f = new JPanel();
    spacerPanel_f.setPreferredSize(new Dimension(1350, 60));
    spacerPanel_f.setMaximumSize(new Dimension(1350, 60));
    spacerPanel_f.setBackground(new Color(245, 245, 245));
    panneauChambres.add(spacerPanel_f);
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
public JButton gettitre(){
		return titre;
	}
}