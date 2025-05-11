import java.util.*;

public class Chambre {
    public int nb_u; 
    public String t_ch;
    public String thm_ch;
    public float prix_ch;
    public int etage;
    private String[] tc = {"Chambre double","Chambre simple","Suite","Suite présidentielle"};

    public Chambre (int nch, int tch, String tmch, float pch, int et){
        nb_u = nch;
        t_ch = tc[tch];
        thm_ch = tmch;
        prix_ch = pch;
        etage = et;
    }
}
