import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;


public class PageAvecImageEtCarte extends JFrame {
     Model_prc mod;
     int index;
     JLabel imageLabel;
     JLabel titre;
     JButton retourButton;
     JButton butt;
  
    
    public JMenuBar bar = new JMenuBar();
    JMenu dest = new JMenu("Destinations");
    JMenu selct = new JMenu("Nos sélections");
    JMenu sav = new JMenu("En savoir plus");

    public PageAvecImageEtCarte(Model_prc md, int index) {
        super("Voyagez en Afrique");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        imageLabel = new JLabel();
	this.mod = md;
        this.index = index;

        // Barre de menu
        ImageIcon icon = new ImageIcon("icone_site.png");
        Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(image));
        titre = new JLabel("RoomBloom");
        titre.setForeground(new Color(0, 0, 0));
        titre.setFont(new Font("Georgia", Font.ITALIC, 20));
        butt = new JButton("Me connecter/ M'inscrire");
        butt.setBackground(new Color(245, 245, 245));
        butt.setFocusPainted(false);



        JPanel separator = new JPanel();
        separator.setPreferredSize(new Dimension(2, 40));
        separator.setMaximumSize(new Dimension(2, 40));
        separator.setBackground(Color.GRAY);

        JMenuItem rec_dest1 = new JMenuItem("Voyagez en Asie");
        JMenuItem rec_dest2 = new JMenuItem("Voyagez en Europe");
        JMenuItem rec_dest3 = new JMenuItem("Voyagez en Afrique");
        JMenuItem rec_selct1 = new JMenuItem("Nos Chambres insolites");
        JMenuItem rec_selct2 = new JMenuItem("Nos suites luxueuses");
        JMenuItem rec_selct3 = new JMenuItem("Nos Chambres familliales");
        JMenuItem rec_selct4 = new JMenuItem("Nos Chambres solo pour vous");

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

//bar.add(sav);
//sav.setFont(new Font("Georgia", Font.PLAIN, 12));

// Ajouter un espace
bar.add(Box.createHorizontalStrut(10));


// Créer le bouton "Retour"
retourButton = new JButton("Retour");
retourButton.setFont(new Font("Georgia", Font.PLAIN, 12));
retourButton.setBackground(new Color(245, 245, 245));
retourButton.setFocusPainted(false);


bar.add(retourButton);

// Ajouter un espace
bar.add(Box.createHorizontalStrut(550));

// Ajouter le bouton "Se connecter / S'inscrire"
butt.setFont(new Font("Georgia", Font.PLAIN, 12));
bar.add(butt);

        bar.add(Box.createHorizontalStrut(15));
        bar.setPreferredSize(new Dimension(90, 91));





        //  Couleurs
        Color fondClair = new Color(0, 0, 0);
        Color roseGrisClair = new Color(180, 160, 130);
        Color blancCasse = new Color(245, 245, 240);

//  PANEL GAUCHE
JPanel panelGauche = new JPanel(new BorderLayout());
panelGauche.setBackground(fondClair);
panelGauche.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
panelGauche.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

Set<Integer> deuxImagesIndices = new HashSet<>(Arrays.asList(
    80,81, 96, 97, 98, 99, 100, 101, 102, 103, // Afrique - Suites présidentielles
   // 104, 105, 106, 107, // Paris - Suites présidentielles
   // 108, 109, 110, 111, // Autres - Suites présidentielles (suP)
   // 112,
 113, 114, 107,
//115, // Kyoto - Suites (pas forcément présidentielles)
    116, 117, 118, 119,  // Reykjavik - Suites (pas forcément présidentielles)
   88, 89,90,91,92,93,94,95
));

if (deuxImagesIndices.contains(index)) {
    ImageIcon temp1 = null;
    ImageIcon temp2 = null;

    switch (index) {

	case 80:
            temp1 = new ImageIcon(new ImageIcon("suite_monnet_paris.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("suite_monnet_paris_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;

	case 81:
            temp1 = new ImageIcon(new ImageIcon("suite_dior_paris.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("suite_dior_paris_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;

	 case 88:
            temp1 = new ImageIcon(new ImageIcon("Hanami_Kyoto_Suite_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Hanami_Kyoto_Suite_2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 89:
            temp1 = new ImageIcon(new ImageIcon("Samurai_Kyoto_Suite_2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Samurai_Kyoto_Suite_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 90:
            temp1 = new ImageIcon(new ImageIcon("Caligraphie_kyoto_Suite_2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Caligraphie_kyoto_Suite_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	case 91:
            temp1 = new ImageIcon(new ImageIcon("Mystique_Kyoto_Suite_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Mystique_Kyoto_Suite_2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;



        case 96:
            temp1 = new ImageIcon(new ImageIcon("LacRose_suite_p1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("LacRose_suite_p2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
        case 97:
            temp1 = new ImageIcon(new ImageIcon("zoo_suite_p1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("zoo_suite_p2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
        case 98:
            temp1 = new ImageIcon(new ImageIcon("lion_suite_p1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("lion_suite_p2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 99:
            temp1 = new ImageIcon(new ImageIcon("sheraton_suite_p1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("sheraton_suite_p2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 100:
            temp1 = new ImageIcon(new ImageIcon("reveOriental_suite_p1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("reveOriental_suite_p2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 101:
            temp1 = new ImageIcon(new ImageIcon("OasisDeLuxe_suite_p1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("OasisDeLuxe_suite_p2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 102:
            temp1 = new ImageIcon(new ImageIcon("riadModerne_suite_p1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("riadModerne_suite_p2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 103:
            temp1 = new ImageIcon(new ImageIcon("AtlasMajestueux_suite_p1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("AtlasMajestueux_suite_p2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	case 107:
            temp1 = new ImageIcon(new ImageIcon("suite_pres_elysee_paris.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("suite_pres_elysee_paris_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;


	//case 92:
       //     temp1 = new ImageIcon(new ImageIcon("suite_pres_louvres_paris.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
       //     temp2 = new ImageIcon(new ImageIcon("suite_pres_louvres_paris_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
      //      break;
     //   case 93:
      //      temp1 = new ImageIcon(new ImageIcon("suite_pres_luxe_paris.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
      //      temp2 = new ImageIcon(new ImageIcon("suite_pres_luxe_paris_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
      //      break;
        //case 94:
          //  temp1 = new ImageIcon(new ImageIcon("suite_pres_traditionnelfrancais_paris.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            //temp2 = new ImageIcon(new ImageIcon("suite_pres_traditionnelfrancais_paris_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
      //      break;
	// case 95:
          //  temp1 = new ImageIcon(new ImageIcon("suite_pres_elysee_paris.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
         //   temp2 = new ImageIcon(new ImageIcon("suite_pres_elysee_paris_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
           // break;




      //  case 112:
       //     temp1 = new ImageIcon(new ImageIcon("Luxe_Kyoto_Suitep.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
       //     temp2 = new ImageIcon(new ImageIcon("Luxe_Kyoto_Suitep_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
        //    break;
        case 113:
            temp1 = new ImageIcon(new ImageIcon("Sushi_Kyoto_Suitep_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Sushi_Kyoto_Suitep.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	case 114:
            temp1 = new ImageIcon(new ImageIcon("Moderne_Kyoto_Suitep_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Moderne_Kyoto_Suitep.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	// case 115:
          //  temp1 = new ImageIcon(new ImageIcon("Hanabi_Kyoto_Suitep_4.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
       //     temp2 = new ImageIcon(new ImageIcon("Hanabi_Kyoto_Suitep_4_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
          //  break;

	case 92:
            temp1 = new ImageIcon(new ImageIcon("Alcool_Reykjavik_Suite.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Alcool_Reykjavik_Suite_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 93:
            temp1 = new ImageIcon(new ImageIcon("Cascade_Reykjavik_Suite_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Cascade_Reykjavik_Suite.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 94:
            temp1 = new ImageIcon(new ImageIcon("Baleine_Reykjavik_Suite_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Baleine_Reykjavik_Suite.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	case 95:
            temp1 = new ImageIcon(new ImageIcon("Marin_Reykjavik_Suite_2.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Marin_Reykjavik_Suite.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
        

	 case 116:
            temp1 = new ImageIcon(new ImageIcon("Luxe_Reykjavik_Suitep.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Luxe_Reykjavik_Suitep_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 117:
            temp1 = new ImageIcon(new ImageIcon("Impérial_Reykjavik_Suitep.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Impérial_Reykjavik_Suitep_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	 case 118:
            temp1 = new ImageIcon(new ImageIcon("Glace_futur_Reykjavik_Suitep.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Glace_futur_Reykjavik_Suitep_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
	case 119:
            temp1 = new ImageIcon(new ImageIcon("Nature_Reykjavik_Suitep_1.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            temp2 = new ImageIcon(new ImageIcon("Nature_Reykjavik_Suitep.png").getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH));
            break;
        default:
            return;
    }

    // Utiliser ImageIcon pour les images
    final ImageIcon image1 = temp1;
    final ImageIcon image2 = temp2;

    JLabel imageLabel = new JLabel(image1);
    imageLabel.setBounds(0, 0, 700, 600);

    JButton voirPlusBtn = new JButton("Voir plus");
    JButton retourBtn = new JButton("←");
    retourBtn.setVisible(false);
    voirPlusBtn.setBackground(blancCasse);
    voirPlusBtn.setForeground(Color.BLACK);
    retourBtn.setBackground(blancCasse);
    retourBtn.setForeground(Color.BLACK);

    voirPlusBtn.addActionListener(e -> {
        imageLabel.setIcon(image2);
        voirPlusBtn.setVisible(false);
        retourBtn.setVisible(true);
    });

    retourBtn.addActionListener(e -> {
        imageLabel.setIcon(image1);
        voirPlusBtn.setVisible(true);
        retourBtn.setVisible(false);
    });

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(700, 600));
    layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.setBounds(470, 500, 180, 50);
    buttonPanel.setOpaque(false);
    buttonPanel.add(voirPlusBtn);
    buttonPanel.add(retourBtn);
    layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);

    panelGauche.add(layeredPane, BorderLayout.NORTH);
} else {
    // Afficher les autres images sans boutons
    Image image5 = new ImageIcon(mod.images[index]).getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH);

    ImageIcon scaledIcon = new ImageIcon(image5); // convertir en ImageIcon pour JLabel
    JLabel imageLabel = new JLabel(scaledIcon);
    imageLabel.setBounds(0, 0, 700, 600);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(700, 600));
    layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

    panelGauche.add(layeredPane, BorderLayout.NORTH);
}




 // PANEL DROITE
JPanel panelDroite = new JPanel();
panelDroite.setLayout(new BoxLayout(panelDroite, BoxLayout.Y_AXIS));  // BoxLayout pour empiler les composants verticalement
panelDroite.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
panelDroite.setBackground(fondClair);
panelDroite.setMaximumSize(new Dimension(100, Integer.MAX_VALUE));

// Description Panel
JPanel descriptionPanel = new JPanel();
descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS)); // Utilisation du BoxLayout ici
//descriptionPanel.setBorder(BorderFactory.createCompoundBorder(
       // BorderFactory.createLineBorder(Color.BLACK, 2),
     //   BorderFactory.createEmptyBorder(0, 0, 0, 0)
//));
descriptionPanel.setBackground(roseGrisClair);
descriptionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

// Titre
JLabel titreDesc = new JLabel(mod.types[index] + " - " + mod.themes[index]);
titreDesc.setFont(new Font("Arial", Font.BOLD, 16));
titreDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
titreDesc.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

// Texte
JTextPane descriptionText = new JTextPane();
descriptionText.setEditable(false);
descriptionText.setFocusable(false);
descriptionText.setBackground(descriptionPanel.getBackground());
descriptionText.setFont(new Font("Arial", Font.PLAIN, 14));
descriptionText.setPreferredSize(new Dimension(300, 150)); // légèrement réduit
descriptionText.setBorder(BorderFactory.createEmptyBorder(30, 70, 70, 70)); // décalage gauche via marge interne

StyledDocument doc = descriptionText.getStyledDocument();

Style stylePrix = descriptionText.addStyle("prix", null);
StyleConstants.setForeground(stylePrix, Color.BLACK); 
StyleConstants.setBold(stylePrix, true);
StyleConstants.setFontSize(stylePrix, 18);


Style styleRose = descriptionText.addStyle("rose", null);
StyleConstants.setForeground(styleRose, new Color(120, 100, 70));
StyleConstants.setBold(styleRose, true);

Style styleNoir = descriptionText.addStyle("noir", null);
StyleConstants.setForeground(styleNoir, Color.BLACK);

String[] descriptionParts = mod.getDescription(index); // [base, suite]
int prix = mod.getPrix(index); 

try {
    doc.insertString(doc.getLength(), descriptionParts[0], styleRose); // intro rose
    doc.insertString(doc.getLength(), descriptionParts[1], styleNoir);  // suite en noir
    doc.insertString(doc.getLength(),"                                           Prix TTC  " + prix + " € ", stylePrix);
} catch (BadLocationException e) {
    e.printStackTrace();
}

// Wrapper vertical pour empiler titre + texte
JPanel contentWrapper = new JPanel();
contentWrapper.setLayout(new BoxLayout(contentWrapper, BoxLayout.Y_AXIS));
contentWrapper.setBackground(descriptionPanel.getBackground());
contentWrapper.add(titreDesc);
//contentWrapper.add(Box.createVerticalStrut(100));
contentWrapper.add(descriptionText);

// Ajout au panneau avec centrage vertical
descriptionPanel.add(contentWrapper);

// --- Bouton "Je réserve" ---
// Créer un panel pour le bouton
JPanel buttonPanel1 = new JPanel();
buttonPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));  // FlowLayout centré pour aligner le bouton au centre
buttonPanel1.setBackground(descriptionPanel.getBackground()); // Garder la même couleur de fond

// Créer le bouton
JButton reserverBtn = new JButton("Je réserve");
reserverBtn.setBackground(blancCasse);
reserverBtn.setForeground(Color.BLACK);
reserverBtn.setFont(new Font("Georgia", Font.PLAIN, 12));
reserverBtn.setPreferredSize(new Dimension(180, 50)); // Taille du bouton


buttonPanel1.add(reserverBtn);

// Ajouter le panel du bouton à la fin de descriptionPanel (en bas)
descriptionPanel.add(buttonPanel1);

// Ajouter descriptionPanel au panelDroite 
panelDroite.add(descriptionPanel);


        // Carte Panel
        JPanel cartePanel = new JPanel(new BorderLayout());
        cartePanel.setPreferredSize(new Dimension(700, 300));
        cartePanel.setMaximumSize(new Dimension(700, 300));
        //cartePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        ImageIcon carteImageIcon = new ImageIcon(new ImageIcon("carte.png").getImage().getScaledInstance(700, 300, Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(carteImageIcon);
        backgroundLabel.setLayout(new BorderLayout());
        cartePanel.add(backgroundLabel, BorderLayout.CENTER);
	cartePanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));


        panelDroite.add(descriptionPanel);
        panelDroite.add(cartePanel);

        // SPLITPANE
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelGauche, panelDroite);
        splitPane.setDividerSize(0);
        splitPane.setResizeWeight(0);
        splitPane.setEnabled(false);
        splitPane.setBorder(null);



//BAS
JPanel basGlobal = new JPanel(new BorderLayout());
//basGlobal.setPreferredSize(new Dimension(1350, 400));
basGlobal.setBackground(roseGrisClair);

// Création du panneau central pour les éléments, en grille 3x3
JPanel servicesPanel = new JPanel(new GridLayout(3, 3, 10, 0));
servicesPanel.setBackground(roseGrisClair);

// Définir les textes (sans emojis)
String[] services = {
    "☕      Petit déjeuner buffet",
    "🚗      Parking en libre service",
    "🐶      Animaux acceptés",
    "🏊      Piscine extérieure",
    "📶      Wifi gratuite",
    "🍽️      Service d'étage",
    "📞      Réception ouverte 24h/24",
    "🌞      Terrasse",
    "🍷      Bar et salon"
};

// Ajouter les éléments alignés à gauche avec émoji plus grand
for (String service : services) {
    // Séparer l’émoji du texte
    String emoji = service.substring(0, service.indexOf(" ")).trim();
    String texte = service.substring(service.indexOf(" ")).trim();

    // Créer un sous-panel horizontal
    JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
    linePanel.setBackground(roseGrisClair);

    // Emoji agrandi
    JLabel emojiLabel = new JLabel(emoji);
    emojiLabel.setFont(new Font("SansSerif", Font.PLAIN, 28));

    // Texte normal
    JLabel textLabel = new JLabel(texte);
    textLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

    // Ajouter dans la ligne
    linePanel.setBorder(BorderFactory.createEmptyBorder(20, 120, 20, 0)); // décalage global
    linePanel.add(emojiLabel);
    linePanel.add(textLabel);

    // Ajouter la ligne au panel principal
    servicesPanel.add(linePanel);
}

// Ajout du panneau de services au centre
basGlobal.add(servicesPanel, BorderLayout.CENTER);

        JPanel mt_legl = new JPanel(new GridLayout(4, 4));
        mt_legl.setBackground(Color.LIGHT_GRAY);
        ImageIcon icon_mt = new ImageIcon("icone_site.png");
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

        basGlobal.add(mt_legl, BorderLayout.SOUTH);

        //CONTENT
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        contentPanel.add(splitPane, BorderLayout.CENTER);
        contentPanel.add(basGlobal, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1350, 400));
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        this.setContentPane(scrollPane);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
}
