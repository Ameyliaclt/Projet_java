package model;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Hotel_model{
	public String photo_entete;
	public String[] photo_hotel;
	public String[] type_ch;
	public String[] theme_ch;
	public Color Color_background;
	public String[] theme_fil;

	public Hotel_model(String photo_e, String[] photo_h, String[] type, String[] theme, Color col_b, String[] theme_f){
		photo_entete = photo_e;
		photo_hotel = photo_h;
		type_ch = type;
		theme_ch = theme;
		Color_background = col_b;
		theme_fil = theme_fil;
	}
}