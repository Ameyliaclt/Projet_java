import java.util.*;

public class Hotel{
    String pays_h;
    String ville_h;
    String ad_p_h;
    String nm_h;
    String num_t_h;
    String ad_m_h;
    boolean piscine;
    Lieu_trsm[] lieux_prx; 

    public Hotel(String pays, String ville, String ad_p, String nm, String num, String ad_m, Lieu_trsm[] prx){
        pays_h = pays;
        ville_h = ville;
        ad_p_h = ad_p;
        nm_h = nm;
        num_t_h = num;
        ad_m_h = ad_m;
        lieux_prx = prx;
        piscine = false;
    }

    public Hotel(String pays, String ville, String ad_p, String nm, String num, String ad_m, Lieu_trsm[] prx, boolean pisc){
        pays_h = pays;
        ville_h = ville;
        ad_p_h = ad_p;
        nm_h = nm;
        num_t_h = num;
        ad_m_h = ad_m;
        lieux_prx = prx;
        piscine = pisc;
    }
}
