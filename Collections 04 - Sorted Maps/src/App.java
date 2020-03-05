import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * We use the interface type MAP to facilitate collections but explicitly mention the type via the NEW statement
		 */
		Map<Integer,String> hashMap = new HashMap<Integer,String>();
		Map<Integer,String> linkedHashMap = new LinkedHashMap<Integer,String>();
		Map<Integer,String> treeMap = new TreeMap<Integer,String>(); 
		
		System.out.println("HashMap - un sorted  \n");
		testMap(hashMap);
		
		System.out.println("\n LinkedHashMap - maintains the order in which the data are put in \n");
		testMap(linkedHashMap);
		
		System.out.println("\n TreeMap - maintains the order of the KEys  \n");
		testMap(treeMap);
	}
	
	
	public static void testMap(Map<Integer,String> map){
		map.put(10,"Methsala");
		map.put(22,"Nilanka");
		map.put(27,"Lasen");
		map.put(9, "Anoja");
		map.put(1,"Ranjith");
		
		for (Integer key: map.keySet()){
			String value = map.get(key);
			System.out.println(key+": "+ value);
			
		}
	}

}
