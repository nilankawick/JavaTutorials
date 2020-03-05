import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


class Person{
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
		
		this.setId(id);
		this.setName(name);
	}

	@Override
	public String toString() {
		return "Person [id=" + this.getId() + ", name=" + this.getName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
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
		 * HashMap <key,type>
		 * Important hashmaps are not sorted
		 * Keys in a map are unique when compared against the the value, therefore you cant have two entries of the
		 * same key 
		 * the above is applicable for sets as well
		 */
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		/*
		 * In the example below we have two entries  with the same Key -->"one"
		 * with MAPs the KEYs are to be unique, therefore you cannot have entries with the same KEY
		 * 
		 */
		map.put("one",1);
		map.put("two",2);
		map.put("three",3);
		map.put("four",4);
		map.put("one",11);
		
		for(String key:map.keySet()){
			System.out.println(key +": "+map.get(key));
		}
		
		Set<String> set1 = new LinkedHashSet<String>();
		
		/*
		 * With SETs, you can only have unique items
		 * therefore in the example you have tried to add two "Dog" items
		 * but with SETs you cannot have two items of the same value
		 */
		set1.add("Dog");
		set1.add("Cat");
		set1.add("Mouse");
		set1.add("Tree");
		set1.add("Dog");
		System.out.println(set1);
		
		
		//Using custom objects with Sets and HashMaps
		
		/*
		 * with MAPS, the KEY needs to be unique
		 * IF WE ARE USING CUSTOM OBJECTS for Keys we need to implement HASHCODE and EQUALS with CUSTOM OBJECT
		 * SO that MAPs collection can figure out if two objects are similar or NOT
		 */
		System.out.println("");
		System.out.println("Working with Custom objects \n");
		Person p1 = new Person(0,"Nilanka");
		Person p2 = new Person(1,"Methsala");
		Person p3 = new Person(2,"Lasen");
		Person p4 = new Person(1,"Methsala");
		
		
		Map<Person, Integer> map1 = new LinkedHashMap<Person, Integer>();
		
		/*
		 * As mentioned earlier, with MAPS, the KEY needs to be unique 
		 * in this example we are using a custom object as a KEY
		 * and the Object PERSON is made up of two pieces of information --> ID,NAME
		 * so an Object with the SAME ID & NAME is considered to be the same instance of the object 
		 * new Person(1,"Methsala") != new Person(2,"Methsala") --> these two are not equal since the ID is different
		 * but new Person(1,"Methsala") == new Person(1,"Methsala") --> these two are the same since ID and NAME is equal
		 * 
		 * and with MAPS we cant use the later definitions
		 * as a KEY in MAPS
		 */
		map1.put(p1,1);
		map1.put(p2,2);
		map1.put(p3,3);
		
		/*
		 * Sine KEYs need to be unique, we will not be able to create an ITEM in MAP
		 * because we have used the SAME PERSON earlier
		 */
		map1.put(p4,1);
		
		
		for(Person key:map1.keySet()){ 
			System.out.println("KEY :"+key +"- VALUE: "+map1.get(key));
			//System.out.println("Map Key - "+key);
			//System.out.println("Value at key("+key+") - "+map1.get(key));
		}
		
		Set<Person> set2 = new LinkedHashSet<Person>();
		set2.add(p1);
		set2.add(p2);
		set2.add(p3);
		set2.add(p4);
		
		System.out.println(set2);
		
		
	}

}
