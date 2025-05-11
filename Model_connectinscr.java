import java.util.HashMap;

public class Model_connectinscr {
    // Stockage des utilisateurs par email
    private HashMap<String, Client> users = new HashMap<>();

    public Model_connectinscr() {
        users.put("alice@example.com", new Client("Durand", "Alice", "0600000000", "alice@example.com", "1234"));
    }

	//Connect
    public boolean checkLogin(String email, String password) {
        if (users.containsKey(email)) {
            return users.get(email).getPassword().equals(password);
        }
        return false;
    }

	//inscription
    public boolean registerUser(String nom, String prenom, String phone, String email, String password) {
        if (users.containsKey(email)) {
            return false; // L'email est déjà utilisé
        }
        users.put(email, new Client(nom, prenom, phone, email, password));
        return true;
    }
}
