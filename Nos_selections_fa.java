import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.geom.RoundRectangle2D;
import java.lang.Object;
import java.awt.geom.RectangularShape;

public class Nos_selections_fa extends JFrame {
	Hotel mod;
	Hotel_model ht;
	JLabel lab;
	JButton butt;

	// Données des chambres
	private String[] nomsFichiers;
	private String[] categories;
	private String[] themes_ch;
	
	// Composants de la barre menu
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

	// Panel construction de la page
	JPanel entete = new JPanel();
	JPanel deroul = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel filtre = new JPanel();
	JPanel mt_legl = new JPanel();
	JPanel panneauChambres;
	JPanel mainPanel;

	Color couleurFond = new Color(245, 245, 245);

	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int largeur = (int)dim.getWidth();
	int hauteur = (int)dim.getHeight();

	public Nos_selections_fa(String types_recomandations, String[] nomsFichiers, String[] categories, String[] themes_ch) {
		this.nomsFichiers = nomsFichiers;
		this.categories = categories;
		this.themes_ch = themes_ch;

		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(couleurFond);

		panneauChambres = new JPanel();
		panneauChambres.setLayout(new BoxLayout(panneauChambres, BoxLayout.Y_AXIS));
		panneauChambres.setBackground(couleurFond);
		panneauChambres.setBorder(new EmptyBorder(20, 20, 20, 20));

		ImageIcon icon = new ImageIcon("images//icone_site.png"); 
		Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JLabel iconLabel = new JLabel(new ImageIcon(image));
		titre = new JLabel("RoomBloom");
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

		JPanel titrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titrePanel.setBackground(couleurFond);
		JLabel titrePage = new JLabel("<html><div style='text-align: center;'><br> Nos Sélections de Chambres : <br><br>    "+types_recomandations+"</div></html>");
		titrePage.setFont(new Font("Georgia", Font.BOLD, 28));
		titrePanel.add(titrePage);
		titrePanel.setPreferredSize(new Dimension(1350, 200));
		titrePanel.setBackground(new Color(241, 250, 247));
		mainPanel.add(titrePanel);

		for (int i = 0; i < nomsFichiers.length; i++) {
			ajouterChambre(i);
		}

		mainPanel.add(panneauChambres);
		mainPanel.add(mt_legl);

		mt_legl.setLayout(new GridLayout(4,5));
		mt_legl.setBackground(new Color(240,240,240));

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

		UIManager.put("ScrollBar.width", 0); 
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(1350,768));
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setContentPane(scrollPane);
	}

	private void ajouterChambre(int index) {
		if (index > 0 || panneauChambres.getComponentCount() > 0) {
			JPanel spacerPanel = new JPanel();
			spacerPanel.setBackground(couleurFond);
			spacerPanel.setPreferredSize(new Dimension(1000, 20));
			spacerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
			panneauChambres.add(spacerPanel);
		}

		RoundedPanel ch_s_1 = new RoundedPanel(15);
		ch_s_1.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		ch_s_1.setBackground(Color.WHITE);
		ch_s_1.setPreferredSize(new Dimension(1000, 250));
		ch_s_1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));
		ch_s_1.setBorder(new RoundBorder(15, Color.BLACK));

		ImageIcon icon_ch = new ImageIcon("images//" + nomsFichiers[index]); 
		Image image_ch = icon_ch.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		JLabel iconLabel_ch = new JLabel(new ImageIcon(image_ch));

		JPanel texte_ch = new JPanel();
		texte_ch.setLayout(new BoxLayout(texte_ch, BoxLayout.Y_AXIS));
		JLabel titre_ch = new JLabel(categories[index] + " " + themes_ch[index]);
		titre_ch.setFont(new Font("Georgia", Font.ITALIC, 30));
		JLabel espc = new JLabel(" ");
		JLabel desc_ch = new JLabel("Description du " + categories[index] + " " + themes_ch[index]);
		desc_ch.setFont(new Font("Georgia", Font.PLAIN, 15));
		texte_ch.add(titre_ch);
		texte_ch.add(espc);
		texte_ch.add(espc);
		texte_ch.add(desc_ch);
		texte_ch.setBackground(Color.WHITE);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1; 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 20);
		ch_s_1.add(iconLabel_ch, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.9; 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 20, 10, 10);
		ch_s_1.add(texte_ch, gbc);

		panneauChambres.add(ch_s_1);
	}

	class RoundedPanel extends JPanel {
		private int cornerRadius;
		public RoundedPanel(int radius) {
			super();
			this.cornerRadius = radius;
			setOpaque(false);
		}
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground());
			g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
			g2.dispose();
		}
	}

	class RoundBorder implements Border {
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
