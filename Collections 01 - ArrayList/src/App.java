import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> numbers = new ArrayList<Integer>(500);
		
		// Adding values into ArrayList
		numbers.add(10);
		numbers.add(100);
		numbers.add(30);
		
		//Retrieving Values from ArrayList
		System.out.println(numbers.get(0));
		
		System.out.println("\n Iteration method 01");
		//indexed for loop iteration
		for(int i=0;i< numbers.size();i++){
			System.out.println(numbers.get(i));
		}
		
		System.out.println("\n Iteration method 02");
		for(Integer value: numbers){
			System.out.println(value);
		}
		
		// remove items from ArrayList from the end
		
		numbers.remove(numbers.size() -1);
		System.out.println("\n removing items from ArrayList - from the end");
		for(Integer value: numbers){
			System.out.println(value);
		}
		
		// remove items from ArrayList from the beginning 
		numbers.remove(0);
		System.out.println("\n removing items from ArrayList - from the beginning");
		for(Integer value: numbers){
			System.out.println(value);
		}
	}

}
