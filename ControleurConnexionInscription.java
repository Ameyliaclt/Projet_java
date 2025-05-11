import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurConnexionInscription {
	private Model_connectinscr mo;
	private Seconnecter v_1;
	
	public ControleurConnexionInscription(Model_connectinscr mod,Seconnecter vue){
	this.mo = mod;
	this.v_1 = vue;
	this.initListeners();
	}
	
	private void initListeners(){
		//Bouton connexion 
		v_1.getLoginButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String email = v_1.getEmailLogin().getText().trim();
				String mdp = new String(v_1.getPasswordLogin().getPassword()).trim();//convertion en char[]
				
				if(mo.checkLogin(email,mdp)){
					JOptionPane.showMessageDialog(v_1,"Connexion réussie !");//comme dans la recherche
				} else {
					JOptionPane.showMessageDialog(v_1,"Email ou mot de passe incorrect veuillez réessayez.","Erreur",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//Bouton inscription
		v_1.getRegisterButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ed){
				String nom = v_1.getNom().getText().trim();
				String prenom = v_1.getPrenom().getText().trim();
				String tel = v_1.getPhone().getText().trim();
				String email = v_1.getEmailRegister().getText().trim();
				String mdp = new String(v_1.getPasswordRegister().getPassword()).trim();//convertion char[]
				
				if(nom.isEmpty() || prenom.isEmpty() || tel.isEmpty() || email.isEmpty() || mdp.isEmpty()){
					JOptionPane.showMessageDialog(v_1, "Veuillez remplir tous les champs d'inscription.","Erreur",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(mo.registerUser(nom, prenom, tel, email, mdp)){
					JOptionPane.showMessageDialog(v_1,"<html>Inscription réussie !<br>Bienvenue !</html>");
				} else {
					JOptionPane.showMessageDialog(v_1, "Cet email est déjà utilisé.","Erreur",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
