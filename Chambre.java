import java.util.*;

public class Chambre {
    int nb_u; 
    String t_ch;
    String thm_ch;
    float prix_ch;
    int etage;
    String[] tc = {"double","simple","st_nrml","st_pres"};

    public Chambre (int nch, int tch, String tmch, float pch, int et){
        nb_u = nch;
        t_ch = tc[tch];
        thm_ch = tmch;
        prix_ch = pch;
        etage = et;
    }
}
