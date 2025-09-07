package model;
import classe.*;
import java.util.List;

public class Model_prc_Chambre {

    public List<Chambre> chambres;
	public Model_connectinscr clt;
	
	public Model_prc_Chambre(List<Chambre> chambres, Model_connectinscr clt) {
        this.chambres = chambres;
		this.clt = clt;
    }

    public Chambre getChambre(int index) {
        return chambres.get(index);
    }

    public String[] getDescription(int index) {

        Chambre ch = chambres.get(index);

        String base = "Bienvenue dans notre espace inspiré par le thème " + ch.thm_ch +
                ". Un mélange unique de culture, confort et découverte pour un séjour inoubliable :\n";

        String suite;

        switch (ch.t_ch) {
            case "Chambre simple":
                suite = "Notre chambre simple offre un confort épuré, idéal pour les voyageurs en quête de sérénité et d’authenticité.\n\n";
                break;
            case "Chambre double":
                suite = "Parfaite pour les couples ou amis, notre chambre double associe espace et harmonie dans un cadre accueillant.\n\n";
                break;
            case "Suite":
                suite = "Découvrez une suite élégante et spacieuse, alliant inspiration locale et confort moderne pour un séjour raffiné.\n\n";
                break;
            case "Suite présidentielle":
                suite = "Notre suite présidentielle allie raffinement moderne et charme sénégalais. Vue imprenable, confort haut de gamme, et une atmosphère paisible pour une expérience inoubliable.\n\n";
                break;
            default:
                suite = "Un espace unique conçu pour votre confort et votre bien-être.\n";
        }

        return new String[]{base, suite};
    }
}

