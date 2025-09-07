package vue;
import model.*;
import controlleur.*;
import classe.*;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vue_conso extends JFrame{
	Conso_mb[] choix;

	JPanel main = new JPanel();
	JLabel title_vue;
	JPanel sep = new JPanel();
	JPanel ajout = new JPanel();
	JLabel space_ajout;
	JComboBox<String> menu_choix;
	JLabel prix;
	JPanel button = new JPanel();
	public JButton confirm;
	JLabel space;

	String[] type_conso;

	public Vue_conso(Conso_mb[] choice){
		choix = choice;

		Dimension t_scr = Toolkit.getDefaultToolkit().getScreenSize();

		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.setBackground(Color.WHITE);

		title_vue = new JLabel("<html> <br> &emsp Ajout de consommation minibar <br> <br> </html>");
		title_vue.setFont(new Font("Georgia", Font.PLAIN, 16));
		title_vue.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		main.add(title_vue);

		sep.setBackground(new Color(220,220,220));
		sep.setPreferredSize(new Dimension((int)((double)t_scr.getWidth()*0.23), 1));
		sep.setMaximumSize(new Dimension((int)((double)t_scr.getWidth()*0.23), 1));
		sep.setMinimumSize(new Dimension((int)((double)t_scr.getWidth()*0.23), 1));
		sep.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		main.add(sep);
		
		ajout.setLayout(new FlowLayout(FlowLayout.LEFT));
		ajout.setBackground(Color.WHITE);

		space_ajout = new JLabel("<html> &emsp </html>");
		space_ajout.setFont(new Font("Georgia", Font.PLAIN, 14));
		ajout.add(space_ajout);

		type_conso = types_conso();
		menu_choix = new JComboBox<>(type_conso);
		menu_choix.setFont(new Font("Georgia", Font.PLAIN, 14));
		menu_choix.setBackground(new Color(245,245,245));
		menu_choix.setRenderer(new DefaultListCellRenderer() {
            		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                		Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                		if (isSelected) {
                    			comp.setBackground(new Color(241, 250, 247));
                    			comp.setForeground(Color.BLACK);
                		} 

				else {
                    			comp.setBackground(Color.WHITE);
                    			comp.setForeground(Color.BLACK);
                		}

                		return comp;
            		}
        	});
		menu_choix.setEditable(true);
		menu_choix.getEditor().getEditorComponent().setBackground(new Color(241,250,247));
		ajout.add(menu_choix);

		prix = new JLabel("<html> <br> &emsp "+choix[0].prix_mb+"€ <br> <br> </html>");
		prix.setFont(new Font("Georgia", Font.PLAIN, 14));
		ajout.add(prix);
		Controleur_prix_conso control = new Controleur_prix_conso(prix, menu_choix, type_conso, choix);
		menu_choix.addActionListener(control);

		ajout.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)ajout.getPreferredSize().getHeight()));
		main.add(ajout);

		button.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button.setBackground(Color.WHITE);
		
		confirm = new JButton("Confirmer");
		confirm.setFont(new Font("Georgia", Font.PLAIN, 14));
		confirm.setBackground(new Color(245,245,245));
		confirm.setFocusPainted(false);
		button.add(confirm);

		space = new JLabel("<html> &emsp </html>");
		space.setFont(new Font("Georgia", Font.PLAIN, 14));
		button.add(space);

		button.setMaximumSize(new Dimension((int)t_scr.getWidth(), (int)ajout.getPreferredSize().getHeight()));
		main.add(button);

		this.getContentPane().add(main);
	}

	public String[] types_conso(){	
		String[] types = new String[choix.length];
		
		for(int i = 0; i<types.length; i++){
			types[i] = choix[i].t_mb;
		}

		return types;
	}
}