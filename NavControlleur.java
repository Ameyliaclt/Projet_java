import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JButton;


public class NavControlleur {
	private Vue_prcp vue_principale;
	private Vue_prcp vue_principale_1;
    private Vue_pays vuePays;
    private Vue_hotel vueHotel;
	private Vue_pays vuePays_2;
	private Continent vueContinent;
	private Continent vueContinent_2;
	private Continent vueContinent_3;
	private Continent vueContinent_4;
	private Seconnecter vue_ci;
	private Seconnecter vue_ci_1;
	private Nos_selections_fa selections;
	private Nos_selections_fa selections_1;
	private Nos_selections_fa selections_2;
	private Nos_selections_fa selections_3;
	private EnSavoirPlus vue_ensavoir_plus;
	private EnSavoirPlus vue_ensavoir_plus_1;
	private Vue_rsrv vue_reserv;
	private Vue_Resultats_Recherche vue_rech;
    
	//constructeur -> prcp
    public NavControlleur(Vue_pays vueP, Vue_hotel vueH) {
        this.vuePays = vueP;
        this.vueHotel = vueH;
    }
	
	public NavControlleur(Vue_pays v_p, Vue_prcp vue_p) {
        this.vue_principale = vue_p;
        this.vuePays = v_p;
		
		rendreCliquable_1(vuePays.gettitre(),vue_principale);
    }
	
	public NavControlleur(Vue_hotel v_h, Vue_prcp vue_pr) {
		this.vueHotel = v_h;
        this.vue_principale = vue_pr;
		
		rendreCliquable_2(vueHotel.gettitre(),vue_principale);
    }
	
	public NavControlleur(Continent v_c,Vue_prcp vue_prc) {
        this.vueContinent = v_c;
		this.vue_principale = vue_prc;
		
		rendreCliquable_3(vueContinent.gettitre(),vue_principale);
    }
	
	public NavControlleur(Nos_selections_fa vue_s,Vue_prcp vue_prc) {
        this.selections = vue_s;
		this.vue_principale = vue_prc;
		
		rendreCliquable_sel(selections.gettitre(),vue_principale);
    }
	
	public NavControlleur(Seconnecter v_c,Vue_prcp vue_prc) {
        this.vue_ci = v_c;
		this.vue_principale = vue_prc;
		
		rendreCliquable_ci(vue_ci.gettitre(),vue_principale);
    }
	
	public NavControlleur(EnSavoirPlus v_esp,Vue_prcp vue_prc) {
        this.vue_ensavoir_plus = v_esp;
		this.vue_principale = vue_prc;
		
		rendreCliquable_esp(vue_ensavoir_plus.gettitre(),vue_principale);
    }
	
	public NavControlleur(Vue_prcp v_pr,Vue_prcp vue_prc) {
        this.vue_principale = v_pr;
		this.vue_principale_1 = vue_prc;
		
		rendreCliquable_pr(vue_principale.gettitre(),vue_principale_1);
    }
	
	public NavControlleur(Vue_Resultats_Recherche v_c,Vue_prcp vue_prc) {
        this.vue_rech = v_c;
		this.vue_principale_1 = vue_prc;
		
		rendreJButtonVersConnexion_rch(vue_rech.gettitre(),vue_principale_1);
    }
	
	/*public NavControlleur(Vue_rsrv v_r,Vue_prcp vue_prc) {
        this.vue_reserv = v_r;
		this.vue_principale_1 = vue_prc;
		
		rendreCliquable_rsrv(vue_reserv.gettitre(),vue_principale_1);
    }*/
	
	//constructeur continent -> vue pays
	public NavControlleur(Continent Vue_c,Vue_pays vuep_1, Vue_pays vuep_2){
		this.vueContinent = Vue_c;
		this.vuePays = vuep_1;
		this.vuePays_2 = vuep_2;
		
		// Associe chaque label à sa vuePays
		rendreCliquableVersPays(vueContinent.getLabelPays_1(), vuePays); 
		rendreCliquableVersPays(vueContinent.getLabelPays_2(), vuePays_2);
	}
	
	//constructeur -> continent/nos selections
	public NavControlleur(Seconnecter vueci,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.vue_ci = vueci;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent_ci(vue_ci.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent_ci(vue_ci.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent_ci(vue_ci.getRecDest3(),vueContinent_4);
	}
	
	/*public NavControlleur(Vue_rsrv vuer,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.vue_reserv = vuer;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent_rsrv(vue_reserv.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent_rsrv(vue_reserv.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent_rsrv(vue_reserv.getRecDest3(),vueContinent_4);
	}*/
	
	/*public NavControlleur(Vue_rsrv vuer,Nos_selections_fa Vue_c1s,Nos_selections_fa Vue_c2s,Nos_selections_fa Vue_c3s){
		this.vue_reserv = vuer;
		this.selections_1 = Vue_c1s;
		this.selections_2 = Vue_c2s;
		this.selections_3 = Vue_c3s;
		
		//Associe chaque menuitem à sa VueNosselections
		rendreMenuItemVersDestinations_rsrv(vue_reserv.getrec_selct1(),selections_1);
		rendreMenuItemVersDestinations_rsrv(vue_reserv.getrec_selct2(),selections_2);
		rendreMenuItemVersDestinations_rsrv(vue_reserv.getrec_selct3(),selections_3);
	}*/
	public NavControlleur(Seconnecter vueci,Nos_selections_fa Vue_c1s,Nos_selections_fa Vue_c2s,Nos_selections_fa Vue_c3s){
		this.vue_ci = vueci;
		this.selections_1 = Vue_c1s;
		this.selections_2 = Vue_c2s;
		this.selections_3 = Vue_c3s;
		
		//Associe chaque menuitem à sa VueNosselections
		rendreMenuItemVersDestinations_ci(vue_ci.getrec_selct1(),selections_1);
		rendreMenuItemVersDestinations_ci(vue_ci.getrec_selct2(),selections_2);
		rendreMenuItemVersDestinations_ci(vue_ci.getrec_selct3(),selections_3);
	}
	
	public NavControlleur(Continent Vue_c,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.vueContinent = Vue_c;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent(vueContinent.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent(vueContinent.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent(vueContinent.getRecDest3(),vueContinent_4);
	}
	
	public NavControlleur(Continent Vue_c,Nos_selections_fa Vue_c1s,Nos_selections_fa Vue_c2s,Nos_selections_fa Vue_c3s){
		this.vueContinent = Vue_c;
		this.selections_1 = Vue_c1s;
		this.selections_2 = Vue_c2s;
		this.selections_3 = Vue_c3s;
		
		//Associe chaque menuitem à sa VueNosselections
		rendreMenuItemVersDestinations_co(vueContinent.getrec_selct1(),selections_1);
		rendreMenuItemVersDestinations_co(vueContinent.getrec_selct2(),selections_2);
		rendreMenuItemVersDestinations_co(vueContinent.getrec_selct3(),selections_3);
	}
	
	public NavControlleur(Vue_pays vue_p,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.vuePays = vue_p;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent_1(vuePays.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent_1(vuePays.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent_1(vuePays.getRecDest3(),vueContinent_4);
	}
	
	public NavControlleur(Vue_pays vue_p,Nos_selections_fa Vue_c1s,Nos_selections_fa Vue_c2s,Nos_selections_fa Vue_c3s){
		this.vuePays = vue_p;
		this.selections_1 = Vue_c1s;
		this.selections_2 = Vue_c2s;
		this.selections_3 = Vue_c3s;
		
		//Associe chaque menuitem à sa VueNosselections
		rendreMenuItemVersDestinations_pa(vuePays.getrec_selct1(),selections_1);
		rendreMenuItemVersDestinations_pa(vuePays.getrec_selct2(),selections_2);
		rendreMenuItemVersDestinations_pa(vuePays.getrec_selct3(),selections_3);
	}
	
	public NavControlleur(Vue_hotel hotel_v,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.vueHotel = hotel_v;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent_2(vueHotel.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent_2(vueHotel.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent_2(vueHotel.getRecDest3(),vueContinent_4);
	}
	
	public NavControlleur(Vue_hotel hotel_v,Nos_selections_fa Vue_c1s,Nos_selections_fa Vue_c2s,Nos_selections_fa Vue_c3s){
		this.vueHotel = hotel_v;
		this.selections_1 = Vue_c1s;
		this.selections_2 = Vue_c2s;
		this.selections_3 = Vue_c3s;
		
		//Associe chaque menuitem à sa VueNosselections
		rendreMenuItemVersDestinations_ho(vueHotel.getrec_selct1(),selections_1);
		rendreMenuItemVersDestinations_ho(vueHotel.getrec_selct2(),selections_2);
		rendreMenuItemVersDestinations_ho(vueHotel.getrec_selct3(),selections_3);
	}
	
	public NavControlleur(Nos_selections_fa select,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.selections = select;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent_sel(selections.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent_sel(selections.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent_sel(selections.getRecDest3(),vueContinent_4);
	}
	
	public NavControlleur(Nos_selections_fa select,Nos_selections_fa Vue_c1s,Nos_selections_fa Vue_c2s,Nos_selections_fa Vue_c3s){
		this.selections = select;
		this.selections_1 = Vue_c1s;
		this.selections_2 = Vue_c2s;
		this.selections_3 = Vue_c3s;
		
		//Associe chaque menuitem à sa VueNosselections
		rendreMenuItemVersDestinations_sel(selections.getrec_selct1(),selections_1);
		rendreMenuItemVersDestinations_sel(selections.getrec_selct2(),selections_2);
		rendreMenuItemVersDestinations_sel(selections.getrec_selct3(),selections_3);
	}
	
	public NavControlleur(EnSavoirPlus esp,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.vue_ensavoir_plus = esp;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent_esp(vue_ensavoir_plus.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent_esp(vue_ensavoir_plus.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent_esp(vue_ensavoir_plus.getRecDest3(),vueContinent_4);
	}
	
	public NavControlleur(EnSavoirPlus vue_esp,Nos_selections_fa Vue_c1s,Nos_selections_fa Vue_c2s,Nos_selections_fa Vue_c3s){
		this.vue_ensavoir_plus = vue_esp;
		this.selections_1 = Vue_c1s;
		this.selections_2 = Vue_c2s;
		this.selections_3 = Vue_c3s;
		
		//Associe chaque menuitem à sa VueNosselections
		rendreMenuItemVersDestinations_esp(vue_ensavoir_plus.getrec_selct1(),selections_1);
		rendreMenuItemVersDestinations_esp(vue_ensavoir_plus.getrec_selct2(),selections_2);
		rendreMenuItemVersDestinations_esp(vue_ensavoir_plus.getrec_selct3(),selections_3);
	}
	
	public NavControlleur(Vue_prcp v_p,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.vue_principale = v_p;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent_pr(vue_principale.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent_pr(vue_principale.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent_pr(vue_principale.getRecDest3(),vueContinent_4);
	}
	
	public NavControlleur(Vue_prcp v_p,Nos_selections_fa Vue_c1s,Nos_selections_fa Vue_c2s,Nos_selections_fa Vue_c3s){
		this.vue_principale = v_p;
		this.selections_1 = Vue_c1s;
		this.selections_2 = Vue_c2s;
		this.selections_3 = Vue_c3s;
		
		//Associe chaque menuitem à sa VueNosselections
		rendreMenuItemVersDestinations_pr(vue_principale.getrec_selct1(),selections_1);
		rendreMenuItemVersDestinations_pr(vue_principale.getrec_selct2(),selections_2);
		rendreMenuItemVersDestinations_pr(vue_principale.getrec_selct3(),selections_3);
	}
	
	//controleur  -> sav 
	public NavControlleur(EnSavoirPlus vue_esp,EnSavoirPlus vue_sav){
		this.vue_ensavoir_plus = vue_esp;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus
		rendreMenuItemVersSav_esp(vue_ensavoir_plus.get_sacv(),vue_ensavoir_plus_1);
	}
	
	/*public NavControlleur(Vue_rsrv vue_r,EnSavoirPlus vue_sav){
		this.vue_reserv = vue_r;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus
		rendreMenuItemVersSav_rsrv(vue_reserv.get_sacv(),vue_ensavoir_plus_1);
	}*/
	
	public NavControlleur(Continent vue_co,EnSavoirPlus vue_sav){
		this.vueContinent = vue_co;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus
		rendreMenuItemVersSav_co(vueContinent.get_sacv(),vue_ensavoir_plus_1);
	}
	
	public NavControlleur(Seconnecter vue_sec,EnSavoirPlus vue_sav){
		this.vue_ci = vue_sec;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus
		rendreMenuItemVersSav_ci(vue_ci.get_sacv(),vue_ensavoir_plus_1);
	}
	
	public NavControlleur(Nos_selections_fa vue_fa,EnSavoirPlus vue_sav){
		this.selections = vue_fa;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus
		rendreMenuItemVersSav_fa(selections.get_sacv(),vue_ensavoir_plus_1);
	}
	
	public NavControlleur(Vue_pays v_p, EnSavoirPlus vue_sav){
		this.vuePays = v_p;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus
		rendreMenuItemVersSav_pa(vuePays.get_sacv(),vue_ensavoir_plus_1);
	}
	
	public NavControlleur(Vue_hotel v_h,EnSavoirPlus vue_sav){
		this.vueHotel = v_h;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus 
		rendreMenuItemVersSav_ho(vueHotel.get_sacv(),vue_ensavoir_plus_1);
	}
	
	public NavControlleur(Vue_prcp v_p,EnSavoirPlus vue_sav){
		this.vue_principale = v_p;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus 
		rendreMenuItemVersSav_pr(vue_principale.get_sacv(),vue_ensavoir_plus_1);
	}
	
	//controleur -> seconnecter
	public NavControlleur(Seconnecter v_ci,Seconnecter vue_c){
		this.vue_ci = v_ci;
		this.vue_ci_1 = vue_c;
		
		//Associe butt vers la connexion client
		rendreJButtonVersConnexion_ci(vue_ci.getButt(),vue_ci_1);
	}
	
	/*public NavControlleur(Vue_rsrv v_r,Seconnecter vue_c){
		this.vue_reserv = v_r;
		this.vue_ci_1 = vue_c;
		
		//Associe butt vers la connexion client
		rendreJButtonVersConnexion_rsrv(vue_reserv.getButt(),vue_ci_1);
	}*/
	
	public NavControlleur(Nos_selections_fa vu_s,Seconnecter vue_c){
		this.selections = vu_s;
		this.vue_ci_1 = vue_c;
		
		//Associe butt vers la connexion client
		rendreJButtonVersConnexion_sel(selections.getButt(),vue_ci_1);
	}
	
	public NavControlleur(Continent v_c,Seconnecter vue_c){
		this.vueContinent = v_c;
		this.vue_ci_1 = vue_c;
		
		//Associe butt vers la connexion client pour chaque continent
		rendreJButtonVersConnexion_co(vueContinent.getButt(),vue_ci_1);
	}
	
	public NavControlleur(Vue_pays v_p,Seconnecter vue_c){
		this.vuePays = v_p;
		this.vue_ci_1 = vue_c;
		
		//Associe butt vers la connexion client pour chaque pays
		rendreJButtonVersConnexion_pa(vuePays.getButt(),vue_ci_1);
	}
	
	public NavControlleur(Vue_hotel v_h,Seconnecter vue_c){
		this.vueHotel = v_h;
		this.vue_ci_1 = vue_c;
		
		//Associe butt vers la connexion client pour chaque hotel
		rendreJButtonVersConnexion_ho(vueHotel.getButt(),vue_ci_1);
	}
	
	public NavControlleur(EnSavoirPlus v_s,Seconnecter vue_c){
		this.vue_ensavoir_plus = v_s;
		this.vue_ci_1 = vue_c;
		
		//Associe butt vers la connexion client pour chaque hotel
		rendreJButtonVersConnexion_esp(vue_ensavoir_plus.getButt(),vue_ci_1);
	}
	
	public NavControlleur(Vue_prcp v_p,Seconnecter vue_c){
		this.vue_principale = v_p;
		this.vue_ci_1 = vue_c;
		
		//Associe butt vers la connexion client pour chaque hotel
		rendreJButtonVersConnexion_pr(vue_principale.getButt(),vue_ci_1);
		rendreJButtonVersConnexion_pr(vue_principale.getButt_m(),vue_ci_1);
	}
	
	//méthode pour associé les vues entre elle
	//rendre Label cliquable pour aller vers la vue prcp(pays)
	public void rendreCliquable_1(JLabel label, Vue_prcp cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vuePays.setVisible(false); 
				cible.setVisible(true); 
            }
        });
    }
	
	/*//rendre Label cliquable pour aller vers la vue prcp(vue reserv)
	public void rendreCliquable_rsrv(JLabel label, Vue_prcp cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vue_reserv.setVisible(false); 
				cible.setVisible(true); 
            }
        });
    }*/
	
	//rendre Label cliquable pour aller vers la vue prcp(hotel)
	public void rendreCliquable_2(JLabel label, Vue_prcp cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vueHotel.setVisible(false); 
				cible.setVisible(true); 
            }
        });
    }	
	
	//rendre Label cliquable pour aller vers la vue prcp(destinations recommandée)
	public void rendreCliquable_sel(JLabel label, Vue_prcp cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selections.setVisible(false); 
				cible.setVisible(true); 
            }
        });
    }	
	
	//rendre Label cliquable pour aller vers la vue prcp(continent)
	public void rendreCliquable_3(JLabel label, Vue_prcp cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vueContinent.setVisible(false); 
				cible.setVisible(true); 
            }
        });
    }
	
	//rendre Label cliquable pour aller vers la vue prcp(connect)
	public void rendreCliquable_ci(JLabel label, Vue_prcp cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vue_ci.setVisible(false); 
				cible.setVisible(true); 
            }
        });
    }
	
	//rendre Label cliquable pour aller vers la vue prcp(ensavoirplus)
	public void rendreCliquable_esp(JLabel label, Vue_prcp cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vue_ensavoir_plus.setVisible(false); 
				cible.setVisible(true); 
            }
        });
    }
	
	//rendre Label cliquable pour aller vers la vue prcp(vueprcp)
	public void rendreCliquable_pr(JLabel label, Vue_prcp cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vue_principale.setVisible(false); 
				cible.setVisible(true); 
            }
        });
    }
	
	// Méthode pour rendre un JButton cliquable(vue_rech) et aller vers une vue principale
	private void rendreJButtonVersConnexion_rch(JButton item, Vue_prcp cible) {
		item.addActionListener(e -> {
			vue_rech.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JButton cliquable(seconnecter) et aller vers une vue de connection utilisateur
	private void rendreJButtonVersConnexion_ci(JButton item, Seconnecter cible) {
		item.addActionListener(e -> {
			vue_ci.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	/*// Méthode pour rendre un JButton cliquable(reserv) et aller vers une vue de connection utilisateur
	private void rendreJButtonVersConnexion_rsrv(JButton item, Seconnecter cible) {
		item.addActionListener(e -> {
			vue_reserv.setVisible(false); 
			cible.setVisible(true);         
		});
	}*/
	
	// Méthode pour rendre un JButton cliquable(nos selections) et aller vers une vue de connection utilisateur
	private void rendreJButtonVersConnexion_sel(JButton item, Seconnecter cible) {
		item.addActionListener(e -> {
			selections.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JButton cliquable(nos selections) et aller vers une vue de connection utilisateur
	private void rendreJButtonVersConnexion_esp(JButton item, Seconnecter cible) {
		item.addActionListener(e -> {
			vue_ensavoir_plus.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JButton cliquable(continent) et aller vers une vue de connection utilisateur
	private void rendreJButtonVersConnexion_co(JButton item, Seconnecter cible) {
		item.addActionListener(e -> {
			vueContinent.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JButton cliquable(pays) et aller vers une vue de connection utilisateur
	private void rendreJButtonVersConnexion_pa(JButton item, Seconnecter cible) {
		item.addActionListener(e -> {
			vuePays.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JButton cliquable(principale) et aller vers une vue de connection utilisateur
	private void rendreJButtonVersConnexion_pr(JButton item, Seconnecter cible) {
		item.addActionListener(e -> {
			vue_principale.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JButton cliquable(hotel) et aller vers une vue de connection utilisateur
	private void rendreJButtonVersConnexion_ho(JButton item, Seconnecter cible) {
		item.addActionListener(e -> {
			vueHotel.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(seconnecter) et aller vers une vue Continent
	private void rendreMenuItemVersContinent_ci(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			vue_ci.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	/*// Méthode pour rendre un JMenuItem cliquable(reserv) et aller vers une vue Continent
	private void rendreMenuItemVersContinent_rsrv(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			vue_reserv.setVisible(false); 
			cible.setVisible(true);         
		});
	}*/
	
	// Méthode pour rendre un JMenuItem cliquable(pays) et aller vers une vue Continent
	private void rendreMenuItemVersContinent_1(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			vuePays.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(hotel) et aller vers une vue Continent
	private void rendreMenuItemVersContinent_2(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			vueHotel.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(destinations recommandée) et aller vers une vue Continent
	private void rendreMenuItemVersContinent_sel(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			selections.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(ensavoirplus) et aller vers une vue Continent
	private void rendreMenuItemVersContinent_esp(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			vue_ensavoir_plus.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(principale) et aller vers une vue Continent
	private void rendreMenuItemVersContinent_pr(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			vue_principale.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(principale) et aller vers une vue destinations
	private void rendreMenuItemVersDestinations_pr(JMenuItem item, Nos_selections_fa cible) {
		item.addActionListener(e -> {
			vue_principale.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	/*// Méthode pour rendre un JMenuItem cliquable(reserve) et aller vers une vue destinations
	private void rendreMenuItemVersDestinations_rsrv(JMenuItem item, Nos_selections_fa cible) {
		item.addActionListener(e -> {
			vue_reserv.setVisible(false); 
			cible.setVisible(true);         
		});
	}*/
	
	// Méthode pour rendre un JMenuItem cliquable(continent) et aller vers une vue Continent
	private void rendreMenuItemVersContinent(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			vueContinent.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(seconnecter) et aller vers une vue destinations
	private void rendreMenuItemVersDestinations_ci(JMenuItem item, Nos_selections_fa cible) {
		item.addActionListener(e -> {
			vue_ci.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(Continent) et aller vers une vue destinations
	private void rendreMenuItemVersDestinations_co(JMenuItem item, Nos_selections_fa cible) {
		item.addActionListener(e -> {
			vueContinent.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(Pays) et aller vers une vue destinations
	private void rendreMenuItemVersDestinations_pa(JMenuItem item, Nos_selections_fa cible) {
		item.addActionListener(e -> {
			vuePays.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JMenuItem cliquable(hotel) et aller vers une vue destinations
	private void rendreMenuItemVersDestinations_ho(JMenuItem item, Nos_selections_fa cible) {
		item.addActionListener(e -> {
			vueHotel.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	// Méthode pour rendre un JMenuItem cliquable(nosselections) et aller vers une vue destinations
	private void rendreMenuItemVersDestinations_sel(JMenuItem item, Nos_selections_fa cible) {
		item.addActionListener(e -> {
			selections.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	// Méthode pour rendre un JMenuItem cliquable(ensavoirplus) et aller vers une vue destinations
	private void rendreMenuItemVersDestinations_esp(JMenuItem item, Nos_selections_fa cible) {
		item.addActionListener(e -> {
			vue_ensavoir_plus.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	//méthode pour rendre un JMenu cliquable(ensavoirplus) et allers vers la vue en savoir plus
	private void rendreMenuItemVersSav_esp(JMenuItem menu, EnSavoirPlus cible){
		menu.addActionListener(e -> {
			vue_ensavoir_plus.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	//méthode pour rendre un JMenu cliquable(reserve) et allers vers la vue en savoir plus
	/*private void rendreMenuItemVersSav_rsrv(JMenuItem menu, EnSavoirPlus cible){
		menu.addActionListener(e -> {
			vue_reserv.setVisible(false); 
			cible.setVisible(true);         
		});
	}*/
	
	//méthode pour rendre un JMenu cliquable(continent) et allers vers la vue en savoir plus
	private void rendreMenuItemVersSav_co(JMenuItem menu, EnSavoirPlus cible){
		menu.addActionListener(e -> {
			vueContinent.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	//méthode pour rendre un JMenu cliquable(seconnecter) et allers vers la vue en savoir plus
	private void rendreMenuItemVersSav_ci(JMenuItem menu, EnSavoirPlus cible){
		menu.addActionListener(e -> {
			vue_ci.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	//méthode pour rendre un JMenu cliquable(prcp) et allers vers la vue en savoir plus
	private void rendreMenuItemVersSav_pr(JMenuItem menu, EnSavoirPlus cible){
		menu.addActionListener(e -> {
			vue_principale.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	//méthode pour rendre un JMenu cliquable(selections) et allers vers la vue en savoir plus
	private void rendreMenuItemVersSav_fa(JMenuItem menu, EnSavoirPlus cible){
		menu.addActionListener(e -> {
			selections.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	
	//méthode pour rendre un JMenu cliquable(pays) et allers vers la vue en savoir plus
	private void rendreMenuItemVersSav_pa(JMenuItem menu, EnSavoirPlus cible){
		menu.addActionListener(e -> {
			vuePays.setVisible(false); 
			cible.setVisible(true);         
		});
	}
	//méthode pour rendre un JMenu cliquable(hotel) et allers vers la vue en savoir plus
	private void rendreMenuItemVersSav_ho(JMenuItem menu, EnSavoirPlus cible){
		menu.addActionListener(e -> {
			vueHotel.setVisible(false); 
			cible.setVisible(true);         
		});
	}

	//méthode adaptée pour le lien entre Continent et pays car deux possibilités
	private void rendreCliquableVersPays(JLabel label, Vue_pays cible) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                allerVersVuePays(cible);
            }
        });
    }
	
	//rendre JLabel cliquable pour aller vers un hotel (pays)
    public void rendreCliquable(JLabel label) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                allerVersVueHotel();
            }
        });
    }
 
    private void allerVersVueHotel() {
        vuePays.setVisible(false); 
        vueHotel.setVisible(true); 
    }
	
	private void allerVersVuePays(Vue_pays cible) {
        vueContinent.setVisible(false); 
        cible.setVisible(true);       
    }
}  