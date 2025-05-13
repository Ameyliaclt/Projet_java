import java.awt.*;
import java.util.stream.Stream;

public class Main_prjt{
	public static void main(String[]args){
		Model_prjt m_1 = new Model_prjt ("RoomBloom");	
		
		//Se connecter/s'inscrire 
		Model_connectinscr modele_ci = new Model_connectinscr();
		SessionUtil.setModel(modele_ci);
		Seconnecter vue_ci = new Seconnecter(modele_ci);
		ControleurConnexionInscription Controlleur_ci = new ControleurConnexionInscription(modele_ci, vue_ci);
		
		//vue hotel 
		//hotel japon
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
    
		Hotel hotel_japon = new Hotel("Japon", "Kyoto", "Tatsumicho, Higashiyama Ward, Kyoto, 605-0862, Japon", "Atarashii Kyoto", "+81 75-551-4321", "atarashiiKyoto@hotel.com", lieu_ky);
		String[] chambre_jap = {"Automne_Kyoto_Double.png", "Caligraphie_kyoto_Suite_2.png","CarpeKoi_Kyoto_Simple.png","Cyberpunk_Kyoto_Double.png","Dragon_Kyoto_Simple.png","Futuriste_Kyoto_Simple.png","Ghibli_Kyoto_Simple.png","Hanabi_Kyoto_Suitep_4.png","Hanami_Kyoto_Suite_1.png","Luxe_Kyoto_Suitep.png","Lycoris_Kyoto_Double.png","Minimalisme_Kyoto_Double.png","Moderne_Kyoto_Suitep_1.png","Mystique_Kyoto_Suite_1.png","Ninja_Kyoto_Double.png","Pokemon_Kyoto_Double.png","Samurai_Kyoto_Suite_2.png","Sushi_Kyoto_Suitep_1.png","Tradition_printemps_Kyoto_Simple.png","Traditionnelle_Kyoto_Simple.png"};
		String[] type_chambre_jap ={"Chambre double","Suite","Chambre simple","Chambre double","Chambre Simple","Chambre simple","Chambre simple","Suite présidentielle","Suite","Suite présidentielle","Chambre double","Chambre double","Suite présidentielle","Suite","Chambre double","Chambre double","Suite","Suite présidentielle","Chambre simple","Chambre simple"};
		String[] theme_chambre_jap ={"sur le thème de l'automne","sur le thème de la caligraphie japonaise","sur le thème de la carpekoi","sur le thème de Cyberpunk","sur le thème des dragons","futuriste","sur le thème de Ghibli","sur le thèmes des hanabi","sur le thèmes des hanabi","de luxe","sur le thème du Lycoris japonais","minimaliste","moderne","mystique","sur le thème des ninja","sur le thème de pokémon","sur le thème des samouraï","sur le thème des sushis","printanière","traditionnelle"};
		String[] theme_filtre_jap ={"Culture","Culture","Culture","Aimer des touristes","Aimer des touristes","Moderne","Aimer des touristes","Culture","Luxe","Luxe","Culture","Moderne","Moderne","Culture","Culture","Aimer des touristes","Culture","Aimer des touristes","Aimer des touristes","Culture"};
		Hotel_model japon = new Hotel_model("images//photo_entete_jap.png",chambre_jap,type_chambre_jap,theme_chambre_jap,new Color(255,236,253),theme_filtre_jap);
		Vue_hotel hotel_jap = new Vue_hotel(hotel_japon,japon);
		
		//hotel thailande
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
		
		Hotel hotel_thailande = new Hotel("Thailande","Bangkok", "PFWR+C85, Maha Rat Rd, Phra Borom Maha Ratchawang, Phra Nakhon, Bangkok 10200, Thaïlande","Wat Pho Hotel","+66 89 057 7100","watpho_hotel@hotel.com",lieux_ba);
		String[] chambre_thai ={"d_1t.png","s_1t.png","s_2t.png","suP_3t.png","su_1t.png","s_3t.png","d_3t.png","d_2t.png","suP_1t.png","suP_2t.png","d_5t.png","s_4t.png","d_4t.png","su_2t.png","s_5t.png","suP_4t.png","su_3t.png","d_6t.png","su_4t.png","s_6t.png"};
		String[] type_chambre_thai = {"Chambre double","Chambre simple","Chambre simple","Suite présidentielle","Suite","Chambre simple","Chambre double","Chambre double","Suite présidentielle","Suite présidentielle","Chambre double","Chambre simple","Chambre double","Suite","Chambre simple","Suite présidentielle","Suite","Chambre double","Suite","Chambre simple"};
		String[] theme_chambre_thai = {"traditionnel","traditionnel","sur le thème de Wan Makha Bucha","Royal","Traditionnel","sur le thème Wan Vaisakh Bucha","sur le thème des rues thailandaises","sur le thème des éléphants","sur le thème des orchidées","dorée à l'Or pur","sur le thème Makha Bucha","sur le thème China town","sur le thème de Bo sang","sur le thème du festival des lumières","sur le thème des tigres","du nouvelle an Chinois","sur le thème de la pleine lune","sur le thème de Phi Ta Khon","sur le thème de Lopburi","sur le thème de la fleur de lotus"};
		String[] theme_filtre_thai = {"Culture","Culture","Culture","Luxe","Culture","Aimer des touristes","Aimer des touristes","Culture","Aimer des touristes","Luxe","Culture","Luxe","Culture","Moderne","Moderne","Culture","Culture","Moderne"};
		Hotel_model thailande = new Hotel_model("images//photo_entete_thai.png",chambre_thai,type_chambre_thai,theme_chambre_thai,new Color(200,173,127),theme_filtre_thai);
		Vue_hotel hotel_thai = new Vue_hotel(hotel_thailande, thailande);
		
		//hotel France 
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
		
		Hotel hotel_france = new Hotel("France", "Paris","127 Av. des Champs-Élysées, 75008 Paris","Elégance","0145678926","elegance_paris@hotel.fr",lieu_pa); 
		String[] chambre_paris = {"chambre_double_boheme_paris.png","chambre_simple_futuriste_paris.png","chambre_double_romantiqueparisien_paris.png","suite_pres_louvres_paris.png","suite_monnet_paris.png","suite_dior_paris.png","chambre_simple_traditionnel_paris.png","chambre_double_moderneparisien_paris.png","chambre_simple_royal_paris.png","chambre_simple_parisien_paris.png","suite_pres_traditionnelfrancais_paris.png","chambre_double_moulinrouge_paris.png","chambre_simple_moderne_paris.png","suite_rococo_paris.png","chambre_double_cabinetdecuriosite_paris.png","suite_pres_luxe_paris.png","chambre_simple_minimaliste_paris.png","suite_modernefuturiste_paris.png","suite_pres_elysee_paris.png","chambre_double_luxe_paris.png"};
		String[] type_chambre_paris = {"Chambre double","Chambre simple","Chambre double","Suite présidentielle","Suite","Suite","Chambre simple","Chambre double","Chambre simple","Chambre simple","Suite présidentielle","Chambre double","Chambre simple","Suite","Chambre double","Suite présidentielle","Chambre simple","Suite","Suite présidentielle","Chambre double"};
		String[] theme_chambre_paris = {"bohème","futuriste","romantique","sur le thème du Louvres","sur le thème de Monnet","sur le thème de Dior","traditionnel","moderne","royal","parisien","traditionnel","sur le thème du moulin rouge","moderne","rococo","sur le thème cabinet de curiosité","de luxe","minimaliste","moderne/futuriste","sur le thème de l'élysée","de luxe"};
		String[] theme_filtre_paris = {"Aimer des touristes","moderne","Aimer des touristes","Culture","Culture","Culture","Culture","Moderne","Luxe","Culture","Luxe","Culture","Moderne","Aimer des touristes","Aimer des touristes","Luxe","Moderne","Moderne","Luxe","Luxe"};
		Hotel_model paris = new Hotel_model("images//photo_entete_paris.png",chambre_paris,type_chambre_paris,theme_chambre_paris,new Color(239,231,219),theme_filtre_paris);
		Vue_hotel hotel_prs = new Vue_hotel(hotel_france,paris);
		
		//hotel islande
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
		
		Hotel hotel_islande = new Hotel("Islande", "Reykjavik", "Nautholsvégur 83, Reykjavik, Islande", "Fagun Reykjavik", "+354 710 9648", "fagunReykjavik@hotel.com", lieux_re);
		String[] chambre_isl = {"Aurore_Reykjavik_Simple.png","Baleine_Reykjavik_Suite_1.png","Basalte_Reykjavik_Double.png","Cascade_Reykjavik_Suite_1.png","Futuriste_Reykjavik_Simple.png","Glace_futur_Reykjavik_Suitep.png","Glaciers_Reykjavik_Double.png","Igloo_Reykjavik_Simple.png","Imperial_Reykjavik_Suitep.png","Lagoon_Reykjavik_Simple.png","Luxe_Reykjavik_Suitep.png","Minimaliste_Reykjavik_Double.png","Montagnes_Reykjavik_Double.png","Marin_Reykjavik_Suite_2.png","Nature_Reykjavik_Suitep_1.png","Ours_Polaire_Reykjavik_Double.png","Traditionnel_Reykjavik_Simple.png","Viking_Reykjavik_Simple.png","Volcan_Reykjavik_Double.png","Alcool_Reykjavik_Suite.png"};
		String[] type_chambre_isl = {"Chambre simple","Suite","Chambre double","Suite","Chambre simple","Suite présidentielle","Chambre double","Chambre simple","Suite présidentielle","Chambre simple","Suite présidentielle","Chambre double","Chambre double","Suite","Suite présidentielle","Chambre double","Chambre simple","Chambre simple","Chambre double","Suite"};
		String[] theme_chambre_isl = {"sur le thème des aurores boréales","sur le thème des baleines","basalte","sur le thème des cascades","futuriste","sur le thème de la glace","sur le thème des glaciers","sur le thème des igloo","impérial","sur le thème des lagoon","de luxe","minimaliste","sur le thème des montagnes","sur le thème marin","sur le thème des animaux","sur le thème des ours polaires","traditionnel","sur le thème des vikings","sur le thème des  volcans","sur le thème elixirs"};
		String[] theme_filtre_isl = {"Aimer des touristes","Aimer des touristes","Culture","Aimer des touristes","Moderne","Culture","Culture","Culture","Luxe","Luxe","Luxe","Moderne","Culture","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Culture","Culture"};
		Hotel_model islande = new Hotel_model("images//photo_entete_islande.png",chambre_isl,type_chambre_isl,theme_chambre_isl,new Color(119, 136, 153),theme_filtre_isl);
		Vue_hotel hotel_isl = new Vue_hotel(hotel_islande,islande);

		//hotel maroc 
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
		
		Hotel hotel_maroc = new Hotel("Maroc", "Marrakech", "Place Jemaa El Fna, Marrakech 40 000, Maroc", "Marrakech Palace", "+212 524 33 44 33", "marrakech_palace@hotel.com", lieux_ma);
		String[] chambre_ma = {"arabe_cham_s.png","argile_cham_d.png","atay_cham_d.png","AtlasMajestueux_suite_p1.png","babouche_cham_s.png","couscous_cham_d.png","datte_suite_n.png","flouka_cham_s.png","hamam_suite_n.png","henna_cham_d.png","jame3lefna_cham_d.png","mosquee_cham_s.png","OasisDeLuxe_suite_p1.png","olivier_suite_n.png","or_cham_s.png","reveOriental_suite_p1.png","riadModerne_suite_p1.png","souk_suite_n.png","tajine_cham_d.png","tborida_cham_s.png"};
		String[] type_chambre_ma ={"Chambre simple","Chambre double","Chambre double","Suite présidentielle","Chambre simple","Chambre double","Suite","Chambre simple","Suite","Chambre double","Chambre double","Chambre simple","Suite présidentielle","Suite","Chambre simple","Suite présidentielle","Suite présidentielle","Suite","Chambre double","Chambre simple"};
		String[] theme_chambre_ma = {"Andalouse","Ocre","sur le thème du Atay","sur le thème des lions","sur le thème des babouches","berbère","sur le thème des dattes","sur le thème des flouka","sur le thème du hammam","sur le thème du henné","Jemaa el-Fna","Minaret","Oasis de luxe","sur le thème des oliviers","Zest","rêve oriental","riad moderne","sur le thème des épices","sur le thème du tajine","Sultane"};
		String[] theme_filtre_ma = {"Moderne","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Luxe","Culture","Luxe","Luxe","Culture","Aimer par les touristes","Luxe","Luxe","Moderne","Luxe","Moderne","Moderne","Aimer des touristes"};
		Hotel_model maroc = new Hotel_model("images//photo_entete_ma.png",chambre_ma,type_chambre_ma,theme_chambre_ma,new Color(240, 230, 210),theme_filtre_ma);
		Vue_hotel hotel_ma = new Vue_hotel(hotel_maroc,maroc);
		
		//hotel sénégal 
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
		
		Hotel hotel_senegal = new Hotel("Sénégal", "Dakar", "Bp 8, Somone, Sénégal", "Royal Horizon Baobab", "+221 33 939 71 71", "", lieux_sn);
		String[] chambre_sn = {"barque_cham_s.png","cacao_cham_s.png","couleurs_cham_d.png","chocolat_cham_s.png","foot_cham_d.png","fruitexotic_suite_n.png","ile_suite_n.png","instrumentXalam_cham_s.png","koya_suite_n.png","LacRose_suite_p1.png","lion_suite_p1.png","maison_senegalaise_cham_d.png","mosquee_s_cham_d.png","moustiquaire_cham_d.png","ocean_cham_s.png","orange_s_cham_d.png","riz_cham_s.png","sheraton_suite_p1.png","tresse_suite_n.png","zoo_suite_p1.png"};
		String[] type_chambre_sn = {"Chambre simple","Chambre simple","Chambre double","Chambre simple","Chambre double","Suite","Suite","Chambre simple","Suite","Suite présidentielle","Suite présidentielle","Chambre double","Chambre double","Chambre double","Chambre simple","Chambre double","Chambre simple","Suite présidentielle","Suite","Suite présidentielle"};
		String[] theme_chambre_sn = {"sur le thème des barques","sur le thème cacao","coloré","chocolaté","sur le thème du football","sur le thème des fruits exotiques","sur le thème des îles","sur le thèmes des Xalam","koya","lac rose","sur le thèmes des lions","sur le thèmes des maisons sénégalaises","mosquée","sur le thème des moustiquaires","sur le thème des océan","orangé","sur le thème du riz","sheraton","sur le thème des tresse","sur le thème du zoo"};
		String[] theme_filtre_sn = {"Aimer des touristes","Culture","Culture","Aimer des tourites","Aimer des touristes","Luxe","Aimer des touristes","Culture","Luxe","Luxe","Moderne","Culture","Culture","Luxe","Culture","Moderne","Aimer des touristes","Luxe","Culture","Moderne"};
		Hotel_model senegal = new Hotel_model("images//photo_entete_sn.png",chambre_sn,type_chambre_sn,theme_chambre_sn,new Color(144, 164, 96),theme_filtre_sn);
		Vue_hotel hotel_sn = new Vue_hotel(hotel_senegal,senegal);
		
		//page Pays
		Pays jap = new Pays("images//Fond_japon.jpg", "images//Sakura_back.png", "images//Hotel_Kyoto_3.jpg", Color.PINK, new Color(244,204,231), new Color(232,100,134));
		Pays isl = new Pays("images//Fond_islande.png", "images//Glacon_fond.png", "images//Hotel_Reykjavik.png", new Color(190,243,220), new Color(152,194,225), Color.WHITE);
		Pays fr = new Pays("images//Fond_france.png", "images//Fond_lys.png", "images//hotel_paris.png", new Color(105,181,238), new Color(180,235,126), Color.WHITE);
		Pays ma = new Pays("images//Fond_maroc.png", "images//Fond_tajine.png", "images//hotel_maroc.png", new Color(169,121,217), new Color(111,180,241), Color.WHITE);
		Pays thai = new Pays("images//Fond_thailande.png", "images//Fond_lanternes.png", "images//hotel_piscine_thai.jpg", new Color(162,240,233), new Color(249,222,142), Color.WHITE);
		Pays sn = new Pays("images//Fond_senegal.png", "images//Fond_baobab.png", "images//hotel_senegal.png", new Color(215,107,100), new Color(215,107,100), Color.WHITE);

		//Création des vues.
		Vue_pays v_j = new Vue_pays(hotel_japon, jap);
		NavControlleur controlleur_jap = new NavControlleur(v_j, hotel_jap);
        v_j.setControlleur(controlleur_jap);
		
		Vue_pays v_i = new Vue_pays(hotel_islande, isl);
		NavControlleur controlleur_isl = new NavControlleur(v_i, hotel_isl);
        v_i.setControlleur(controlleur_isl);
		
		Vue_pays v_f = new Vue_pays(hotel_france, fr);
		NavControlleur controlleur_fr = new NavControlleur(v_f, hotel_prs);
        v_f.setControlleur(controlleur_fr);
		
		Vue_pays v_m = new Vue_pays(hotel_maroc, ma);
		NavControlleur controlleur_ma = new NavControlleur(v_m, hotel_ma);
        v_m.setControlleur(controlleur_ma);
		
		Vue_pays v_t = new Vue_pays(hotel_thailande, thai);
		NavControlleur controlleur_thai = new NavControlleur(v_t, hotel_thai);
        v_t.setControlleur(controlleur_thai);
		
		Vue_pays v_s = new Vue_pays(hotel_senegal, sn);
		NavControlleur controlleur_sn = new NavControlleur(v_s, hotel_sn);
        v_s.setControlleur(controlleur_sn);

		
		//vue continent
		String[] pays_asie = {"japon.png","thailande.png"};
		String[] nom_asie = {"Japon","Thailande"};
		Continent_model asie_ct = new Continent_model(pays_asie,"asie.png",nom_asie,"Voyagez en Asie");
		Continent Continent_Asie = new Continent(m_1,asie_ct);
		NavControlleur controlleur_asie = new NavControlleur(Continent_Asie, v_j, v_t);
		
		String[] pays_afrique = {"maroc.png","senegal.png"};
		String[] nom_afrique = {"Maroc","Sénégal"};
		Continent_model afrique_ct = new Continent_model(pays_afrique,"afrique.png",nom_afrique,"Voyagez en Afrique");
		Continent Continent_Afrique = new Continent(m_1, afrique_ct);
		NavControlleur controlleur_afrique = new NavControlleur(Continent_Afrique, v_m, v_s);
		
		String[] pays_europe = {"france.png","islande.png"};
		String[] nom_europe = {"France","Islande"};
		Continent_model europe_ct = new Continent_model(pays_europe,"europe1.png",nom_europe,"Voyagez en Europe");
		Continent Continent_Europe = new Continent(m_1,europe_ct);
		NavControlleur controlleur_europe = new NavControlleur(Continent_Europe, v_f, v_i);
		
		//selections
		String[] Chambre_simple = {"riz_cham_s.png", "chocolat_cham_s.png", "barque_cham_s.png", "ocean_cham_s.png", "instrumentXalam_cham_s.png", "cacao_cham_s.png",
		"tborida_cham_s.png", "flouka_cham_s.png", "or_cham_s.png", "babouche_cham_s.png", "arabe_cham_s.png", "mosquee_cham_s.png",
		"chambre_simple_parisien_paris.png", "chambre_simple_traditionnel_paris.png", "chambre_simple_moderne_paris.png", "chambre_simple_royal_paris.png", "chambre_simple_futuriste_paris.png", "chambre_simple_minimaliste_paris.png",
		"s_1t.png", "s_2t.png", "s_3t.png", "s_4t.png","s_5t.png", "s_6t.png", 
		"Tradition_printemps_Kyoto_Simple.png", "CarpeKoi_Kyoto_Simple.png", "Dragon_Kyoto_Simple.png", "Ghibli_Kyoto_Simple.png", "Traditionnelle_Kyoto_Simple.png", "Futuriste_Kyoto_Simple.png",
		"Aurore_Reykjavik_Simple.png", "Lagoon_Reykjavik_Simple.png", "Viking_Reykjavik_Simple.png", "Traditionnel_Reykjavik_Simple.png", "Igloo_Reykjavik_Simple.png", "Futuriste_Reykjavik_Simple.png"};
		String[] types_chambre_s = {"Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", 
		"Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple","Chambre Simple",
		"Chambre Simple","Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple",
		"Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple",
		"Chambre Simple","Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple",
		"Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple", "Chambre Simple"};
		String[] theme_chambre_s = {"Riz", "Chocolat", "Barque", "Océan", "Instrument xalam", "Cacao",  
		"Sultane", "Flouka", "Zest", "Babouche", "Andalouse", "Minaret",
		"Parisien", "Traditionel", "Moderne", "Royal", "Futuriste", "Minimaliste",
		"Traditionnel", "Wan Makha Bucha", "Wan Vaisakh Bucha", "China Town", "Tiger", "Lotus",
		"Traditionnel printannier", "Carpe Koi", "Dragon", "Ghibli", "Traditionnelle", "Futuriste", 
		"Aurore", "Lagoon", "Viking", "Traditionnelle", "Igloo", "Futuriste"};
		String[] Chambre_double = {"moustiquaire_cham_d.png", "couleurs_cham_d.png", "maison_senegalaise_cham_d.png", "mosquee_s_cham_d.png", "orange_s_cham_d.png", "foot_cham_d.png",
		"henna_cham_d.png", "jame3lefna_cham_d.png", "tajine_cham_d.png", "argile_cham_d.png", "couscous_cham_d.png", "atay_cham_d.png",
		"chambre_double_romantiqueparisien_paris.png", "chambre_double_luxe_paris.png", "chambre_double_boheme_paris.png", "chambre_double_moderneparisien_paris.png", "chambre_double_moulinrouge_paris.png", "chambre_double_cabinetdecuriosite_paris.png",
		"d_1t.png", "d_2t.png", "d_3t.png","d_4t.png", "d_5t.png", "d_6t.png",
		"Pokemon_Kyoto_Double.png", "Cyberpunk_Kyoto_Double.png", "Minimalisme_Kyoto_Double.png", "Ninja_Kyoto_Double.png", "Lycoris_Kyoto_Double.png", "Automne_Kyoto_Double.png",
		"Glaciers_Reykjavik_Double.png", "Volcan_Reykjavik_Double.png", "Montagnes_Reykjavik_Double.png", "Ours_Polaire_Reykjavik_Double.png", "Minimaliste_Reykjavik_Double.png", "Basalte_Reykjavik_Double.png"};
		String[] types_chambre_d = {"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",
		"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",
		"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",
		"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",
		"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double",
		"Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double", "Chambre Double"};
		String[] theme_chambre_d ={"Moustiquaire","Couleurs", "Maison sénégalaise", "Mosquée", "Orange", "Foot",
		"Henné", "Jemaa el-Fna", "Tajine", "Argile", "Berbère", "Atay",
		"romantique & parisien", "Luxe", "Bohème", "Moderne & parisien", "Moulin Rouge", "Cabinet de curiosité",  
		"Traditionnel", "Elephant", "Street", "Bo sang", "Makha Bucha", "Phi Ta Khon",  
		"Pokemon", "Cyberpunk", "Minimaliste", "Ninja", "Lycoris", "Automne",  
		"Glaciers", "Volcan", "Montagnes", "Ours polaire", "Minimaliste", "Basalte"};
		String[] Suite_pres = {"LacRose_suite_p1.png", "zoo_suite_p1.png", "lion_suite_p1.png", "sheraton_suite_p1.png",
		"reveOriental_suite_p1.png","OasisDeLuxe_suite_p1.png","riadModerne_suite_p1.png","AtlasMajestueux_suite_p1.png",
		"suite_pres_louvres_paris.png","suite_pres_luxe_paris.png","suite_pres_traditionnelfrancais_paris.png", "suite_pres_elysee_paris.png",
		"suP_1t.png", "suP_2t.png","suP_3t.png","suP_4t.png",
		"Luxe_Kyoto_Suitep.png","Sushi_Kyoto_Suitep_1.png","Moderne_Kyoto_Suitep_1.png","Hanabi_Kyoto_Suitep_4.png", 
		"Luxe_Reykjavik_Suitep.png", "Imperial_Reykjavik_Suitep.png", "Glace_futur_Reykjavik_Suitep.png", "Nature_Reykjavik_Suitep_1.png"};
		String[] types_suite = { "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",
		"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",
		"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",
		"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",
		"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle",
		"Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle", "Suite Présidentielle","Suite Présidentielle", "Suite Présidentielle"};
		String [] theme_suite = {"Lac Rose", "Zoo", "Lion", "Sheraton",
		"Rêve Oriental", "Oasis de Luxe", "Riad Moderne", "Atlas Majestueux",
		"Louvres", "Luxe", "Traditionnel Français", "Elysée",  
		"Orchidée", "Or", "Royal", "Nouvelle an Chinois",  
		"Luxe", "Sushi", "Moderne", "Hanabi",  
		"Luxe", "Impérial", "Glace", "Nature"};
		Nos_selections_fa selection_famille = new Nos_selections_fa("Nos chambres familliales",Chambre_double,types_chambre_d,theme_chambre_d);
		Nos_selections_fa selection_solo = new Nos_selections_fa("Nos chambres solos",Chambre_simple,types_chambre_s,theme_chambre_s);
		Nos_selections_fa selection_luxe = new Nos_selections_fa("Nos Suites luxueuses",Suite_pres,types_suite,theme_suite);
		
		//page en savoir plus
		EnSavoirPlus esp = new EnSavoirPlus(m_1);
		
		//page de recherche prcp
        String[] nomsFichiers = {"Automne_Kyoto_Double.png", "Caligraphie_kyoto_Suite_2.png","CarpeKoi_Kyoto_Simple.png","Cyberpunk_Kyoto_Double.png","Dragon_Kyoto_Simple.png",
		"Futuriste_Kyoto_Simple.png","Ghibli_Kyoto_Simple.png","Hanabi_Kyoto_Suitep_4.png","Hanami_Kyoto_Suite_1.png","Luxe_Kyoto_Suitep.png","Lycoris_Kyoto_Double.png",
		"Minimalisme_Kyoto_Double.png","Moderne_Kyoto_Suitep_1.png","Mystique_Kyoto_Suite_1.png","Ninja_Kyoto_Double.png","Pokemon_Kyoto_Double.png","Samurai_Kyoto_Suite_2.png",
		"Sushi_Kyoto_Suitep_1.png","Tradition_printemps_Kyoto_Simple.png","Traditionnelle_Kyoto_Simple.png","d_1t.png","s_1t.png","s_2t.png","suP_3t.png","su_1t.png","s_3t.png",
		"d_3t.png","d_2t.png","suP_1t.png","suP_2t.png","d_5t.png","s_4t.png","d_4t.png","su_2t.png","s_5t.png","suP_4t.png","su_3t.png","d_6t.png","su_4t.png","s_6t.png",
		"chambre_double_boheme_paris.png","chambre_simple_futuriste_paris.png","chambre_double_romantiqueparisien_paris.png","suite_pres_louvres_paris.png","suite_monnet_paris.png",
		"suite_dior_paris.png","chambre_simple_traditionnel_paris.png","chambre_double_moderneparisien_paris.png","chambre_simple_royal_paris.png","chambre_simple_parisien_paris.png",
		"suite_pres_traditionnelfrancais_paris.png","chambre_double_moulinrouge_paris.png","chambre_simple_moderne_paris.png","suite_rococo_paris.png","chambre_double_cabinetdecuriosite_paris.png",
		"suite_pres_luxe_paris.png","chambre_simple_minimaliste_paris.png","suite_modernefuturiste_paris.png","suite_pres_elysee_paris.png","chambre_double_luxe_paris.png","Aurore_Reykjavik_Simple.png",
		"Baleine_Reykjavik_Suite_1.png","Basalte_Reykjavik_Double.png","Cascade_Reykjavik_Suite_1.png","Futuriste_Reykjavik_Simple.png","Glace_futur_Reykjavik_Suitep.png","Glaciers_Reykjavik_Double.png",
		"Igloo_Reykjavik_Simple.png","Imperial_Reykjavik_Suitep.png","Lagoon_Reykjavik_Simple.png","Luxe_Reykjavik_Suitep.png","Minimaliste_Reykjavik_Double.png","Montagnes_Reykjavik_Double.png",
		"Marin_Reykjavik_Suite_2.png","Nature_Reykjavik_Suitep_1.png","Ours_Polaire_Reykjavik_Double.png","Traditionnel_Reykjavik_Simple.png","Viking_Reykjavik_Simple.png","Volcan_Reykjavik_Double.png",
		"Alcool_Reykjavik_Suite.png","arabe_cham_s.png","argile_cham_d.png","atay_cham_d.png","AtlasMajestueux_suite_p1.png","babouche_cham_s.png","couscous_cham_d.png","datte_suite_n.png","flouka_cham_s.png",
		"hamam_suite_n.png","henna_cham_d.png","jame3lefna_cham_d.png","mosquee_cham_s.png","OasisDeLuxe_suite_p1.png","olivier_suite_n.png","or_cham_s.png","reveOriental_suite_p1.png","riadModerne_suite_p1.png",
		"souk_suite_n.png","tajine_cham_d.png","tborida_cham_s.png","barque_cham_s.png","cacao_cham_s.png","couleurs_cham_d.png","chocolat_cham_s.png","foot_cham_d.png","fruitexotic_suite_n.png","ile_suite_n.png",
		"instrumentXalam_cham_s.png","koya_suite_n.png","LacRose_suite_p1.png","lion_suite_p1.png","maison_senegalaise_cham_d.png","mosquee_s_cham_d.png","moustiquaire_cham_d.png","ocean_cham_s.png","orange_s_cham_d.png",
		"riz_cham_s.png","sheraton_suite_p1.png","tresse_suite_n.png","zoo_suite_p1.png"};
                    
        String[] categories = {"Chambre double","Suite","Chambre simple","Chambre double","Chambre Simple","Chambre simple","Chambre simple","Suite présidentielle","Suite",
		"Suite présidentielle","Chambre double","Chambre double","Suite présidentielle","Suite","Chambre double","Chambre double","Suite","Suite présidentielle","Chambre simple",
		"Chambre simple","Chambre double","Chambre simple","Chambre simple","Suite présidentielle","Suite","Chambre simple","Chambre double","Chambre double","Suite présidentielle",
		"Suite présidentielle","Chambre double","Chambre simple","Chambre double","Suite","Chambre simple","Suite présidentielle","Suite","Chambre double","Suite","Chambre simple",
		"Chambre double","Chambre simple","Chambre double","Suite présidentielle","Suite","Suite","Chambre simple","Chambre double","Chambre simple","Chambre simple","Suite présidentielle",
		"Chambre double","Chambre simple","Suite","Chambre double","Suite présidentielle","Chambre simple","Suite","Suite présidentielle","Chambre double","Chambre simple","Suite","Chambre double",
		"Suite","Chambre simple","Suite présidentielle","Chambre double","Chambre simple","Suite présidentielle","Chambre simple","Suite présidentielle","Chambre double","Chambre double","Suite",
		"Suite présidentielle","Chambre double","Chambre simple","Chambre simple","Chambre double","Suite","Chambre simple","Chambre double","Chambre double","Suite présidentielle","Chambre simple",
		"Chambre double","Suite","Chambre simple","Suite","Chambre double","Chambre double","Chambre simple","Suite présidentielle","Suite","Chambre simple","Suite présidentielle","Suite présidentielle",
		"Suite","Chambre double","Chambre simple","Chambre simple","Chambre simple","Chambre double","Chambre simple","Chambre double","Suite","Suite","Chambre simple","Suite","Suite présidentielle",
		"Suite présidentielle","Chambre double","Chambre double","Chambre double","Chambre simple","Chambre double","Chambre simple","Suite présidentielle","Suite","Suite présidentielle"};
                    
        String[] themes_ch = {"sur le thème de l'automne","sur le thème de la caligraphie japonaise","sur le thème de la carpekoi","sur le thème de Cyberpunk","sur le thème des dragons",
		"futuriste","sur le thème de Ghibli","sur le thèmes des hanabi","sur le thèmes des hanabi","de luxe","sur le thème du Lycoris japonais","minimaliste","moderne","mystique",
		"sur le thème des ninja","sur le thème de pokémon","sur le thème des samouraï","sur le thème des sushis","printanière","traditionnelle","traditionnel","traditionnel",
		"sur le thème de Wan Makha Bucha","Royal","Traditionnel","sur le thème Wan Vaisakh Bucha","sur le thème des rues thailandaises","sur le thème des éléphants",
		"sur le thème des orchidées","dorée à l'Or pur","sur le thème Makha Bucha","sur le thème China town","sur le thème de Bo sang","sur le thème du festival des lumières",
		"sur le thème des tigres","du nouvelle an Chinois","sur le thème de la pleine lune","sur le thème de Phi Ta Khon","sur le thème de Lopburi","sur le thème de la fleur de lotus",
		"bohème","futuriste","romantique","sur le thème du Louvres","sur le thème de Monnet","sur le thème de Dior","traditionnel","moderne","royal","parisien","traditionnel","sur le thème du moulin rouge",
		"moderne","rococo","sur le thème cabinet de curiosité","de luxe","minimaliste","moderne/futuriste","sur le thème de l'élysée","de luxe","sur le thème des aurores boréales","sur le thème des baleines",
		"basalte","sur le thème des cascades","futuriste","sur le thème de la glace","sur le thème des glaciers","sur le thème des igloo","impérial","sur le thème des lagoon","de luxe","minimaliste",
		"sur le thème des montagnes","sur le thème marin","sur le thème des animaux","sur le thème des ours polaires","traditionnel","sur le thème des vikings","sur le thème des  volcans","sur le thème elixirs",
		"Andalouse","Ocre","sur le thème du Atay","sur le thème des lions","sur le thème des babouches","berbère","sur le thème des dattes","sur le thème des flouka","sur le thème du hammam","sur le thème du henné",
		"Jemaa el-Fna","Minaret","Oasis de luxe","sur le thème des oliviers","Zest","rêve oriental","riad moderne","sur le thème des épices","sur le thème du tajine","Sultane","sur le thème des barques","sur le thème cacao",
		"coloré","chocolaté","sur le thème du football","sur le thème des fruits exotiques","sur le thème des îles","sur le thèmes des Xalam","koya","lac rose","sur le thèmes des lions","sur le thèmes des maisons sénégalaises",
		"mosquée","sur le thème des moustiquaires","sur le thème des océan","orangé","sur le thème du riz","sheraton","sur le thème des tresse","sur le thème du zoo"};
                    
        String[] themes_fil = {"Culture","Culture","Culture","Aimer des touristes","Aimer des touristes","Moderne","Aimer des touristes","Culture","Luxe","Luxe","Culture","Moderne","Moderne",
		"Culture","Culture","Aimer des touristes","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Culture","Culture","Luxe","Culture","Aimer des touristes",
		"Aimer des touristes","Culture","Aimer des touristes","Luxe","Culture","Luxe","Culture","Moderne","Moderne","Culture","Culture","Moderne","Aimer des touristes","moderne","Aimer des touristes",
		"Culture","Culture","Culture","Culture","Moderne","Luxe","Culture","Luxe","Culture","Moderne","Aimer des touristes","Aimer des touristes","Luxe","Moderne","Moderne","Luxe","Luxe","Aimer des touristes",
		"Aimer des touristes","Culture","Aimer des touristes","Moderne","Culture","Culture","Culture","Luxe","Luxe","Luxe","Moderne","Culture","Culture","Aimer des touristes","Aimer des touristes","Culture",
		"Culture","Culture","Culture","Moderne","Culture","Aimer des touristes","Aimer des touristes","Culture","Culture","Luxe","Culture","Luxe","Luxe","Culture","Aimer par les touristes","Luxe","Luxe","Moderne",
		"Luxe","Moderne","Moderne","Aimer des touristes","Aimer des touristes","Culture","Culture","Aimer des tourites","Aimer des touristes","Luxe","Aimer des touristes","Culture","Luxe","Luxe","Moderne","Culture",
		"Culture","Luxe","Culture","Moderne","Aimer des touristes","Luxe","Culture","Moderne"};		
		
		Vue_Resultats_Recherche vueResultat = new Vue_Resultats_Recherche("", nomsFichiers, categories, themes_ch, themes_fil, m_1);

		
		//vue principale/acceuil 
		Vue_prcp vue_principale = new Vue_prcp(m_1,vueResultat);
		
		
		//controlleurs de changement de vue (barre de menu)
		//gestion des connections pour vue connect 
		NavControlleur controlleur_connection_ci = new NavControlleur(vue_ci, vue_ci);
		//gestion des connections pour chaque continent 
		NavControlleur controlleur_connection_co_asie = new NavControlleur(Continent_Asie, vue_ci);
		NavControlleur controlleur_connection_co_afrique = new NavControlleur(Continent_Afrique, vue_ci);
		NavControlleur controlleur_connection_co_europe = new NavControlleur(Continent_Europe, vue_ci);
		//gestion des connections pour chaque pays 
		NavControlleur controlleur_connection_pa_jap = new NavControlleur(v_j, vue_ci);
		NavControlleur controlleur_connection_pa_thai = new NavControlleur(v_t, vue_ci);
		NavControlleur controlleur_connection_pa_fr = new NavControlleur(v_f, vue_ci);
		NavControlleur controlleur_connection_pa_isl = new NavControlleur(v_i, vue_ci);
		NavControlleur controlleur_connection_pa_ma = new NavControlleur(v_m, vue_ci);
		NavControlleur controlleur_connection_pa_sn = new NavControlleur(v_s, vue_ci);
		//gestion des connections pour chaque hotel 
		NavControlleur controlleur_connection_pa_japh = new NavControlleur(hotel_jap, vue_ci);
		NavControlleur controlleur_connection_pa_thaih = new NavControlleur(hotel_thai, vue_ci);
		NavControlleur controlleur_connection_pa_frh = new NavControlleur(hotel_prs, vue_ci);
		NavControlleur controlleur_connection_pa_islh = new NavControlleur(hotel_isl, vue_ci);
		NavControlleur controlleur_connection_pa_mah = new NavControlleur(hotel_ma, vue_ci);
		NavControlleur controlleur_connection_pa_snh = new NavControlleur(hotel_sn, vue_ci);
		//gestions des connections pour chaque destionations recommandée
		NavControlleur controlleur_connection_dest1 = new NavControlleur(selection_famille, vue_ci);
		NavControlleur controlleur_connection_dest2 = new NavControlleur(selection_solo, vue_ci);
		NavControlleur controlleur_connection_dest3 = new NavControlleur(selection_luxe, vue_ci);
		//gestions des connections pour la page en savoir plus
		NavControlleur controlleur_connection_esp = new NavControlleur(esp,vue_ci);
		//gestions des connections pour la page principale 
		NavControlleur controlleur_connection_pr = new NavControlleur(vue_principale,vue_ci);
		
		
		//gestion des MenuItem pour chaque continent 
		NavControlleur controlleur_europe_mi = new NavControlleur(Continent_Europe, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_afrique_mi = new NavControlleur(Continent_Afrique, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_asie_mi = new NavControlleur(Continent_Asie, Continent_Asie, Continent_Europe,Continent_Afrique);
		//gestion des MenuItem pour chaque pays 
		NavControlleur controlleur_vuejap = new NavControlleur(v_j, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuethai = new NavControlleur(v_t, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuefr = new NavControlleur(v_f, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vueisl = new NavControlleur(v_i, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuesn = new NavControlleur(v_s, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuema = new NavControlleur(v_m, Continent_Asie, Continent_Europe,Continent_Afrique);
		//gestion des MenuItem pour chaque hotel 
		NavControlleur controlleur_vuejap_h = new NavControlleur(hotel_jap, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuethai_h = new NavControlleur(hotel_thai, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuefr_h = new NavControlleur(hotel_prs, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vueisl_h = new NavControlleur(hotel_isl, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuesn_h = new NavControlleur(hotel_sn, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuema_h = new NavControlleur(hotel_ma, Continent_Asie, Continent_Europe,Continent_Afrique);
		//gestion des MenuItem pour la page de connnectinscr
		NavControlleur controlleur_vueco_ci = new NavControlleur(vue_ci, Continent_Asie, Continent_Europe,Continent_Afrique);
		//gestion des MenuItem pour les pages destinations
		NavControlleur controlleur_vuedest_1 = new NavControlleur(selection_famille, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuedest_2 = new NavControlleur(selection_solo, Continent_Asie, Continent_Europe,Continent_Afrique);
		NavControlleur controlleur_vuedest_3 = new NavControlleur(selection_luxe, Continent_Asie, Continent_Europe,Continent_Afrique);
		//gestion des MenuItem pour la page en savoir plus 
		NavControlleur controlleur_vueesp_co = new NavControlleur(esp, Continent_Asie, Continent_Europe,Continent_Afrique);
		//gestion des MenuItem pour la page principale
		NavControlleur controlleur_vuepr_co = new NavControlleur(vue_principale, Continent_Asie, Continent_Europe,Continent_Afrique);
		
		//gestion des MenusItem vers nos destinations 
		//gestion des MenuItem pour chaque continent 
		NavControlleur controlleur_europe_dest = new NavControlleur(Continent_Europe, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_afrique_dest = new NavControlleur(Continent_Afrique, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_asie_dest = new NavControlleur(Continent_Asie, selection_famille, selection_solo,selection_luxe);
		//gestion des MenuItem pour chaque pays 
		NavControlleur controlleur_vuejapdest = new NavControlleur(v_j, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuethaidest = new NavControlleur(v_t, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuefrdest = new NavControlleur(v_f, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vueisldest = new NavControlleur(v_i, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuesndest = new NavControlleur(v_s, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuemadest = new NavControlleur(v_m, selection_famille, selection_solo,selection_luxe);
		//gestion des MenuItem pour chaque hotel 
		NavControlleur controlleur_vuejap_hdest = new NavControlleur(hotel_jap, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuethai_hdest = new NavControlleur(hotel_thai, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuefr_hdest = new NavControlleur(hotel_prs, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vueisl_hdest = new NavControlleur(hotel_isl, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuesn_hdest = new NavControlleur(hotel_sn, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuema_hdest = new NavControlleur(hotel_ma, selection_famille, selection_solo,selection_luxe);
		//gestion des MenuItem pour la page de connnectinscr
		NavControlleur controlleur_vueco_cidest = new NavControlleur(vue_ci, selection_famille, selection_solo,selection_luxe);
		//gestion des MenuItem pour les pages destinations
		NavControlleur controlleur_vuedest_1dest = new NavControlleur(selection_famille, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuedest_2dest = new NavControlleur(selection_solo, selection_famille, selection_solo,selection_luxe);
		NavControlleur controlleur_vuedest_3dest = new NavControlleur(selection_luxe, selection_famille, selection_solo,selection_luxe); 
		//gestion des MenuItem pour la page en savoir plus 
		NavControlleur controlleur_vuedest_esp = new NavControlleur(esp, selection_famille, selection_solo,selection_luxe);
		//gestion des MenuItem pour la page principale 
		NavControlleur controlleur_vuedest_pr = new NavControlleur(vue_principale, selection_famille, selection_solo,selection_luxe);
		
		//gestion du JMenuItem vers en savoir plus
		//gestion JMenuItem pour chaque continent 
		NavControlleur controlleur_europe_sav = new NavControlleur(Continent_Europe, esp);
		NavControlleur controlleur_afrique_sav = new NavControlleur(Continent_Afrique, esp);
		NavControlleur controlleur_asie_sav = new NavControlleur(Continent_Asie, esp);
		//gestion JMenuItem pour chaque pays
		NavControlleur controlleur_vuejapsav = new NavControlleur(v_j, esp);
		NavControlleur controlleur_vuethaisav = new NavControlleur(v_t, esp);
		NavControlleur controlleur_vuefrsav = new NavControlleur(v_f, esp);
		NavControlleur controlleur_vueislsav = new NavControlleur(v_i, esp);
		NavControlleur controlleur_vuesnsav = new NavControlleur(v_s, esp);
		NavControlleur controlleur_vuemasav = new NavControlleur(v_m, esp);	
		//gestion JMenuItem pour chaque hotel 
		NavControlleur controlleur_vuejap_hsav = new NavControlleur(hotel_jap, esp);
		NavControlleur controlleur_vuethai_hsav = new NavControlleur(hotel_thai, esp);
		NavControlleur controlleur_vuefr_hsav = new NavControlleur(hotel_prs, esp);
		NavControlleur controlleur_vueisl_hsav = new NavControlleur(hotel_isl, esp);
		NavControlleur controlleur_vuesn_hsav = new NavControlleur(hotel_sn, esp);
		NavControlleur controlleur_vuema_hsav = new NavControlleur(hotel_ma, esp);
		//gestion JMenuItem pour la page de connectinscr
		NavControlleur controlleur_vueco_cisav = new NavControlleur(vue_ci, esp);
		//gestion JMenuItem pour les destinations
		NavControlleur controlleur_vuedest_1sav = new NavControlleur(selection_famille, esp);
		NavControlleur controlleur_vuedest_2sav = new NavControlleur(selection_solo, esp);
		NavControlleur controlleur_vuedest_3sav = new NavControlleur(selection_luxe, esp);
		//gestions JMenuItem pour la page en savoir plus 
		NavControlleur controlleur_vuesav_esp = new NavControlleur(esp, esp); 
		//gestions JMenuItem pour la page principale 
		NavControlleur controlleur_vuesav_pr = new NavControlleur(vue_principale, esp); 


		//controleur pour revenir a la vue principale :
		//pays -> prcp
		NavControlleur controlleur_vuejap_prcp = new NavControlleur(v_j,vue_principale);
		NavControlleur controlleur_vuethai_prcp = new NavControlleur(v_t,vue_principale);
		NavControlleur controlleur_vuesn_prcp = new NavControlleur(v_s,vue_principale);
		NavControlleur controlleur_vuema_prcp = new NavControlleur(v_m,vue_principale);
		NavControlleur controlleur_vuefr_prcp = new NavControlleur(v_f,vue_principale);
		NavControlleur controlleur_vueisl_prcp = new NavControlleur(v_i,vue_principale);
		//hotel -> prcp 
		NavControlleur controlleur_vuehjap_prcp = new NavControlleur(hotel_jap, vue_principale);
		NavControlleur controlleur_vuehthai_prcp = new NavControlleur(hotel_thai, vue_principale);
		NavControlleur controlleur_vuehfr_prcp = new NavControlleur(hotel_prs, vue_principale);
		NavControlleur controlleur_vuehisl_prcp = new NavControlleur(hotel_isl, vue_principale);
		NavControlleur controlleur_vuehsn_prcp = new NavControlleur(hotel_sn, vue_principale);
		NavControlleur controlleur_vuehjma_prcp = new NavControlleur(hotel_ma, vue_principale);
		//continent -> prcp 
		NavControlleur controlleurcontinent_prcp_e = new NavControlleur(Continent_Europe,vue_principale);
		NavControlleur controlleurcontinent_prcp_af = new NavControlleur(Continent_Afrique,vue_principale);
		NavControlleur controlleurcontinent_prcp_a = new NavControlleur(Continent_Asie,vue_principale);
		//connection -> prcp
		NavControlleur controlleurcontinent_prcp_ci = new NavControlleur(vue_ci,vue_principale);
		//destinations -> prcp
		NavControlleur controlleur_vuedest_prcp_1 = new NavControlleur(selection_famille, vue_principale);
		NavControlleur controlleur_vuedest_prcp_2 = new NavControlleur(selection_solo, vue_principale);
		NavControlleur controlleur_vuedest_prcp_3 = new NavControlleur(selection_luxe, vue_principale);
		//esp -> prcp
		NavControlleur controlleur_vueesp_prcp = new NavControlleur(esp, vue_principale);
		//prcp -> prcp 
		NavControlleur controlleur_vuepr_prcp = new NavControlleur(vue_principale, vue_principale);
		//rech -> prcp 
		NavControlleur controlleur_vuerech_prcp = new NavControlleur(vueResultat, vue_principale);

		
		
		//Initialisation des pages
		vue_principale.setVisible(true);
		esp.pack();
		selection_famille.pack();
		selection_solo.pack();
		selection_luxe.pack();
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
}