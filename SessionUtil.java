import javax.swing.JButton;

public class SessionUtil {
    private static Model_connectinscr model;

    public static void setModel(Model_connectinscr m) {
        model = m;
    }

    public static Model_connectinscr getModel() {
        return model;
    }

    public static void updateConnectionStatus(JButton bouton) {
        if (model.isUserLoggedIn()) {
            Client client = model.getCurrentUser();
            if (client != null) {
                bouton.setText("Bienvenue, " + client.getPnm());
            } else {
                bouton.setText("Me connecter/ M'inscrire");
            }
        } else {
            bouton.setText("Me connecter/ M'inscrire");
        }
    }
}
