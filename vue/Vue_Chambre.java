package vue;
import classe.*;
import controlleur.*;
import model.*;
import main.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.border.Border;
import java.awt.Graphics;
import java.awt.Insets;
import java.time.LocalDate; 
import java.time.Month;



public class Vue_Chambre extends JFrame {
    Model_prc_Chambre mod;
    int index;
    public Chambre chambreActuelle;
	Dimension t_ecran = Toolkit.getDefaultToolkit().getScreenSize();
	JButton reserverBtn;
	public Vue_transition v_tr;
	public Chambre[]cha_r1;
	public Date arrivee;
	public Date depart;
	public Client client;
	public Hotel h_k;
	public Vue_date v_date;
    public Vue_Chambre(Model_prc_Chambre md, int index) {
        super("RoomBloom - Chambre");
        this.mod = md;
        this.index = index;
        this.setLayout(new BorderLayout());
		AppContext.vueChambre = this;
    // Récupérer la chambre actuelle via l’index
	this.chambreActuelle = mod.getChambre(index);
	this.cha_r1 = new Chambre[]{chambreActuelle};
	Model_transition model_trans = new Model_transition();

	LocalDate currentDate = LocalDate.now();

	LocalDate currentDate_js = currentDate.plusDays(1);
	int jour = currentDate_js.getDayOfMonth();
	String mois = currentDate_js.getMonth().name().toLowerCase();
	int annee = currentDate_js.getYear();

	LocalDate dateDep = currentDate_js.plusDays(1);
	int jourDep = dateDep.getDayOfMonth();
	String moisDep = dateDep.getMonth().name().toLowerCase();
	int anneeDep = dateDep.getYear();
		
	Date setupDate = new Date(jour, 6, annee, 17, 00);
	Date ajd = new Date(jour, setupDate.getIntMonth_english(mois), annee, 17, 00);

	arrivee = new Date(jour, setupDate.getIntMonth_english(mois), annee, 17, 00);
	depart = new Date(jourDep, setupDate.getIntMonth_english(moisDep), anneeDep, 15, 00);

	// Vue et contrôleurs
	client = mod.clt.getCurrentUser();
	h_k = chambreActuelle.hotel;

	v_tr = new Vue_transition(h_k, cha_r1, arrivee, depart, client);
	v_date = new Vue_date(arrivee, depart, ajd);

	// Création visuelle (en fonction de t_ecran que tu dois avoir défini quelque part)
	Dimension dimTrans = new Dimension(921,362);
	Dimension dimFull = new Dimension((int)(t_ecran.getWidth()), (int)(t_ecran.getHeight() * 0.95));
	Dimension dimDate = new Dimension((int)(t_ecran.getWidth() * 0.3), (int)(t_ecran.getHeight() * 0.5));

	v_tr.setPreferredSize(dimTrans);
	v_tr.pack();

	v_date.setPreferredSize(dimDate);
	v_date.pack();

        // ----- Barre du haut -----
        JPanel topBar = new JPanel(new BorderLayout());

        JButton btnRetour = new JButton("← Retour");
		btnRetour.setBackground(new Color(245,245,245));
		btnRetour.setFocusPainted(false);
		btnRetour.addActionListener(e -> {
			this.dispose();
		});
        topBar.add(btnRetour, BorderLayout.WEST);

        // *** PANEL GAUCHE : affichage de l'image ***
        JPanel panelGauche = new JPanel(new BorderLayout());
        panelGauche.setBackground(Color.WHITE);

        String[] imagePaths = chambreActuelle.images;
        ImageIcon img1 = loadScaledIcon(imagePaths[0], 500, 400);
        JLabel imgLabel = new JLabel(img1);
        panelGauche.add(imgLabel, BorderLayout.WEST);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(500, 500));
        imgLabel.setBounds(50, 0, 500, 500);
        layeredPane.add(imgLabel, JLayeredPane.DEFAULT_LAYER);

        if (imagePaths.length > 1) {
            ImageIcon img2 = loadScaledIcon(imagePaths[1], 500, 400);

            JButton voirPlus = new JButton("Voir plus");
			voirPlus.setBackground(new Color(245,245,245));
			voirPlus.setFocusPainted(false);
            JButton retour = new JButton("←");
			retour.setBackground(new Color(245,245,245));
			retour.setFocusPainted(false);
            retour.setVisible(false);

            voirPlus.addActionListener(e -> {
                imgLabel.setIcon(img2);
                voirPlus.setVisible(false);
                retour.setVisible(true);
            });

            retour.addActionListener(e -> {
                imgLabel.setIcon(img1);
                retour.setVisible(false);
                voirPlus.setVisible(true);
            });

            JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            btnPanel.setOpaque(false);
            btnPanel.add(voirPlus);
            btnPanel.add(retour);
            btnPanel.setBounds(10, 10, 100, 100);
            layeredPane.add(btnPanel, JLayeredPane.PALETTE_LAYER);
        }

        panelGauche.add(layeredPane, BorderLayout.CENTER);

        // *** PANEL DROITE : description + bouton réservation + services ***
        JPanel panelDroite = new JPanel();
        panelDroite.setLayout(new BoxLayout(panelDroite, BoxLayout.Y_AXIS));
        panelDroite.setBackground(Color.WHITE);
        panelDroite.setBorder(BorderFactory.createEmptyBorder(50, 50, 170, 100));

        // Description + bouton reservation
        JTextPane description = createDescriptionPane();
		panelDroite.add(description);


        // Services bas de page
        Color roseGrisClair = new Color(180, 160, 130);

        JPanel basGlobal = new JPanel(new BorderLayout());
		
        JPanel sercicePanelglob = new JPanel();
		RoundedPanel servicesPanel = new RoundedPanel(60);
		servicesPanel.setLayout(new GridLayout(3, 3, 10, 0));
		servicesPanel.setBackground(roseGrisClair);


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

        for (String service : services) {
            String emoji = service.substring(0, service.indexOf(" ")).trim();
            String texte = service.substring(service.indexOf(" ")).trim();

            JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
			linePanel.setBackground(roseGrisClair);
			
            JLabel emojiLabel = new JLabel(emoji);
            emojiLabel.setFont(new Font("SansSerif", Font.PLAIN, 28));

            JLabel textLabel = new JLabel(texte);
            textLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

            linePanel.setBorder(BorderFactory.createEmptyBorder(20, 120, 20, 0));
            linePanel.add(emojiLabel);
            linePanel.add(textLabel);

            servicesPanel.add(linePanel);
        }

        basGlobal.add(servicesPanel, BorderLayout.NORTH);
		
		JPanel esp = new JPanel();
		esp.setPreferredSize(new Dimension(1350, 200));
		esp.setBackground(Color.WHITE);

        // Footer légal
        JPanel mt_legl = new JPanel(new GridLayout(4, 4));
        mt_legl.setBackground(Color.LIGHT_GRAY);

        ImageIcon icon_mt = new ImageIcon("images//icone_site.png");
        Image image_mt = icon_mt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel iconLabel_mt = new JLabel(new ImageIcon(image_mt));

        JLabel[] infos = {
            new JLabel("RoomBloom"), new JLabel("97 rue George Leclerc"), new JLabel("33800 Bordeaux"),
            new JLabel("Accueil"), new JLabel("En savoir plus"), new JLabel("Où voyager ?"),
            new JLabel("Voyager en Europe"), new JLabel("Voyager en Asie"), new JLabel("Voyager en Afrique"),
            new JLabel("Nous contacter"), new JLabel("Instagram : @RoomBloom_fr"),
            new JLabel("Facebook : @RoomBloom_fr"), new JLabel("X : @RoomBloom_fr")
        };

        mt_legl.add(new JLabel(" "));
        mt_legl.add(infos[0]); mt_legl.add(infos[3]); mt_legl.add(infos[5]);
        mt_legl.add(infos[9]); mt_legl.add(new JLabel(" "));
        mt_legl.add(infos[1]); mt_legl.add(infos[4]); mt_legl.add(infos[6]);
        mt_legl.add(infos[10]); mt_legl.add(iconLabel_mt); mt_legl.add(infos[2]);
        mt_legl.add(new JLabel(" ")); mt_legl.add(infos[7]); mt_legl.add(infos[11]);
        mt_legl.add(new JLabel(" ")); mt_legl.add(new JLabel(" "));
        mt_legl.add(new JLabel(" ")); mt_legl.add(infos[8]); mt_legl.add(infos[12]);

        basGlobal.add(mt_legl, BorderLayout.SOUTH);

        // Assemblage final
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelGauche, panelDroite);
        split.setDividerSize(0);
        split.setResizeWeight(0);
        split.setEnabled(false);

        JPanel gen = new JPanel();
        gen.setLayout(new BorderLayout());
		gen.add(topBar, BorderLayout.NORTH);
        gen.add(split, BorderLayout.CENTER);
        gen.add(basGlobal, BorderLayout.SOUTH);
		
		UIManager.put("ScrollBar.width", 0); 

		JScrollPane scrollPane_chambre = new JScrollPane(gen);
		scrollPane_chambre.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_chambre.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_chambre.setPreferredSize(new Dimension(1350,768));
		scrollPane_chambre.getVerticalScrollBar().setUnitIncrement(12);
		
        this.setContentPane(scrollPane_chambre);
        this.pack();
        this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(t_ecran);
    }

    /** Charge et met à l'échelle une ImageIcon depuis un chemin */
    private ImageIcon loadScaledIcon(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    /** Crée un JTextPane pour la description + prix */
	public JTextPane createDescriptionPane() {
		JTextPane descriptionText = new JTextPane();
		descriptionText.setEditable(false);
		descriptionText.setFocusable(false);
		descriptionText.setBackground(new Color(180, 160, 130)); // Couleur roseGrisClair
		descriptionText.setFont(new Font("Arial", Font.PLAIN, 14));
		descriptionText.setPreferredSize(new Dimension(700, 150));
		descriptionText.setBorder(BorderFactory.createEmptyBorder(30, 70, 30, 70));

		StyledDocument doc = descriptionText.getStyledDocument();

		// Création des styles
		Style stylePrix = descriptionText.addStyle("prix", null);
		StyleConstants.setForeground(stylePrix, Color.BLACK);
		StyleConstants.setFontFamily(stylePrix, "Georgia");
		StyleConstants.setItalic(stylePrix, true);
		StyleConstants.setBold(stylePrix, true);
		StyleConstants.setFontSize(stylePrix, 18);

		Style styleRose = descriptionText.addStyle("rose", null);
		StyleConstants.setForeground(styleRose, new Color(120, 100, 70));
		StyleConstants.setBold(styleRose, true);

		Style styleNoir = descriptionText.addStyle("noir", null);
		StyleConstants.setForeground(styleNoir, Color.BLACK);

		// Récupérer la description via le modèle
		String[] descriptionParts = mod.getDescription(index); 
		int prix = chambreActuelle.prix;

		try {
			doc.insertString(doc.getLength(), descriptionParts[0], styleRose);  
			doc.insertString(doc.getLength(), descriptionParts[1], styleNoir);  
			doc.insertString(doc.getLength(), "\n\n", styleNoir); 
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		reserverBtn = new JButton("Je réserve");
		reserverBtn.setBackground(Color.WHITE);
		reserverBtn.setForeground(Color.BLACK);
		reserverBtn.setFont(new Font("Georgia", Font.PLAIN, 12));
		reserverBtn.setPreferredSize(new Dimension(120, 40));
		reserverBtn.addActionListener(e -> {
			NavControlleur controlleur_vers_trans = new NavControlleur(this ,v_tr);
			Main_prjt.lancerReservationDepuisVueChambre();
		});

		JPanel prixPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		prixPanel.setOpaque(false);
		JLabel prx = new JLabel("Prix : " + prix + " €");
		prx.setForeground(Color.BLACK);
		prx.setFont(new Font("Georgia", Font.ITALIC, 20));
		prx.setBorder(BorderFactory.createEmptyBorder(30, 70, 30, 70));
		prixPanel.add(prx);
		prixPanel.add(reserverBtn);

		descriptionText.insertComponent(prixPanel);

		return descriptionText;
	}
	public JButton getbutt() {
		return reserverBtn;
	}
	public Date getArrivee() {
    return this.arrivee;
	}

	public Date getDepart() {
		return this.depart;
	}

	public Client getClient() {
		return this.client;
	}

	public Hotel getHotel() {
		return this.h_k;
	}
	public boolean isReady() {
    return  client != null 
        && h_k != null 
        && cha_r1 != null 
        && cha_r1.length > 0;
	}
}


