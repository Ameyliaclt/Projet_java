impot java.util.*;

public class Chambre {
    int nb_u; 
    String t_ch;
    String thm_ch;
    float prix_ch;
    int etage;

    public Chambre (int nch,String tch, String tmch, float pch, int et){
        nb_u = nch;
        t_ch = tch;
        thm_ch = tmch;
        prix_ch = pch;
        etage = et;
    }
}