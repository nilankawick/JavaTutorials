
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ============ block 1
		int value = 7;
		System.out.println("1. Value is : " + value);
		App app = new App();
		app.show(value);
		System.out.println("4. Value is : " + value);
		
		// ============ block 2
		System.out.println("");
		Person person = new Person("Nilanka");
		
		System.out.println("1. person is - "+person);
		
		app.show(person);
		/*
		 * we have changed the name in the show() method below
		 */
		System.out.println("4. person is - "+person);
		
		
		
	}

	public void show(int value) {
		System.out.println("2. Value is : " + value);
		
		value = 8;
		
		System.out.println("3. Value is : " + value);
		
	}
	
	/*
	 * example of passing by value with non primitive objects
	 * in the example what is being passed to the method below is the address of the object Person created in Block 1
	 */
	public void show(Person person){
		System.out.println("2. person is - "+person);
		
		/*
		 * we have the address of the person object in block 1 and we are now setting the name of the 
		 * person object in block 1 to lasen
		 */
		person.setName("Lasen");
		
		/*
		 * we are creating a new person ,i.e we are now creating new address of a new person object
		 */
		person = new Person("Methsala");
		System.out.println("3. person is - "+person);
	}

}
