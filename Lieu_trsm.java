import java.util.*;

public class Lieu_trsm {
    private String[] l_lieu = {"Musée", "Visite guidée", "Espace détente", "Zone commerciale", "Parc d'attraction", "Restaurant", "Location de voiture", "Aéroport", "Gare", "Port"};

    public String nm_lt;
    public String ad_lt;
    public String contact;
    public String t_lieu;

    public Lieu_trsm(String nm, String ad, String ct, int type){
        this.nm_lt = nm;
        this.ad_lt = ad;
        this.contact = ct;
        this.t_lieu = l_lieu[type];
    }
}
