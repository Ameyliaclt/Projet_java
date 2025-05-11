import javax.swing.*;
import java.awt.*;

public class MainESP {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
          
            Model_prc model = new Model_prc(); // Ce constructeur doit exister

          
            EnSavoirPlus frame = new EnSavoirPlus(model);

           
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int largeur = (int) dim.getWidth();
            int hauteur = (int) dim.getHeight();
            frame.setSize(largeur, hauteur);

          
            frame.setLocationRelativeTo(null);

            
            frame.setVisible(true);
        });
    }
}
