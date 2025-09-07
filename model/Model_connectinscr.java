package model;
import classe.*;
import java.util.ArrayList;

public class Model_connectinscr {
    private ArrayList<Client> clients;
    private Client currentUser;
    
    public Model_connectinscr() {
        clients = new ArrayList<>();
		
		Client client1 = new Client("Dupont", "Jean", "0658490340","jean.dupont@gmail.com","2910");
		Client client2 = new Client("Martin", "Sophie", "0982194433","sophie.martin@outlook.com","Univ2901");
		Client client3 = new Client("Durand", "Paul", "0748920149","paul.durand@gmail.com","1234");

		// Ajout à la liste clients
		clients.add(client1);
		clients.add(client2);
		clients.add(client3);
    }
    
    public boolean checkLogin(String email, String password) {
        for (Client client : clients) {
            if (client.getEmail().equals(email) && client.getPassword().equals(password)) {
                client.setConnected(true);  
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
