import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


/*
 * Using TreeSet to enforce a natural order for custom objects will throw an error
 * to overcome this we need to define the natural order at the class level 
 * to do this we bring in the implementation of COMPARABLE interface and provide an override functionality to 
 * the CompareTo method
 * 
 * furthermore we need to also bring in equals and HashCode to maintain uniqueness , 
 * this is a requirement since sets only handle 
 * unique values
 * 
 * actual sorting is done via the compareTo override method
 * in which we compare current object to a another object of the same type
 */

/*
 * Comparable interface provides users with only a single method that is to be overriden
 * 1 . CompareTo
 */

class Person implements Comparable<Person>{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		
		this.setName(name);
	}

	@Override
	public String toString() {
		return "Name - "+this.getName()+" -"+hashCode();
	}
 
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * will enforce a natural order based on name
	 */
	@Override
	public int compareTo(Person person) {
		//System.out.println("CompareTo :"+this.getName()+" With "+person.getName());
		
		/*
		 * Sorting in reverse alphabetic order
		 * remove comment to execute
		 */
		//return -this.name.compareTo(person.name);
		
		//Sorting by length of name
		int len1 = this.getName().length();
		int len2 = person.getName().length();
		
		if (len1>len2){
			return 1;
		}else if (len1<len2){
			return -1;
		}else{
			return this.getName().compareTo(person.getName());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * we are initiating a ArrayList Collection of type String
		 */
		List<String> list = new ArrayList<String>();
		/*
		 * Indicates that the below is a naturally sorted set
		 */
		SortedSet<String> set = new TreeSet<String>();
		
		
		
		
		
		
		addElements(list);
		addElements(set);
		
		/*
		 * Sorting the list
		 */
		Collections.sort(list);
		
		
		System.out.println("Iterating through List");
		showElements(list);
		System.out.println("");
		System.out.println("Iterating through set");
		
		
		showElements(set);
		
		
		////////// Custom objects/////////////
		
		/*
		 * Handling custom objects
		 */
		List<Person> list1 = new ArrayList<Person>();
		/*
		 * Using TreeSet to enforce a natural order for custom objects will throw an error
		 * to overcome this we need to define the natural order at the class level 
		 */
		SortedSet<Person> set1 = new TreeSet<Person>();
		
		
		addPersonElements(list1);
		addPersonElements(set1);
		
		/*
		 * Collections.sort(list1) will initially give out an error since there is no default
		 * natural order defined for Person object, this is manually implemented into the class
		 */
		
		System.out.println("");
		System.out.println("Iterating through custom objects");
		
		Collections.sort(list1);
		
		System.out.println("Iterating through person List");
		showPersonElements(list1);
		System.out.println("");
		System.out.println("Iterating through person set - via Comparable compareTo");
		showPersonElements(set1);
	}

	

	/*
	 * creating a class that allows the ability to add elements through the  COLLECTIONs interface
	 * collections interface is the super parent for all Collections type
	 *  
	 */
	private static void addElements(Collection<String> col){
		col.add("Anoja");
		col.add("Ranjith");
		col.add("Lasen");
		col.add("Nilanka");
		col.add("Methsala");
		/*
		 * for sets this will not be added ,sets only contain unique values
		 */
		col.add("Methsala");
		
		
	}
	
	private static void showElements(Collection<String> col){
		for (String element:col){
			System.out.println(element);
			
		}
		
	}
	
	/*
	 * Classes to handle custom objects
	 */
	
	private static void addPersonElements(Collection<Person> col) {
		// TODO Auto-generated method stub
		col.add(new Person("Anoja"));
		col.add(new Person("Ranjith"));
		col.add(new Person("Lasen"));
		col.add(new Person("Nilanka"));
		col.add(new Person("Methsala"));
		
		/*
		 * for sets this will not be added ,sets only contain unique values
		 */
		col.add(new Person("Methsala"));
		
	}
	
	private static void showPersonElements(Collection<Person> col) {
		// TODO Auto-generated method stub
		for(Person people:col){
			System.out.println(people);
		}
		
	}
	
}
