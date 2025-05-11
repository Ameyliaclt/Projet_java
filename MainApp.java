import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        // Créer une instance du modèle avec une chaîne (par exemple, un nom d'utilisateur)
        Model_prc model = new Model_prc("RedOne");

        int index = 0;

        javax.swing.SwingUtilities.invokeLater(() -> {
            PageAvecImageEtCarte fenetre = new PageAvecImageEtCarte(model, index);

            // Récupérer la taille de l'écran
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int largeur = (int) dim.getWidth();
            int hauteur = (int) dim.getHeight();

            // Configurer la fenêtre
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH); // plein écran
            fenetre.setSize(largeur, hauteur); // Redimensionner explicitement si nécessaire
            fenetre.setLocationRelativeTo(null); // Centre la fenêtre
            fenetre.setVisible(true);
        });
    }
}
