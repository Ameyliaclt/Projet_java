package controlleur;
import classe.*;
import vue.*;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import vue.*;

public class ChargementImages {
    private static Map<String, Image> imageCache = new HashMap<>();
    
    // Pool de threads pour le chargement parallèle des images
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);
    
    private Vue_Resultats_Recherche vue;
    
    public void setVue(Vue_Resultats_Recherche vue) {
        this.vue = vue;
    }
	
    public static Image chargerEtRedimensionnerImage(String cheminImage, int largeur, int hauteur) {
        // Créer une clé unique pour cette image et cette taille
        String cle = cheminImage + "_" + largeur + "x" + hauteur;
        
        // Vérifier si l'image est déjà dans le cache
        if (imageCache.containsKey(cle)) {
            return imageCache.get(cle);
        }
        
        // Charger l'image depuis le disque
        ImageIcon icon = new ImageIcon(cheminImage);
        Image image = icon.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
        
        // Mettre l'image redimensionnée en cache
        imageCache.put(cle, image);
        
        return image;
    }
    
    public void chargerImages() {
        if (vue == null) return;
        
        // Précharger toutes les images en arrière-plan
        for (String nomFichier : vue.nomsFichiers) {
            final String cheminComplet = "images//" + nomFichier;
            
            executorService.submit(() -> {
                // Précharger l'image redimensionnée
                chargerEtRedimensionnerImage(cheminComplet, 200, 200);
                
                // Informer l'EDT qu'une image est disponible
                SwingUtilities.invokeLater(() -> {
                    // Rafraîchir l'affichage si nécessaire
                    vue.repaint();
                });
            });
        }
    }
	
    public static void shutdown() {
        executorService.shutdown();
        imageCache.clear();
    }
}
