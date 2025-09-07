package classe;
import java.util.*;
public class Client {
    public String nm_cl;
    public String pnm_cl;
    public String num_t_cl;
    public String ad_m_cl;
    public String cd_b_cl;
	public String psw;
	public boolean isConnected;
	
	public Client(String nom, String prenom, String phone, String email, String password) {
        this.nm_cl = nom;
        this.pnm_cl = prenom;
        this.num_t_cl = phone;
        this.ad_m_cl = email;
		this.psw = password;
		this.isConnected = false;
    }
	public void setClient(Client client){
		this.nm_cl = client.nm_cl;
		this.pnm_cl = client.pnm_cl;
		this.num_t_cl = client.num_t_cl;
		this.ad_m_cl = client.ad_m_cl;
		this.psw = client.psw;
    }
    public String getPassword() {
        return psw;
    }
	
    public String getPnm() {
        return pnm_cl;
    }
    
    public String getNom() {
        return nm_cl;
    }
    
    public String getEmail() {
        return ad_m_cl;
    }
	
	public void setConnected(boolean status) {
        this.isConnected = status;
    }
    
    public boolean isConnected() {
        return isConnected;
    }
}