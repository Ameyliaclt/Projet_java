import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.text.JTextComponent;

public class Seconnecter extends JFrame {
    Model_connectinscr mod;
    JButton butt;
    JLabel lab;
    private JLabel imageLabel;

    JPanel pBottom = new JPanel();

    public JMenuBar bar = new JMenuBar();
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
	
	JButton loginButton;
	JButton registerButton;
	JTextField emailLogin;
	JPasswordField passwordLogin;
	JTextField nom;
	JTextField prenom;
	JTextField phone;
	JTextField emailRegister;
	JPasswordField passwordRegister;

    public Seconnecter(Model_connectinscr md) {
        super("Connexion / Inscription");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.mod = md;
        lab = new JLabel();

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
        bar.add(Box.createVerticalStrut(0));
        bar.add(butt);
        butt.setFont(new Font("Georgia", Font.PLAIN, 12));
        bar.add(Box.createHorizontalStrut(15));
        bar.setPreferredSize(new Dimension(90, 91));

        Color bgColor = new Color(241, 250, 247);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgColor);
        setLayout(new GridBagLayout());

        Color lightGray = new Color(245, 245, 245); // Blanc cassé

// Panel principal
JPanel mainPanel = new JPanel(new GridBagLayout());
mainPanel.setBackground(bgColor);
mainPanel.setPreferredSize(new Dimension(1000, 500));

// PANEL CONNEXION
JPanel loginPanel = new JPanel();
loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
loginPanel.setBackground(bgColor);
loginPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 190));

JLabel loginTitle = new JLabel("Se connecter");
loginTitle.setFont(new Font("Arial", Font.BOLD, 24));
loginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
loginTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
loginPanel.add(loginTitle);
loginPanel.add(Box.createRigidArea(new Dimension(0, 30)));

// Champs de texte avec les mêmes dimensions et couleur blanche cassée
emailLogin = styledTextField("  Mail");
emailLogin.setBackground(lightGray); // Application de la couleur blanche cassée
emailLogin.setPreferredSize(new Dimension(300, 10)); // Taille du champ
emailLogin.addFocusListener(new FieldController(emailLogin, "  Mail", Color.GRAY, Color.BLACK));

passwordLogin = styledPasswordField("  Mot de passe");
passwordLogin.setBackground(lightGray); // Application de la couleur blanche cassée
passwordLogin.setPreferredSize(new Dimension(300, 10)); // Taille du champ
passwordLogin.addFocusListener(new FieldController(passwordLogin, "  Mot de passe", Color.GRAY, Color.BLACK));


loginButton = styledButton("Se connecter");
//loginButton.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
loginPanel.add(emailLogin);
loginPanel.add(Box.createRigidArea(new Dimension(0, 50)));
loginPanel.add(passwordLogin);
loginPanel.add(Box.createRigidArea(new Dimension(0, 50)));


JPanel loginButtonWrapper = new JPanel();
loginButtonWrapper.setLayout(new BoxLayout(loginButtonWrapper, BoxLayout.X_AXIS));
loginButtonWrapper.setBackground(bgColor);
loginButtonWrapper.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
loginButtonWrapper.add(loginButton);
loginPanel.add(loginButtonWrapper);

// PANEL INSCRIPTION
JPanel registerPanel = new JPanel();
registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
registerPanel.setBackground(bgColor);
registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 140, 20, 40));
registerPanel.setPreferredSize(new Dimension(400, 400));

JLabel registerTitle = new JLabel("S'inscrire");
registerTitle.setFont(new Font("Arial", Font.BOLD, 24));
registerTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
registerTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

registerPanel.add(registerTitle);
registerPanel.add(Box.createRigidArea(new Dimension(0, 30)));

// Champs de texte avec les mêmes dimensions et couleur blanche cassée
nom = styledTextField("  Nom");
nom.setBackground(lightGray); // Application de la couleur blanche cassée
nom.setPreferredSize(new Dimension(300, 30)); // Taille du champ
nom.addFocusListener(new FieldController(nom, "  Nom", Color.GRAY, Color.BLACK));

prenom = styledTextField("  Prénom");
prenom.setBackground(lightGray); // Application de la couleur blanche cassée
prenom.setPreferredSize(new Dimension(300, 30)); // Taille du champ
prenom.addFocusListener(new FieldController(prenom, "  Prénom", Color.GRAY, Color.BLACK));

phone = styledTextField("  Téléphone");
phone.setBackground(lightGray); // Application de la couleur blanche cassée
phone.setPreferredSize(new Dimension(300, 30)); // Taille du champ
phone.addFocusListener(new FieldController(phone, "  Téléphone", Color.GRAY, Color.BLACK));

emailRegister = styledTextField("  Mail");
emailRegister.setBackground(lightGray); // Application de la couleur blanche cassée
emailRegister.setPreferredSize(new Dimension(300, 30)); // Taille du champ
emailRegister.addFocusListener(new FieldController(emailRegister, "  Mail", Color.GRAY, Color.BLACK));

passwordRegister = styledPasswordField("Mot de passe");
passwordRegister.setBackground(lightGray); // Application de la couleur blanche cassée
passwordRegister.setPreferredSize(new Dimension(300, 30)); // Taille du champ
passwordRegister.addFocusListener(new FieldController(passwordRegister, "Mot de passe", Color.GRAY, Color.BLACK));

registerButton = styledButton("S'inscrire");

registerPanel.add(nom);
registerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
registerPanel.add(prenom);
registerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
registerPanel.add(phone);
registerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
registerPanel.add(emailRegister);
registerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
registerPanel.add(passwordRegister);
registerPanel.add(Box.createRigidArea(new Dimension(0, 30)));

JPanel registerButtonWrapper = new JPanel();
registerButtonWrapper.setLayout(new BoxLayout(registerButtonWrapper, BoxLayout.X_AXIS));
registerButtonWrapper.setBackground(bgColor);
registerButtonWrapper.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
registerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
registerButtonWrapper.add(registerButton);
registerPanel.add(registerButtonWrapper);

// SÉPARATEUR
JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
separator.setForeground(Color.GRAY);
separator.setPreferredSize(new Dimension(1, 400));

// Placement des panels
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridy = 0;
gbc.fill = GridBagConstraints.VERTICAL;

gbc.gridx = 0;
gbc.insets = new Insets(0, 10, 0, 10);
mainPanel.add(loginPanel, gbc);

gbc.gridx = 1;
mainPanel.add(separator, gbc);

gbc.gridx = 2;
mainPanel.add(registerPanel, gbc);


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

    pBottom.setLayout(new BorderLayout());
    pBottom.add(mt_legl, BorderLayout.CENTER);

        // PANNEAU GLOBAL
        JPanel globalPanel = new JPanel(new BorderLayout());
        globalPanel.setBackground(bgColor);
        globalPanel.add(mainPanel, BorderLayout.CENTER);
        globalPanel.add(pBottom, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(globalPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        this.setContentPane(scrollPane);
    }

    // Define missing methods
    private JTextField styledTextField(String text) {
        JTextField field = new JTextField(text);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(Color.GRAY);
        return field;
    }

    private JPasswordField styledPasswordField(String text) {
        JPasswordField field = new JPasswordField(text);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(Color.GRAY);
        return field;
    }

    private JButton styledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(245, 245, 245));
        button.setForeground(Color.BLACK);
        return button;
    }

    public static class FieldController implements FocusListener {
        private final JTextComponent field;
        private final String defaultText;
        private final Color defaultColor;
        private final Color focusColor;

        public FieldController(JTextComponent field, String defaultText, Color defaultColor, Color focusColor) {
            this.field = field;
            this.defaultText = defaultText;
            this.defaultColor = defaultColor;
            this.focusColor = focusColor;
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (field.getText().equals(defaultText)) {
                field.setText("");
                field.setForeground(focusColor);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (field.getText().isEmpty()) {
                field.setText(defaultText);
                field.setForeground(defaultColor);
            }
        }
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
	public JMenuItem getrec_selct1() {
		return rec_selct1;
	}
	public JMenuItem getrec_selct2() {
		return rec_selct2;
	}
	public JMenuItem getrec_selct3() {
		return rec_selct3;
	}
	public JButton getButt() {
		return butt;
	}
	public JLabel gettitre(){
		return titre;
	}
	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public JTextField getEmailLogin() {
		return emailLogin;
	}

	public JPasswordField getPasswordLogin() {
		return passwordLogin;
	}

	public JTextField getNom() {
		return nom;
	}

	public JTextField getPrenom() {
		return prenom;
	}

	public JTextField getPhone() {
		return phone;
	}

	public JTextField getEmailRegister() {
		return emailRegister;
	}

	public JPasswordField getPasswordRegister() {
		return passwordRegister;
	}
}



