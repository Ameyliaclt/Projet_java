public static Lieu_trsm[] Lieu_p(){
    Lieu_trsm[] lieux_pa = new Lieu_trsm[10];
    
    lieux_pa[0] l_p_m = new Lieu_trsm("Aquarium de Paris","5 Av. Albert de Mun, 75016 Paris","0145393000");
    lieux_pa[1] l_p_c = new Lieu_trsm("Visite des catacombes de Paris","1 Av. du Colonel Henri Rol-Tanguy, 75014 Paris","0145430657");
    lieux_pa[2] l_p_d = new Lieu_trsm("Espace Détente","22 rue de magdebourg, 75016 Paris","0749619185");
    lieux_pa[3] l_p_cm = new Lieu_trsm("Centre commercial Beaugrenelle","12 Rue Linois, 75015 Paris","0153952400");
    lieux_pa[4] l_p_pa = new Lieu_trsm("Disneyland Paris","Bd de Parc, 77700 Coupvray","0969326066");
    lieux_pa[5] l_p_rt = new Lieu_trsm("Madame Brasserie - Tour Eiffel","av. Gustave Eiffel, 75007 Paris","0183777778");
    lieux_pa[6] l_p_aprt = new Lieu_trsm("Aéroport de Paris-Orly","94390 Orly","0170363950");
    lieux_pa[7] l_p_gr = new Lieu_trsm("Gare Montparnasse","17 Bd de Vaugirard","3635");
    lieux_pa[8] l_p_prt = new Lieu_trsm("SIXT|Location voiture gare Montparnasse","Gare face, Hall 2, Bd Pasteur voie 19, 75015 Paris","0170976111");

    return lieux_pa;
}

public static Lieu_trsm[] lieux_k(){
    Lieu_trsm[] lieux_ky = new Lieu_trsm[10];
    
    lieux_ky[0] = new Lieu_trsm();
    lieux_ky[1] = new Lieu_trsm();
    lieux_ky[2] = new Lieu_trsm();
    lieux_ky[3] = new Lieu_trsm();
    lieux_ky[4] = new Lieu_trsm();
    lieux_ky[5] = new Lieu_trsm();
    lieux_ky[6] = new Lieu_trsm();
    lieux_ky[7] = new Lieu_trsm();
    lieux_ky[8] = new Lieu_trsm();
    lieux_ky[9] = new Lieu_trsm();

    return lieux_ky;
}

public static Lieu_trsm[] Lieux_r(){
    Lieu_trsm[] lieux_re = new Lieu_trsm[10];

    lieux_re[0] = new Lieu_trsm();
    lieux_re[1] = new Lieu_trsm();
    lieux_re[2] = new Lieu_trsm();
    lieux_re[3] = new Lieu_trsm();
    lieux_re[4] = new Lieu_trsm();
    lieux_re[5] = new Lieu_trsm();
    lieux_re[6] = new Lieu_trsm();
    lieux_re[7] = new Lieu_trsm();
    lieux_re[8] = new Lieu_trsm();
    lieux_re[9] = new Lieu_trsm();

    return lieux_re;
}

public static void main(String[] args){
    Hotel h_p = new Hotel("France", "Paris","127 Av. des Champs-Élysées, 75008 Paris","élégance","0145678926","elegance_paris@hotel.fr",Lieu_p());
    Hotel h_k = new Hotel("Japon", "Kyoto", "", "Atarashii Kyoto", "atarashiiKyoto@hotel.com", Lieux_k());
    Hotel h_r = new Hotel("Islande", "Reykjavik", "", "", "", Lieux_r());
}
