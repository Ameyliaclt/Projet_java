package classe;
import java.util.*;

public class Lieu_trsm {
    String[] l_lieu = {"Musée", "Visite guidée", "Espace détente", "Zone commerciale", "Parc d'attraction", "Restaurant", "Location de voiture", "Aéroport", "Gare", "Port"};
    String nm_lt;
    String ad_lt;
    String contact;
    String t_lieu;

    public Lieu_trsm(String nm, String ad, String ct, int type){
        this.nm_lt = nm;
        this.ad_lt = ad;
        this.contact = ct;
        this.t_lieu = l_lieu[type];
    }
}
