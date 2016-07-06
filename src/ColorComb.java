import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Set for storing the color
// If (present){
//	then that color take the index plus one place} 
// else{
//	store at global counter index}


public class ColorComb {

	 HashMap<String,Integer> colormap = new HashMap<String,Integer>();
	 String[] colorarray = new String[50];
	 int globalindex = 0;
	 int inputsize = 0;
	
	public void addelement(String colorstring){
		
		if(colormap.containsKey(colorstring)){
			
			// color coming second time
			int localindex = colormap.get(colorstring);
			localindex++;
			colormap.remove(colorstring);
			colorarray[localindex] = colorstring;
						
		}else{
			
			// color coming first time / third time
			colormap.put(colorstring, globalindex);
			colorarray[globalindex] = colorstring;
			globalindex = globalindex + 2;
		}
	}
	
}
