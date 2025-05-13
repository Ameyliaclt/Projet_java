public class Model_prc {
    public String[] images;
    public String[] themes;
    public String[] types;
    public int[] prix;
    private String suite;

    public Model_prc(String suite) {
        MainApp main = new MainApp();  
        this.images = main.images;
        this.themes = main.themes;
        this.types = main.types;
        this.prix = main.prix;
        this.suite = suite;
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

        return new String[]{base, suite};
    }

    public int getPrix(int index) {
        return prix[index];
    }

    // Classe interne pour représenter les chambres
    public static class Chambre {
        public int nb_u;
        public String t_ch;
        public String thm_ch;
        public int prix;
        public String image;

        public Chambre(int nb_u, String t_ch, String thm_ch, int prix, String image) {
            this.nb_u = nb_u;
            this.t_ch = t_ch;
            this.thm_ch = thm_ch;
            this.prix = prix;
            this.image = image;
        }
    }
}
