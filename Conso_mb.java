import java.util.*;

public class Conso_mb{
	String t_mb;
	float prix_mb;

	public Conso_mb(String t , float prix){
		t_mb = t; 
		prix_mb = prix;
 	}

 	public String getType (){ 
    		return t_mb;
 	} 

 	public float getPrix (){
   		return prix_mb;

 	}
}
