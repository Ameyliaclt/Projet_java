import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Pays{
	public String path_fond;
	public String path_back;
	public String path_photo;
	public Color col;
	public Color col2;
	public Color col3;

	public Pays(String path_f, String path_b, String path_p, Color colo, Color colo2, Color colo3){
		path_fond = path_f;
		path_back = path_b;
		path_photo = path_p;
		col = colo;
		col2 = colo2;
		col3 = colo3;
	}
}
