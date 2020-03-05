import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 401633306273802062L;
	
	private  transient int id;
	private String name;
	
	/*
	 * a Static variable in class means that it will be a single value across all objects created off the class
	 * and also that the static variable can be accessed without initializing a new class object
	 * 
	 * you dont need to create a 
	 * Person person1 = new Person();
	 * and then
	 * person.count to access 
	 * you can 
	 * Person.count
	 * 
	 * therefore count will have the same value across all different initiations 
	 * 
	 * refer tutorial 18
	 * 
	 * Finally static fields and methods are note serialized
	 * if you want to serialize methods or variables you should not be using static
	 * 
	 */
	private static int count;
	
	public Person(){
		System.out.println("Default Constructor");
	}
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}

	public Person(int id, String name){
		this.id = id;
		this.name = name;
		
		System.out.println("Two-Argument Constructor");
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		
		return "Person [id=" + id + ", name=" + name + "] Count is - " + count ;
		
	}


	
	

}
