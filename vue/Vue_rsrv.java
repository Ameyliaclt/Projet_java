package vue;
import controlleur.*;
import classe.*;
import model.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Graphics;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.geom.RoundRectangle2D;
import java.lang.Object;
import java.awt.geom.RectangularShape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Vue_rsrv extends JFrame{
	public Reservation rsrv;

	JPanel main = new JPanel(); //Panel principal.

	//Eléments pour la menubar.
	JMenuBar bar = new JMenuBar();
	JMenu dest = new JMenu("Destinations");
	JMenu sav = new JMenu("En savoir plus");
	JMenuItem sav_i = new JMenuItem("Questions fréquentes/règlement");
	JMenuItem rec_dest1 = new JMenuItem("Voyagez en Asie");
	JMenuItem rec_dest2 = new JMenuItem("Voyagez en Europe");
	JMenuItem rec_dest3 = new JMenuItem("Voyagez en Afrique");

	JPanel content = new JPanel(); //Panel du contenu.
	JPanel p1 = new JPanel(); //Panel de gauche.
	JPanel p2 = new JPanel(); //Panel de droite.

	//Création des panels pour l'affichage du panel en (1,1) => (ligne, colonne)
	JPanel details = new RoundedPanel(20); //Panel (1,1).
	JPanel details_h = new JPanel(); //Panel pour les détails de l'hôtel.
	JPanel details_ch = new JPanel(); //Panel pour les détails des chambres.

	//Création des panels pour l'affichage du panel en (2,1).
	JPanel horaires_nbP = new RoundedPanel(20); //Panel (2,1).
	JPanel horaires = new JPanel(); //Panel des horaires et dates.
	JPanel ar_dep = new JPanel(); //Panel des dates et heures d'arrivée et de départ.
	JPanel ar = new JPanel(); //Panel de date et heure d'arrivée.
	JPanel sep_ad = new JPanel(); //Séparateur entre arr et dep.
	JPanel dep = new JPanel(); //Panel date et heure de départ.
	JPanel sep_h = new JPanel(); //Séparateur entre horaires et nb_p.
	JPanel nb_p = new JPanel(); //Panel nombre de personne.

	//Création des panels pour l'affichage du panel (3,1).
	JPanel montants = new RoundedPanel(20); //Panel (3,1).
	JPanel montant = new JPanel();//Panel des montants.
	
	//Création des paneks pour l'affichage du panel (1,2);
	JPanel infos = new RoundedPanel(20); //Panel (1,2).
	JPanel infos_clt = new JPanel(); //Panel des informations client.
	JPanel pnm_nm = new JPanel(); //Panel des noms et prénoms.
	JPanel tel_mail = new JPanel(); //Panel des numéro de téléphone et mail.
	JPanel qui = new JPanel(); //Panel du choix de personne qui fait la réservation.
	JPanel p_qui = new JPanel(); //Panel pour les boutons du panel précédent.
	JPanel work = new JPanel(); //Panel du choix de si la réservation se fait pour le travail ou non.
	JPanel p_work = new JPanel(); //Panel des boutons du panel précédent.

	//Création des panels pour l'affichage du panel (2,2).
	JPanel paiement = new RoundedPanel(20); //Panel (2,2).
	JPanel infos_p = new JPanel(); //Panel textuels des informations de paiements.
	JPanel sep_p = new JPanel(); //Séparateur entre infos_p et infos_b.
	JPanel infos_b = new JPanel(); //Panel des JTextField des coordonnées bancaires.
	JPanel date_code = new JPanel(); //Panel pour mettre cote à cote la date d'expiration et le code (JTextField).
	
	//JLabel du panel (1,1).
	JLabel detail;
	JLabel title_h;
	JLabel infos_h;
	JLabel title_ch;
	JLabel infos_ch;

	JLabel title_ar;
	JLabel date_ar;
	JLabel heure_ar;
	JLabel title_dep;
	JLabel date_dep;
	JLabel heure_dep;

	JLabel duree;
	
	JLabel title_pe;
	JLabel infos_pe;

	JLabel title_m;
	JLabel details_pch;
	JLabel infos_m;
	JLabel total_m;

	JLabel title_i;
	JLabel pnm_c;
	JLabel nm_c;
	JLabel tel_c;
	JLabel mail_c;
	JLabel quest_qui;
	JLabel quest_work;

	JLabel title_p;
	JLabel info_p;
	JLabel title_b;

	public JCheckBox confirm;

	JTextField num_carte;
	JTextField date;
	JTextField code;
	JTextField intitule;

	ButtonGroup bg_qui = new ButtonGroup();
	ButtonGroup bg_work = new ButtonGroup();

	JRadioButton rb_qui1;
	JRadioButton rb_qui2;
	JRadioButton rb_w1;
	JRadioButton rb_w2;
	JButton butt; 
	public JButton validation;

	JPanel mt_legl = new JPanel();
	public void refreshConnectionStatus() {
        // Met à jour le bouton de connexion avec le statut actuel
        SessionUtil.updateConnectionStatus(butt);
    }

	public Vue_rsrv(Reservation r){
		rsrv = r;

		Dimension t_scr = Toolkit.getDefaultToolkit().getScreenSize();
	
		bar.setPreferredSize(new Dimension(90,91));

		ImageIcon icon = new ImageIcon("images//icone_site.png");
		Image image = icon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		JLabel iconLabel = new JLabel(new ImageIcon(image));
	
		JLabel titre = new JLabel("RoomBloom");
		titre.setForeground(new Color(0,0,0));
		titre.setFont(new Font("Georgia", Font.ITALIC, 20));

		butt = new JButton("Me connecter/ M'inscrire");
		butt.setBackground(new Color(245,245,245));
		butt.setFocusPainted(false);
		SessionUtil.updateConnectionStatus(butt);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                refreshConnectionStatus();
            }
        });

		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(2,40));
		separator.setMaximumSize(new Dimension(2,40));
		separator.setBackground(Color.GRAY);
		
		this.setJMenuBar(bar);
		bar.setBackground(Color.WHITE);
		bar.add(Box.createHorizontalStrut(15));

		bar.add(iconLabel);
		bar.add(Box.createHorizontalStrut(10));
	
		bar.add(titre);
		bar.add(Box.createHorizontalStrut(25));

		bar.add(separator);
		bar.add(Box.createHorizontalStrut(25));

		bar.add(dest);
		dest.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(rec_dest1);
		rec_dest1.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(new JSeparator(SwingConstants.HORIZONTAL));
		dest.add(rec_dest2);
		rec_dest2.setFont(new Font("Georgia", Font.PLAIN, 12));
		dest.add(new JSeparator(SwingConstants.HORIZONTAL));
		dest.add(rec_dest3);
		rec_dest3.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(10));
		
		bar.add(sav);
		sav.setFont(new Font("Georgia", Font.PLAIN, 12));
		sav.add(sav_i);
		bar.add(Box.createVerticalStrut(0));

		bar.add(Box.createVerticalStrut(0));
		bar.add(butt);
		butt.setFont(new Font("Georgia", Font.PLAIN, 12));
		bar.add(Box.createHorizontalStrut(15));
		
		main.setLayout(new BorderLayout());
		content.setLayout(new FlowLayout());
		content.setBackground(new Color(241,250,247));

		p1.setLayout(new GridLayout(3,1,(int)((double)t_scr.getWidth()*0.005),(int)((double)t_scr.getWidth()*0.005)));
		p1.setBackground(new Color(241,250,247));
		p1.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()*0.4), (int)((double)t_scr.getHeight())));
		p1.setBorder(new EmptyBorder((int)((double)t_scr.getWidth()*0.005), (int)((double)t_scr.getWidth()*0.005), (int)((double)t_scr.getWidth()*0.005), (int)((double)t_scr.getWidth()*0.005)));

		p2.setLayout(new GridLayout(2,1,(int)((double)t_scr.getWidth()*0.005),(int)((double)t_scr.getWidth()*0.005)));
		p2.setBackground(new Color(241,250,247));
		p2.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()*0.58), (int)((double)t_scr.getHeight())));
		p2.setBorder(new EmptyBorder((int)((double)t_scr.getWidth()*0.005), (int)((double)t_scr.getWidth()*0.005), (int)((double)t_scr.getWidth()*0.005), (int)((double)t_scr.getWidth()*0.005)));

		details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
		details.setBackground(Color.WHITE);
		details.setBorder(new RoundBorder(20, new Color(240,240,240)));

		detail = new JLabel("<html> Détails de la réservation <br> <br> </html>");
		detail.setFont(new Font("Georgia", Font.PLAIN, 16));
		detail.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		details.add(detail);

		details_h.setLayout(new BoxLayout(details_h, BoxLayout.Y_AXIS));
		details_h.setBackground(Color.WHITE);

		title_h = new JLabel("<html> Détails hôtel : <br> <br> </html>");
		title_h.setFont(new Font("Georgia", Font.PLAIN, 14));
		title_h.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		details_h.add(title_h);

		infos_h = new JLabel("<html> Nom de l'hôtel : "+ rsrv.hotel.nm_h+"<br> Adresse de l'hôtel : "+ rsrv.hotel.ad_p_h+"<br> Piscine : "+piscine()+" <br> </html>");
		infos_h.setFont(new Font("Georgia", Font.PLAIN, 12));
		infos_h.setPreferredSize(new Dimension((int)t_scr.getWidth(), 20));
		infos_h.setMinimumSize(new Dimension((int)t_scr.getWidth(), 20)); 
		infos_h.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		details_h.add(infos_h);

		details.add(details_h);

		details_ch.setLayout(new BoxLayout(details_ch, BoxLayout.Y_AXIS));
		details_ch.setBackground(Color.WHITE);

		title_ch = new JLabel("<html> <br> Détails "+ nb_chambre()+"<br> <br> </html>");
		title_ch.setFont(new Font("Georgia", Font.PLAIN, 14));
		title_ch.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		details_ch.add(title_ch);

		infos_ch = new JLabel(details_cha());
		infos_ch.setFont(new Font("Georgia", Font.PLAIN, 12));
		infos_ch.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		details_ch.add(infos_ch);

		details.add(details_ch);

		p1.add(details);

		horaires_nbP.setLayout(new BoxLayout(horaires_nbP,BoxLayout.Y_AXIS));
		horaires_nbP.setBackground(Color.WHITE);
		horaires_nbP.setBorder(new RoundBorder(20, new Color(240,240,240)));

		horaires.setLayout(new BoxLayout(horaires, BoxLayout.Y_AXIS));
		horaires.setBackground(Color.WHITE);

		ar_dep.setLayout(new BoxLayout(ar_dep, BoxLayout.X_AXIS));
		ar_dep.setBackground(Color.WHITE);

		ar.setLayout(new BoxLayout(ar, BoxLayout.Y_AXIS));
		ar.setBackground(Color.WHITE);
		ar.setPreferredSize(new Dimension(270, 62));
		ar.setMinimumSize(new Dimension(270,62));
		ar.setMaximumSize(new Dimension(270,62));

		title_ar = new JLabel("<html> Arrivée <br> <br> </html>");
		title_ar.setFont(new Font("Georgia", Font.PLAIN, 14));
		title_ar.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		ar.add(title_ar);

		date_ar = new JLabel("<html> Date : "+rsrv.date_r_d.jr+" "+rsrv.date_r_d.mois+" "+rsrv.date_r_d.annee+"</html>");
		date_ar.setFont(new Font("Georgia", Font.PLAIN, 12));
		date_ar.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		ar.add(date_ar);

		heure_ar = new JLabel("<html> Heure : "+rsrv.date_r_d.ifZero_h(rsrv.date_r_d)+""+rsrv.date_r_d.heure+"h"+rsrv.date_r_d.ifZero_m(rsrv.date_r_d)+""+rsrv.date_r_d.minute+"</html>");
		heure_ar.setFont(new Font("Georgia", Font.PLAIN, 12));
		heure_ar.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		ar.add(heure_ar);

		ar_dep.add(ar);

		sep_ad.setPreferredSize(new Dimension(2, (int)t_scr.getHeight()));
		sep_ad.setMaximumSize(new Dimension(2, (int)t_scr.getHeight()));
		sep_ad.setBackground(new Color(240,240,240));
		ar_dep.add(sep_ad);

		dep.setLayout(new BoxLayout(dep, BoxLayout.Y_AXIS));
		dep.setBackground(Color.WHITE);
		dep.setPreferredSize(new Dimension(286, 62));
		dep.setMinimumSize(new Dimension(286,62));
		dep.setMaximumSize(new Dimension(286,62));

		title_dep = new JLabel("<html> &emsp &ensp Départ <br> <br> </html>");
		title_dep.setFont(new Font("Georgia", Font.PLAIN, 14));
		dep.add(title_dep);

		date_dep = new JLabel("<html> &emsp &emsp Date : "+rsrv.date_r_f.jr+" "+rsrv.date_r_f.mois+" "+rsrv.date_r_f.annee+"</html>");
		date_dep.setFont(new Font("Georgia", Font.PLAIN, 12));
		dep.add(date_dep);

		heure_dep = new JLabel("<html> &emsp &emsp Heure : "+rsrv.date_r_f.ifZero_h(rsrv.date_r_f)+""+rsrv.date_r_f.heure+"h"+rsrv.date_r_f.ifZero_m(rsrv.date_r_f)+""+rsrv.date_r_f.minute+"</html>");
		heure_dep.setFont(new Font("Georgia", Font.PLAIN, 12));
		dep.add(heure_dep);

		ar_dep.add(dep);

		horaires.add(ar_dep);

		duree = new JLabel("<html> <br> <br> Durée du séjour : "+rsrv.date_r_f.calcul_d(rsrv.date_r_d,rsrv.date_r_f)+" nuits. <br> <br> </html>");
		duree.setFont(new Font("Georgia", Font.PLAIN, 12));
		duree.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		horaires.add(duree);

		horaires_nbP.add(horaires);

		sep_h.setBackground(new Color(240,240,240));
		sep_h.setPreferredSize(new Dimension((int)t_scr.getWidth(), 2));
		sep_h.setMaximumSize(new Dimension((int)t_scr.getWidth(), 2));
		sep_h.setMinimumSize(new Dimension((int)t_scr.getWidth(), 2));
		sep_h.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		horaires_nbP.add(sep_h);

		nb_p.setLayout(new BoxLayout(nb_p, BoxLayout.Y_AXIS));
		nb_p.setBackground(Color.WHITE);

		title_pe = new JLabel("<html> <br> Nombre de personnes : <br> <br> </html>");
		title_pe.setFont(new Font("Georgia", Font.PLAIN, 14));
		title_pe.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		nb_p.add(title_pe);

		int nb_perso[] = nb_pe();
		infos_pe = new JLabel("<html> Adultes : "+nb_perso[1]+"<br> Enfants : "+nb_perso[2]+"<br> Total : "+nb_perso[0]+"</html>");
		infos_pe.setFont(new Font("Georgia", Font.PLAIN, 12));
		infos_pe.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		nb_p.add(infos_pe);

		horaires_nbP.add(nb_p);

		p1.add(horaires_nbP);

		montants.setLayout(new BoxLayout(montants, BoxLayout.Y_AXIS));
		montants.setBackground(Color.WHITE);
		montants.setBorder(new RoundBorder(20, new Color(240,240,240)));

		montant.setLayout(new BoxLayout(montant, BoxLayout.Y_AXIS));
		montant.setBackground(Color.WHITE);

		title_m = new JLabel("<html> Récapitulatif des montants <br> <br> </html>");
		title_m.setFont(new Font("Georgia", Font.PLAIN, 16));
		montant.add(title_m);

		details_pch = new JLabel("<html> Détail des montants par chambre : <br> <br> </html>");
		details_pch.setFont(new Font("Georgia", Font.PLAIN, 14));
		montant.add(details_pch);

		infos_m = new JLabel(recap_m(rsrv.prix_r));
		infos_m.setFont(new Font("Georgia", Font.PLAIN, 12));
		montant.add(infos_m);
	
		total_m = new JLabel("<html> <br> Total : "+rsrv.prix_r[rsrv.chmb_r.length]+"€. </html>");
		total_m.setFont(new Font("Georgia", Font.PLAIN, 14));
		montant.add(total_m);

		montants.add(montant);

		p1.add(montants);

		infos.setLayout(new GridLayout(5,1,20,20));
		infos.setBackground(Color.WHITE);
		infos.setBorder(new RoundBorder(20, new Color(240,240,240)));

		title_i = new JLabel("Informations client");
		title_i.setFont(new Font("Georgia", Font.PLAIN, 16));
		infos.add(title_i);

		infos_clt.setLayout(new GridLayout(3,1,(int)((double)t_scr.getWidth()*0.003),(int)((double)t_scr.getWidth()*0.003)));
		infos_clt.setBackground(Color.WHITE);

		pnm_nm.setLayout(new GridLayout(1,2,(int)((double)t_scr.getWidth()*0.05),(int)((double)t_scr.getWidth()*0.05)));
		pnm_nm.setBackground(Color.WHITE);

		pnm_c = new JLabel("<html>"+rsrv.client.pnm_cl+"</html>");
		pnm_c.setFont(new Font("Georgia", Font.PLAIN, 12));
		pnm_nm.add(pnm_c);

		nm_c = new JLabel("<html>"+rsrv.client.nm_cl+"</html>");
		nm_c.setFont(new Font("Georgia", Font.PLAIN, 12));
		pnm_nm.add(nm_c);

		infos_clt.add(pnm_nm);

		tel_mail.setLayout(new GridLayout(1,2,(int)((double)t_scr.getWidth()*0.05),(int)((double)t_scr.getWidth()*0.05)));
		tel_mail.setBackground(Color.WHITE);

		tel_c = new JLabel("<html>"+r.client.num_t_cl+"</html>");
		tel_c.setFont(new Font("Georgia", Font.PLAIN, 12));
		tel_mail.add(tel_c);

		mail_c = new JLabel("<html>"+r.client.ad_m_cl+"</html>");
		mail_c.setFont(new Font("Georgia", Font.PLAIN, 12));
		tel_mail.add(mail_c);

		infos_clt.add(tel_mail);

		infos.add(infos_clt);

		confirm = new JCheckBox(" Confirmer la réservation.");
		confirm.setIcon(new ImageIcon("images//case.png"));
		confirm.setSelectedIcon(new ImageIcon("images//case_c_good.png"));
		confirm.setFont(new Font("Georgia", Font.PLAIN, 12));
		confirm.setBackground(Color.WHITE);
		infos.add(confirm);

		qui.setLayout(new GridLayout(2,1));
		qui.setBackground(Color.WHITE);

		quest_qui = new JLabel("Pour qui réservez-vous ?");
		quest_qui.setFont(new Font("Georgia", Font.PLAIN, 13));
		qui.add(quest_qui);

		p_qui.setLayout(new GridLayout(2,1));
		p_qui.setBackground(Color.WHITE);

		rb_qui1 = new JRadioButton("Pour moi.");
		rb_qui1.setFont(new Font("Georgia", Font.PLAIN, 12));
		rb_qui1.setBackground(Color.WHITE);
		rb_qui1.setIcon(new ImageIcon("images//case_rond.png"));
		rb_qui1.setSelectedIcon(new ImageIcon("images//case_rond_good.png"));		bg_qui.add(rb_qui1);
		p_qui.add(rb_qui1);

		rb_qui2 = new JRadioButton("Pour quelqu'un d'autre.");
		rb_qui2.setFont(new Font("Georgia", Font.PLAIN, 12));
		rb_qui2.setBackground(Color.WHITE);
		rb_qui2.setIcon(new ImageIcon("images//case_rond.png"));
		rb_qui2.setSelectedIcon(new ImageIcon("images//case_rond_good.png"));
		bg_qui.add(rb_qui2);
		p_qui.add(rb_qui2);
		
		qui.add(p_qui);

		infos.add(qui);

		work.setLayout(new GridLayout(2,1));
		work.setBackground(Color.WHITE);

		quest_work = new JLabel("Réservez-vous pour le travail ?");
		quest_work.setFont(new Font("Georgia", Font.PLAIN, 13));
		work.add(quest_work);

		p_work.setLayout(new BoxLayout(p_work, BoxLayout.X_AXIS));
		p_work.setBackground(Color.WHITE);

		rb_w1 = new JRadioButton("Oui");
		rb_w1.setFont(new Font("Georgia", Font.PLAIN, 12));
		rb_w1.setBackground(Color.WHITE);
		rb_w1.setIcon(new ImageIcon("images//case_rond.png"));
		rb_w1.setSelectedIcon(new ImageIcon("images//case_rond_good.png"));
		bg_work.add(rb_w1);
		p_work.add(rb_w1);

		rb_w2 = new JRadioButton("Non");
		rb_w2.setFont(new Font("Georgia", Font.PLAIN, 12));
		rb_w2.setBackground(Color.WHITE);
		rb_w2.setIcon(new ImageIcon("images//case_rond.png"));
		rb_w2.setSelectedIcon(new ImageIcon("images//case_rond_good.png"));
		bg_work.add(rb_w2);
		p_work.add(rb_w2);

		work.add(p_work);

		infos.add(work);

		p2.add(infos);

		paiement.setLayout(new BoxLayout(paiement, BoxLayout.Y_AXIS));
		paiement.setBackground(Color.WHITE);
		paiement.setBorder(new RoundBorder(20, new Color(240,240,240)));

		infos_p.setLayout(new BoxLayout(infos_p, BoxLayout.Y_AXIS));
		infos_p.setBackground(Color.WHITE);

		title_p = new JLabel("<html> Informations paiement <br> <br> </html>");
		title_p.setFont(new Font("Georgia", Font.PLAIN, 14));
		title_p.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		infos_p.add(title_p);

		info_p = new JLabel("<html> Vous pouvez confirmer et modifier la réservation jusqu'à 2 semaines avant la date prévue. <br> Le paiement se fera au moment de votre séjour, auprès de l'accueil de votre hôtel. Nous prenons vos coordonnées bancaires en guise de garantie de paiement. <br> Vous pourrez payer par carte, en espèces ou par chèque. <br> <br> <br> <br> </html>");
		info_p.setFont(new Font("Georgia", Font.PLAIN, 12));
		info_p.setMinimumSize(new Dimension((int)((double)t_scr.getWidth()*2), (int)((double)t_scr.getHeight()*0.12)));
		info_p.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		infos_p.add(info_p);

		paiement.add(infos_p);

		sep_p.setBackground(new Color(240,240,240));
		sep_p.setPreferredSize(new Dimension((int)t_scr.getWidth(), 2));
		sep_p.setMaximumSize(new Dimension((int)t_scr.getWidth()*3, 2));
		sep_p.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		paiement.add(sep_p);

		title_b = new JLabel("<html> <br> <br> Coordonnées bancaires <br> <br> </html>");
		title_b.setFont(new Font("Georgia", Font.PLAIN, 14));
		title_b.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		paiement.add(title_b);

		infos_b.setLayout(new GridLayout(3,1,(int)((double)t_scr.getWidth()*0.003),(int)((double)t_scr.getWidth()*0.003)));
		infos_b.setBorder(new EmptyBorder((int)((double)t_scr.getHeight()*0.02), 0, (int)((double)t_scr.getHeight()*0.04), (int)((double)t_scr.getWidth()*0.3)));
		infos_b.setBackground(Color.WHITE);

		num_carte = new JTextField("  Numéro de carte.");
		num_carte.setFont(new Font("Georgia", Font.PLAIN, 12));
		SearchFieldController search_num_carte = new SearchFieldController(num_carte, "  Numéro de carte.", Color.BLACK, Color.BLACK);
		num_carte.addFocusListener(search_num_carte);
		infos_b.add(num_carte);

		date_code.setLayout(new GridLayout(1,2,(int)((double)t_scr.getWidth()*0.05),(int)((double)t_scr.getWidth()*0.05)));
		date_code.setBackground(Color.WHITE);

		date = new JTextField("  Date d'expiration.");
		date.setFont(new Font("Georgia", Font.PLAIN, 12));
		SearchFieldController search_date = new SearchFieldController(date, "  Date d'expiration.", Color.BLACK, Color.BLACK);
		date.addFocusListener(search_date);
		date_code.add(date);

		code = new JTextField("  Code.");
		code.setFont(new Font("Georgia", Font.PLAIN, 12));
		SearchFieldController search_code = new SearchFieldController(code, "  Code.", Color.BLACK, Color.BLACK);
		code.addFocusListener(search_code);
		date_code.add(code);

		infos_b.add(date_code);

		intitule = new JTextField("  Intitulé.");
		intitule.setFont(new Font("Georgia", Font.PLAIN, 12));
		SearchFieldController search_intitule = new SearchFieldController(intitule, "  Intitulé.", Color.BLACK, Color.BLACK);
		intitule.addFocusListener(search_intitule);
		infos_b.add(intitule);

		paiement.add(infos_b);

		validation = new JButton("Valider");
		validation.setFont(new Font("Georgia", Font.PLAIN, 12));
		validation.setBackground(new Color(245,245,245));
		validation.setFocusPainted(false);
		validation.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		paiement.add(validation);

		p2.add(paiement);

		content.add(p1);
		content.add(p2);
		main.add(content, BorderLayout.CENTER);
	
		mt_legl.setLayout(new GridLayout(4,4));
		ImageIcon icon_mt = new ImageIcon("images//icone_site.png");
		Image image_mt = icon_mt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel iconLabel_mt = new JLabel(new ImageIcon(image_mt));
		
		JLabel texte_ml_1 = new JLabel("RoomBloom");
		JLabel texte_ml_2 = new JLabel("97 rue George Leclerc");
		JLabel texte_ml_3 = new JLabel("33800 Bordeaux");
		JLabel texte_ml_4 = new JLabel("Accueil");
		JLabel texte_ml_5 = new JLabel("En savoir plus");
		JLabel texte_ml_6 = new JLabel("Où voyager ?");
		JLabel texte_ml_7 = new JLabel("Voyager en Europe");

		JLabel texte_ml_8 = new JLabel("Voyager en Asie");
		//texte_ml_8.addActionListener(asieController);

		JLabel texte_ml_9 = new JLabel("Voyager en Afrique");
		JLabel texte_ml_10 = new JLabel("Nous contacter");
		JLabel texte_ml_11 = new JLabel("Instagram : @RoomBloom_fr");
		JLabel texte_ml_12 = new JLabel("Facebook : @RoomBloom_fr");
		JLabel texte_ml_13 = new JLabel("X : @RoomBloom_fr");

		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_1);
		mt_legl.add(texte_ml_4);
		mt_legl.add(texte_ml_6);
		mt_legl.add(texte_ml_10);
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_2);
		mt_legl.add(texte_ml_5);
		mt_legl.add(texte_ml_7);
		mt_legl.add(texte_ml_11);

		mt_legl.add(iconLabel_mt);
		mt_legl.add(texte_ml_3);
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_8);
		mt_legl.add(texte_ml_12);
		
		mt_legl.add(new JLabel(" "));
		mt_legl.add(new JLabel(" "));
		mt_legl.add(new JLabel(" "));

		mt_legl.add(texte_ml_9);
		mt_legl.add(texte_ml_13);
		mt_legl.setBackground(Color.LIGHT_GRAY);

		main.add(mt_legl, BorderLayout.SOUTH);
		//Création de la scrollPane. 
		UIManager.put("ScrollBar.width", 0); 
		JScrollPane scroll = new JScrollPane(main);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.getVerticalScrollBar().setBlockIncrement(64);
		scroll.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()), (int)((double)t_scr.getHeight())));

		
		this.getContentPane().add(scroll);
	}

	class RoundBorder implements Border{
		private int r;
		private Color col;
    		RoundBorder(int r, Color col) {
        		this.r = r;
			this.col = col;
    		}
    			
		public Insets getBorderInsets(Component c) {
        		return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    		}
    			
		public boolean isBorderOpaque() {
        		return true;
    		}
    			
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.setColor(this.col);
        		g.drawRoundRect(x, y, width-1, height-1, r, r);
    		}
	}

	public void updateInfos(Reservation r){
		this.rsrv = r;

		infos_h.setText("<html> Nom de l'hôtel : "+rsrv.hotel.nm_h+"<br> Adresse de l'hôtel : "+rsrv.hotel.ad_p_h+"<br> Piscine : "+piscine()+"<br> </html>");
		title_ch.setText("<html> <br> Détails "+nb_chambre()+"<br> <br> </html>");
		infos_ch.setText(details_cha());

		date_ar.setText("<html> Date : "+rsrv.date_r_d.jr+" "+rsrv.date_r_d.mois+" "+rsrv.date_r_d.annee+"</html>");
		heure_ar.setText("<html> Heure : "+rsrv.date_r_d.ifZero_h(rsrv.date_r_d)+""+rsrv.date_r_d.heure+"h"+rsrv.date_r_d.ifZero_m(rsrv.date_r_d)+""+rsrv.date_r_d.minute+"</html>");
		date_dep.setText("<html> &emsp &emsp Date : "+rsrv.date_r_f.jr+" "+rsrv.date_r_f.mois+" "+rsrv.date_r_f.annee+"</html>");
		heure_dep.setText("<html> &emsp &emsp Heure : "+rsrv.date_r_f.ifZero_h(rsrv.date_r_f)+""+rsrv.date_r_f.heure+"h"+rsrv.date_r_f.ifZero_m(rsrv.date_r_f)+""+rsrv.date_r_f.minute+"</html>");
		duree.setText("<html> <br> <br> Durée du séjour : "+rsrv.date_r_d.calcul_d(rsrv.date_r_d, rsrv.date_r_f)+" nuits. <br> <br> </html>");

		int[] nb_perso = nb_pe();
		infos_pe.setText("<html> Adultes : "+nb_perso[1]+"<br> Enfants : "+nb_perso[2]+"<br> Total : "+nb_perso[0]+"</html>");

		infos_m.setText(recap_m(rsrv.prix_r));
		total_m.setText("<html> <br> Total : "+rsrv.prix_r[rsrv.chmb_r.length]+"€. </html>");

		pnm_c.setText("<html>"+rsrv.client.pnm_cl+"</html>");
		nm_c.setText("<html>"+rsrv.client.nm_cl+"</html>");
		tel_c.setText("<html>"+rsrv.client.num_t_cl+"</html>");
		mail_c.setText("<html>"+rsrv.client.ad_m_cl+"</html>");

		this.revalidate();
		this.repaint();
	}

	public String piscine(){
		if(rsrv.hotel.piscine) return "Oui";
		else return "Non";
	}

	public String nb_chambre(){
		if(rsrv.chmb_r.length > 1) return "des chambres ";
		else return "de la chambre ";
	}

	public String details_cha(){
		String dc = "<html> ";
		
		for(int i = 0; i < rsrv.chmb_r.length; i++){
			dc += " Chambre "+rsrv.chmb_r[i].thm_ch+" : "+rsrv.chmb_r[i].t_ch+" à "+rsrv.chmb_r[i].prix+"€. <br>";
		}
		
		dc += "</html>";
		return dc;
	}

	public int[] nb_pe(){
		int nb[] = {0, 0, 0};

		for(int i = 0; i <rsrv.chmb_r.length; i++){
			if((rsrv.chmb_r[i].t_ch.compareTo("Chambre double")) == 0){
				nb[0] += 3;
				nb[1] += 2;
				nb[2] += 1;
			}
			
			else{
				nb[0] += 2;
				nb[1] += 2;
			}
		}
	
		return nb;
	}

	public String recap_m(float[] mt_n){
		String t_mt = "<html>";

		for(int i = 0; i < rsrv.chmb_r.length; i++){
			t_mt += " &emsp Chambre "+rsrv.chmb_r[i].thm_ch+" : <br>";

			for(int j = 0; j < 11; j++){
				t_mt += "----";
			}

			t_mt += " &nbsp Prix à la nuit : "+rsrv.chmb_r[i].prix+"€ &emsp |";
			t_mt += " &emsp Total du séjour : "+rsrv.prix_r[i]+"€ <br>";
		}
	
		return t_mt;
	}
	public Reservation getReservation() {
		return this.rsrv;
	}
}