import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnSavoirPlus extends JFrame {

	Model_prjt mod;
    private JButton butt;
    private JLabel lab;
    private JLabel imageLabel;
    private JLabel titre;
	JMenuItem rec_dest1 = new JMenuItem("Voyagez en Asie");
    JMenuItem rec_dest2 = new JMenuItem("Voyagez en Europe");
    JMenuItem rec_dest3 = new JMenuItem("Voyagez en Afrique");
	JMenuItem rec_selct1 = new JMenuItem("Nos Chambres familliales");
	JMenuItem rec_selct2 = new JMenuItem("Nos Chambres solo pour vous");
	JMenuItem rec_selct3 = new JMenuItem("Nos suites luxueuses");
    
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int largeur = (int)dim.getWidth();
	int hauteur = (int)dim.getHeight();
	
    JPanel pBottom = new JPanel();

    public JMenuBar bar = new JMenuBar();
    JMenu dest = new JMenu("Destinations");
    JMenu selct = new JMenu("Nos sélections");
    JMenu sav = new JMenu("En savoir plus");
	JMenuItem sav_i = new JMenuItem("Questions fréquentes/règlement");
	public void refreshConnectionStatus() {
        // Met à jour le bouton de connexion avec le statut actuel
        SessionUtil.updateConnectionStatus(butt);
    }

    public EnSavoirPlus(Model_prjt md) {
        super("En savoir plus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.mod = md;
        lab = new JLabel();
		Dimension t_scr = Toolkit.getDefaultToolkit().getScreenSize();
// Barre de menu
        ImageIcon icon = new ImageIcon("images//icone_site.png");
        Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(image));
        titre = new JLabel("RoomBloom");
        titre.setForeground(new Color(0, 0, 0));
        titre.setFont(new Font("Georgia", Font.ITALIC, 20));
        butt = new JButton("Me connecter/ M'inscrire");
        butt.setBackground(new Color(245, 245, 245));
        butt.setFocusPainted(false);
		SessionUtil.updateConnectionStatus(butt);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                refreshConnectionStatus();
            }
        });

        JPanel sepPanel = new JPanel();
        sepPanel.setPreferredSize(new Dimension(2, 40));
        sepPanel.setMaximumSize(new Dimension(2, 40));
        sepPanel.setBackground(Color.GRAY);

        this.setJMenuBar(bar);
        bar.setBackground(Color.WHITE);
        bar.add(Box.createHorizontalStrut(15));
        bar.add(iconLabel);
        bar.add(Box.createHorizontalStrut(10));
        bar.add(titre);
        bar.add(Box.createHorizontalStrut(25));
        bar.add(sepPanel);
        bar.add(Box.createHorizontalStrut(25));
        bar.add(dest);
        dest.setFont(new Font("Georgia", Font.PLAIN, 12));
        dest.add(rec_dest1);
        dest.add(new JSeparator(SwingConstants.HORIZONTAL));
        dest.add(rec_dest2);
        dest.add(new JSeparator(SwingConstants.HORIZONTAL));
        dest.add(rec_dest3);
        bar.add(Box.createHorizontalStrut(10));

        bar.add(selct);
        selct.setFont(new Font("Georgia", Font.PLAIN, 12));
		selct.add(rec_selct1);
		selct.add(new JSeparator(SwingConstants.HORIZONTAL));
        selct.add(rec_selct2);
        selct.add(new JSeparator(SwingConstants.HORIZONTAL));
        selct.add(rec_selct3);

        bar.add(sav);
        sav.setFont(new Font("Georgia", Font.PLAIN, 12));
		sav.add(sav_i);
        bar.add(Box.createVerticalStrut(0));
        bar.add(butt);
        butt.setFont(new Font("Georgia", Font.PLAIN, 12));
        bar.add(Box.createHorizontalStrut(15));
        bar.setPreferredSize(new Dimension(90, 91));
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(241, 250, 247));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(241, 250, 247));

        JLabel titreLabel = new JLabel("💬 Questions fréquentes");
        titreLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        titreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titreLabel.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));
        mainPanel.add(titreLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        String[] questions = {
            "Puis-je annuler ma réservation ?",
            "Quels sont les horaires d'arrivée et de départ ?",
            "Le parking est-il disponible ?",
            "Les animaux sont-ils acceptés ?",
            "Puis-je modifier ma réservation ?"
        };

        String[] reponses = {
            "Oui, vous pouvez annuler jusqu'à 48 heures avant l'arrivée.",
            "L'heure d'arrivée est à partir de 15h, et l'heure de départ est avant 10h.",
            "Oui, le parking est gratuit pour tous nos clients.",
            "Oui, nous acceptons les animaux sur demande préalable.",
            "Oui, vous pouvez modifier votre réservation via votre espace client."
        };

        for (int i = 0; i < questions.length; i++) {
            JLabel questionLabel = new JLabel("<html><b>" + questions[i] + "</b></html>");
            questionLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 18));
            questionLabel.setForeground(Color.BLACK);
            questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            mainPanel.add(questionLabel);

            JLabel reponseLabel = new JLabel("<html><p style='width:500px'>" + reponses[i] + "</p></html>");
            reponseLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
            reponseLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            reponseLabel.setForeground(Color.BLACK);
            reponseLabel.setBackground(new Color(241, 250, 247));
            mainPanel.add(reponseLabel);

            mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        }

        // Espace entre FAQ et Témoignages
        mainPanel.add(Box.createRigidArea(new Dimension(0, 70)));

        JLabel testimonialsLabel = new JLabel("🗣️ Témoignages de nos clients");
        testimonialsLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        testimonialsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(testimonialsLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 70)));

        String[] testimonials = {
            "\"Le séjour chez RoomBloom a été incroyable, un service au top et une vue magnifique !\" - Alice.",
            "\"Un endroit paisible, idéal pour un week-end en amoureux. J'y reviendrai sans hésiter !\" - Marc.",
            "\"Nous avons adoré la chambre et l'accueil chaleureux. Je recommande vivement !\" - Sarah."
        };

        for (String testimonial : testimonials) {
            JLabel testimonialLabel = new JLabel(testimonial);
            testimonialLabel.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 16));
            testimonialLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(testimonialLabel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Espace entre Témoignages et Services
        mainPanel.add(Box.createRigidArea(new Dimension(0, 70)));

        JLabel servicesLabel = new JLabel("🔧 Nos Services");
        servicesLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        servicesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(servicesLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        String[] services = {
            "🧖‍♀️ Spa et bien-être : Détendez-vous dans notre espace bien-être avec sauna et massage.",
            "🍽️ Restaurant gastronomique : Profitez de notre restaurant avec une vue imprenable.",
            "🏖️ Activités : Excursions et activités pour toute la famille, y compris des sports nautiques."
        };

        for (String service : services) {
            JLabel serviceLabel = new JLabel(service);
            serviceLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
            serviceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            mainPanel.add(serviceLabel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Espace entre Services et l’image des réseaux
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        // Image juste avant "Nous suivre"
        ImageIcon socialIcon = new ImageIcon("suivre.png");
        Image img = socialIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel socialLabel = new JLabel(new ImageIcon(img));
        socialLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(socialLabel);

        // Espace entre image et "Nous suivre"
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel followLabel = new JLabel("📱 Nous suivre sur :");
        followLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        followLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(followLabel);

        JLabel instagramLabel = new JLabel("Instagram : @RoomBloom_fr");
        instagramLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        instagramLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(instagramLabel);

        JLabel facebookLabel = new JLabel("Facebook : @RoomBloom_fr");
        facebookLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        facebookLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(facebookLabel);

        // Espace entre "Nous suivre" et "Nous contacter"
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        JLabel contactLabel = new JLabel("📧 Contactez-nous");
        contactLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        contactLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(contactLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel contactInfoLabel = new JLabel("Si vous avez des questions supplémentaires, n'hésitez pas à nous contacter par email à :");
        contactInfoLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        contactInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(contactInfoLabel);

        JLabel emailLabel = new JLabel("✉️ Email : contact@roombloom.com");
        emailLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(emailLabel);
		emailLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 70, 0));

// MENTIONS LÉGALES
        JPanel mt_legl = new JPanel(new GridLayout(4, 4));
        mt_legl.setBackground(Color.LIGHT_GRAY);
        ImageIcon icon_mt = new ImageIcon("images//icone_site.png");
        Image image_mt = icon_mt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel iconLabel_mt = new JLabel(new ImageIcon(image_mt));

        mt_legl.add(new JLabel(" "));
        mt_legl.add(new JLabel("RoomBloom"));
        mt_legl.add(new JLabel("Accueil"));
        mt_legl.add(new JLabel("Où voyager ?"));
        mt_legl.add(new JLabel("Nous contacter"));
        mt_legl.add(new JLabel(" "));
        mt_legl.add(new JLabel("97 rue George Leclerc"));
        mt_legl.add(new JLabel("En savoir plus"));
        mt_legl.add(new JLabel("Voyager en Europe"));
        mt_legl.add(new JLabel("Instagram : @RoomBloom_fr"));
        mt_legl.add(iconLabel_mt);
        mt_legl.add(new JLabel("33800 Bordeaux"));
        mt_legl.add(new JLabel(" "));
        mt_legl.add(new JLabel("Voyager en Asie"));
        mt_legl.add(new JLabel("Facebook : @RoomBloom_fr"));
        mt_legl.add(new JLabel(" "));
        mt_legl.add(new JLabel(" "));
        mt_legl.add(new JLabel(" "));
        mt_legl.add(new JLabel("Voyager en Afrique"));
        mt_legl.add(new JLabel("X : @RoomBloom_fr"));

       mainPanel.add(mt_legl);
	   JScrollPane scrollPane = new JScrollPane(mainPanel);
	   scrollPane.getVerticalScrollBar().setUnitIncrement(12); 
	scrollPane.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()), (int)((double)t_scr.getHeight())));
	this.getContentPane().add(scrollPane);


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
