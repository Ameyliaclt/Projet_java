package classe;

public class Chambre {
    public int nb_u;
    public String t_ch;
    public String thm_ch;
    public int prix;
    public String[] images;
	public Hotel hotel;

    public Chambre(int nb_u, String t_ch, String thm_ch, int prix, String[] images, Hotel hotel_actuel) {
        this.nb_u = nb_u;
        this.t_ch = t_ch;
        this.thm_ch = thm_ch;
        this.prix = prix;
        this.images = images;
		this.hotel = hotel_actuel;
    }
	
	public void setChambres(Chambre chambre){
		this.nb_u = chambre.nb_u;
		this.t_ch = chambre.t_ch;
		this.thm_ch = chambre.thm_ch;
		this.prix = chambre.prix;
		//this.etage = chambre.etage;
    }
}
