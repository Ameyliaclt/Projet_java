import javax.swing.*;
import java.awt.*;

public class Vue_prc extends JFrame {
	Model_prc mod;
	JLabel lab;
	JButton butt;

	
	JMenuBar bar = new JMenuBar();
	JMenu dest = new JMenu("Destinations");
	JMenu selct = new JMenu("Nos sélections");
	JMenu sav = new JMenu("En savoir plus");
	
public Vue_prc(Model_prc md){
	super(md.att);
	mod = md;
	lab = new JLabel();
	this.getContentPane().add(lab);

	ImageIcon icon = new ImageIcon("C://Users//ameyl//Desktop//POO projet//images//icone_site.png"); 
	Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	JLabel iconLabel = new JLabel(new ImageIcon(image));
	JLabel titre = new JLabel("RedOne");
	titre.setForeground(new Color(230, 0, 0));
	titre.setFont(new Font("Arial", Font.PLAIN, 20));
	butt = new JButton("Me connecter/ M'inscrire");

	this.setJMenuBar(bar);
	bar.add(Box.createHorizontalStrut(15));
	bar.add(iconLabel);
	bar.add(Box.createHorizontalStrut(10));
	bar.add(titre);
	bar.add(Box.createHorizontalStrut(25));
	bar.add(new JSeparator(SwingConstants.VERTICAL));
	bar.add(Box.createHorizontalStrut(25));
	bar.add(dest);
	bar.add(Box.createHorizontalStrut(10));
	bar.add(selct);
	bar.add(Box.createHorizontalStrut(10));
	bar.add(sav);
	bar.add(Box.createVerticalStrut(0));
	bar.add(butt);
	bar.add(Box.createHorizontalStrut(15));
	
	

	bar.setPreferredSize(new Dimension(90, 91));
	
	this.getContentPane().setLayout(new FlowLayout());
	}
}
