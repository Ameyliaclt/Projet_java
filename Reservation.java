import java.util.*;
import Client;
import Chambre; 
import Hotel; 
import Date; 

public class Reservation{
    String[] stat = {"annule", "confirme"}

    Date date_r_d;
    Date date_r_f;
    Client client;
    Hotel hotel;
    float prix_r;
    Chambre[] chmb_r;
    String statut_r;

    public Reservation(Date date_d, Date date_f, Client clt, Hotel htl, float prix, Chambre[] chmb){
        date_r_d = date_d;
        date_r_f = date_f;
        client = clt;
        hotel = htl;
        prix_r = prix;
        chmb_r = chmb;
        statut_r = " ";
    }

    void add_r(Reservation r){
        statut_r = stat[1];
    }

    void rmv_r(Reservation r){
        statut_r = stat[0];
    }

    void modif_date_r(Reservation r, Date deb, Date fin){
        date_r_d = deb;
        date_r_f = fin;
    }
}
