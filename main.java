import java.awt.*;

public class Main {
    public static Lieu_trsm[] Lieu_p(){
        Lieu_trsm[] lieux_pa = new Lieu_trsm[9];
        
        lieux_pa[0] = new Lieu_trsm("Aquarium de Paris","5 Av. Albert de Mun, 75016 Paris","0145393000",0);
        lieux_pa[1] = new Lieu_trsm("Visite des catacombes de Paris","1 Av. du Colonel Henri Rol-Tanguy, 75014 Paris","0145430657",1);
        lieux_pa[2] = new Lieu_trsm("Espace Détente","22 rue de magdebourg, 75016 Paris","0749619185",2);
        lieux_pa[3] = new Lieu_trsm("Centre commercial Beaugrenelle","12 Rue Linois, 75015 Paris","0153952400",3);
        lieux_pa[4] = new Lieu_trsm("Disneyland Paris","Bd de Parc, 77700 Coupvray","0969326066",4);
        lieux_pa[5] = new Lieu_trsm("Madame Brasserie - Tour Eiffel","av. Gustave Eiffel, 75007 Paris","0183777778",5);
        lieux_pa[6] = new Lieu_trsm("Aéroport de Paris-Orly","94390 Orly","0170363950",6);
        lieux_pa[7] = new Lieu_trsm("Gare Montparnasse","17 Bd de Vaugirard","3635",7);
        lieux_pa[8] = new Lieu_trsm("SIXT|Location voiture gare Montparnasse","Gare face, Hall 2, Bd Pasteur voie 19, 75015 Paris","0170976111",8);
    
        return lieux_pa;
    }
    public static Lieu_trsm[] Lieu_b(){
        Lieu_trsm[] lieux_ba = new Lieu_trsm[10];
    
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
    
        return lieux_ba;
    }
    public static Lieu_trsm[] lieux_k(){
        Lieu_trsm[] lieux_ky = new Lieu_trsm[10];
        
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
    
        return lieux_ky;
    }
    public static Lieu_trsm[] Lieu_m(){
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
        
        return lieux_ma;
    }
    public static Lieu_trsm[] Lieu_s(){
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
    
    
        return lieux_sn;
    }
    
    public static Lieu_trsm[] Lieux_r(){
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
    
        return lieux_re;
    }
    
    public static void main(String[] args){
        Hotel h_p = new Hotel("France", "Paris","127 Av. des Champs-Élysées, 75008 Paris","Elégance","0145678926","elegance_paris@hotel.fr",Lieu_p());
        Hotel h_k = new Hotel("Japon", "Kyoto", "Tatsumicho, Higashiyama Ward, Kyoto, 605-0862, Japon", "Atarashii Kyoto", "+81 75-551-4321", "atarashiiKyoto@hotel.com", Lieu_k());
        Hotel h_r = new Hotel("Islande", "Reykjavik", "Nautholsvégur 83, Reykjavik, Islande", "Fagun Reykjavik", "+354 710 9648", "fagunReykjavik@hotel.com", Lieu_r());
        Hotel h_b = new Hotel("Thailande","Bangkok", "PFWR+C85, Maha Rat Rd, Phra Borom Maha Ratchawang, Phra Nakhon, Bangkok 10200, Thaïlande","Wat Pho(วัดโพธิ์) Hotel","+66 89 057 7100","watpho_hotel@hotel.com",Lieu_b());
        Hotel h_m = new Hotel("Maroc", "Marrakech", "Place Jemaa El Fna, Marrakech 40 000, Maroc", "Marrakech Palace", "+212 524 33 44 33", "marrakech_palace@hotel.com", Lieu_m());
        Hotel h_s = new Hotel("Sénégal", "Dakar", "Bp 8, Somone, Sénégal", "Royal Horizon Baobab", "+221 33 939 71 71", "", Lieu_s());
        //Chambres  h_p
        Chambre s_1p = new Chambre(101, 1, "Parisien", 120, 1);
        Chambre s_2p = new Chambre(102, 1, "Traditionel", 120, 1);
        Chambre s_3p = new Chambre(103, 1, "Moderne", 140, 1);
        Chambre s_4p = new Chambre(104, 1, "Royal", 200, 1);
        Chambre s_5p = new Chambre(105, 1, "Futuriste", 160, 1);
        Chambre s_6p = new Chambre(106, 1, "Minimaliste", 110, 1);
        Chambre d_1p = new Chambre(201, 0, "romantique & parisien", 160, 2);
        Chambre d_2p = new Chambre(202, 0, "Luxe", 170, 2);
        Chambre d_3p = new Chambre(203, 0, "Bohème", 160, 2);
        Chambre d_4p = new Chambre(204, 0, "Moderne & parisien", 160, 2);
        Chambre d_5p = new Chambre(205, 0, "Moulin Rouge", 180, 2);
        Chambre d_6p = new Chambre(206, 0, "Cabinet de curiosité", 170, 2);
        Chambre su_1p = new Chambre(301, 2, "Monnet", 220, 3);
        Chambre su_2p = new Chambre(302, 2, "Dior", 220, 3);
        Chambre su_3p = new Chambre(401, 2, "Moderne & futuriste", 240, 4);
        Chambre su_4p = new Chambre(402, 2, "Rococo", 240, 4);
        Chambre suP_1p = new Chambre(501, 3, "Louvres", 1580, 5);
        Chambre suP_2p = new Chambre(502, 3, "Luxe", 887, 5);
        Chambre suP_3p = new Chambre(601, 3, "Traditionnel Français", 1380, 6);
        Chambre suP_4p = new Chambre(602, 3, "Elysée", 1690, 6);
        //Chambre h_t
        Chambre s_1t = new Chambre(101, 1, "Traditionnel", 50, 1);
        Chambre s_2t = new Chambre(102, 1, "Wan Makha Bucha", 100, 1);
        Chambre s_3t = new Chambre(103, 1, "Wan Vaisakh Bucha", 120, 1);
        Chambre s_4t = new Chambre(104, 1, "China Town", 130, 1);
        Chambre s_5t = new Chambre(105, 1, "Tiger", 110, 1);
        Chambre s_6t = new Chambre(106, 1, "Lotus", 120, 1);
        Chambre d_1t = new Chambre(201, 0, "Traditionnel", 140, 2);
        Chambre d_2t = new Chambre(202, 0, "Elephant", 180, 2);
        Chambre d_3t = new Chambre(203, 0, "Street", 100, 2);
        Chambre d_4t = new Chambre(204, 0, "Bo sang", 180, 2);
        Chambre d_5t = new Chambre(205, 0, "Makha Bucha", 200, 2);
        Chambre d_6t = new Chambre(206, 0, "Phi Ta Khon", 210, 2);
        Chambre su_1t = new Chambre(301, 2, "Traditionnel", 1000, 3);
        Chambre su_2t = new Chambre(303, 2, "Festival des lumières", 1500, 3);
        Chambre su_3t = new Chambre(305, 2, "Pleine lune", 1250, 3);
        Chambre su_4t = new Chambre(307, 2, "Lopburi", 1900, 3);
        Chambre suP_1t = new Chambre(401, 3, "Orchidée", 2500, 4);
        Chambre suP_2t = new Chambre(403, 3, "Or", 3000, 4);
        Chambre suP_3t = new Chambre(406, 3, "Royal", 3200, 4);
        Chambre suP_4t = new Chambre(409, 3, "Nouvelle an Chinois", 3000, 4);
    
        //Chambre h_k
        Chambre s_1k = new Chambre(101, 1, "Traditionnel printannier", 100, 1);
        Chambre s_2k = new Chambre(102, 1, "Carpe Koi", 100, 1);
        Chambre s_3k = new Chambre(103, 1, "Dragon", 100, 1);
        Chambre s_4k = new Chambre(201, 1, "Ghibli", 100, 2);
        Chambre s_5k = new Chambre(202, 1, "Traditionnelle", 100, 2);
        Chambre s_6k = new Chambre(203, 1, "Futuriste", 100, 2);
        Chambre d_1k = new Chambre(104, 0, "Pokemon", 200, 1);
        Chambre d_2k = new Chambre(105, 0, "Cyberpunk", 200, 1);
        Chambre d_3k = new Chambre(106, 0, "Minimaliste", 200, 1);
        Chambre d_4k = new Chambre(204, 0, "Ninja", 200, 2);
        Chambre d_5k = new Chambre(205, 0, "Lycoris", 200, 2);
        Chambre d_6k = new Chambre(206, 0, "Automne", 200, 2);
        Chambre su_1k = new Chambre(301, 2, "Hanami", 500, 3);
        Chambre su_2k = new Chambre(302, 2, "Samurai", 500, 3);
        Chambre su_3k = new Chambre(303, 2, "Caligraphie", 500, 3);
        Chambre su_4k = new Chambre(304, 2, "Mystique", 500, 3);
        Chambre suP_1k = new Chambre(401, 3, "Luxe", 1000, 4);
        Chambre suP_2k = new Chambre(402, 3, "Sushi", 1000, 4);
        Chambre suP_3k = new Chambre(403, 3, "Moderne", 1000, 4);
        Chambre suP_4k = new Chambre(404, 3, "Hanabi", 1000, 4);
    
        //Chambre h_r
        Chambre s_1r = new Chambre(101, 1, "Aurore", 100, 1);
        Chambre s_2r = new Chambre(102, 1, "Lagoon", 100, 1);
        Chambre s_3r = new Chambre(103, 1, "Viking", 100, 1);
        Chambre s_4r = new Chambre(201, 1, "Traditionnelle", 100, 2);
        Chambre s_5r = new Chambre(202, 1, "Igloo", 100, 2);
        Chambre s_6r = new Chambre(203, 1, "Futuriste", 100, 2);
        Chambre d_1r = new Chambre(104, 0, "Glaciers", 200, 1);
        Chambre d_2r = new Chambre(105, 0, "Volcan", 200, 1);
        Chambre d_3r = new Chambre(106, 0, "Montagnes", 200, 1);
        Chambre d_4r = new Chambre(204, 0, "Ours polaire", 200, 2);
        Chambre d_5r = new Chambre(205, 0, "Minimaliste", 200, 2);
        Chambre d_6r = new Chambre(206, 0, "Basalte", 200, 2);
        Chambre su_1r = new Chambre(301, 2, "Elixir", 500, 3);
        Chambre su_2r = new Chambre(302, 2, "Cascade", 500, 3);
        Chambre su_3r = new Chambre(303, 2, "Baleine", 500, 3);
        Chambre su_4r = new Chambre(304, 2, "Marin", 500, 3);
        Chambre suP_1r = new Chambre(401, 3, "Luxe", 1000, 4);
        Chambre suP_2r = new Chambre(402, 3, "Impérial", 1000, 4);
        Chambre suP_3r = new Chambre(403, 3, "Glace", 1000, 4);
        Chambre suP_4r = new Chambre(404, 3, "Animalier", 1000, 4);

        //Chambres h_m
        Chambre s_1 = new Chambre(101, 1, "Sultane", 100, 1);
        Chambre s_2 = new Chambre(102, 1, "Flouka", 100, 1);
        Chambre s_3 = new Chambre(103, 1, "Zest", 100, 1);
        Chambre s_4 = new Chambre(201, 1, "Babouche", 100, 2);
        Chambre s_5 = new Chambre(202, 1, "Andalouse", 100, 2);
        Chambre s_6 = new Chambre(203, 1, "Minaret", 100, 2);
        Chambre d_1 = new Chambre(104, 0, "Henné", 200, 1);
        Chambre d_2 = new Chambre(105, 0, "Jemaa el-Fna", 200, 1);
        Chambre d_3 = new Chambre(106, 0, "Tajine", 200, 1);
        Chambre d_4 = new Chambre(204, 0, "Ocre", 200, 2);
        Chambre d_5 = new Chambre(205, 0, "Berbère", 200, 2);
        Chambre d_6 = new Chambre(206, 0, "Atay", 200, 2);
        Chambre su_1 = new Chambre(301, 2, "Olivier", 500, 3);
        Chambre su_2 = new Chambre(302, 2, "Dattier", 500, 3);
        Chambre su_3 = new Chambre(303, 2, "Souk des épices", 500, 3);
        Chambre su_4 = new Chambre(304, 2, "Hammam", 500, 3);
        Chambre suP_1 = new Chambre(401, 3, "Rêve Oriental", 1000, 4);
        Chambre suP_2 = new Chambre(402, 3, "Oasis de Luxe", 1000, 4);
        Chambre suP_3 = new Chambre(403, 3, "Riad Moderne", 1000, 4);
        Chambre suP_4 = new Chambre(404, 3, "Atlas Majestueux", 1000, 4);


        //Chambres h_s
        Chambre s_1 = new Chambre(101, 1, "Riz", 100, 1);
        Chambre s_2 = new Chambre(102, 1, "Chocolat", 100, 1);
        Chambre s_3 = new Chambre(103, 1, "Barque", 100, 1);
        Chambre s_4 = new Chambre(201, 1, "Océan", 100, 2);
        Chambre s_5 = new Chambre(202, 1, "Instrument xalam", 100, 2);
        Chambre s_6 = new Chambre(203, 1, "Cacao", 100, 2);
        Chambre d_1 = new Chambre(104, 0, "Moustiquaire", 200, 1);
        Chambre d_2 = new Chambre(105, 0, "Couleurs", 200, 1);
        Chambre d_3 = new Chambre(106, 0, "Maison sénégalaise", 200, 1);
        Chambre d_4 = new Chambre(204, 0, "Mosquée", 200, 2);
        Chambre d_5 = new Chambre(205, 0, "Orange", 200, 2);
        Chambre d_6 = new Chambre(206, 0, "Foot", 200, 2);
        Chambre su_1 = new Chambre(301, 2, "Koya", 500, 3);
        Chambre su_2 = new Chambre(302, 2, "Fruits Exotiques", 500, 3);
        Chambre su_3 = new Chambre(303, 2, "Ile", 500, 3);
        Chambre su_4 = new Chambre(304, 2, "Tresse", 500, 3);
        Chambre suP_1 = new Chambre(401, 3, "Lac Rose", 1000, 4);
        Chambre suP_2 = new Chambre(402, 3, "Zoo", 1000, 4);
        Chambre suP_3 = new Chambre(403, 3, "Sheraton", 1000, 4);
        Chambre suP_4 = new Chambre(404, 3, "Lion", 1000, 4);

        
    	Model_prc m_prc = new Model_prc ("RedOne");
    	Vue_prc v_prc = new Vue_prc(m_prc);
    	v_prc.setPreferredSize(new Dimension(1024,768));
    	v_prc.show();
    	v_prc.pack();
    }
}
