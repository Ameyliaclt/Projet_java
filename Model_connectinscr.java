import java.util.ArrayList;

public class Model_connectinscr {
    private ArrayList<Client> clients;
    private Client currentUser;
    
    public Model_connectinscr() {
        clients = new ArrayList<>();
        // Vous pourriez ajouter des utilisateurs de test ici
    }
    
    public boolean checkLogin(String email, String password) {
        for (Client client : clients) {
            if (client.getEmail().equals(email) && client.getPassword().equals(password)) {
                client.setConnected(true);  // Marquer le client comme connecté
                currentUser = client;
                return true;
            }
        }
        return false;
    }
    
    public boolean registerUser(String nom, String prenom, String phone, String email, String password) {
        // Vérifier si l'email existe déjà
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return false;
            }
        }
        
        // Créer un nouveau client
        Client newClient = new Client(nom, prenom, phone, email, password);
        clients.add(newClient);
        currentUser = newClient;
        newClient.setConnected(true);  // Marquer le client comme connecté
        return true;
    }
    
    public boolean isUserLoggedIn() {
        return currentUser != null && currentUser.isConnected();
    }
    
    public Client getCurrentUser() {
        return currentUser;
    }
}
