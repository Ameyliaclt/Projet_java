import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;


public class Model_prc {
    private String username;
String suite;
    public String[] themes = {

// chambre simple
        "Riz", "Chocolat", "Barque", "Océan", "Instrument xalam", "Cacao", //Senegal 
	"Sultane", "Flouka", "Zest", "Babouche", "Andalouse", "Minaret", // maroc

	"Parisien", "Traditionel", "Moderne", "Royal", "Futuriste", "Minimaliste",//Paris
	"Traditionnel", "Wan Makha Bucha", "Wan Vaisakh Bucha", "China Town", "Tiger", "Lotus",//Thailande


	"Traditionnel printannier", "Carpe Koi", "Dragon", "Ghibli", "Traditionnelle", "Futuriste", // Japon
	"Aurore", "Lagoon", "Viking", "Traditionnelle", "Igloo", "Futuriste",//Islande

//chambre double 

	"Moustiquaire","Couleurs", "Maison sénégalaise", "Mosquée", "Orange", "Foot",
	"Henné", "Jemaa el-Fna", "Tajine", "Argile", "Berbère", "Atay",

	"romantique & parisien", "Luxe", "Bohème", "Moderne & parisien", "Moulin Rouge", "Cabinet de curiosité",  
	"Traditionnel", "Elephant", "Street", "Bo sang", "Makha Bucha", "Phi Ta Khon",  

	"Pokemon", "Cyberpunk", "Minimaliste", "Ninja", "Lycoris", "Automne",  
	"Glaciers", "Volcan", "Montagnes", "Ours polaire", "Minimaliste", "Basalte",

//suite normale

	"Koya", "Fruits Exotiques","Ile","Tresse",
	"Olivier", "Dattier", "Souk des épices", "Hammam",

	"Monnet", "Dior", "Moderne & futuriste", "Rococo",  
	"Traditionnel", "Festival des lumières", "Pleine lune", "Lopburi",  

	"Hanami", "Samurai", "Caligraphie", "Mystique",  
	"Elixir", "Cascade", "Baleine", "Marin",

//suite presidentielle

	"Lac Rose", "Zoo", "Lion", "Sheraton",
	"Rêve Oriental", "Oasis de Luxe", "Riad Moderne", "Atlas Majestueux",

	"Louvres", "Luxe", "Traditionnel Français", "Elysée",  
	"Orchidée", "Or", "Royal", "Nouvelle an Chinois",  

	"Luxe", "Sushi", "Moderne", "Hanabi",  
	"Luxe", "Impérial", "Glace", "Nature"

    };

  public String[] images = {
    // Chambre Simple
    "riz_cham_s.png", "chocolat_cham_s.png", "barque_cham_s.png", "ocean_cham_s.png", "instrumentXalam_cham_s.png", "cacao_cham_s.png",
    "tborida_cham_s.png", "flouka_cham_s.png", "or_cham_s.png", "babouche_cham_s.png", "arabe_cham_s.png", "mosquee_cham_s.png",

    "chambre_simple_parisien_paris.png", "chambre_simple_traditionnel_paris.png", "chambre_simple_moderne_paris.png", "chambre_simple_royal_paris.png", "chambre_simple_futuriste_paris.png", "chambre_simple_minimaliste_paris.png",
    "s_1t.png", "s_2t.png", "s_3t.png", "s_4t.png","s_5t.png", "s_6t.png", 


    "Tradition_printemps_Kyoto_Simple.png", "CarpeKoi_Kyoto_Simple.png", "Dragon_Kyoto_Simple.png", "Ghibli_Kyoto_Simple.png", "Traditionnelle_Kyoto_Simple.png", "Futuriste_Kyoto_Simple.png",
    "Aurore_Reykjavik_Simple.png", "Lagoon_Reykjavik_Simple.png", "Viking_Reykjavik_Simple.png", "Traditionnel_Reykjavik_Simple.png", "Igloo_Reykjavik_Simple.png", "Futuriste_Reykjavik_Simple.png",

    // Chambre Double
    "moustiquaire_cham_d.png", "couleurs_cham_d.png", "maison_senegalaise_cham_d.png", "mosquee_s_cham_d.png", "orange_s_cham_d.png", "foot_cham_s.png",
    "henna_cham_d.png", "jame3lefna_cham_d.png", "tajine_cham_d.png", "argile_cham_d.png", "couscous_cham_d.png", "atay_cham_d.png",

    "chambre_double_romantiqueparisien_paris.png", "chambre_double_luxe_paris.png", "chambre_double_boheme_paris.png", "chambre_double_moderneparisien_paris.png", "chambre_double_moulinrouge_paris.png", "chambre_double_cabinetdecuriosite_paris.png",
    "d_1t.png", "d_2t.png", "d_3t.png","d_4t.png", "d_5t.png", "d_6t.png",

    "Pokemon_Kyoto_Double.png", "Cybrepunk_Kyoto_Double.png", "Minimalisme_Kyoto_Double.png", "Ninja_Kyoto_Double.png", "Lycoris_Kyoto_Double.png", "Automne_Kyoto_Double.png",
    "Glaciers_Reykjavik_Double.png", "Volcan_Reykjavik_Double.png", "Montagnes_Reykjavik_Double.png", "Ours_Polaire_Reykjavik_Double.png", "Minimaliste_Reykjavik_Double.png", "Basalte_Reykjavik_Double.png",

    // Suite Normale
    "koya_suite_n.png", "fruitexotic_suite_n.png", "ile_suite_n.png", "tresse_suite_n.png",
    "olivier_suite_n.png", "datte_suite_n.png", "souk_suite_n.png", "hamam_suite_n.png",

    "suite_monnet_paris.png", "suite_dior_paris.png", "suite_modernefuturiste_paris.png", "suite_rococo_paris.png",
    "su_1t.png","su_2t.png", "su_3t.png", "su_4t.png",

    "Hanami_Kyoto_Suite_1.png", "Samurai_Kyoto_Suite_2.png", "Caligraphie_kyoto_Suite_2.png", "Mystique_Kyoto_Suite_1.png",
    "Alcool_Reykjavik_Suite.png", "Cascade_Reykjavik_Suite_1.png", "Baleine_Reykjavik_Suite_1.png", "Marin_Reykjavik_Suite_2.png",


    // Suite Présidentielle
    "LacRose_suite_p1.png",

//"LacRose_suite_p2.png",

 "zoo_suite_p1.png",

// "zoo_suite_p2.png",

 "lion_suite_p1.png",

//"lion_suite_p2.png",

 "sheraton_suite_p1.png",

// "sheraton_suite_p2.png",

    "reveOriental_suite_p1.png",

//"reveOriental_suite_p2.png",

 "OasisDeLuxe_suite_p1.png",

// "OasisDeLuxe_suite_p2.png",

 "riadModerne_suite_p1.png",

//"riadModerne_suite_p2.png",

 "AtlasMajestueux_suite_p1.png",

// "AtlasMajestueux_suite_p2.png",


 "suite_pres_louvres_paris.png",
//"suite_pres_louvres_paris_1.png",
 "suite_pres_luxe_paris.png",
//"suite_pres_luxe_paris_1.png",
 "suite_pres_traditionnelfrancais_paris.png",
//"suite_pres_traditionnelfrancais_paris_1.png",
 "suite_pres_elysee_paris.png",
//"suite_pres_elysee_paris_1.png",

    "suP_1t.png",

// "suP_11t.png",
 "suP_2t.png",
// "suP_21t.png",
"suP_3t.png",
// "suP_31t.png",
 "suP_4t.png",
// "suP_41t.png",




     "Luxe_Kyoto_Suitep.png",

//"Luxe_Kyoto_Suitep_1.png",

"Sushi_Kyoto_Suitep_1.png",

//"Sushi_Kyoto_Suitep.png",

"Moderne_Kyoto_Suitep_1.png",

//"Moderne_Kyoto_Suitep.png",

 "Hanabi_Kyoto_Suitep_4.png",

//"Hanabi_Kyoto_Suitep_4_1.png", 

     "Luxe_Reykjavik_Suitep.png",

 //"Luxe_Reykjavik_Suitep_1.png",

"Impérial_Reykjavik_Suitep.png",

//"Impérial_Reykjavik_Suitep_1.png",

 "Glace_futur_Reykjavik_Suitep.png",

//"Glace_futur_Reykjavik_Suitep_1.png",

 "Nature_Reykjavik_Suitep_1.png",

//"Nature_Reykjavik_Suitep.png" 

};


    public String[] types = {
        "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", 
	"Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple","Chambre Simple",

 	"Chambre Simple","Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple",
	"Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple",

	"Chambre Simple","Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple",
	"Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", 


        "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",
	"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",

	"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",
	"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",

	"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",
	"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",

        "Suite Normale", "Suite Normale", "Suite Normale", "Suite Normale",
	"Suite Normale", "Suite Normale", "Suite Normale", "Suite Normale",

	"Suite Normale", "Suite Normale", "Suite Normale", "Suite Normale",
	"Suite Normale", "Suite Normale", "Suite Normale", "Suite Normale",

	"Suite Normale", "Suite Normale", "Suite Normale", "Suite Normale",
	"Suite Normale", "Suite Normale", "Suite Normale", "Suite Normale",


        "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",
	"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",

	"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",
	"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",

	"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",
	"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle"

    };

    public Model_prc() {
        this.username = "Invité";
    }

    public Model_prc(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


public String[] getDescription(int index) {
    String type = types[index];
    String theme = themes[index];

    String base = "Bienvenue dans notre espace inspiré par le thème " + theme +
                  ". Un mélange unique de culture, confort et découverte pour un séjour inoubliable :\n";

    String suite;
    switch (type) {
        case "Chambre Simple":
            suite = "Notre chambre simple offre un confort épuré, idéal pour les voyageurs en quête de sérénité et d’authenticité.\n\n";
            break;
        case "Chambre Double":
            suite = "Parfaite pour les couples ou amis, notre chambre double associe espace et harmonie dans un cadre accueillant.\n\n";
            break;
        case "Suite Normale":
            suite = "Découvrez une suite élégante et spacieuse, alliant inspiration locale et confort moderne pour un séjour raffiné.\n\n";
            break;
        case "Suite Présidentielle":
            suite = "Notre suite présidentielle allie raffinement moderne et charme sénégalais. Vue imprenable, confort haut de gamme, et une atmosphère paisible pour une expérience inoubliable.\n\n";
            break;
        default:
            suite = "Un espace unique conçu pour votre confort et votre bien-être.\n";
    }

    return new String[] { base, suite };
}

public int[] prix = {

// Chambre simple
    100, 100, 100, 100, 100, 100,
    100, 100, 100, 100, 100, 100,
    100, 100, 100, 100, 100, 100,
    100, 100, 100, 100, 100, 100, 
    100, 100, 100, 100, 100, 100,
    100, 100, 100, 100, 100, 100,
 
// Chambre double
    200, 200, 200, 200, 200, 200,
    200, 200, 200, 200, 200, 200,
    200, 200, 200, 200, 200, 200,
    200, 200, 200, 200, 200, 200,
    200, 200, 200, 200, 200, 200,
    200, 200, 200, 200, 200, 200,
  
// Suite normale
    500, 500, 500, 500,
    500, 500, 500, 500,
    500, 500, 500, 500,
    500, 500, 500, 500,
    500, 500, 500, 500,
    500, 500, 500, 500,
      
// Suite présidentielle  
    1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,           
    1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
    1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 
    1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
    1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 
    1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 

};

public int getPrix(int index) {
    return prix[index];
}

}
