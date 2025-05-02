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


public class Vue_prcp extends JFrame {
	Model_prjt mod;
	JButton butt;

	//Composants de la barre menu
	JMenuBar bar = new JMenuBar();
	JMenu dest = new JMenu("Destinations");
	JMenu selct = new JMenu("Nos sélections");
	JMenu sav = new JMenu("En savoir plus");
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
public Vue_prcp(Model_prjt mode){
	mod = mode;

	//insertion du logo + composants de la barre de menu
	ImageIcon icon = new ImageIcon("images//icone_site.png"); 
	Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	JLabel iconLabel = new JLabel(new ImageIcon(image));
	JLabel titre = new JLabel("RoomBloom");
	p_vue_prcp controleur = new p_vue_prcp(this, mod);
	p_vue_prcp.rendreJLabelCliquable(titre, controleur);
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
	//p_vue_asie asieController = new p_vue_asie(this, mod);
	//rec_dest1.addActionListener(asieController);
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

	// 2. Ajoutez un écouteur d'événements au bouton de recherche:
	butt_rch.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String termeRecherche = br_ch.getText();
        // Recherche que si le texte non null
        if (!termeRecherche.isEmpty() && !termeRecherche.equals("Rechercher...")) {            
            // Désactiver le bouton pendant le chargement pour éviter les clics multiples
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
            
            // Afficher la boîte de dialogue de chargement dans un thread séparé
            // pour ne pas bloquer l'interface utilisateur
            SwingUtilities.invokeLater(() -> {
                loading.setVisible(true);
            });
            
            // Exécuter le chargement en arrière-plan
            SwingWorker<Vue_Resultats_Recherche, Void> worker = new SwingWorker<Vue_Resultats_Recherche, Void>() {
                @Override
                protected Vue_Resultats_Recherche doInBackground() throws Exception {
                    // Définition du tableau de noms de fichiers avec tous les éléments
                    String[] nomsFichiers = {"Automne_Kyoto_Double.png", "Caligraphie_kyoto_Suite_2.png","CarpeKoi_Kyoto_Simple.png","Cyberpunk_Kyoto_Double.png","Dragon_Kyoto_Simple.png",
					"Futuriste_Kyoto_Simple.png","Ghibli_Kyoto_Simple.png","Hanabi_Kyoto_Suitep_4.png","Hanami_Kyoto_Suite_1.png","Luxe_Kyoto_Suitep.png","Lycoris_Kyoto_Double.png",
					"Minimalisme_Kyoto_Double.png","Moderne_Kyoto_Suitep_1.png","Mystique_Kyoto_Suite_1.png","Ninja_Kyoto_Double.png","Pokemon_Kyoto_Double.png","Samurai_Kyoto_Suite_2.png",
					"Sushi_Kyoto_Suitep_1.png","Tradition_printemps_Kyoto_Simple.png","Traditionnelle_Kyoto_Simple.png","d_1t.png","s_1t.png","s_2t.png","suP_3t.png","su_1t.png","s_3t.png",
					"d_3t.png","d_2t.png","suP_1t.png","suP_2t.png","d_5t.png","s_4t.png","d_4t.png","su_2t.png","s_5t.png","suP_4t.png","su_3t.png","d_6t.png","su_4t.png","s_6t.png",
					"chambre_double_boheme_paris.png","chambre_simple_futuriste_paris.png","chambre_double_romantiqueparisien_paris.png","suite_pres_louvres_paris.png","suite_monnet_paris.png",
					"suite_dior_paris.png","chambre_simple_traditionnel_paris.png","chambre_double_moderneparisien_paris.png","chambre_simple_royal_paris.png","chambre_simple_parisien_paris.png",
					"suite_pres_traditionnelfrancais_paris.png","chambre_double_moulinrouge_paris.png","chambre_simple_moderne_paris.png","suite_rococo_paris.png","chambre_double_cabinetdecuriosite_paris.png",
					"suite_pres_luxe_paris.png","chambre_simple_minimaliste_paris.png","suite_modernefuturiste_paris.png","suite_pres_elysee_paris.png","chambre_double_luxe_paris.png","Aurore_Reykjavik_Simple.png",
					"Baleine_Reykjavik_Suite_1.png","Basalte_Reykjavik_Double.png","Cascade_Reykjavik_Suite_1.png","Futuriste_Reykjavik_Simple.png","Glace_futur_Reykjavik_Suitep.png","Glaciers_Reykjavik_Double.png",
					"Igloo_Reykjavik_Simple.png","Imperial_Reykjavik_Suitep.png","Lagoon_Reykjavik_Simple.png","Luxe_Reykjavik_Suitep.png","Minimaliste_Reykjavik_Double.png","Montagnes_Reykjavik_Double.png",
					"Marin_Reykjavik_Suite_2.png","Nature_Reykjavik_Suitep_1.png","Ours_Polaire_Reykjavik_Double.png","Traditionnel_Reykjavik_Simple.png","Viking_Reykjavik_Simple.png","Volcan_Reykjavik_Double.png",
					"Alcool_Reykjavik_Suite.png","arabe_cham_s.png","argile_cham_d.png","atay_cham_d.png","AtlasMajestueux_suite_p1.png","babouche_cham_s.png","couscous_cham_d.png","datte_suite_n.png","flouka_cham_s.png",
					"hamam_suite_n.png","henna_cham_d.png","jame3lefna_cham_d.png","mosquee_cham_s.png","OasisDeLuxe_suite_p1.png","olivier_suite_n.png","or_cham_s.png","reveOriental_suite_p1.png","riadModerne_suite_p1.png",
					"souk_suite_n.png","tajine_cham_d.png","tborida_cham_s.png","barque_cham_s.png","cacao_cham_s.png","couleurs_cham_d.png","chocolat_cham_s.png","foot_cham_d.png","fruitexotic_suite_n.png","ile_suite_n.png",
					"instrumentXalam_cham_s.png","koya_suite_n.png","LacRose_suite_p1.png","lion_suite_p1.png","maison_senegalaise_cham_d.png","mosquee_s_cham_d.png","moustiquaire_cham_d.png","ocean_cham_s.png","orange_s_cham_d.png",
					"riz_cham_s.png","sheraton_suite_p1.png","tresse_suite_n.png","zoo_suite_p1.png"};
                    
                    // Définir les tableaux correspondants de catégories et thèmes
                    String[] categories = {"Chambre double","Suite","Chambre simple","Chambre double","Chambre Simple","Chambre simple","Chambre simple","Suite présidentielle","Suite",
					"Suite présidentielle","Chambre double","Chambre double","Suite présidentielle","Suite","Chambre double","Chambre double","Suite","Suite présidentielle","Chambre simple",
					"Chambre simple","Chambre double","Chambre simple","Chambre simple","Suite présidentielle","Suite","Chambre simple","Chambre double","Chambre double","Suite présidentielle",
					"Suite présidentielle","Chambre double","Chambre simple","Chambre double","Suite","Chambre simple","Suite présidentielle","Suite","Chambre double","Suite","Chambre simple",
					"Chambre double","Chambre simple","Chambre double","Suite présidentielle","Suite","Suite","Chambre simple","Chambre double","Chambre simple","Chambre simple","Suite présidentielle",
					"Chambre double","Chambre simple","Suite","Chambre double","Suite présidentielle","Chambre simple","Suite","Suite présidentielle","Chambre double","Chambre simple","Suite","Chambre double",
					"Suite","Chambre simple","Suite présidentielle","Chambre double","Chambre simple","Suite présidentielle","Chambre simple","Suite présidentielle","Chambre double","Chambre double","Suite",
					"Suite présidentielle","Chambre double","Chambre simple","Chambre simple","Chambre double","Suite","Chambre simple","Chambre double","Chambre double","Suite présidentielle","Chambre simple",
					"Chambre double","Suite","Chambre simple","Suite","Chambre double","Chambre double","Chambre simple","Suite présidentielle","Suite","Chambre simple","Suite présidentielle","Suite présidentielle",
					"Suite","Chambre double","Chambre simple","Chambre simple","Chambre simple","Chambre double","Chambre simple","Chambre double","Suite","Suite","Chambre simple","Suite","Suite présidentielle",
					"Suite présidentielle","Chambre double","Chambre double","Chambre double","Chambre simple","Chambre double","Chambre simple","Suite présidentielle","Suite","Suite présidentielle"};
                    
                    String[] themes_ch = {"sur le thème de l'automne","sur le thème de la caligraphie japonaise","sur le thème de la carpekoi","sur le thème de Cyberpunk","sur le thème des dragons",
					"futuriste","sur le thème de Ghibli","sur le thèmes des hanabi","sur le thèmes des hanabi","de luxe","sur le thème du Lycoris japonais","minimaliste","moderne","mystique",
					"sur le thème des ninja","sur le thème de pokémon","sur le thème des samouraï","sur le thème des sushis","printanière","traditionnelle","traditionnel","traditionnel",
					"sur le thème de Wan Makha Bucha","Royal","Traditionnel","sur le thème Wan Vaisakh Bucha","sur le thème des rues thailandaises","sur le thème des éléphants",
					"sur le thème des orchidées","dorée à l'Or pur","sur le thème Makha Bucha","sur le thème China town","sur le thème de Bo sang","sur le thème du festival des lumières",
					"sur le thème des tigres","du nouvelle an Chinois","sur le thème de la pleine lune","sur le thème de Phi Ta Khon","sur le thème de Lopburi","sur le thème de la fleur de lotus",
					"bohème","futuriste","romantique","sur le thème du Louvres","sur le thème de Monnet","sur le thème de Dior","traditionnel","moderne","royal","parisien","traditionnel","sur le thème du moulin rouge",
					"moderne","rococo","sur le thème cabinet de curiosité","de luxe","minimaliste","moderne/futuriste","sur le thème de l'élysée","de luxe","sur le thème des aurores boréales","sur le thème des baleines",
					"basalte","sur le thème des cascades","futuriste","sur le thème de la glace","sur le thème des glaciers","sur le thème des igloo","impérial","sur le thème des lagoon","de luxe","minimaliste",
					"sur le thème des montagnes","sur le thème marin","sur le thème des animaux","sur le thème des ours polaires","traditionnel","sur le thème des vikings","sur le thème des  volcans","sur le thème elixirs",
					"Andalouse","Ocre","sur le thème du Atay","sur le thème des lions","sur le thème des babouches","berbère","sur le thème des dattes","sur le thème des flouka","sur le thème du hammam","sur le thème du henné",
					"Jemaa el-Fna","Minaret","Oasis de luxe","sur le thème des oliviers","Zest","rêve oriental","riad moderne","sur le thème des épices","sur le thème du tajine","Sultane","sur le thème des barques","sur le thème cacao",
					"coloré","chocolaté","sur le thème du football","sur le thème des fruits exotiques","sur le thème des îles","sur le thèmes des Xalam","koya","lac rose","sur le thèmes des lions","sur le thèmes des maisons sénégalaises",
					"mosquée","sur le thème des moustiquaires","sur le thème des océan","orangé","sur le thème du riz","sheraton","sur le thème des tresse","sur le thème du zoo"};
                    
                    String[] themes_fil = {"Culture","Culture","Culture","Aimer des touristes","Aimer des touristes","Moderne","Aimer des touristes","Culture","Luxe","Luxe","Culture","Moderne","Moderne",
					"Culture","Culture","Aimer des touristes","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Culture","Culture","Luxe","Culture","Aimer des touristes",
					"Aimer des touristes","Culture","Aimer des touristes","Luxe","Culture","Luxe","Culture","Moderne","Moderne","Culture","Culture","Moderne","Aimer des touristes","moderne","Aimer des touristes",
					"Culture","Culture","Culture","Culture","Moderne","Luxe","Culture","Luxe","Culture","Moderne","Aimer des touristes","Aimer des touristes","Luxe","Moderne","Moderne","Luxe","Luxe","Aimer des touristes",
					"Aimer des touristes","Culture","Aimer des touristes","Moderne","Culture","Culture","Culture","Luxe","Luxe","Luxe","Moderne","Culture","Culture","Aimer des touristes","Aimer des touristes","Culture",
					"Culture","Culture","Culture","Moderne","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Luxe","Culture","Luxe","Luxe","Culture","Aimer par les touristes","Luxe","Luxe","Moderne",
					"Luxe","Moderne","Moderne","Aimer des touristes","Aimer des touristes","Culture","Culture","Aimer des tourites","Aimer des touristes","Luxe","Aimer des touristes","Culture","Luxe","Luxe","Moderne","Culture",
					"Culture","Luxe","Culture","Moderne","Aimer des touristes","Luxe","Culture","Moderne"};
                    
                    Vue_Resultats_Recherche vueResultats = new Vue_Resultats_Recherche(
                        termeRecherche, 
                        nomsFichiers, 
                        categories, 
                        themes_ch, 
                        themes_fil,
                        mode
                    );
                    
                    // Précharger les images les plus probables en fonction du terme de recherche
                    ChargementImages chargement = new ChargementImages();
                    chargement.setVue(vueResultats);
                    
                    return vueResultats;
                }
                
                @Override
                protected void done() {
                    try {
                        // Récupérer la vue créée dans doInBackground
                        Vue_Resultats_Recherche vueResultats = get();
                        
                        // Fermer la boîte de dialogue de chargement
                        loading.dispose();
                        
                        // Afficher la vue des résultats + suppression de la page 
                        vueResultats.setVisible(true);
						dispose();
                        
                        // Lancer le chargement des images en arrière-plan
                        ChargementImages chargement = new ChargementImages();
                        chargement.setVue(vueResultats);
                        
                        // Utiliser un autre SwingWorker pour le chargement des images
                        SwingWorker<Void, Void> imageLoader = new SwingWorker<Void, Void>() {
                            @Override
                            protected Void doInBackground() throws Exception {
                                chargement.chargerImages();
                                return null;
                            }
                        };
                        imageLoader.execute();
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        loading.dispose(); // S'assurer que la boîte de dialogue est fermée en cas d'erreur
                        
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

	// 3. Ajoutez également un écouteur pour la touche Entrée dans le champ de recherche:

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
	JLabel apr = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;Nos chambres que vous allez adorer !</html>");
	apr.setFont(new Font("Georgia", Font.PLAIN, 20));
	apercu.add(apr);
	apercu.setPreferredSize(new Dimension(1350,321));
	
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
	
	JButton butt_mb = new JButton("Devenir membre ?");	
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
	//texte_ml_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//texte_ml_8.addActionListener(asieController);
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
}
