package controlleur;
import vue.*;
import classe.*;
import model.*;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.ArrayList;


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
	private EnSavoirPlus vue_ensavoir_plus;
	private EnSavoirPlus vue_ensavoir_plus_1;
	private Vue_rsrv vue_reserv;
	private Vue_Resultats_Recherche vue_rech;
	private Vue_transition trans;
	private Vue_Chambre chambre;
	private ArrayList<Vue_Chambre> chambres;
	private ArrayList<RoundedPanel> panels;
	private Vue_gestion_rs reserv;
    
	//constructeur vuechambre -> vue transition 
	public NavControlleur(Vue_Chambre ch,Vue_transition trs){
		this.chambre = ch;
		this.trans = trs;
		
		rendreJButtonVerstransition(chambre.getbutt(),trans);
	}
	
	public NavControlleur(Vue_gestion_rs v_g,Vue_prcp vue_prc) {
        this.reserv = v_g;
		this.vue_principale_1 = vue_prc;
		
		rendreCliquable_gest(reserv.gettitre(),vue_principale_1);
    }
	
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
	
	//constructeur continent -> vue pays
	public NavControlleur(Continent Vue_c,Vue_pays vuep_1, Vue_pays vuep_2){
		this.vueContinent = Vue_c;
		this.vuePays = vuep_1;
		this.vuePays_2 = vuep_2;
		
		// Associe chaque label à sa vuePays
		rendreCliquableVersPays(vueContinent.getLabelPays_1(), vuePays); 
		rendreCliquableVersPays(vueContinent.getLabelPays_2(), vuePays_2);
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
	
	public NavControlleur(Seconnecter ci,Continent Vue_c1,Continent Vue_c2,Continent Vue_c3){
		this.vue_ci = ci;
		this.vueContinent_2 = Vue_c1;
		this.vueContinent_3 = Vue_c2;
		this.vueContinent_4 = Vue_c3;
		
		//Associe chaque menuitem à sa Vuecontinent
		rendreMenuItemVersContinent_ci(vue_ci.getRecDest1(),vueContinent_2);
		rendreMenuItemVersContinent_ci(vue_ci.getRecDest2(),vueContinent_3);
		rendreMenuItemVersContinent_ci(vue_ci.getRecDest3(),vueContinent_4);
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
	
	//controleur  -> sav 
	public NavControlleur(EnSavoirPlus vue_esp,EnSavoirPlus vue_sav){
		this.vue_ensavoir_plus = vue_esp;
		this.vue_ensavoir_plus_1 = vue_sav;
		
		//Associe JMenu à la vue en savoir plus
		rendreMenuItemVersSav_esp(vue_ensavoir_plus.get_sacv(),vue_ensavoir_plus_1);
	}
	
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
	public NavControlleur(Seconnecter v_ci, Seconnecter vue_c, Vue_gestion_rs v_gi) {
        this.vue_ci = v_ci;
        this.vue_ci_1 = vue_c;
        this.reserv = v_gi;
		
		if (vue_ci.getButt() != null) {
			vue_ci.getButt().addActionListener(e -> {
				vue_ci.setVisible(false);
				vue_ci_1.setVisible(true);
			});
		}

		if (vue_ci.getPanier() != null) {
			vue_ci.getPanier().addActionListener(e -> {
				vue_ci.setVisible(false);
				reserv.setVisible(true);
			});
		}

    }

    public NavControlleur(Continent v_c, Seconnecter vue_c, Vue_gestion_rs v_gi) {
        this.vueContinent = v_c;
        this.vue_ci_1 = vue_c;
        this.reserv = v_gi;

        if (vueContinent.getButt() != null) {
			vueContinent.getButt().addActionListener(e -> {
				vueContinent.setVisible(false);
				vue_ci_1.setVisible(true);
			});
		}

		if (vueContinent.getPanier() != null) {
			vueContinent.getPanier().addActionListener(e -> {
				vueContinent.setVisible(false);
				reserv.setVisible(true);
			});
		}
    }

    public NavControlleur(Vue_pays v_p, Seconnecter vue_c, Vue_gestion_rs v_gi) {
        this.vuePays = v_p;
        this.vue_ci_1 = vue_c;
        this.reserv = v_gi;

       if (vuePays.getButt() != null) {
			vuePays.getButt().addActionListener(e -> {
				vuePays.setVisible(false);
				vue_ci_1.setVisible(true);
			});
		}

		if (vuePays.getPanier() != null) {
			vuePays.getPanier().addActionListener(e -> {
				vuePays.setVisible(false);
				reserv.setVisible(true);
			});
		}
    }

    public NavControlleur(Vue_hotel v_h, Seconnecter vue_c, Vue_gestion_rs v_gi) {
        this.vueHotel = v_h;
        this.vue_ci_1 = vue_c;
        this.reserv = v_gi;

        if (vueHotel.getButt() != null) {
			vueHotel.getButt().addActionListener(e -> {
				vueHotel.setVisible(false);
				vue_ci_1.setVisible(true);
			});
		}

		if (vueHotel.getPanier() != null) {
			vueHotel.getPanier().addActionListener(e -> {
				vueHotel.setVisible(false);
				reserv.setVisible(true);
			});
		}
    }

    public NavControlleur(EnSavoirPlus v_s, Seconnecter vue_c, Vue_gestion_rs v_gi) {
        this.vue_ensavoir_plus = v_s;
        this.vue_ci_1 = vue_c;
        this.reserv = v_gi;

        if (vue_ensavoir_plus.getButt() != null) {
			vue_ensavoir_plus.getButt().addActionListener(e -> {
				vue_ensavoir_plus.setVisible(false);
				vue_ci_1.setVisible(true);
			});
		}

		if (vue_ensavoir_plus.getPanier() != null) {
			vue_ensavoir_plus.getPanier().addActionListener(e -> {
				vue_ensavoir_plus.setVisible(false);
				reserv.setVisible(true);
			});
		}
    }

    public NavControlleur(Vue_prcp v_p, Seconnecter vue_c, Vue_gestion_rs v_gi) {
        this.vue_principale = v_p;
        this.vue_ci_1 = vue_c;
        this.reserv = v_gi;

       	if (vue_principale.getButt() != null) {
			vue_principale.getButt().addActionListener(e -> {
				vue_principale.setVisible(false);
				vue_ci_1.setVisible(true);
			});
		}

		if (vue_principale.getPanier() != null) {
			vue_principale.getPanier().addActionListener(e -> {
				vue_principale.setVisible(false);
				reserv.setVisible(true);
			});
		}
    }
	
	private void rendreCliquable_gest(JLabel label, Vue_prcp vue_principale) {
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vue_principale.setVisible(true);
			}
		});
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
	
	// Méthode pour rendre un JButton cliquable(chambre) et aller vers une vue de transition 
	private void rendreJButtonVerstransition(JButton item, Vue_transition cible) {
		item.addActionListener(e -> {
			chambre.setVisible(true); 
			cible.setVisible(true);         
		});
	}
	
	// Méthode pour rendre un JButton cliquable(sav) et aller vers une vue de connection utilisateur
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
	
	// Méthode pour rendre un JMenuItem cliquable(continent) et aller vers une vue Continent
	private void rendreMenuItemVersContinent(JMenuItem item, Continent cible) {
		item.addActionListener(e -> {
			vueContinent.setVisible(false); 
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