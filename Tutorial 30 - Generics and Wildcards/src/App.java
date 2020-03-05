import java.util.ArrayList;

class Machine {

	private static int count = 0;  
	private int objID;

	public Machine() {
		this.setCount();
		this.setObjID(this.getCount());
	}

	/**/
	@Override
	public String toString() {
		return "I am a Machine";

	}

	public void start() {
		System.out.println("Machine Started with ID " + this.getObjID());
	}

	public void setObjID(int ID) {
		this.objID = getCount();
	}

	public int getObjID() {
		return this.objID;
	}

	public int getCount() {

		return count;
	}

	public void setCount() {
		count++;
	}

}

class Camera extends Machine {
	
	public Camera(){
		//this.setCount();
		this.setObjID(this.getCount());
		
	}    
	
	@Override
	/**/
	public String toString() {

		return "I am a Camera";

	}

	@Override
	public void start() {
		System.out.println("Camera Started with ID " + this.getObjID() );
	}

	public void snap() {
		System.out.println("Snap!, camera taking pictures");
	}
}

public class App {

	public static void main(String[] args) {
  
		ArrayList<Machine> list = new ArrayList<>();

		list.add(new Machine());
		list.add(new Machine());
		//list.add(new Machine());
		//list.add(new Machine());

		System.out.println("Using wild cards with a upper bound of extend");
		System.out.println("");

		showList(list);
		System.out.println("");

		/*
		 * even though a camera object is the child of parent MACHINE class when
		 * they are part of ArrayList it is not the same
		 */
		
		  ArrayList<Camera> list1 = new ArrayList<>();
		  
		  list1.add(new Camera()); 
		  list1.add(new Camera()); 
		  //list1.add(new Camera()); 
		  //list1.add(new Camera());
 
		/*
		 * example usage of wild cards when extends is used in this example a
		 * camera is an extension of Machine
		 */
		showList(list1);

		/**/
		 
		  System.out.println(""); System.out.
		  println("Using wilds cards when you want to work on a child class - Lower Bound");
		  System.out.println(""); 
		  showList1(list);
		  System.out.println(""); 
		  showList1(list1);
		
		  /**/
		  System.out.println("");
		  System.out.println("Using wild cards Only - this will only allow access to Object class methods");
		  System.out.println("");
		  showList3(list1); 
		  System.out.println(""); 
		  showList3(list);
		  
		  /**/
		  System.out.println(""); 
		  System.out.println("Using for Camera alone");
		  System.out.println(""); 
		  showList4(list1); 
		  System.out.println("");
		 
		  
		 

		// will not work since the parameterized generic is expecting a Camera
		// object
		// showList4(list);
	}

	/*
	 * when using wild cards for an object that extends on Parent  , 
	 * in this example we are using toString() method of both "Machine" and "Camera" for which
	 * "Machine" is the parent class. 
	 * And "list1" ArrayList is for the type "Camera" which is a child of "Machine". 
	 * Therefore if we are creating a Method which is parameterized   and we require the same 
	 * to work on parent and child relationships we will have to use EXTENDS  as part of the parameter.
	 * With the example below what we are saying is that we will be passing a Machine or
	 * something that is part of Machine 
	 *
	 *Upper Bound
	 *
	 *you can only call methods that are available to the Machine Class or shared with 
	 *child instances hence upper bound
	 */
	public static void showList(ArrayList<? extends Machine> list) {

		/*
		 for (int i=0; i<list.size();i++){
		 
		System.out.println(list.get(i)); 
		}
		*/
		 
		/**/
		for (Machine value : list) {
			System.out.println(value); 
			
			value.start();

		}
		
		
	}

	/*
	 * when using wild cards for child classes and its super class we will have
	 * to revert back to object class and its methods
	 * 
	 * 
	 * 
	 * Lower Bound 
	 * can only pass a super class of camera or a camera
	 * Problem with a lower bound wild card of an Class would only allow you
	 * to access Object methods not any methods associated directly to camera or a super class of 
	 * camera
	 */
	public static void showList1(ArrayList<? super Camera> list) {
		/*
		 * for (int i=0; i<list.size();i++){
		 * 
		 * System.out.println(list.get(i)); }
		 */
		for (Object value : list) {
			System.out.println(value);
			
			
		}
	}

	/*
	 * using wild cards to enforce the ability to pass any object
	 */
	public static void showList3(ArrayList<?> list) {
		/*
		 * for (int i=0; i<list.size();i++){
		 * 
		 * System.out.println(list.get(i)); }
		 */
		for (Object value : list) {
			System.out.println(value);
			
		}
	}

	public static void showList4(ArrayList<Camera> list) {
		/*
		 * for (int i=0; i<list.size();i++){
		 * 
		 * System.out.println(list.get(i)); }
		 */
		for (Camera value : list) {
			System.out.println(value);
			value.snap();
		}
	}
}
