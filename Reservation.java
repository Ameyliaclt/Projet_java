package classe;
import controlleur.*;
import vue.*;
import model.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Reservation{
    protected String[] stat = {"annule", "confirme", "attente"};

    public Date date_r_d;
    public Date date_r_f;
    public Client client;
    public Hotel hotel;
    public float[] prix_r;
    public Chambre[] chmb_r;
    public String statut_r;

    public Reservation(Date date_d, Date date_f, Client clt, Hotel htl, Chambre[] chmb, int stt){
        this.date_r_d = date_d;
        this.date_r_f = date_f;
        this.client = clt;
        this.hotel = htl;
        this.chmb_r = chmb;
        this.statut_r = stat[stt];
        this.prix_r = calcul_m();
    }

    public Sejour add_r(){
	ArrayUtils au1 = new ArrayUtils();
	int stt = au1.indexOf(this.stat, this.statut_r);
        this.statut_r = stat[1];
	Sejour sej = new Sejour(this, stt);
	return sej;
    }

    public void supp_r(){
	ArrayUtils au1 = new ArrayUtils();
	int stt = au1.indexOf(this.stat, this.statut_r);
        this.statut_r = stat[0];
    }

    public void rmv_r(){
        this.statut_r = stat[0];
    }

    public void modif_date_r(Date deb, Date fin){
        this.date_r_d = deb;
        this.date_r_f = fin;
    }
	
    public float[] calcul_m(){
	float[] mt = new float[this.chmb_r.length+1];
	float tot = 0;

	for(int i = 0; i < this.chmb_r.length; i++){
		mt[i] = this.chmb_r[i].prix * (float)this.date_r_d.calcul_d(this.date_r_d,this.date_r_f);
		tot += mt[i];
	}

	mt[this.chmb_r.length] = tot;

	return mt;
    }

    public void updateReservation(Date d, Date f, Client cl, Hotel ht, Chambre[] ch, String statut){
	this.date_r_d.setDate(d);
	this.date_r_f.setDate(f);
	this.client.setClient(cl);
	this.hotel.setHotel(ht);
	this.chmb_r = ch;
	this.statut_r = statut;
	this.prix_r = calcul_m();
    }

    public void setControleurConfirm(Controleur_gestion control, JButton button, Vue_gestion_rs v_gest){
	control.rendreCliquable_statut_confirm(button);
    }
}