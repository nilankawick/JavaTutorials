import java.util.Iterator;
import java.util.LinkedList;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> animals = new LinkedList<String>();

		animals.add("Fox");
		animals.add("Cat");
		animals.add("Dog");
		animals.add("elephant");

		/////// OLD WAY of Iterating //////
		/*
		 * Iterator interface is commonly implemented in the collections
		 * framework by default. Iterator allowed the user to iterate through
		 * the list prior to JAVA 5
		 */
		System.out.println("Using Iterators");
		Iterator<String> it = animals.iterator();

		/*
		 * .next() captures the items in the list
		 */
		while (it.hasNext()) {

			String val = it.next();
			System.out.println(val);

			if (val.equals("Cat")) {
				it.remove();

			}
		}

		///// Modern Iteration - post JAVA 5 or later /////////
		System.out.println("");
		System.out.println("Modern way");
		for (String animal : animals) {
			System.out.println(animal);

		}
		System.out.println("");
	}

}
