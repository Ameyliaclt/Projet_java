package controlleur;
import model.*;
import classe.*;
import javax.swing.JButton;

public class SessionUtil {
    private static Model_connectinscr model;

    public static void setModel(Model_connectinscr m) {
        model = m;
    }

    public static Model_connectinscr getModel() {
        return model;
    }

    public static void toggleButtons(JButton boutonConnexion, JButton boutonPanier) {
        if (model != null && model.isUserLoggedIn()) {
            boutonConnexion.setVisible(false);
            boutonPanier.setVisible(true);
        } else {
            boutonConnexion.setVisible(true);
            boutonPanier.setVisible(false);
        }
    }
	
	public static void updateConnectionStatus(JButton button) {
    if (model != null && model.isUserLoggedIn()) {
        button.setText("Votre panier");
    } else {
        button.setText("Me connecter / M'inscrire");
    }
}

}

