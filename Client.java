import java.util.*;
public class Client {
    private String nm_cl;
    private String pnm_cl;
    private String num_t_cl;
    private String ad_m_cl;
    private String ad_p_cl;
    private String cd_b_cl;
	private String psw;

    public Client(String nm, String pnm, String num_t, String ad_m, String ad_p, String cd_b){
        this.nm_cl = nm;
        this.pnm_cl = pnm;
        this.num_t_cl = num_t;
        this.ad_m_cl = ad_m;
        this.ad_p_cl = ad_p;
        this.cd_b_cl = cd_b;
    }
	
	public Client(String nom, String prenom, String phone, String email, String password) {
        this.nm_cl = nom;
        this.pnm_cl = prenom;
        this.num_t_cl = phone;
        this.ad_m_cl = email;
		this.psw = password;
    }

    public String getPassword() {
        return psw;
    }
}