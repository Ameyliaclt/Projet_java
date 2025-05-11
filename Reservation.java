import java.util.*;

public class Reservation{
    private String[] stat = {"annule", "confirme", "attente"};

    public Date date_r_d;
    public Date date_r_f;
    public Client client;
    public Hotel hotel;
    public float prix_r;
    public Chambre[] chmb_r;
    public String statut_r;

    public Reservation(Date date_d, Date date_f, Client clt, Hotel htl, float prix, Chambre[] chmb, int stt){
        date_r_d = date_d;
        date_r_f = date_f;
        client = clt;
        hotel = htl;
        prix_r = prix;
        chmb_r = chmb;
        statut_r = stat[stt];
    }

    public void add_r(Reservation r){
        statut_r = stat[1];
    }

    public void rmv_r(Reservation r){
        statut_r = stat[0];
    }

    public void modif_date_r(Reservation r, Date deb, Date fin){
        date_r_d = deb;
        date_r_f = fin;
    }
}
