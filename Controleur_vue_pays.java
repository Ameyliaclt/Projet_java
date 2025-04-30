import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controleur_vue_pays implements ActionListener {
	private final JFrame frameParent;
	private final JFrame nouvelleFenetre;
    
    	public Controleur_vue_pays(JFrame fp, JFrame nf){
       		this.frameParent = fp;
        	this.nouvelleFenetre = nf;
    	}
    
    	@Override
    	public void actionPerformed(ActionEvent e) {
        	Point location = frameParent.getLocation();
        	Dimension size = frameParent.getSize();
        	int state = frameParent.getExtendedState();
			
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
