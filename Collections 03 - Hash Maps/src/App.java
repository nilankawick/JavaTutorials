import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//HashMap <key,type>
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		
		/*
		 * HashMap <key,type>
		 * Important hashmaps are not sorted
		 * Keys in a map are unique when compared against the the value, therefore you cant have two entries of the
		 * same key 
		 */
		map.put(1, "One");
		map.put(3, "Three");
		map.put(5, "five");
		map.put(7, "Seven");
		map.put(7, "Seven");
		
		String text = map.get(5);
		
		System.out.println(text);
		
		
		
		//Iterating through Map via the Map interface
		for(Map.Entry<Integer,String> entry: map.entrySet()){
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key +" : "+value);
			
			}
		

	}

}
