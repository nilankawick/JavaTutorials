 import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * Sets will only have unique items PLUS, HashSet will not remember
		 * HashSet for it to be ordered we can use LinkedHashSet for it to be
		 * naturally ordered we can use TreeSet
		 */
		Set<String> set1 = new TreeSet<String>();
		if (set1.isEmpty()) {
			System.out.println("Nothing is set at Start, we will be setting up values");
		}
		set1.add("Dog");
		set1.add("Cat");
		set1.add("Mouse");
		set1.add("Tree");
		set1.add("House");

		//System.out.println(set1);

		/*
		 * Since sets only have unique items we even if we add another Dog it
		 * will have no impact and you will not have two DOGs
		 */

		set1.add("Dog");
		System.out.println(set1);

		// iterating
		/**/
System.out.println("set1");
		for (String element : set1) {
			System.out.println(element);
		}
		
		
		
		// searching to see if there is a item in the set

		
		String usrInput = null;
		Scanner input = new Scanner(System.in);
		
		if (set1.isEmpty()) {
			System.out.println("Nothing is set");
			
			
		} else {
			
			System.out.println("Enter String to search:");
			usrInput = input.nextLine();
 
			if (set1.contains(usrInput)) {
				System.out.println("Contains : " + usrInput);
			} else {
				System.out.println("Does not contain :" + usrInput);
			}
		}
		input.close();
		
		// Intersection
		Set<String> set2 = new TreeSet<String>();
		System.out.println("set2");		
		set2.add("Dog");
		set2.add("Cat");
		set2.add("Elephant");
		set2.add("Giraffe");
		set2.add("Monkey");

		System.out.println(set2);
		
		// checking what is common between sets Set1<->Set2
		Set<String> intersectionSet1 = new TreeSet<String>(set1);
		//System.out.println(intersectionSet1);
		
		System.out.println("What is common");
		intersectionSet1.retainAll(set2);
		System.out.println(intersectionSet1);
		
		//Checking the difference between sets
		Set<String> diffSet1 = new TreeSet<String>(set2);
		
		System.out.println("What is different");
		
		//Removes items from Set2  that are common with Set1
		diffSet1.removeAll(set1);
		System.out.println(diffSet1);
	}

}
