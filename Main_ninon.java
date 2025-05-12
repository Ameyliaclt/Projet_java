import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Main_ninon{
	public static void main(String[] args){
		//Création des tableaux de lieux touristiques.
		Lieu_trsm[] lieux_ky = new Lieu_trsm[10];
		Lieu_trsm[] lieux_re = new Lieu_trsm[10];
		Lieu_trsm[] lieux_pa = new Lieu_trsm[9];
		Lieu_trsm[] lieux_ba = new Lieu_trsm[10];
		Lieu_trsm[] lieux_ma = new Lieu_trsm[9];
		Lieu_trsm[] lieux_da = new Lieu_trsm[10];
  
		//Création des lieux touristiques de Kyoto.
        	lieux_ky[0] = new Lieu_trsm("Samurai & Ninja Museum Kyoto", "202 Higashi Daimonjicho, Nakagyo-ku, Utano koji Building 2F, Kyoto, 604-8043, Japon", "+81 75-585-5410",0);
        	lieux_ky[1] = new Lieu_trsm("Kyomizu-dera", "1 Chome-294 Kiyomizu, Higashiyama Ward, Kyoto, 605-0862, Japon", "+81 75-551-1234",1);
        	lieux_ky[2] = new Lieu_trsm("Aman Kyoto", "1 Okitayama Watashimine-cho Kita-ku Kita-ku, Kyoto, 603-8458, Japon", "+81 75-496-1334",2);
        	lieux_ky[3] = new Lieu_trsm("Marché Nishiki", "Nakagyo Ward, Kyoto, Kyoto, 604-8055, Japon", "+81 75-211-3882",3);
        	lieux_ky[4] = new Lieu_trsm("Toei Kyoto Studio park", "10 Uzumasa, Higashihachiokacho, Ukyo Ward, Kyoto, 604-8586, Japon", "+81 75-864-7716",4);
        	lieux_ky[5] = new Lieu_trsm("Gion Owatari", "570-265 Giommachi Minamigawa, Higashiyama-ku, Kyoto, 605-0074, Japon", "+81 75-551-5252",5);
        	lieux_ky[7] = new Lieu_trsm("Aéroport international du Kansai", "1 Banchi Senshukukokita, Izumisano, Osaka, 549-0001, Japon", "+81 72-455-2500",7);
        	lieux_ky[8] = new Lieu_trsm("gare de Kyoto", "Higashishiokoji Kamadonocho, Shimogyo Ward, Kyoto, 600-8216, Japon", "+81 75-361-4401",8);
        	lieux_ky[6] = new Lieu_trsm("TOYOTA Rent a car", "31-1 Higashikujo Kamitonodacho, Minami Ward, Kyoto, 601-8002, Japon", "+81 75-682-0800",6);
        	lieux_ky[9] = new Lieu_trsm("Ferry Miyazaki", "3-7 Shinko-cho, Chuo-ku, Kobe-shi, Hyogo, 650-0041, Japon", "+81 78-321-2244",9);

		//Création des lieux touristiques de Reykjavik.
		lieux_re[0] = new Lieu_trsm("Musée des Sagas", "Grandagardur 2, 101 Reykjavik, Islande", "+354 511 1517", 0);
		lieux_re[1] = new Lieu_trsm("Northern Lights Bus", "Skogarhlid 10, 105 Reykjavik, Islande", "+354 539 3888", 1);
		lieux_re[2] = new Lieu_trsm("Sky Lagoon", "Vesturvör 44-48, Kopavogur, Islande", "+354 527 6800", 2);
		lieux_re[3] = new Lieu_trsm("Kringlan Mall", "Kringlan 4-12, 103 Reykjavik, Islande", "+354 517 9000", 3);
		lieux_re[4] = new Lieu_trsm("Laugardalur", "Sundlaugavegur 32, 105 Reykjavik, Islande", "+354 411 1111", 4);
		lieux_re[5] = new Lieu_trsm("Kol Restaurant", "Skolavördustigur 40, 101 Reykjavik, Islande", "+354 517 7474", 5);
		lieux_re[6] = new Lieu_trsm("Sixt Rent a car", "Krokhals 9, 110 Reykjavik, Islande", "+354 540 2222", 6);
		lieux_re[7] = new Lieu_trsm("Aéroport de Reykjavik", "Vatnsmyri, 101 Reykjavik, Islande", "+354 424 4000", 7);
		lieux_re[8] = new Lieu_trsm("Terminal Bus Reykjavik", "Skogarhlid 10, 105 Reykjavik, Islande", "+354 497 5000", 8);
		lieux_re[9] = new Lieu_trsm("Skarfabakki Harbour", "544P+F35, 104 Reykjavik, Islande", "+354 525 8900", 9);

		//Création des lieux touristiques de Paris.
		lieux_pa[0] = new Lieu_trsm("Aquarium de Paris","5 Av. Albert de Mun, 75016 Paris","0145393000",0);
       		lieux_pa[1] = new Lieu_trsm("Visite des catacombes de Paris","1 Av. du Colonel Henri Rol-Tanguy, 75014 Paris","0145430657",1);
        	lieux_pa[2] = new Lieu_trsm("Espace Détente","22 rue de magdebourg, 75016 Paris","0749619185",2);
        	lieux_pa[3] = new Lieu_trsm("Centre commercial Beaugrenelle","12 Rue Linois, 75015 Paris","0153952400",3);
        	lieux_pa[4] = new Lieu_trsm("Disneyland Paris","Bd de Parc, 77700 Coupvray","0969326066",4);
        	lieux_pa[5] = new Lieu_trsm("Madame Brasserie - Tour Eiffel","av. Gustave Eiffel, 75007 Paris","0183777778",5);
        	lieux_pa[6] = new Lieu_trsm("Aéroport de Paris-Orly","94390 Orly","0170363950",6);
        	lieux_pa[7] = new Lieu_trsm("Gare Montparnasse","17 Bd de Vaugirard","3635",7);
        	lieux_pa[8] = new Lieu_trsm("SIXT|Location voiture gare Montparnasse","Gare face, Hall 2, Bd Pasteur voie 19, 75015 Paris","0170976111",8);

		//Création des lieux touristiques de Bangkok.
		lieux_ba[0] = new Lieu_trsm("Wat Pho(วัดโพธิ์)","2 Sanamchai Road, Grand Palace Subdistrict, Pranakorn District, Bangkok 10200, Thaïlande","+66830577100",0);
        	lieux_ba[1] = new Lieu_trsm("The Grand Palace(พระบรมมหาราชวัง)","Na Phra Lan Rd, Phra Nakhon, Bangkok 10200, Thaïlande","+66232259519",1);
        	lieux_ba[2] = new Lieu_trsm("Bangkok Yai Park(สวนบางกอกใหญ่)","PFJH+J8Q, Wat Tha Phra, Bangkok Yai, Bangkok 10600, Thaïlande","+6624655640",2);
        	lieux_ba[3] = new Lieu_trsm("CentralWorld(เซ็นทรัลเวิลด์)","999/9 Rama I Rd, Pathum Wan, Bangkok 10330, Thaïlande","+6626407000",3);
        	lieux_ba[4] = new Lieu_trsm("Siam Amazing Park(สยามอะเมซิ่งพาร์ค)","203 Suan Siam Rd, Khwaeng Khan Na Yao, Khet Khan Na Yao, Krung Thep Maha Nakhon 10230, Thaïlande","+6621054292",4);
        	lieux_ba[5] = new Lieu_trsm("Kinu by Tagaki","Mandarin Oriental Bangkok, 48 Oriental Ave, Khwaeng Bang Rak, Bang Rak, Bangkok 10500, Thaïlande","+6626599000",5);
        	lieux_ba[6] = new Lieu_trsm("Suvarnabhumi Airport (BKK)","999, Nong Prue, Bang Phli District, Samut Prakan 10540, Thaïlande","+6621321888",6);
        	lieux_ba[7] = new Lieu_trsm("Bangkok Railway Station(กรุงเทพ)","Rong Mueang Rd, Rong Muang, Pathum Wan, Bangkok 10330, Thaïlande","+6622204334",7);
        	lieux_ba[8] = new Lieu_trsm("Bangkok Port(ท่าเรือกรุงเทพ)","Khlong Toei, Bangkok 10110, Thaïlande","+6622384000",8);
        	lieux_ba[9] = new Lieu_trsm("Drive Car Rental - Suvarnabhumi Airport","Suvarnabhumi Airport,, Arrival Hall, 999 Moo 1, Nong Prue,, Bang Phli District, Samut Prakan 10540, Thaïlande","+66847004376",9);

		//Création des lieux touristiques de Marrakesh.
		lieux_ma[0] = new Lieu_trsm("Musée de Marrakech", "Place Ben Youssef, Marrakesh 40 000, Maroc", "+212 5 24 44 18 93", 0);
        	lieux_ma[1] = new Lieu_trsm("Mosquée Koutoubia", "Koutoubia Marrakech, Marrakech 40 000, Maroc", "+212 5 24 43 34 07", 1);
        	lieux_ma[2] = new Lieu_trsm("Elysa Center", "Las Torrres de Majorelle, av. Yacoub El Mansour, Marrakech 40 000, Maroc", "+212 5 24 43 31 79", 2);
        	lieux_ma[3] = new Lieu_trsm("Ménara Mall", "Bd Mohamed VI, Marrakech 40 000, Maroc", "+212 5 24 35 10 50", 3);
        	lieux_ma[4] = new Lieu_trsm("Gravity Park", "Bd de Casablanca, Marrakech 40 000, Maroc", "+212 6 55 50 59 59", 4);
        	lieux_ma[5] = new Lieu_trsm("Le Grand Bazar", "Place Jemaa El Fna, propriete Zanket El Guassabine, Marrakech 40 000, Maroc", "+212 6 82 54 25 13", 5);
        	lieux_ma[6] = new Lieu_trsm("Medloc Car Rental 4x4", "75 Rue Ibn Aincha, Marrakech 40 000, Maroc", "+212 6 61 18 13 89", 6);
        	lieux_ma[7] = new Lieu_trsm("Aéroport international Marrakech Ménara", "Marrakech 40 000, Maroc", "+212 5 24 44 79 10", 7);
        	lieux_ma[8] = new Lieu_trsm("Gare MARRAKECH", "Centre, Bd Mohamed VI, Marrakesh 40 100, Maroc", "+212 5 37 77 47 47", 8);

		//Création des lieux touristiques de Dakar. 
		lieux_da[0] = new Lieu_trsm("Centre d’interprétation du Delta du Saloum de Toubacouta", "Toubakouta, Sénégal", "+221 33 945 86 28", 0);
        	lieux_da[1] = new Lieu_trsm("Phare des Mamelles", "Mamelles, Rte de l'aéroport, Dakar, Sénégal", "+221 77 343 72 72", 1);
        	lieux_da[2] = new Lieu_trsm("Ryad al Sultan Oriental Spa", "Rte de la Corniche O, Dakar, Sénégal", "+221 33 824 99 28", 2);
        	lieux_da[3] = new Lieu_trsm("Centre commercial les 4 C", "Av. Malick Sy, Dakar 10000, Sénégal", "+221 77 444 14 75", 3);
        	lieux_da[4] = new Lieu_trsm("Magic Land", "Route de la Corniche Ouest, Dakar, Sénégal", "+221 33 823 49 36", 4);
        	lieux_da[5] = new Lieu_trsm("Restaurant La Terrasse", "Boulevard Martin Luther King, Rte de la Corniche O, Dakar 91 179, Sénégal", "+221 33 839 90 40", 5);
        	lieux_da[6] = new Lieu_trsm("Sixt Sénégal", "269 rue LIB 02, Dakar 11 000, Sénégal", "+221 33 820 15 95", 6);
        	lieux_da[7] = new Lieu_trsm("Aéroport de Dakar-Blaise Diagne", "Diass, Sénégal", "+221 33 939 69 00", 7);
        	lieux_da[8] = new Lieu_trsm("Gare ferroviaire de Dakar", "Dakar, Sénégal", "33 920 00 40", 8);

		//Création des hôtels.
		Hotel h_k = new Hotel("Japon", "Kyoto", "Tatsumicho, Higashiyama Ward, Kyoto, 605-0862, Japon", "Atarashii Kyoto", "+81 75-551-4321", "atarashiiKyoto@roombloom.com", lieux_ky);
		Hotel h_r = new Hotel("Islande", "Reykjavik", "Nautholsvégur 83, Reykjavik, Islande", "Fagun Reykjavik", "+354 710 9648", "fagunReykjavik@roombloom.com", lieux_re);
		Hotel h_p = new Hotel("France", "Paris","127 Av. des Champs-Élysées, 75008 Paris","Elégance","0145678926","elegance_paris@roombloom.com", lieux_pa);	
		Hotel h_b = new Hotel("Thaïlande","Bangkok", "PFWR+C85, Maha Rat Rd, Phra Borom Maha Ratchawang, Phra Nakhon, Bangkok 10200, Thaïlande","Wat Pho Hotel","+66 89 057 7100","watpho_hotel@roombloom.com",lieux_ba);
		Hotel h_m = new Hotel("Maroc", "Marrakech", "Place Jemaa El Fna, Marrakech 40 000, Maroc", "Marrakech Palace", "+212 524 33 44 33", "marrakech_palace@roombloom.com", lieux_ma);	
		Hotel h_d = new Hotel("Sénégal", "Dakar", "Bp 8, Somone, Sénégal", "Royal Horizon Baobab", "+221 33 939 71 71", "royal_horizon_baobab@roombloom.com", lieux_da);
	
		//Création des models nécessaires pour les vues.
		Pays japon = new Pays("Projet_poo_images//Fond_japon.png", "Projet_poo_images//Sakura_back.jpg", "Projet_poo_images//Hotel_Kyoto_3.jpg", Color.PINK, new Color(244,204,231), new Color(232,100,134));
		Pays islande = new Pays("Projet_poo_images//Fond_islande.png", "Projet_poo_images//Glacon_fond.png", "Projet_poo_images//Hotel_Reykjavik.jpg", new Color(190,243,220), new Color(152,194,225), Color.WHITE);
		Pays france = new Pays("Projet_poo_images//Fond_france.png", "Projet_poo_images//Fond_lys.png", "Projet_poo_images//hotel_paris.jpg", new Color(105,181,238), new Color(180,235,126), Color.WHITE);
		Pays thailande = new Pays("Projet_poo_images//Fond_thailande.png", "Projet_poo_images//Fond_lanternes.png", "Projet_poo_images//hotel_piscine_thai.jpg", new Color(162,240,233), new Color(249,222,142), Color.WHITE);
		Pays maroc = new Pays("Projet_poo_images//Fond_maroc.png", "Projet_poo_images//Fond_tajine.png", "Projet_poo_images//hotel_maroc.png", new Color(169,121,217), new Color(111,180,241), Color.WHITE);
		Pays senegal = new Pays("Projet_poo_images//Fond_senegal.png", "Projet_poo_images//Fond_baobab.png", "Projet_poo_images//hotel_senegal.png", new Color(215,107,100), new Color(215,107,100), Color.WHITE);
		
		//Création des vues.
		Vue_pays v_j = new Vue_pays(h_k, japon);
		Vue_pays v_i = new Vue_pays(h_r, islande);
		Vue_pays v_f = new Vue_pays(h_p, france);
		Vue_pays v_t = new Vue_pays(h_b, thailande);
		Vue_pays v_m = new Vue_pays(h_m, maroc);
		Vue_pays v_s = new Vue_pays(h_d, senegal);

		Chambre[] cha_r = new Chambre[4];

		cha_r[0] = new Chambre(105, 0, "Cyberpunk", 200, 1);
		cha_r[1] = new Chambre(302, 2, "Samurai", 500, 3);
		cha_r[2] = new Chambre(101, 1, "Traditionnel printannier", 100, 1);
		cha_r[3] = new Chambre(205, 0, "Lycoris", 200, 2);

		Date arrivee = new Date(5, 6, 2016, 17, 00);
		Date depart = new Date(12, 9, 2016, 15, 00);

		Client client = new Client("Caristan", "Ninon", "xx xx xx xx xx", "x@gmail.com", "");

		Vue_rsrv v_rsrv_client = new Vue_rsrv(h_k, client, cha_r, arrivee, depart);

		Vue_transition v_tr = new Vue_transition(h_k, cha_r, arrivee, depart, client);

		Reservation rsrv1 = new Reservation(arrivee, depart, client, h_k, 99000, cha_r, 2);
		Reservation rsrv2 = new Reservation(arrivee, depart, client, h_k, 99000, cha_r, 2);

		Reservation[] tab_r = {rsrv1, rsrv2};

		Reservation rsrv3 = new Reservation(arrivee, depart, client, h_k, 99000, cha_r, 2);
		Reservation rsrv4 = new Reservation(arrivee, depart, client, h_k, 99000, cha_r, 2);
		Sejour sej1 = rsrv3.add_r();
		Sejour sej2 = rsrv4.add_r();
		
		Conso_mb conso1 = new Conso_mb("Coca cola", 3);
		Conso_mb conso2 = new Conso_mb("Sprite", 2);

		sej1.add_conso_mb(conso1);
		sej1.add_conso_mb(conso2);
		sej2.add_conso_mb(conso1);
		sej2.add_conso_mb(conso2);

		Sejour[] tab_s = {sej1, sej2};
		
		Vue_gestion_rs v_gest = new Vue_gestion_rs(tab_r);
		Vue_gestion_rs v_gest1 = new Vue_gestion_rs(tab_s);
		Vue_gestion_rs v_gest2 = new Vue_gestion_rs(tab_r, tab_s);

		Dimension t_ecran = Toolkit.getDefaultToolkit().getScreenSize();

		//Création visuel vue Japon.
		v_j.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_j.dispose();
		v_j.setVisible(true);
		v_j.pack();

		//Création visuel vue Islande.
		v_i.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_i.dispose();
		v_i.setVisible(true);
		v_i.pack();

		//Création visuel vue France.
		v_f.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_f.dispose();
		v_f.setVisible(true);
		v_f.pack();

		//Création visuel vue Thaïlande.
		v_t.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_t.dispose();
		v_t.setVisible(true);
		v_t.pack();

		//Création visuel vue Maroc.
		v_m.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_m.dispose();
		v_m.setVisible(true);
		v_m.pack();
		
		//Création visuel vue Sénégal.
		v_s.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_s.dispose();
		v_s.setVisible(true);
		v_s.pack();

		//Création visuel vue Réservation avec client.
		v_rsrv_client.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_rsrv_client.dispose();
		v_rsrv_client.setVisible(true);
		v_rsrv_client.pack();

		//Création visuel vue transition. 
		v_tr.setPreferredSize(new Dimension((int)((double)t_ecran.getWidth()*0.6), (int)((double)t_ecran.getHeight()*0.43)));
		v_tr.dispose();
		v_tr.setVisible(true);
		v_tr.pack();

		//Création visuel vue gestion avec tableau réservations seul. 
		v_gest.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_gest.dispose();
		v_gest.setVisible(true);
		v_gest.pack();

		//Création visuel vue gestion avec tableau séjour seul. 
		v_gest1.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_gest1.dispose();
		v_gest1.setVisible(true);
		v_gest1.pack();

		//Création visuel vue gestion avec les deux tableaux. 
		v_gest2.setPreferredSize(new Dimension((int)t_ecran.getWidth(), (int)((double)t_ecran.getHeight()*0.95)));
		v_gest2.dispose();
		v_gest2.setVisible(true);
		v_gest2.pack();
	}
}
