import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Hotel_model{
	String photo_entete;
	String[] photo_hotel;
	String[] type_ch;
	String[] theme_ch;
	Color Color_background;
	String[] theme_fil;

	public Hotel_model(String photo_e, String[] photo_h, String[] type, String[] theme, Color col_b, String[] theme_f){
		photo_entete = photo_e;
		photo_hotel = photo_h;
		type_ch = type;
		theme_ch = theme;
		Color_background = col_b;
		theme_fil = theme_fil;
	}
}