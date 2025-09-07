package classe;
import java.util.*;

public class Hotel{
    public String pays_h;
    public String ville_h;
    public String ad_p_h;
    public String nm_h;
    public String num_t_h;
    public String ad_m_h;
    public boolean piscine;
    public Lieu_trsm[] lieux_prx; 

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

    public String getNom(){
	return nm_h;
    }
    
    public String getPays() {
        return pays_h;
    }
    
    public String getVille() {
        return ville_h;
    }
    
    public String getAdresse() {
        return ad_p_h;
    }
    
    public String getNumero() {
        return num_t_h;
    }
    
    public String getEmail() {
        return ad_m_h;
    }
    
    public Lieu_trsm[] getLieux() {
        return lieux_prx;
    }
    
    public boolean hasPiscine() {
        return piscine;
    }

    public void setHotel(Hotel hotel){
	this.pays_h = hotel.pays_h;
	this.ville_h = hotel.ville_h;
	this.ad_p_h = hotel.ad_p_h;
	this.nm_h = hotel.nm_h;
	this.num_t_h = hotel.num_t_h;
	this.ad_m_h = hotel.ad_m_h;
	this.piscine = hotel.piscine;
	this.lieux_prx = hotel.lieux_prx;
    }
}