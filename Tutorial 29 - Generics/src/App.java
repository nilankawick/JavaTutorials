	import java.util.ArrayList;
import java.util.HashMap;

class Animal{
	
}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// array list - before java 5 //
		
		ArrayList list = new ArrayList();
		
		list.add("Apple");
		list.add("Banana"); 
		list.add("Peach");
		
		/// down casting was required ///
		String fruit = (String)list.get(0);
		
		System.out.println(fruit);
		
		
		//// Generic's after post 5 ////
		
		ArrayList<String> strings = new ArrayList<String>();
		
		strings.add("Dog");
		strings.add("Cat");
		strings.add("Bull");
		
		String animal = strings.get(2);
		System.out.println(animal);
		System.out.println("");
		System.out.println("lets loop through the array:");
		
		for (int i = 0; i<strings.size();i++){
			System.out.println(strings.get(i));
		}
		
		/// more than 1 parameterized class///
		
		HashMap <Integer,String> map = new HashMap<Integer,String>();
		
		
		
		/// Java 7 style ///
		
		
		ArrayList <Animal> animalList = new ArrayList<>();
		
		
		
	}

}
