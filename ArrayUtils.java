import java.util.*;

public class ArrayUtils{
	String[] tab;
	String find;

	public ArrayUtils(String[] t, String f){
		tab = t;
		find = f;
	}

	public ArrayUtils(){
	}

	public int indexOf(String[] ta, String fi){
		for(int i = 0; i < ta.length; i++){
			if((ta[i].compareTo(fi)) == 0) return i;
		}

		return 0;
	}
}