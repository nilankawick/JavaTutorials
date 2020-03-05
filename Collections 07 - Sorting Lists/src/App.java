 import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(int id, String name) {

		setId(id);
		setName(name);
	}
	
	public Person(){
		
	}

	@Override
	public String toString() {
		return "ID - "+getId()+" Name - "+getName();
	}

}

/*
 * Comparator is used for non natural/custom sorting for primitive data
 * the interface provides 2 override methods
 * a. compare
 * b. equals
 */
class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2) {
			return 1;
		} else if (len1 < len2) {
			return -1;
		}

		return 0;
	}

}

class AlphabeticalComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		/*
		 * compareTo is a method that is available in the comparable interface
		 * compareTo defines how natural order is executed
		 */
		return s1.compareTo(s2);
	}

} 

class ReverseAlphabeticalComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		return -s1.compareTo(s2);
	}

}

public class App {

	public static void main(String[] args) {

		//////////// Sorting Strings ///////////
		List<String> animals = new ArrayList<String>();

		animals.add("Cat");
		animals.add("Albatross");
		animals.add("Tiger");
		animals.add("Lion");
		animals.add("Mongoose");
		animals.add("Dog");
		
		/*
		 * Default sorting in alphabetical order can be achieved by Collections.SORT
		 * this is known as natural order
		 * please remove comment and execute
		 */
		//Collections.sort(animals);

		/*
		 * Sorting based in string length please remove comment and execute
		 */
		// Collections.sort(animals, new StringLengthComparator());

		/*
		 * Alphabetical Order please remove comment and execute
		 */
		// Collections.sort(animals, new AlphabeticalComparator());

		/*
		 * Reverse Alphabetical Order please remove comment and execute
		 */
		Collections.sort(animals, new ReverseAlphabeticalComparator());

		//Iterate through the list
		System.out.println("Iterate through the String Arraylist after the custmoized sorting of primitive data type STRING");
		
		for (String animal : animals) {
			System.out.println(animal);
		}

		//////////// Sorting numbers ///////////
		System.out.println("");
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(11);
		numbers.add(16);
		numbers.add(1);
		numbers.add(3);
		numbers.add(18);

		/*
		 * sorting naturally for integers please remove comments and execute
		 */
		// Collections.sort(numbers);

		/*
		 * Sorting in reverse for Integers please remove comments and execute
		 * 
		 * we are using anonymous classes for this example
		 * 
		 */
		Collections.sort(numbers, new Comparator<Integer>() {

			@Override
			public int compare(Integer num1, Integer num2) {
				// TODO Auto-generated method stub
				return -num1.compareTo(num2);
			}

		});
		
		//Iterate through the list
		System.out.println("Iterate through the String Arraylist after the custmoized sorting of primitive data type INTEGER");
		
		for (Integer number : numbers) {
			System.out.println(number);
		}

		//////////// Sorting Objects ///////////
		System.out.println("");
		System.out.println("Sorting Custom Objects");
		List<Person> people = new ArrayList<Person>();
		System.out.println(people);
		
        
		
		people.add(new Person(1, "Lasen"));
		people.add(new Person(2, "Ammi"));
		people.add(new Person(3, "Apuchi"));
		people.add(new Person(4, "Nilanka"));
		people.add(new Person(5, "Methsala"));

		/*
		 * Collections.sort(people) - will not work since people class does not have a defined natural order by default.
		 * sorting in reverse ID order for Person
		 * please remove comment and execute
		 */
		Collections.sort(people, new Comparator<Person>() {

			@Override 
			public int compare(Person p1, Person p2) {
				// TODO Auto-generated method stub

				if (p1.getId() < p2.getId()) {
					return 1;
				} else if (p1.getId() > p2.getId()) {
					return -1;
				}
				return 0;
			}
		});

		System.out.println("Iterate through the Arraylist of objects after the custmoized sorting on ID(descending order)");
		for (Person pearson1 : people) {
			System.out.println(pearson1);

		}

		/*
		 * sorting in order of Person Name
		 * please remove comment and execute
		 */
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				// TODO Auto-generated method stub

				return p1.getName().compareTo(p2.getName());
			}
		});
		System.out.println("");
		System.out.println("Iterate through the Arraylist of objects after the custmoized sorting on NAME(Alphabetical order)");
		for (Person pearson1 : people) {
			System.out.println(pearson1);

		}

	}

}
