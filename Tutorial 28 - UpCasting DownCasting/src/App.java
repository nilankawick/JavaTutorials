class Machine{
	
	public void start(){
		System.out.println("Machine Started");
	}
	
}

class Camera extends Machine{

	@Override
	public void start() {
		System.out.println("Camera Started");
	}
	
	public void snap(){
		System.out.println("Photo Taken");
	}
	
	
}



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Machine machine1 = new Machine();
		Camera camera1 = new Camera();
		
		//inheritance
		System.out.println("Inheritance");
		machine1.start();
		camera1.start();
		camera1.snap();
		System.out.println("");
		
		/*
		 * upcasting --> going up the class hierarchy, child to parent
		 * 
		 * variable type decides what you can access. in this instance variable type
		 * is Machine, hence you can access only methods associated with Machine class
		 * 
		 * the object that is referred through the variable machine2 is a camera object, hence 
		 * it will refer to the instance of a camera object that is available via camera 2 
		 */
		System.out.println("Upcasting");
		
		Machine machine2 = camera1;
		
		machine2.start();
		
		System.out.println("");
		/*
		 * downcasting
		 */
		System.out.println("downcasting \n");
		
		Machine machine3 = new Camera();
		System.out.println("prior to downcasting");
		machine3.start();
		
		/*
		 * wont work
		 */
		//System.out.println(machine3.snap());
		System.out.println("\n after downcasting");		
		Camera camera2 = (Camera)machine3;
		
		camera2.start();
		camera2.snap();
		
		
		

	}

}
