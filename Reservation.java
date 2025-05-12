import java.util.*;

public class Reservation{
    protected String[] stat = {"annule", "confirme", "attente"};

    public Date date_r_d;
    public Date date_r_f;
    public Client client;
    public Hotel hotel;
    public float prix_r;
    public Chambre[] chmb_r;
    public String statut_r;

    public Reservation(Date date_d, Date date_f, Client clt, Hotel htl, float prix, Chambre[] chmb, int stt){
        this.date_r_d = date_d;
        this.date_r_f = date_f;
        this.client = clt;
        this.hotel = htl;
        this.prix_r = prix;
        this.chmb_r = chmb;
        this.statut_r = stat[stt];
    }

    public Sejour add_r(){
	ArrayUtils au1 = new ArrayUtils();
	int stt = au1.indexOf(this.stat, this.statut_r);
        this.statut_r = stat[1];
	Sejour sej = new Sejour(this, stt);
	return sej;
    }

    public void rmv_r(){
        this.statut_r = stat[0];
    }

    public void modif_date_r(Date deb, Date fin){
        this.date_r_d = deb;
        this.date_r_f = fin;
    }
}
