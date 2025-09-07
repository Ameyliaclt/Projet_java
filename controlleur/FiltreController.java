package controlleur;
import model.*;
import classe.*;
import vue.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.ArrayList;

public class FiltreController {
    private JPanel panneauChambres;
    private JCheckBox[] checkboxes;
    private JComboBox<String> comboCategories;
    private String[] nomsFichiers;
    private String[] categories;
    private String[] themes_ch;
	private String[] themes_fil;
    private Color couleurFond;
	Model_prc_Chambre model_i;
	public RoundedPanel ch_s_1;
    
    public FiltreController(JPanel panneauChambres, JCheckBox[] checkboxes, JComboBox<String> comboCategories, 
                            String[] nomsFichiers, String[] categories, String[] themes_ch,String[] themes_fil, Model_prc_Chambre model_image) {
        this.panneauChambres = panneauChambres;
        this.checkboxes = checkboxes;
        this.comboCategories = comboCategories;
        this.nomsFichiers = nomsFichiers;
        this.categories = categories;
        this.themes_ch = themes_ch;
		this.themes_fil = themes_fil;
        this.couleurFond = panneauChambres.getBackground();
		this.model_i = model_image;
            
        ActionListener filtreListener = e -> filtrerChambres();
            
        for (JCheckBox checkbox : checkboxes) {
            checkbox.addActionListener(filtreListener);
        }
        comboCategories.addActionListener(filtreListener);
            
        filtrerChambres();
    }
	
    public void filtrerChambres() {
		panneauChambres.removeAll();
            
        // Récupérer la catégorie sélectionnée
        String categorieSelectionnee = (String)comboCategories.getSelectedItem();
            
        // Vérifier si au moins une checkbox est cochée
        boolean auMoinsUneCheckboxCochee = false;
        for (JCheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                auMoinsUneCheckboxCochee = true;
                break;
            }
        }
            
        // Parcourir toutes les chambres
        for (int i = 0; i < nomsFichiers.length; i++) {
            // Vérification des filtres
            boolean passeFiltreCategorie = categorieSelectionnee.equals("Tous") || categories[i].equals(categorieSelectionnee);
                
            boolean passeFiltreTheme = !auMoinsUneCheckboxCochee; 
                
            // Vérifier si le thème correspond à une checkbox cochée
            for (int j = 0; j < checkboxes.length; j++) {
                if (checkboxes[j].isSelected() && 
                    checkboxes[j].getText().equals(themes_fil[i])) {
                    passeFiltreTheme = true;
                    break;
                }
            }
                
            // Si passe les deux filtres, ajouter la chambre
            if (passeFiltreCategorie && passeFiltreTheme) {
                ajouterChambre(i);
            }
        }
            
        // Rafraîchir l'affichage
        panneauChambres.revalidate();
        panneauChambres.repaint();
    }
    
    private void ajouterChambre(int index) {
        // Ajouter un espacement entre les panels si ce n'est pas le premier
        if (index > 0 || panneauChambres.getComponentCount() > 0) {
            JPanel spacerPanel = new JPanel();
            spacerPanel.setBackground(couleurFond);
            spacerPanel.setPreferredSize(new Dimension(1000, 20));
            spacerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
            panneauChambres.add(spacerPanel);
        }
        
        // Créer le panel de la chambre
        ch_s_1 = new RoundedPanel(15);
        ch_s_1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        ch_s_1.setBackground(Color.WHITE);
        ch_s_1.setPreferredSize(new Dimension(1000, 250));
        ch_s_1.setBorder(new RoundBorder(15, Color.BLACK));

		
        
        // Charger et redimensionner l'image
        ImageIcon icon_ch = new ImageIcon("images//" + nomsFichiers[index]); 
        Image image_ch = icon_ch.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel iconLabel_ch = new JLabel(new ImageIcon(image_ch));
        
        // Créer le panel de texte
        JPanel texte_ch = new JPanel();
        texte_ch.setLayout(new BoxLayout(texte_ch, BoxLayout.Y_AXIS));
        JLabel titre_ch = new JLabel(categories[index] + " " + themes_ch[index]);
        titre_ch.setFont(new Font("Georgia", Font.ITALIC, 30));
        JLabel espc = new JLabel(" ");
        String[] descParts = model_i.getDescription(index);
		String descriptionComplete = "<html><p style='width:700px;'>" + descParts[0] + "<br><br><i>" + descParts[1] + "</i></p></html>";
		JLabel desc_ch = new JLabel(descriptionComplete);
        desc_ch.setFont(new Font("Georgia", Font.PLAIN, 15));
        texte_ch.add(titre_ch);
        texte_ch.add(espc);
        texte_ch.add(espc);
        texte_ch.add(desc_ch);
        texte_ch.setBackground(Color.WHITE);
        
        // Ajouter l'image au panel de la chambre
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1; 
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 20); // Haut, Gauche, Bas, Droite
        ch_s_1.add(iconLabel_ch, gbc);
        
        // Ajouter le panel de texte au panel de la chambre
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.9; 
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 20, 10, 10); // Haut, Gauche, Bas, Droite
        ch_s_1.add(texte_ch, gbc);
        
        // Ajouter le panel de la chambre au container principal
        panneauChambres.add(ch_s_1);
		// Rendre le panel cliquable pour afficher la vue de la chambre
		ch_s_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ch_s_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// Vérifier si un utilisateur est connecté
			Client currentUser = model_i.clt.getCurrentUser(); 
			
			if (currentUser == null) {
				JOptionPane.showMessageDialog(
					null, 
					"Vous devez être connecté pour accéder aux détails de cette chambre.\nVeuillez vous connecter ou créer un compte.",
					"Connexion requise", 
					JOptionPane.WARNING_MESSAGE
				);
			} else {
				// Un utilisateur est connecté, ouvrir la vue chambre normalement
				Vue_Chambre vue_ch = new Vue_Chambre(model_i, index);
				vue_ch.setVisible(true);
			}
		}
		});
	}
    
    // Classe RoundBorder intégrée dans le FiltreController
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
	public  RoundedPanel getchp() {
		return ch_s_1;
	}
}