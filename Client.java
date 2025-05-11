import java.util.*;

public class Client {
    public String nm_cl;
    public String pnm_cl;
    public String num_t_cl;
    public String ad_m_cl;
    public String psw;

    public Client(String nm, String pnm, String num_t, String ad_m, String password){
        this.nm_cl = nm;
        this.pnm_cl = pnm;
        this.num_t_cl = num_t;
        this.ad_m_cl = ad_m;
        this.psw = password;
    }

    public String getPassword() {
        return psw;
    }
	
    public String getPnm() {
	return pnm_cl;
    }
}
