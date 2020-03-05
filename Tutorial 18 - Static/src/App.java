class Thing {

	// Instance variables
	public String name;
	public int objID;

	// static final variable: final variables cannot change its value
	public final static int LUCKY_NUMBER = 23;

	// class/Static variable : this is only available for the class or only attached
	// to the class
	public static String description;
	private static int count = 0;

	/*
	 * class constructor : this will be the first thing that executes when an
	 * object is created of this class
	 */
	public Thing() {
		/*
		 * static variables cannot be accessed with "this." annotation the
		 * following would thrown an error "this.count++;"
		 */
		// count++;
		this.setCount();
		this.objID = this.getCount();
		
	}

	public void showName() {
		System.out.println("name is:" + this.name);
		System.out.println("I am part of the object ID:"+this.objID);
		
		/* you can access static variables/static methods through instance methods
		 * for example showName() is an instance method and you can access static methods or s
		 * static variable
		 * as shown below, the opposite of this not feasible with static methods. in other words 
		 * from within a static method you cannot access instance variables or methods
		 */
		// System.out.println("Description: " + description);
		//showDescription();
	}

	public static void showDescription() {
		/*
		 * note that instance variables cannot be accessed via a static method
		 * i.e; the following would throw an error "this.name;" plus static
		 * methods can only access static variables 
		 * and static methods are available for the class only
		 */
		System.out.println("description: " + description);
	}

	public static void showCount() {
		System.out.println("Object count :" + count);

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;

	}
	
	/*
	 * the next two instance methods are
	 *  examples of an instance method accessing a class/static variable
	 */
	public int getCount(){
		
		return count;
	}

	public void setCount() {
		count++;
	}

}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// static class variables can be set without initiation of a class
		Thing.description = "My Family";
		/*
		 * With static class variables, you can without creating an
		 * instance(object) of "Thing" --> new Thing(), we can access static class
		 * variables and its data
		 * System.out.println("Access static variable description:"+Thing.description);
		 */

		Thing.showDescription();
		
		//System.out.println("Before creating object the count is :" + Thing.count);
		System.out.println("Before creating any instance or object of THING");
		Thing.showCount();

		Thing thing1 = new Thing();
		Thing thing2 = new Thing();

		//System.out.println("After creating object the count is :" + Thing.count);
		System.out.println("After creating Objects/Instances");
		Thing.showCount();
		
		thing1.setName("Nilanka");
		thing2.setName("Methsala");

		thing1.showName();
		thing2.showName();

		System.out.println(Thing.LUCKY_NUMBER);

	}

}
