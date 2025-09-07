package classe;
import controlleur.*;
import vue.*;
import model.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Date {
    public int jr;
    public String mois;
    public int annee;
	public int heure;
	public int minute;
	public String[] tab_mois = {"","janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"};
	public String[] tab_english = {"","january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};

    	public Date (int jr_d, int mois_d, int annee_d, int heure_d, int minute_d){
        	this.annee = annee_d;

		if(0 < mois_d){
			if(mois_d <= 12) this.mois = this.tab_mois[mois_d];
			else{
				this.mois = this.tab_mois[12];
				System.out.println("Erreur sur la saisie du mois (trop grand), le mois a été changé à décembre.");
			}
		}
		else{
			this.mois = this.tab_mois[1];
			System.out.println("Erreur sur la saisie du mois (trop petit), le mois a été changé à janvier.");
		}

		if(jr_d > 0){
			if(jr_d <= 28) this.jr = jr_d;
			else{
				if(!isLeapYear(annee_d) && (mois_d == 2)){
					this.jr = 28;
					System.out.println("Erreur sur la saisie du jour pour le mois de février (trop grand, année non bissextile), il a été changé au 28.");
				}
				else if(jr_d <= 29) this.jr = jr_d;
				else{
					if(mois_d == 2){
						this.jr = 29;
						System.out.println("Erreur sur la saisie du jour pour le mois de février (trop grand, année bissextile), il a été changé au 29.");
					}
					else if(jr_d <= 30) this.jr = jr_d;
					else{
						if((mois_d == 4)||(mois_d == 6)||(mois_d == 9)||(mois_d == 11)){
							this.jr = 30;
							System.out.println("Erreur sur la saisie du jour pour les mois d'avril, juin, septembre et novembre (trop grand), il a été changé au 30.");
						}
						else if(jr_d <= 31) this.jr = jr_d;
						else{ 
							this.jr = 31;
							System.out.println("Erreur sur la saisie du jour pour les mois de janvier, mars, mai, juillet, août, octobre et décembre (trop grand), il a été changé au 31.");
						}
					}
				}
			}
		}
		else{
			this.jr = 1;
			System.out.println("Erreur sur la saisie du jour (trop petit), il a été changé au 1.");
		}

		if(heure_d >= 0){
			if(heure_d <= 23) this.heure = heure_d;
			else{
				this.heure = 23;
				System.out.println("Erreur sur la saisie de l'heure (trop grande), elle a été changée à 23h.");
			}
		}
		else{
			this.heure = 0;
			System.out.println("Erreur sur la saisie de l'heure (trop petite), elle a été changée à 0h.");
		}

		if(minute_d >= 0){
			if(minute_d <= 59) this.minute = minute_d;
			else{
				this.minute = 59;
				System.out.println("Erreur sur la saisie des minutes (trop grandes), elles ont été changées à 59.");
			}
		}
		else{
			this.minute = 0;
			System.out.println("Erreur sur la saisie des minutes (trop petitesà, elles ont été changées à 0.");
		}
    	}

	public static boolean isLeapYear(int an){
		if((an % 4) == 0){
			if((an % 100) == 0){
				if((an % 400) == 0) return true;
				else return false;
			}

			else return true;
		}
		
		else return false;
	}

	public int calcul_d(Date d1, Date d2){
		int d = 0;
	
		ArrayUtils au1 = new ArrayUtils();
		ArrayUtils au2 = new ArrayUtils();

		int m1 = au1.indexOf(tab_mois, d1.mois);
		int m2 = au2.indexOf(tab_mois, d2.mois);

		if(d1.annee == d2.annee){
			if((d1.mois.compareTo(d2.mois)) == 0) d += d2.jr - d1.jr;
			else{
				if(m1 == 2){
					if(isLeapYear(d1.annee)) d += 29 - d1.jr;
					else d += 28 - d1.jr;
				}
				else if((m1 == 4)||(m1 == 6)||(m1 == 9)||(m1 == 11)) d += 30 - d1.jr;
				else d += 31 - d1.jr;

				for(int i = (m1+1); i <= (m2-1); i++){
					if(i == 2){
						if(isLeapYear(d1.annee)) d += 29;
						else d += 28;
					}
					else if((i == 4)||(i == 6)||(i == 9)||(i == 11)) d += 30;
					else d += 31;
				}

				d += d2.jr;
			}
		}

		else{
			if(m1 == 2){
				if(isLeapYear(d1.annee)) d += 29 - d1.jr;
				else d += 28 - d1.jr;
			}
			else if((m1 == 4)||(m1 == 6)||(m1 == 9)||(m1 == 11)) d += 30 - d1.jr;
			else d += 31 - d1.jr;

			for(int i = (m1+1); i < 13; i++){
				if(i == 2){
					if(isLeapYear(d1.annee)) d += 29;
					else d += 28;
				}
				else if((i == 4)||(i == 6)||(i == 9)||(i == 11)) d += 30;
				else d += 31;
			}

			for(int i = (d1.annee+1); i <= (d2.annee-1); i++){
				if(isLeapYear(i)) d += 366;
				else d += 365;
			}
		
			for(int i = 1; i <= (m2-1); i++){
				if(i == 2){
					if(isLeapYear(d2.annee)) d += 29;
					else d += 28;
				}
				else if((i == 4)||(i == 6)||(i == 9)||(i == 11)) d += 30;
				else d += 31;
			}

			d += d2.jr;
		}

		return d;
	}

	public String ifZero_h(Date date){
		if((date.heure >= 0)&&(date.heure <= 9)) return "0";
		else return "";
	}

	public String ifZero_m(Date date){
		if((date.minute >=0)&&(date.minute <=9)) return "0";
		else return "";
	}

	public int nb_jours(){
		ArrayUtils auj = new ArrayUtils();
		int ij = auj.indexOf(this.tab_mois, this.mois);

		if(isLeapYear(this.annee)&&(ij==2)) return 29;
		else if(!isLeapYear(this.annee)&&(ij==2)) return 28;
		else if((ij==4)||(ij==6)||(ij==9)||(ij==11)) return 30;
		else return 31;
	}

	public int getIntMonth(String month){
		ArrayUtils aum = new ArrayUtils();
		return aum.indexOf(tab_mois, month);
	}

	public int getIntMonth_english(String month){
		ArrayUtils aum = new ArrayUtils();
		return aum.indexOf(tab_english, month);
	}

	public void setDate(int j, String m, int a){
		this.jr = j;
		this.mois = m;
		this.annee = a;
	}

	public void setDate(Date date){
		this.jr = date.jr;
		this.mois = date.mois;
		this.annee = date.annee;
	}
	
	public void getDateGestion(Controleur_transition control, Vue_date v_date){
		control.rendreCliquable_gestion(v_date.confirm);
	}

	public String updateMois(String m, boolean f_d){
		ArrayUtils aums = new ArrayUtils();
		int index = aums.indexOf(this.tab_mois, m);
		if(f_d == true){
			if(index < 12) index++;
			else index = 1;
		}
		else{
			if(index > 1) index--;
			else index = 12;
		}
		m = this.tab_mois[index];
		return m;
	}

	public int updateAnnee(String m1, String m2, int an){
		if((m1.compareTo("décembre") == 0)&&(m2.compareTo("janvier") == 0)){
			an++;
			return an;
		}
		else if((m1.compareTo("janvier") == 0)&&(m2.compareTo("décembre") == 0)){
			an--;
			return an;
		}
		
		return an;
	}

	public void getFlecheg(Controleur_setDate control, Vue_date v_date){
		control.setClicableCalendar_fleche(v_date.fleche_g, false);
	}
		
}