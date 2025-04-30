import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class p_vue_prcp implements ActionListener {
    private final JFrame frameParent;
    private final Model_prjt model;
    
    public p_vue_prcp(JFrame frameParent, Model_prjt model) {
        this.frameParent = frameParent;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Point location = frameParent.getLocation();
        Dimension size = frameParent.getSize();
        int state = frameParent.getExtendedState();
        
        // Créer la nouvelle fenêtre
        Vue_prcp nouvelleFenetre = new Vue_prcp(model);
        
        nouvelleFenetre.setLocation(location);
        nouvelleFenetre.setSize(size);
        
        frameParent.dispose();
        
        nouvelleFenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
        nouvelleFenetre.setVisible(true);
    }
    
    // Méthode pour rendre un JLabel cliquable
    public static void rendreJLabelCliquable(JLabel label, ActionListener listener) {
        label.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.actionPerformed(new ActionEvent(label, ActionEvent.ACTION_PERFORMED, ""));
            }
        });
    }
}