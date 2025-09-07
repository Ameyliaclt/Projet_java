package main;
import classe.*;
import vue.*;
import controlleur.*;
import model.*;
import java.awt.*;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate; 
import java.time.Month;

public class Main_prjt{
	public static Chambre[] cha_r;
    public static Hotel hotel_senegal, hotel_japon, hotel_france, hotel_islande, hotel_thailande, hotel_maroc;
    public static Vue_gestion_rs vue_gestion_rs;
    public static Seconnecter vue_ci;
    public static Vue_prcp vue_principale;
    public static Vue_pays v_j, v_t, v_f, v_i, v_m, v_s;
    public static Vue_hotel hotel_jap, hotel_thai, hotel_prs, hotel_isl, hotel_sn, hotel_ma;
    public static Continent Continent_Asie, Continent_Afrique, Continent_Europe;
    public static EnSavoirPlus esp;
	public static Model_tabRsrvSej tabs;
	
	public static void main(String[]args){
	tabs = new Model_tabRsrvSej();
	LocalDate currentDate = LocalDate.now();
	LocalDate currentDate_js = currentDate.plusDays(1);
	int jour = currentDate_js.getDayOfMonth();
	String mois = currentDate_js.getMonth().name().toLowerCase();
	int annee = currentDate_js.getYear();
	LocalDate dateDep = currentDate_js.plusDays(1);
	int jourDep = dateDep.getDayOfMonth();
	String moisDep = dateDep.getMonth().name().toLowerCase();
	int anneeDep = dateDep.getYear();
	Date setupDate = new Date(jour, 6, annee, 17, 00);
	Date ajd = new Date(jour, setupDate.getIntMonth_english(mois), annee, 17, 00);
	Date test_ar = new Date(18, 6,2025,17,00);
	Date test_dep = new Date(19, 6,2025,15,00);
	Client clientest = new Client ("Caristan", "Ninon", "xx xx xx xx xx", "x@gmail.com", "");
	Chambre ch1 = new Chambre(
			105, 
			"Chambre double", 
			"Cyberpunk", 
			200, 
			new String[] {"images//Cyberpunk_Kyoto_Double.png"}, 
			hotel_japon
		);

		Chambre ch2 = new Chambre(
			302, 
			"Suite", 
			"Samurai", 
			500, 
			new String[] {"images//Samurai_Kyoto_Suite_2.png"}, 
			hotel_japon
		);

		Chambre ch3 = new Chambre(
			101, 
			"Chambre simple", 
			"Tradition printanière", 
			100, 
			new String[] {"images//Tradition_printemps_Kyoto_Simple.png"}, 
			hotel_japon
		);

		Chambre ch4 = new Chambre(
			205, 
			"Chambre double", 
			"Lycoris", 
			200, 
			new String[] {"images//Lycoris_Kyoto_Double.png"}, 
			hotel_japon
		);

		cha_r = new Chambre[] { ch1, ch2, ch3, ch4 };
	Reservation rsrv2 = new Reservation (test_ar,test_dep,clientest,hotel_france,cha_r,2);
	Sejour sejControl = new Sejour(rsrv2, 1);
	Conso_mb conso1 = new Conso_mb("Coca cola", 3);
	Conso_mb conso2 = new Conso_mb("Sprite", 2);
	Conso_mb conso3 = new Conso_mb("Bière", 4);
	Conso_mb conso4 = new Conso_mb("Vin", 10);
	Conso_mb conso5 = new Conso_mb("Champagne", 20);
	Conso_mb conso6 = new Conso_mb("Snacks", 5);

	Conso_mb[] choix = {conso1, conso2, conso3, conso4, conso5, conso6};
	vue_gestion_rs = new Vue_gestion_rs(tabs.getCurrentRsrv(), tabs.getCurrentSej(), choix , sejControl, ajd, tabs); 
	int[] prix = {

			100, 100, 100, 100, 100, 100,
			
		 

			200, 200, 200, 200, 200, 200,
			
		  

			500, 500, 500, 500,
			
			  

			1000, 1000, 1000, 1000           
			 

		};
		Model_prjt m_1 = new Model_prjt ("RoomBloom");	
		Model_connectinscr modele_ci = new Model_connectinscr();
		SessionUtil.setModel(modele_ci);
		vue_ci = new Seconnecter(modele_ci);
		ControleurConnexionInscription Controlleur_ci = new ControleurConnexionInscription(modele_ci, vue_ci);
		Vue_Chambre vueChambre = null;

		Lieu_trsm[] lieu_ky = new Lieu_trsm[10];
        
        lieu_ky[0] = new Lieu_trsm("Samurai & Ninja Museum Kyoto", "202 Higashi Daimonjicho, Nakagyo-ku, Utano koji Building 2F, Kyoto, 604-8043, Japon", "+81 75-585-5410",0);
		lieu_ky[1] = new Lieu_trsm("Kyomizu-dera", "1 Chome-294 Kiyomizu, Higashiyama Ward, Kyoto, 605-0862, Japon", "+81 75-551-1234",1);
		lieu_ky[2] = new Lieu_trsm("Aman Kyoto", "1 Okitayama Watashimine-cho Kita-ku Kita-ku, Kyoto, 603-8458, Japon", "+81 75-496-1334",2);
		lieu_ky[3] = new Lieu_trsm("Marché Nishiki", "Nakagyo Ward, Kyoto, Kyoto, 604-8055, Japon", "+81 75-211-3882",3);
		lieu_ky[4] = new Lieu_trsm("Toei Kyoto Studio park", "10 Uzumasa, Higashihachiokacho, Ukyo Ward, Kyoto, 604-8586, Japon", "+81 75-864-7716",4);
		lieu_ky[5] = new Lieu_trsm("Gion Owatari", "570-265 Giommachi Minamigawa, Higashiyama-ku, Kyoto, 605-0074, Japon", "+81 75-551-5252",5);
		lieu_ky[7] = new Lieu_trsm("Aéroport international du Kansai", "1 Banchi Senshukukokita, Izumisano, Osaka, 549-0001, Japon", "+81 72-455-2500",7);
		lieu_ky[8] = new Lieu_trsm("gare de Kyoto", "Higashishiokoji Kamadonocho, Shimogyo Ward, Kyoto, 600-8216, Japon", "+81 75-361-4401",8);
		lieu_ky[6] = new Lieu_trsm("TOYOTA Rent a car", "31-1 Higashikujo Kamitonodacho, Minami Ward, Kyoto, 601-8002, Japon", "+81 75-682-0800",6);
		lieu_ky[9] = new Lieu_trsm("Ferry Miyazaki", "3-7 Shinko-cho, Chuo-ku, Kobe-shi, Hyogo, 650-0041, Japon", "+81 78-321-2244",9);
    
		hotel_japon = new Hotel("Japon", "Kyoto", "Tatsumicho, Higashiyama Ward, Kyoto, 605-0862, Japon", "Atarashii Kyoto", "+81 75-551-4321", "atarashiiKyoto@hotel.com", lieu_ky);
		String[] chambre_jap = {"Automne_Kyoto_Double.png", "Caligraphie_kyoto_Suite_2.png","CarpeKoi_Kyoto_Simple.png","Cyberpunk_Kyoto_Double.png","Dragon_Kyoto_Simple.png","Futuriste_Kyoto_Simple.png","Ghibli_Kyoto_Simple.png","Hanabi_Kyoto_Suitep_4.png","Hanami_Kyoto_Suite_1.png","Luxe_Kyoto_Suitep.png","Lycoris_Kyoto_Double.png","Minimalisme_Kyoto_Double.png","Moderne_Kyoto_Suitep_1.png","Mystique_Kyoto_Suite_1.png","Ninja_Kyoto_Double.png","Pokemon_Kyoto_Double.png","Samurai_Kyoto_Suite_2.png","Sushi_Kyoto_Suitep_1.png","Tradition_printemps_Kyoto_Simple.png","Traditionnelle_Kyoto_Simple.png"};
		String[] type_chambre_jap ={"Chambre double","Suite","Chambre simple","Chambre double","Chambre simple","Chambre simple","Chambre simple","Suite présidentielle","Suite","Suite présidentielle","Chambre double","Chambre double","Suite présidentielle","Suite","Chambre double","Chambre double","Suite","Suite présidentielle","Chambre simple","Chambre simple"};
		String[][] chambre_jap_1 = {{"images//Automne_Kyoto_Double.png"},{"images//Caligraphie_kyoto_Suite_2.png"},{"images//CarpeKoi_Kyoto_Simple.png"},{"images//Cyberpunk_Kyoto_Double.png"},{"images//Dragon_Kyoto_Simple.png"},{"images//Futuriste_Kyoto_Simple.png"},{"images//Ghibli_Kyoto_Simple.png"},{"images//Hanabi_Kyoto_Suitep_4.png"},{"images//Hanami_Kyoto_Suite_1.png", "images//Hanami_Kyoto_Suite_2.png"},{"images//Luxe_Kyoto_Suitep.png"},{"images//Lycoris_Kyoto_Double.png"},{"images//Minimalisme_Kyoto_Double.png"},{"images//Moderne_Kyoto_Suitep_1.png", "images//Moderne_Kyoto_Suitep.png"},{"images//Mystique_Kyoto_Suite_1.png", "images//Mystique_Kyoto_Suite_2.png"},{"images//Ninja_Kyoto_Double.png"},{"images//Pokemon_Kyoto_Double.png"},{"images//Samurai_Kyoto_Suite_2.png", "images//Samurai_Kyoto_Suite_1.png"},{"images//Sushi_Kyoto_Suitep_1.png", "images//Sushi_Kyoto_Suitep.png"},{"images//Tradition_printemps_Kyoto_Simple.png"},{"images//Traditionnelle_Kyoto_Simple.png"}};
		String[] theme_chambre_jap ={"sur le thème de l'automne","sur le thème de la caligraphie japonaise","sur le thème de la carpekoi","sur le thème de Cyberpunk","sur le thème des dragons","futuriste","sur le thème de Ghibli","sur le thèmes des hanabi","sur le thèmes des hanabi","de luxe","sur le thème du Lycoris japonais","minimaliste","moderne","mystique","sur le thème des ninja","sur le thème de pokémon","sur le thème des samouraï","sur le thème des sushis","printanière","traditionnelle"};
		String[] theme_filtre_jap ={"Culture","Culture","Culture","Aimer des touristes","Aimer des touristes","Moderne","Aimer des touristes","Culture","Luxe","Luxe","Culture","Moderne","Moderne","Culture","Culture","Aimer des touristes","Culture","Aimer des touristes","Aimer des touristes","Culture"};
		Hotel_model japon = new Hotel_model("images//photo_entete_jap.png",chambre_jap,type_chambre_jap,theme_chambre_jap,new Color(255,236,253),theme_filtre_jap);
		ArrayList<Chambre> chambres_japon = new ArrayList<>();

		for (int i = 0; i < type_chambre_jap.length; i++) {
			Chambre ch = new Chambre(
					i + 1,
					type_chambre_jap[i],
					theme_chambre_jap[i],
					prix[i],
					chambre_jap_1[i],
					hotel_japon
			);
			chambres_japon.add(ch);
		}
	    Model_prc_Chambre model_chambre_jap = new Model_prc_Chambre(chambres_japon,modele_ci);
		hotel_jap = new Vue_hotel(hotel_japon,japon,model_chambre_jap);
		
		Lieu_trsm[] lieux_ba = new Lieu_trsm[10];
    
        lieux_ba[0] = new Lieu_trsm("Wat Pho","2 Sanamchai Road, Grand Palace Subdistrict, Pranakorn District, Bangkok 10200, Thaïlande","+66830577100",0);
        lieux_ba[1] = new Lieu_trsm("The Grand Palace","Na Phra Lan Rd, Phra Nakhon, Bangkok 10200, Thaïlande","+66232259519",1);
        lieux_ba[2] = new Lieu_trsm("Bangkok Yai Park","PFJH+J8Q, Wat Tha Phra, Bangkok Yai, Bangkok 10600, Thaïlande","+6624655640",2);
        lieux_ba[3] = new Lieu_trsm("CentralWorld","999/9 Rama I Rd, Pathum Wan, Bangkok 10330, Thaïlande","+6626407000",3);
        lieux_ba[4] = new Lieu_trsm("Siam Amazing Park","203 Suan Siam Rd, Khwaeng Khan Na Yao, Khet Khan Na Yao, Krung Thep Maha Nakhon 10230, Thaïlande","+6621054292",4);
        lieux_ba[5] = new Lieu_trsm("Kinu by Tagaki","Mandarin Oriental Bangkok, 48 Oriental Ave, Khwaeng Bang Rak, Bang Rak, Bangkok 10500, Thaïlande","+6626599000",5);
        lieux_ba[6] = new Lieu_trsm("Suvarnabhumi Airport (BKK)","999, Nong Prue, Bang Phli District, Samut Prakan 10540, Thaïlande","+6621321888",6);
        lieux_ba[7] = new Lieu_trsm("Bangkok Railway Station","Rong Mueang Rd, Rong Muang, Pathum Wan, Bangkok 10330, Thaïlande","+6622204334",7);
        lieux_ba[8] = new Lieu_trsm("Bangkok Port","Khlong Toei, Bangkok 10110, Thaïlande","+6622384000",8);
        lieux_ba[9] = new Lieu_trsm("Drive Car Rental - Suvarnabhumi Airport","Suvarnabhumi Airport,, Arrival Hall, 999 Moo 1, Nong Prue,, Bang Phli District, Samut Prakan 10540, Thaïlande","+66847004376",9);
		
		hotel_thailande = new Hotel("Thailande","Bangkok", "PFWR+C85, Maha Rat Rd, Phra Borom Maha Ratchawang, Phra Nakhon, Bangkok 10200, Thaïlande","Wat Pho Hotel","+66 89 057 7100","watpho_hotel@hotel.com",lieux_ba,true);
		String[] chambre_thai ={"d_1t.png","s_1t.png","s_2t.png","suP_3t.png","su_1t.png","s_3t.png","d_3t.png","d_2t.png","suP_1t.png","suP_2t.png","d_5t.png","s_4t.png","d_4t.png","su_2t.png","s_5t.png","suP_4t.png","su_3t.png","d_6t.png","su_4t.png","s_6t.png"};
		String[] type_chambre_thai = {"Chambre double","Chambre simple","Chambre simple","Suite présidentielle","Suite","Chambre simple","Chambre double","Chambre double","Suite présidentielle","Suite présidentielle","Chambre double","Chambre simple","Chambre double","Suite","Chambre simple","Suite présidentielle","Suite","Chambre double","Suite","Chambre simple"};
		String[][] chambre_thai_1 = {{"images//d_1t.png"}, {"images//s_1t.png"}, {"images//s_2t.png"}, {"images//suP_3t.png"}, {"images//su_1t.png"}, {"images//s_3t.png"}, {"images//d_3t.png"}, {"images//d_2t.png"}, {"images//suP_1t.png"}, {"images//suP_2t.png"}, {"images//d_5t.png"}, {"images//s_4t.png"}, {"images//d_4t.png"}, {"images//su_2t.png"}, {"images//s_5t.png"}, {"images//suP_4t.png"}, {"images//su_3t.png"}, {"images//d_6t.png"}, {"images//su_4t.png"}, {"images//s_6t.png"}};	
		String[] theme_chambre_thai = {"traditionnel","traditionnel","sur le thème de Wan Makha Bucha","Royal","Traditionnel","sur le thème Wan Vaisakh Bucha","sur le thème des rues thailandaises","sur le thème des éléphants","sur le thème des orchidées","dorée à l'Or pur","sur le thème Makha Bucha","sur le thème China town","sur le thème de Bo sang","sur le thème du festival des lumières","sur le thème des tigres","du nouvelle an Chinois","sur le thème de la pleine lune","sur le thème de Phi Ta Khon","sur le thème de Lopburi","sur le thème de la fleur de lotus"};
		String[] theme_filtre_thai = {"Culture","Culture","Culture","Luxe","Culture","Aimer des touristes","Aimer des touristes","Culture","Aimer des touristes","Luxe","Culture","Luxe","Culture","Moderne","Moderne","Culture","Culture","Moderne"};
		ArrayList<Chambre> chambres_thailande = new ArrayList<>();

		for (int i = 0; i < type_chambre_thai.length; i++) {
			Chambre ch = new Chambre(
					i + 1,
					type_chambre_thai[i],
					theme_chambre_thai[i],
					prix[i],
					chambre_thai_1[i],
					hotel_thailande
			);
			chambres_thailande.add(ch);
		}
		Hotel_model thailande = new Hotel_model("images//photo_entete_thai.png",chambre_thai,type_chambre_thai,theme_chambre_thai,new Color(200,173,127),theme_filtre_thai);
		Model_prc_Chambre model_chambre_thai = new Model_prc_Chambre(chambres_thailande,modele_ci);	
		hotel_thai = new Vue_hotel(hotel_thailande, thailande,model_chambre_thai);
		
		Lieu_trsm[] lieu_pa = new Lieu_trsm[9];
        
        lieu_pa[0] = new Lieu_trsm("Aquarium de Paris","5 Av. Albert de Mun, 75016 Paris","0145393000",0);
        lieu_pa[1] = new Lieu_trsm("Visite des catacombes de Paris","1 Av. du Colonel Henri Rol-Tanguy, 75014 Paris","0145430657",1);
        lieu_pa[2] = new Lieu_trsm("Espace Détente","22 rue de magdebourg, 75016 Paris","0749619185",2);
        lieu_pa[3] = new Lieu_trsm("Centre commercial Beaugrenelle","12 Rue Linois, 75015 Paris","0153952400",3);
        lieu_pa[4] = new Lieu_trsm("Disneyland Paris","Bd de Parc, 77700 Coupvray","0969326066",4);
        lieu_pa[5] = new Lieu_trsm("Madame Brasserie - Tour Eiffel","av. Gustave Eiffel, 75007 Paris","0183777778",5);
        lieu_pa[6] = new Lieu_trsm("Aéroport de Paris-Orly","94390 Orly","0170363950",6);
        lieu_pa[7] = new Lieu_trsm("Gare Montparnasse","17 Bd de Vaugirard","3635",7);
        lieu_pa[8] = new Lieu_trsm("SIXT|Location voiture gare Montparnasse","Gare face, Hall 2, Bd Pasteur voie 19, 75015 Paris","0170976111",8);
		
		hotel_france = new Hotel("France", "Paris","127 Av. des Champs-Élysées, 75008 Paris","Elégance","0145678926","elegance_paris@hotel.fr",lieu_pa); 
		String[] chambre_paris = {"chambre_double_boheme_paris.png","chambre_simple_futuriste_paris.png","chambre_double_romantiqueparisien_paris.png","suite_pres_louvres_paris.png","suite_monnet_paris.png","suite_dior_paris.png","chambre_simple_traditionnel_paris.png","chambre_double_moderneparisien_paris.png","chambre_simple_royal_paris.png","chambre_simple_parisien_paris.png","suite_pres_traditionnelfrancais_paris.png","chambre_double_moulinrouge_paris.png","chambre_simple_moderne_paris.png","suite_rococo_paris.png","chambre_double_cabinetdecuriosite_paris.png","suite_pres_luxe_paris.png","chambre_simple_minimaliste_paris.png","suite_modernefuturiste_paris.png","suite_pres_elysee_paris.png","chambre_double_luxe_paris.png"};
		String[][] chambre_paris_1 = {{"images//chambre_double_boheme_paris.png"}, {"images//chambre_simple_futuriste_paris.png"}, {"images//chambre_double_romantiqueparisien_paris.png"}, {"images//suite_pres_louvres_paris.png"}, {"images//suite_monnet_paris.png","images//suite_monnet_paris_1.png"}, {"images//suite_dior_paris.png","images//suite_dior_paris_1.png"}, {"images//chambre_simple_traditionnel_paris.png"}, {"images//chambre_double_moderneparisien_paris.png"}, {"images//chambre_simple_royal_paris.png"}, {"images//chambre_simple_parisien_paris.png"}, {"images//suite_pres_traditionnelfrancais_paris.png"}, {"images//chambre_double_moulinrouge_paris.png"}, {"images//chambre_simple_moderne_paris.png"}, {"images//suite_rococo_paris.png"}, {"images//chambre_double_cabinetdecuriosite_paris.png"}, {"images//suite_pres_luxe_paris.png"}, {"images//chambre_simple_minimaliste_paris.png"}, {"images//suite_modernefuturiste_paris.png"}, {"images//suite_pres_elysee_paris.png","images//suite_pres_elysee_paris_2.png"}, {"images//chambre_double_luxe_paris.png"}};
		String[] type_chambre_paris = {"Chambre double","Chambre simple","Chambre double","Suite présidentielle","Suite","Suite","Chambre simple","Chambre double","Chambre simple","Chambre simple","Suite présidentielle","Chambre double","Chambre simple","Suite","Chambre double","Suite présidentielle","Chambre simple","Suite","Suite présidentielle","Chambre double"};
		String[] theme_chambre_paris = {"bohème","futuriste","romantique","sur le thème du Louvres","sur le thème de Monnet","sur le thème de Dior","traditionnel","moderne","royal","parisien","traditionnel","sur le thème du moulin rouge","moderne","rococo","sur le thème cabinet de curiosité","de luxe","minimaliste","moderne/futuriste","sur le thème de l'élysée","de luxe"};
		String[] theme_filtre_paris = {"Aimer des touristes","moderne","Aimer des touristes","Culture","Culture","Culture","Culture","Moderne","Luxe","Culture","Luxe","Culture","Moderne","Aimer des touristes","Aimer des touristes","Luxe","Moderne","Moderne","Luxe","Luxe"};
		ArrayList<Chambre> chambres_paris = new ArrayList<>();

		for (int i = 0; i < type_chambre_paris.length; i++) {
			Chambre ch = new Chambre(
					i + 1,
					type_chambre_paris[i],
					theme_chambre_paris[i],
					prix[i],
					chambre_paris_1[i],
					hotel_france
			);
			chambres_paris.add(ch);
		}
		Hotel_model paris = new Hotel_model("images//photo_entete_paris.png",chambre_paris,type_chambre_paris,theme_chambre_paris,new Color(239,231,219),theme_filtre_paris);
	    Model_prc_Chambre model_chambre_prs = new Model_prc_Chambre(chambres_paris,modele_ci);				
		hotel_prs = new Vue_hotel(hotel_france,paris,model_chambre_prs);
		
		 Lieu_trsm[] lieux_re = new Lieu_trsm[10];
    
        lieux_re[0] = new Lieu_trsm("Musée des Sagas", "Granddagadur 2, 101 Reykjavik, Islande", "+354 511 1517", 0);
        lieux_re[1] = new Lieu_trsm("Northern Lights Bus", "Skogarhlid 10, 105 Reykjavik, Islande", "+354 539 3888", 1);
        lieux_re[2] = new Lieu_trsm("Sky Lagoon", "Vesturvör 44-48, Kopavogur, Islande", "+354 527 6800", 2);
        lieux_re[3] = new Lieu_trsm("Kringlan Mall", "Kringlan 4-12, 103 Reykjavik, Islande", "+354 517 9000", 3);
        lieux_re[4] = new Lieu_trsm("Laugardalur", "Grandagardur 2, 101 Reykjavik, Islande", "+354 411 1111", 4);
        lieux_re[5] = new Lieu_trsm("Kol Restaurant", "Skolavördustigur 40, 101 Reykjavik, Islande", "+354 517 7474", 5);
        lieux_re[6] = new Lieu_trsm("Sixt Rent a car", "Krokhals 9, 110 Reykjavik, Islande", "+354 540 2222", 6);
        lieux_re[7] = new Lieu_trsm("Aéroport de Reykjavik", "Vatnsmyri, 101 Reykjavik, Islande", "+354 424 4000", 7);
        lieux_re[8] = new Lieu_trsm("Terminal Bus Reykjavik", "Skogarhlid 10, 105 Reykjavik, Islande", "+354 497 5000", 8);
        lieux_re[9] = new Lieu_trsm("Skarfabakki Harbour", "544P+F35, 104 Reykjavik, Islande", "+354 525 8900", 9);
		
		hotel_islande = new Hotel("Islande", "Reykjavik", "Nautholsvégur 83, Reykjavik, Islande", "Fagun Reykjavik", "+354 710 9648", "fagunReykjavik@hotel.com", lieux_re);
		String[] chambre_isl = {"Aurore_Reykjavik_Simple.png","Baleine_Reykjavik_Suite_1.png","Basalte_Reykjavik_Double.png","Cascade_Reykjavik_Suite_1.png","Futuriste_Reykjavik_Simple.png","Glace_futur_Reykjavik_Suitep.png","Glaciers_Reykjavik_Double.png","Igloo_Reykjavik_Simple.png","Imperial_Reykjavik_Suitep.png","Lagoon_Reykjavik_Simple.png","Luxe_Reykjavik_Suitep.png","Minimaliste_Reykjavik_Double.png","Montagnes_Reykjavik_Double.png","Marin_Reykjavik_Suite_2.png","Nature_Reykjavik_Suitep_1.png","Ours_Polaire_Reykjavik_Double.png","Traditionnel_Reykjavik_Simple.png","Viking_Reykjavik_Simple.png","Volcan_Reykjavik_Double.png","Alcool_Reykjavik_Suite.png"};
		String[][] chambre_isl_1 = {
			{"images//Aurore_Reykjavik_Simple.png"}, {"images//Baleine_Reykjavik_Suite_1.png"}, {"images//Basalte_Reykjavik_Double.png"},
			{"images//Cascade_Reykjavik_Suite_1.png"}, {"images//Futuriste_Reykjavik_Simple.png"},
			{"images//Glace_futur_Reykjavik_Suitep.png", "images//Glace_futur_Reykjavik_Suitep_1.png"},
			{"images//Glaciers_Reykjavik_Double.png"}, {"images//Igloo_Reykjavik_Simple.png"},
			{"images//Imperial_Reykjavik_Suitep.png", "images//Impérial_Reykjavik_Suitep_1.png"},
			{"images//Lagoon_Reykjavik_Simple.png"}, {"images//Luxe_Reykjavik_Suitep.png","images//Luxe_Reykjavik_Suitep_1.png"},
			{"images//Minimaliste_Reykjavik_Double.png"}, {"images//Montagnes_Reykjavik_Double.png"},
			{"images//Marin_Reykjavik_Suite_2.png", "images//Marin_Reykjavik_Suite.png"},
			{"images//Nature_Reykjavik_Suitep_1.png", "images//Nature_Reykjavik_Suitep.png"},
			{"images//Ours_Polaire_Reykjavik_Double.png"}, {"images//Traditionnel_Reykjavik_Simple.png"},
			{"images//Viking_Reykjavik_Simple.png"}, {"images//Volcan_Reykjavik_Double.png"},
			{"images//Alcool_Reykjavik_Suite.png"}
		};
		String[] type_chambre_isl = {"Chambre simple","Suite","Chambre double","Suite","Chambre simple","Suite présidentielle","Chambre double","Chambre simple","Suite présidentielle","Chambre simple","Suite présidentielle","Chambre double","Chambre double","Suite","Suite présidentielle","Chambre double","Chambre simple","Chambre simple","Chambre double","Suite"};
		String[] theme_chambre_isl = {"sur le thème des aurores boréales","sur le thème des baleines","basalte","sur le thème des cascades","futuriste","sur le thème de la glace","sur le thème des glaciers","sur le thème des igloo","impérial","sur le thème des lagoon","de luxe","minimaliste","sur le thème des montagnes","sur le thème marin","sur le thème des animaux","sur le thème des ours polaires","traditionnel","sur le thème des vikings","sur le thème des  volcans","sur le thème elixirs"};
		String[] theme_filtre_isl = {"Aimer des touristes","Aimer des touristes","Culture","Aimer des touristes","Moderne","Culture","Culture","Culture","Luxe","Luxe","Luxe","Moderne","Culture","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Culture","Culture"};
		ArrayList<Chambre> chambres_islande = new ArrayList<>();

		for (int i = 0; i < type_chambre_isl.length; i++) {
			Chambre ch = new Chambre(
					i + 1,
					type_chambre_isl[i],
					theme_chambre_isl[i],
					prix[i],
					chambre_isl_1[i],
					hotel_islande
			);
			chambres_islande.add(ch);
		}
		Hotel_model islande = new Hotel_model("images//photo_entete_islande.png",chambre_isl,type_chambre_isl,theme_chambre_isl,new Color(119, 136, 153),theme_filtre_isl);
	    Model_prc_Chambre model_chambre_isl = new Model_prc_Chambre(chambres_islande,modele_ci);	
		hotel_isl = new Vue_hotel(hotel_islande,islande,model_chambre_isl);

		Lieu_trsm[] lieux_ma = new Lieu_trsm[9];
        
        lieux_ma[0] = new Lieu_trsm("Musée de Marrakech", "Place Ben Youssef, Marrakesh 40 000, Maroc", "+212 5 24 44 18 93", 0);
        lieux_ma[1] = new Lieu_trsm("Mosquée Koutoubia", "Koutoubia Marrakech, Marrakech 40 000, Maroc", "+212 5 24 43 34 07", 1);
        lieux_ma[2] = new Lieu_trsm("Elysa Center", "Las Torrres de Majorelle, av. Yacoub El Mansour, Marrakech 40 000, Maroc", "+212 5 24 43 31 79", 2);
        lieux_ma[3] = new Lieu_trsm("Ménara Mall", "Bd Mohamed VI, Marrakech 40 000, Maroc", "+212 5 24 35 10 50", 3);
        lieux_ma[4] = new Lieu_trsm("Gravity Park", "Bd de Casablanca, Marrakech 40 000, Maroc", "+212 6 55 50 59 59", 4);
        lieux_ma[5] = new Lieu_trsm("Le Grand Bazar", "Place Jemaa El Fna, propriete Zanket El Guassabine, Marrakech 40 000, Maroc", "+212 6 82 54 25 13", 5);
        lieux_ma[6] = new Lieu_trsm("Medloc Car Rental 4x4", "75 Rue Ibn Aincha, Marrakech 40 000, Maroc", "+212 6 61 18 13 89", 6);
        lieux_ma[7] = new Lieu_trsm("Aéroport international Marrakech Ménara", "Marrakech 40 000, Maroc", "+212 5 24 44 79 10", 7);
        lieux_ma[8] = new Lieu_trsm("Gare MARRAKECH", "Centre, Bd Mohamed VI, Marrakesh 40 100, Maroc", "+212 5 37 77 47 47", 8);
		
		hotel_maroc = new Hotel("Maroc", "Marrakech", "Place Jemaa El Fna, Marrakech 40 000, Maroc", "Marrakech Palace", "+212 524 33 44 33", "marrakech_palace@hotel.com", lieux_ma,true);
		String[] chambre_ma = {"arabe_cham_s.png","argile_cham_d.png","atay_cham_d.png","AtlasMajestueux_suite_p1.png","babouche_cham_s.png","couscous_cham_d.png","datte_suite_n.png","flouka_cham_s.png","hamam_suite_n.png","henna_cham_d.png","jame3lefna_cham_d.png","mosquee_cham_s.png","OasisDeLuxe_suite_p1.png","olivier_suite_n.png","or_cham_s.png","reveOriental_suite_p1.png","riadModerne_suite_p1.png","souk_suite_n.png","tajine_cham_d.png","tborida_cham_s.png"};
		String[][] chambre_ma_1 = {{"images//arabe_cham_s.png"}, {"images//argile_cham_d.png"}, {"images//atay_cham_d.png"}, {"images//AtlasMajestueux_suite_p1.png", "images//AtlasMajestueux_suite_p2.png"}, {"images//babouche_cham_s.png"}, {"images//couscous_cham_d.png"}, {"images//datte_suite_n.png"}, {"images//flouka_cham_s.png"}, {"images//hamam_suite_n.png"}, {"images//henna_cham_d.png"}, {"images//jame3lefna_cham_d.png"}, {"images//mosquee_cham_s.png"}, {"images//OasisDeLuxe_suite_p1.png", "images//OasisDeLuxe_suite_p2.png"}, {"images//olivier_suite_n.png"}, {"images//or_cham_s.png"}, {"images//reveOriental_suite_p1.png", "images//reveOriental_suite_p2.png"}, {"images//riadModerne_suite_p1.png","images//riadModerne_suite_p2.png"}, {"images//souk_suite_n.png"}, {"images//tajine_cham_d.png"}, {"images//tborida_cham_s.png"}};
		String[] type_chambre_ma ={"Chambre simple","Chambre double","Chambre double","Suite présidentielle","Chambre simple","Chambre double","Suite","Chambre simple","Suite","Chambre double","Chambre double","Chambre simple","Suite présidentielle","Suite","Chambre simple","Suite présidentielle","Suite présidentielle","Suite","Chambre double","Chambre simple"};
		String[] theme_chambre_ma = {"Andalouse","Ocre","sur le thème du Atay","sur le thème des lions","sur le thème des babouches","berbère","sur le thème des dattes","sur le thème des flouka","sur le thème du hammam","sur le thème du henné","Jemaa el-Fna","Minaret","Oasis de luxe","sur le thème des oliviers","Zest","rêve oriental","riad moderne","sur le thème des épices","sur le thème du tajine","Sultane"};
		String[] theme_filtre_ma = {"Moderne","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Luxe","Culture","Luxe","Luxe","Culture","Aimer par les touristes","Luxe","Luxe","Moderne","Luxe","Moderne","Moderne","Aimer des touristes"};
		ArrayList<Chambre> chambres_maroc = new ArrayList<>();

		for (int i = 0; i < type_chambre_ma.length; i++) {
			Chambre ch = new Chambre(
					i + 1,
					type_chambre_ma[i],
					theme_chambre_ma[i],
					prix[i],
					chambre_ma_1[i],
					hotel_maroc
			);
			chambres_maroc.add(ch);
		}
		Hotel_model maroc = new Hotel_model("images//photo_entete_ma.png",chambre_ma,type_chambre_ma,theme_chambre_ma,new Color(240, 230, 210),theme_filtre_ma);
		Model_prc_Chambre model_chambre_ma = new Model_prc_Chambre(chambres_maroc,modele_ci);				
		hotel_ma = new Vue_hotel(hotel_maroc,maroc,model_chambre_ma);
		
		Lieu_trsm[] lieux_sn = new Lieu_trsm[9];
        
        lieux_sn[0] = new Lieu_trsm("Centre d’interprétation du Delta du Saloum de Toubacouta", "Toubakouta, Sénégal", "+221 33 945 86 28", 0);
        lieux_sn[1] = new Lieu_trsm("Phare des Mamelles", "Mamelles, Rte de l'aéroport, Dakar, Sénégal", "+221 77 343 72 72", 1);
        lieux_sn[2] = new Lieu_trsm("Ryad al Sultan Oriental Spa", "Rte de la Corniche O, Dakar, Sénégal", "+221 33 824 99 28", 2);
        lieux_sn[3] = new Lieu_trsm("Centre commercial les 4 C", "Av. Malick Sy, Dakar 10000, Sénégal", "+221 77 444 14 75", 3);
        lieux_sn[4] = new Lieu_trsm("Magic Land", "Route de la Corniche Ouest, Dakar, Sénégal", "+221 33 823 49 36", 4);
        lieux_sn[5] = new Lieu_trsm("Restaurant La Terrasse", "Boulevard Martin Luther King, Rte de la Corniche O, Dakar 91 179, Sénégal", "+221 33 839 90 40", 5);
        lieux_sn[6] = new Lieu_trsm("Sixt Sénégal", "269 rue LIB 02, Dakar 11 000, Sénégal", "+221 33 820 15 95", 6);
        lieux_sn[7] = new Lieu_trsm("Aéroport de Dakar-Blaise Diagne", "Diass, Sénégal", "+221 33 939 69 00", 7);
        lieux_sn[8] = new Lieu_trsm("Gare ferroviaire de Dakar", "Dakar, Sénégal", "33 920 00 40", 8);
		
		hotel_senegal = new Hotel("Sénégal", "Dakar", "Bp 8, Somone, Sénégal", "Royal Horizon Baobab", "+221 33 939 71 71", "", lieux_sn,true); 
		String[] chambre_sn = {"barque_cham_s.png","cacao_cham_s.png","couleurs_cham_d.png","chocolat_cham_s.png","foot_cham_d.png","fruitexotic_suite_n.png","ile_suite_n.png","instrumentXalam_cham_s.png","koya_suite_n.png","LacRose_suite_p1.png","lion_suite_p1.png","maison_senegalaise_cham_d.png","mosquee_s_cham_d.png","moustiquaire_cham_d.png","ocean_cham_s.png","orange_s_cham_d.png","riz_cham_s.png","sheraton_suite_p1.png","tresse_suite_n.png","zoo_suite_p1.png"};
		String[][] chambre_sn_1 = {{"images//barque_cham_s.png"}, {"images//cacao_cham_s.png"}, {"images//couleurs_cham_d.png"}, {"images//chocolat_cham_s.png"}, {"images//foot_cham_d.png"}, {"images//fruitexotic_suite_n.png"}, {"images//ile_suite_n.png"}, {"images//instrumentXalam_cham_s.png"}, {"images//koya_suite_n.png"}, {"images//LacRose_suite_p1.png", "images//LacRose_suite_p2.png"}, {"images//lion_suite_p1.png", "images//lion_suite_p2.png"}, {"images//maison_senegalaise_cham_d.png"}, {"images//mosquee_s_cham_d.png"}, {"images//moustiquaire_cham_d.png"}, {"images//ocean_cham_s.png"}, {"images//orange_s_cham_d.png"}, {"images//riz_cham_s.png"}, {"images//sheraton_suite_p1.png", "images//sheraton_suite_p2.png"}, {"images//tresse_suite_n.png"}, {"images//zoo_suite_p1.png", "images//zoo_suite_p2.png"}};
		String[] type_chambre_sn = {"Chambre simple","Chambre simple","Chambre double","Chambre simple","Chambre double","Suite","Suite","Chambre simple","Suite","Suite présidentielle","Suite présidentielle","Chambre double","Chambre double","Chambre double","Chambre simple","Chambre double","Chambre simple","Suite présidentielle","Suite","Suite présidentielle"};
		String[] theme_chambre_sn = {"sur le thème des barques","sur le thème cacao","coloré","chocolaté","sur le thème du football","sur le thème des fruits exotiques","sur le thème des îles","sur le thèmes des Xalam","koya","lac rose","sur le thèmes des lions","sur le thèmes des maisons sénégalaises","mosquée","sur le thème des moustiquaires","sur le thème des océan","orangé","sur le thème du riz","sheraton","sur le thème des tresse","sur le thème du zoo"};
		String[] theme_filtre_sn = {"Aimer des touristes","Culture","Culture","Aimer des tourites","Aimer des touristes","Luxe","Aimer des touristes","Culture","Luxe","Luxe","Moderne","Culture","Culture","Luxe","Culture","Moderne","Aimer des touristes","Luxe","Culture","Moderne"};
		ArrayList<Chambre> chambres_senegal = new ArrayList<>();

		for (int i = 0; i < type_chambre_sn.length; i++) {
			Chambre ch = new Chambre(
					i + 1,
					type_chambre_sn[i],
					theme_chambre_sn[i],
					prix[i],
					chambre_sn_1[i],
					hotel_senegal
			);
			chambres_senegal.add(ch);
		}
		Hotel_model senegal = new Hotel_model("images//photo_entete_sn.png",chambre_sn,type_chambre_sn,theme_chambre_sn,new Color(144, 164, 96),theme_filtre_sn);
		Model_prc_Chambre model_chambre_sn = new Model_prc_Chambre(chambres_senegal,modele_ci);								
		hotel_sn = new Vue_hotel(hotel_senegal,senegal,model_chambre_sn);
		
		Pays jap = new Pays("images//Fond_japon.jpg", "images//Sakura_back.png", "images//Hotel_Kyoto_3.jpg", Color.PINK, new Color(244,204,231), new Color(232,100,134));
		Pays isl = new Pays("images//Fond_islande.png", "images//Glacon_fond.png", "images//Hotel_Reykjavik.png", new Color(190,243,220), new Color(152,194,225), Color.WHITE);
		Pays fr = new Pays("images//Fond_france.png", "images//Fond_lys.png", "images//hotel_p.png", new Color(105,181,238), new Color(180,235,126), Color.WHITE);
		Pays ma = new Pays("images//Fond_maroc.png", "images//Fond_tajine.png", "images//hotel_maroc.png", new Color(169,121,217), new Color(111,180,241), Color.WHITE);
		Pays thai = new Pays("images//Fond_thailande.png", "images//Fond_lanternes.png", "images//hotel_piscine_thai.jpg", new Color(162,240,233), new Color(249,222,142), Color.WHITE);
		Pays sn = new Pays("images//Fond_senegal.png", "images//Fond_baobab.png", "images//hotel_senegal.png", new Color(215,107,100), new Color(215,107,100), Color.WHITE);

		v_j = new Vue_pays(hotel_japon, jap);
		NavControlleur controlleur_jap = new NavControlleur(v_j, hotel_jap);
        v_j.setControlleur(controlleur_jap);
		
		v_i = new Vue_pays(hotel_islande, isl);
		NavControlleur controlleur_isl = new NavControlleur(v_i, hotel_isl);
        v_i.setControlleur(controlleur_isl);
		
		v_f = new Vue_pays(hotel_france, fr);
		NavControlleur controlleur_fr = new NavControlleur(v_f, hotel_prs);
        v_f.setControlleur(controlleur_fr);
		
		v_m = new Vue_pays(hotel_maroc, ma);
		NavControlleur controlleur_ma = new NavControlleur(v_m, hotel_ma);
        v_m.setControlleur(controlleur_ma);
		
		v_t = new Vue_pays(hotel_thailande, thai);
		NavControlleur controlleur_thai = new NavControlleur(v_t, hotel_thai);
        v_t.setControlleur(controlleur_thai);
		
		v_s = new Vue_pays(hotel_senegal, sn);
		NavControlleur controlleur_sn = new NavControlleur(v_s, hotel_sn);
        v_s.setControlleur(controlleur_sn);

		String[] pays_asie = {"japon.png","thailande.png"};
		String[] nom_asie = {"Japon","Thailande"};
		Continent_model asie_ct = new Continent_model(pays_asie,"asie.png",nom_asie,"Voyagez en Asie");
		Continent_Asie = new Continent(m_1,asie_ct);
		NavControlleur controlleur_asie = new NavControlleur(Continent_Asie, v_j, v_t);
		
		String[] pays_afrique = {"maroc.png","senegal.png"};
		String[] nom_afrique = {"Maroc","Sénégal"};
		Continent_model afrique_ct = new Continent_model(pays_afrique,"afrique.png",nom_afrique,"Voyagez en Afrique");
		Continent_Afrique = new Continent(m_1, afrique_ct);
		NavControlleur controlleur_afrique = new NavControlleur(Continent_Afrique, v_m, v_s);
		
		String[] pays_europe = {"france.png","islande.png"};
		String[] nom_europe = {"France","Islande"};
		Continent_model europe_ct = new Continent_model(pays_europe,"europe1.png",nom_europe,"Voyagez en Europe");
		Continent_Europe = new Continent(m_1,europe_ct);
		NavControlleur controlleur_europe = new NavControlleur(Continent_Europe, v_f, v_i);
		
		esp = new EnSavoirPlus(m_1);
		
        String[] nomFichiers = {
			"images//barque_cham_s.png","images//cacao_cham_s.png","images//couleurs_cham_d.png","images//chocolat_cham_s.png","images//foot_cham_d.png",
			"images//fruitexotic_suite_n.png","images//ile_suite_n.png","images//instrumentXalam_cham_s.png","images//koya_suite_n.png","images//LacRose_suite_p1.png",
			"images//lion_suite_p1.png","images//maison_senegalaise_cham_d.png","images//mosquee_s_cham_d.png","images//moustiquaire_cham_d.png","images//ocean_cham_s.png",
			"images//orange_s_cham_d.png","images//riz_cham_s.png","images//sheraton_suite_p1.png","images//tresse_suite_n.png","images//zoo_suite_p1.png",

			"images//arabe_cham_s.png","images//argile_cham_d.png","images//atay_cham_d.png","images//AtlasMajestueux_suite_p1.png","images//babouche_cham_s.png",
			"images//couscous_cham_d.png","images//datte_suite_n.png","images//flouka_cham_s.png","images//hamam_suite_n.png","images//henna_cham_d.png","images//jame3lefna_cham_d.png",
			"images//mosquee_cham_s.png","images//OasisDeLuxe_suite_p1.png","images//olivier_suite_n.png","images//or_cham_s.png","images//reveOriental_suite_p1.png",
			"images//riadModerne_suite_p1.png","images//souk_suite_n.png","images//tajine_cham_d.png","images//tborida_cham_s.png",

			"images//Aurore_Reykjavik_Simple.png","images//Baleine_Reykjavik_Suite_1.png","images//Basalte_Reykjavik_Double.png",
			"images//Cascade_Reykjavik_Suite_1.png","images//Futuriste_Reykjavik_Simple.png","images//Glace_futur_Reykjavik_Suitep.png",
			"images//Glaciers_Reykjavik_Double.png","images//Igloo_Reykjavik_Simple.png","images//Imperial_Reykjavik_Suitep.png",
			"images//Lagoon_Reykjavik_Simple.png","images//Luxe_Reykjavik_Suitep.png","images//Minimaliste_Reykjavik_Double.png",
			"images//Montagnes_Reykjavik_Double.png","images//Marin_Reykjavik_Suite_2.png","images//Nature_Reykjavik_Suitep_1.png",
			"images//Ours_Polaire_Reykjavik_Double.png","images//Traditionnel_Reykjavik_Simple.png","images//Viking_Reykjavik_Simple.png",
			"images//Volcan_Reykjavik_Double.png","images//Alcool_Reykjavik_Suite.png",

			"images//chambre_double_boheme_paris.png","images//chambre_simple_futuriste_paris.png","images//chambre_double_romantiqueparisien_paris.png",
			"images//suite_pres_louvres_paris.png","images//suite_monnet_paris.png","images//suite_dior_paris.png","images//chambre_simple_traditionnel_paris.png",
			"images//chambre_double_moderneparisien_paris.png","images//chambre_simple_royal_paris.png","images//chambre_simple_parisien_paris.png","images//suite_pres_traditionnelfrancais_paris.png",
			"images//chambre_double_moulinrouge_paris.png","images//chambre_simple_moderne_paris.png","images//suite_rococo_paris.png","images//chambre_double_cabinetdecuriosite_paris.png",
			"images//suite_pres_luxe_paris.png","images//chambre_simple_minimaliste_paris.png","images//suite_modernefuturiste_paris.png","images//suite_pres_elysee_paris.png",
			"images//chambre_double_luxe_paris.png",

			"images//d_1t.png","images//s_1t.png","images//s_2t.png","images//suP_3t.png","images//su_1t.png","images//s_3t.png","images//d_3t.png","images//d_2t.png","images//suP_1t.png","images//suP_2t.png","images//d_5t.png",
			"images//s_4t.png","images//d_4t.png","images//su_2t.png","images//s_5t.png","images//suP_4t.png","images//su_3t.png","images//d_6t.png","images//su_4t.png","images//s_6t.png",

			"images//Automne_Kyoto_Double.png", "images//Caligraphie_kyoto_Suite_2.png","images//CarpeKoi_Kyoto_Simple.png","images//Cyberpunk_Kyoto_Double.png",
			"images//Dragon_Kyoto_Simple.png","images//Futuriste_Kyoto_Simple.png","images//Ghibli_Kyoto_Simple.png","images//Hanabi_Kyoto_Suitep_4.png","images//Hanami_Kyoto_Suite_1.png",
			"images//Luxe_Kyoto_Suitep.png","images//Lycoris_Kyoto_Double.png","images//Minimalisme_Kyoto_Double.png","images//Moderne_Kyoto_Suitep_1.png","images//Mystique_Kyoto_Suite_1.png",
			"images//Ninja_Kyoto_Double.png","images//Pokemon_Kyoto_Double.png","images//Samurai_Kyoto_Suite_2.png","images//Sushi_Kyoto_Suitep_1.png","images//Tradition_printemps_Kyoto_Simple.png",
			"images//Traditionnelle_Kyoto_Simple.png"
		};

		
		String[] categories = {
			"Chambre simple","Chambre simple","Chambre double","Chambre simple","Chambre double","Suite","Suite","Chambre simple","Suite",
			"Suite présidentielle","Suite présidentielle","Chambre double","Chambre double","Chambre double","Chambre simple","Chambre double",
			"Chambre simple","Suite résidentielle","Suite","Suite présidentielle",
			
			"Chambre simple","Chambre double","Chambre double","Suite présidentielle","Chambre simple","Chambre double","Suite","Chambre simple",
			"Suite","Chambre double","Chambre double","Chambre simple","Suite présidentielle","Suite","Chambre simple","Suite présidentielle",
			"Suite présidentielle","Suite","Chambre double","Chambre simple",
			
			"Chambre simple","Suite","Chambre double","Suite","Chambre simple","Suite présidentielle","Chambre double","Chambre simple",
			"Suite présidentielle","Chambre simple","Suite présidentielle","Chambre double","Chambre double","Suite","Suite présidentielle",
			"Chambre double","Chambre simple","Chambre simple","Chambre double","Suite",
			
			"Chambre double","Chambre simple","Chambre double","Suite présidentielle","Suite","Suite","Chambre simple","Chambre double",
			"Chambre simple","Chambre simple","Suite présidentielle","Chambre double","Chambre simple","Suite","Chambre double","Suite présidentielle","Chambre simple",
			"Suite","Suite présidentielle","Chambre double",
			
			"Chambre double","Chambre simple","Chambre simple","Suite présidentielle","Suite","Chambre simple","Chambre double","Chambre double",
			"Suite présidentielle","Suite présidentielle","Chambre double","Chambre simple","Chambre double","Suite","Chambre simple","Suite présidentielle",
			"Suite","Chambre double","Suite","Chambre simple",
			
			"Chambre double","Suite","Chambre simple","Chambre double","Chambre simple","Chambre simple","Chambre simple","Suite présidentielle",
			"Suite","Suite présidentielle","Chambre double","Chambre double","Suite présidentielle","Suite","Chambre double","Chambre double","Suite",
			"Suite présidentielle","Chambre simple","Chambre simple"		
		};
		
		String[] themes_ch = {
			"sur le thème des barques","sur le thème cacao","coloré","chocolaté","sur le thème du football","sur le thème des fruits exotiques","sur le thème des îles","sur le thèmes des Xalam","koya","lac rose","sur le thèmes des lions","sur le thèmes des maisons sénégalaises","mosquée",
			"sur le thème des moustiquaires","sur le thème des océan","orangé","sur le thème du riz","sheraton","sur le thème des tresse","sur le thème du zoo",
			
			"Andalouse","Ocre","sur le thème du Atay","sur le thème des lions","sur le thème des babouches","berbère",
			"sur le thème des dattes","sur le thème des flouka","sur le thème du hammam","sur le thème du henné","Jemaa el-Fna","Minaret","Oasis de luxe",
			"sur le thème des oliviers","Zest","rêve oriental","riad moderne","sur le thème des épices","sur le thème du tajine","Sultane",
			
			"sur le thème des aurores boréales","sur le thème des baleines","basalte","sur le thème des cascades","futuriste","sur le thème de la glace",
			"sur le thème des glaciers","sur le thème des igloo","impérial","sur le thème des lagoon","de luxe","minimaliste","sur le thème des montagnes",
			"sur le thème marin","sur le thème des animaux","sur le thème des ours polaires","traditionnel","sur le thème des vikings","sur le thème des  volcans",
			"sur le thème elixirs",
			
			"bohème","futuriste","romantique","sur le thème du Louvres","sur le thème de Monnet","sur le thème de Dior","traditionnel",
			"moderne","royal","parisien","traditionnel","sur le thème du moulin rouge","moderne","rococo","sur le thème cabinet de curiosité","de luxe","minimaliste",
			"moderne/futuriste","sur le thème de l'élysée","de luxe",
			
			"traditionnel","traditionnel","sur le thème de Wan Makha Bucha","Royal","Traditionnel","sur le thème Wan Vaisakh Bucha","sur le thème des rues thailandaises","sur le thème des éléphants","sur le thème des orchidées","dorée à l'Or pur","sur le thème Makha Bucha",
			"sur le thème China town","sur le thème de Bo sang","sur le thème du festival des lumières","sur le thème des tigres","du nouvelle an Chinois","sur le thème de la pleine lune",
			"sur le thème de Phi Ta Khon","sur le thème de Lopburi","sur le thème de la fleur de lotus",
			
			"sur le thème de l'automne","sur le thème de la caligraphie japonaise","sur le thème de la carpekoi","sur le thème de Cyberpunk",
			"sur le thème des dragons","futuriste","sur le thème de Ghibli","sur le thèmes des hanabi","sur le thèmes des hanabi","de luxe",
			"sur le thème du Lycoris japonais","minimaliste","moderne","mystique","sur le thème des ninja","sur le thème de pokémon","sur le thème des samouraï",
			"sur le thème des sushis","printanière","traditionnelle"
		
		};
		String[] themes_fil = {
			"Aimer des touristes","Culture","Culture","Aimer des tourites","Aimer des touristes","Luxe","Aimer des touristes","Culture",
			"Luxe","Luxe","Moderne","Culture","Culture","Luxe","Culture","Moderne","Aimer des touristes","Luxe","Culture","Moderne",
			
			"Moderne","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Luxe","Culture","Luxe","Luxe","Culture",
			"Aimer par les touristes","Luxe","Luxe","Moderne","Luxe","Moderne","Moderne","Aimer des touristes",
			
			"Aimer des touristes","Aimer des touristes","Culture","Aimer des touristes","Moderne","Culture","Culture","Culture","Luxe",
			"Luxe","Luxe","Moderne","Culture","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Culture","Culture",
			
			"Aimer des touristes","moderne","Aimer des touristes","Culture","Culture","Culture","Culture","Moderne","Luxe","Culture",
			"Luxe","Culture","Moderne","Aimer des touristes","Aimer des touristes","Luxe","Moderne","Moderne","Luxe","Luxe",
			
			"Culture","Culture","Culture","Luxe","Culture","Aimer des touristes","Aimer des touristes","Culture","Aimer des touristes",
			"Luxe","Culture","Luxe","Culture","Moderne","Moderne","Culture","Culture","Moderne",
			
			"Culture","Culture","Culture","Aimer des touristes","Aimer des touristes","Moderne","Aimer des touristes","Culture","Luxe","Luxe",
			"Culture","Moderne","Moderne","Culture","Culture","Aimer des touristes","Culture","Aimer des touristes","Aimer des touristes","Culture"
		};
		
		ArrayList<Chambre> chambres_rech = new ArrayList<>();

		chambres_rech.addAll(chambres_senegal);
		chambres_rech.addAll(chambres_maroc);
		chambres_rech.addAll(chambres_islande);
		chambres_rech.addAll(chambres_paris);
		chambres_rech.addAll(chambres_thailande);
		chambres_rech.addAll(chambres_japon);
		Model_prc_Chambre mod_chambre_rech = new Model_prc_Chambre(chambres_rech,modele_ci);
		Vue_Resultats_Recherche vueResultat = new Vue_Resultats_Recherche("", nomFichiers, categories, themes_ch, themes_fil, mod_chambre_rech);
		

		vue_principale = new Vue_prcp(m_1,vueResultat);
		
		NavControlleur controlleur_connection_ci = new NavControlleur((Seconnecter) vue_ci, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_co_asie = new NavControlleur((Continent) Continent_Asie, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_co_afrique = new NavControlleur((Continent) Continent_Afrique, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_co_europe = new NavControlleur((Continent) Continent_Europe, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_jap = new NavControlleur((Vue_pays) v_j, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_thai = new NavControlleur((Vue_pays) v_t, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_fr = new NavControlleur((Vue_pays) v_f, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_isl = new NavControlleur((Vue_pays) v_i, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_ma = new NavControlleur((Vue_pays) v_m, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_sn = new NavControlleur((Vue_pays) v_s, (Seconnecter) vue_ci, vue_gestion_rs);

		NavControlleur controlleur_connection_pa_japh = new NavControlleur((Vue_hotel) hotel_jap, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_thaih = new NavControlleur((Vue_hotel) hotel_thai, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_frh = new NavControlleur((Vue_hotel) hotel_prs, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_islh = new NavControlleur((Vue_hotel) hotel_isl, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_mah = new NavControlleur((Vue_hotel) hotel_ma, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pa_snh = new NavControlleur((Vue_hotel) hotel_sn, (Seconnecter) vue_ci, vue_gestion_rs);

		NavControlleur controlleur_connection_esp = new NavControlleur((EnSavoirPlus) esp, (Seconnecter) vue_ci, vue_gestion_rs);
		NavControlleur controlleur_connection_pr = new NavControlleur((Vue_prcp) vue_principale, (Seconnecter) vue_ci, vue_gestion_rs);


		
		
		NavControlleur controlleur_europe_mi = new NavControlleur(Continent_Europe, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_afrique_mi = new NavControlleur(Continent_Afrique, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_asie_mi = new NavControlleur(Continent_Asie, Continent_Asie, Continent_Europe,Continent_Afrique);

		NavControlleur controlleur_vuejap = new NavControlleur(v_j, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuethai = new NavControlleur(v_t, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuefr = new NavControlleur(v_f, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vueisl = new NavControlleur(v_i, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuesn = new NavControlleur(v_s, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuema = new NavControlleur(v_m, Continent_Asie, Continent_Europe,Continent_Afrique);

		NavControlleur controlleur_vuejap_h = new NavControlleur(hotel_jap, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuethai_h = new NavControlleur(hotel_thai, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuefr_h = new NavControlleur(hotel_prs, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vueisl_h = new NavControlleur(hotel_isl, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuesn_h = new NavControlleur(hotel_sn, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuema_h = new NavControlleur(hotel_ma, Continent_Asie, Continent_Europe,Continent_Afrique);

		NavControlleur controlleur_vueco_ci = new NavControlleur(vue_ci, Continent_Asie, Continent_Europe,Continent_Afrique);

		NavControlleur controlleur_vueesp_co = new NavControlleur(esp, Continent_Asie, Continent_Europe,Continent_Afrique);

		NavControlleur controlleur_vuepr_co = new NavControlleur(vue_principale, Continent_Asie, Continent_Europe,Continent_Afrique);
		

		NavControlleur controlleur_europe_sav = new NavControlleur(Continent_Europe, esp);
		NavControlleur controlleur_afrique_sav = new NavControlleur(Continent_Afrique, esp);
		NavControlleur controlleur_asie_sav = new NavControlleur(Continent_Asie, esp);

		NavControlleur controlleur_vuejapsav = new NavControlleur(v_j, esp);
		NavControlleur controlleur_vuethaisav = new NavControlleur(v_t, esp);
		NavControlleur controlleur_vuefrsav = new NavControlleur(v_f, esp);
		NavControlleur controlleur_vueislsav = new NavControlleur(v_i, esp);
		NavControlleur controlleur_vuesnsav = new NavControlleur(v_s, esp);
		NavControlleur controlleur_vuemasav = new NavControlleur(v_m, esp);	

		NavControlleur controlleur_vuejap_hsav = new NavControlleur(hotel_jap, esp);
		NavControlleur controlleur_vuethai_hsav = new NavControlleur(hotel_thai, esp);
		NavControlleur controlleur_vuefr_hsav = new NavControlleur(hotel_prs, esp);
		NavControlleur controlleur_vueisl_hsav = new NavControlleur(hotel_isl, esp);
		NavControlleur controlleur_vuesn_hsav = new NavControlleur(hotel_sn, esp);
		NavControlleur controlleur_vuema_hsav = new NavControlleur(hotel_ma, esp);

		NavControlleur controlleur_vueco_cisav = new NavControlleur(vue_ci, esp);

		NavControlleur controlleur_vuesav_esp = new NavControlleur(esp, esp); 

		NavControlleur controlleur_vuesav_pr = new NavControlleur(vue_principale, esp); 


		NavControlleur controlleur_vuejap_prcp = new NavControlleur(v_j,vue_principale);
		NavControlleur controlleur_vuethai_prcp = new NavControlleur(v_t,vue_principale);
		NavControlleur controlleur_vuesn_prcp = new NavControlleur(v_s,vue_principale);
		NavControlleur controlleur_vuema_prcp = new NavControlleur(v_m,vue_principale);
		NavControlleur controlleur_vuefr_prcp = new NavControlleur(v_f,vue_principale);
		NavControlleur controlleur_vueisl_prcp = new NavControlleur(v_i,vue_principale);

		NavControlleur controlleur_vuehjap_prcp = new NavControlleur(hotel_jap, vue_principale);
		NavControlleur controlleur_vuehthai_prcp = new NavControlleur(hotel_thai, vue_principale);
		NavControlleur controlleur_vuehfr_prcp = new NavControlleur(hotel_prs, vue_principale);
		NavControlleur controlleur_vuehisl_prcp = new NavControlleur(hotel_isl, vue_principale);
		NavControlleur controlleur_vuehsn_prcp = new NavControlleur(hotel_sn, vue_principale);
		NavControlleur controlleur_vuehjma_prcp = new NavControlleur(hotel_ma, vue_principale);

		NavControlleur controlleurcontinent_prcp_e = new NavControlleur(Continent_Europe,vue_principale);
		NavControlleur controlleurcontinent_prcp_af = new NavControlleur(Continent_Afrique,vue_principale);
		NavControlleur controlleurcontinent_prcp_a = new NavControlleur(Continent_Asie,vue_principale);

		NavControlleur controlleurcontinent_prcp_ci = new NavControlleur(vue_ci,vue_principale);

		NavControlleur controlleur_vueesp_prcp = new NavControlleur(esp, vue_principale);

		NavControlleur controlleur_vuepr_prcp = new NavControlleur(vue_principale, vue_principale);

		NavControlleur controlleur_vuerech_prcp = new NavControlleur(vueResultat, vue_principale);
		NavControlleur controlleur_vuegest_prcp = new NavControlleur (vue_gestion_rs,vue_principale);
		
		vue_principale.setVisible(true);
		esp.pack();
		vue_ci.pack();
		vue_principale.pack();
		Continent_Asie.pack();
		Continent_Afrique.pack();
		Continent_Europe.pack();
		v_f.pack();
		v_i.pack();
		v_j.pack();
		v_m.pack();
		v_s.pack();
		v_t.pack();
		hotel_jap.pack();
		hotel_thai.pack();
		hotel_prs.pack();
		hotel_isl.pack();
		hotel_sn.pack();
		hotel_ma.pack();
	}
	public static void lancerReservationDepuisVueChambre() {
		LocalDate currentDate = LocalDate.now();
		LocalDate currentDate_js = currentDate.plusDays(1);
		int jour = currentDate_js.getDayOfMonth();
		String mois = currentDate_js.getMonth().name().toLowerCase();
		int annee = currentDate_js.getYear();
		LocalDate dateDep = currentDate_js.plusDays(1);
		int jourDep = dateDep.getDayOfMonth();
		String moisDep = dateDep.getMonth().name().toLowerCase();
		int anneeDep = dateDep.getYear();
		Date setupDate = new Date(jour, 6, annee, 17, 00);
		Date ajd = new Date(jour, setupDate.getIntMonth_english(mois), annee, 17, 00);
		
		if (AppContext.vueChambre != null && AppContext.vueChambre.isReady()) {
			Reservation rsrv1 = new Reservation(
				AppContext.vueChambre.getArrivee(),
				AppContext.vueChambre.getDepart(),
				AppContext.vueChambre.getClient(),
				AppContext.vueChambre.getHotel(),
				cha_r,
				2
			);
			
			Vue_rsrv v_rsrv_client = new Vue_rsrv(rsrv1);
	
			Dimension t_ecran = Toolkit.getDefaultToolkit().getScreenSize();
			v_rsrv_client.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)(t_ecran.getHeight() * 0.95)));
			v_rsrv_client.pack();
			vue_gestion_rs.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)(t_ecran.getHeight() * 0.95)));
			vue_gestion_rs.pack();

			Model_transition model = new Model_transition();
			Controleur_transition control_trans = new Controleur_transition(AppContext.vueChambre.v_tr, v_rsrv_client);
			AppContext.vueChambre.v_tr.setControlleur(control_trans);
			Controleur_transition control_dates_trans = new Controleur_transition(AppContext.vueChambre.v_tr, AppContext.vueChambre.v_date);
			AppContext.vueChambre.v_tr.setControlleurDates(control_dates_trans);
			model.getDate(control_dates_trans, AppContext.vueChambre.v_date);

			Controleur_transition control_gest = new Controleur_transition(v_rsrv_client, vue_gestion_rs, vue_gestion_rs.getRsrv(), vue_gestion_rs.getSej());

		} else {
			System.out.println("La vue chambre n'est pas encore prête. Aucune réservation créée.");
		}
	}
}