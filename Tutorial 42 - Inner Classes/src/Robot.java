
public class Robot {
	
	private int id;
	private static int ref = 123;
	
	
	/*
	 * This is a nested class (non static inner class), this can 
	 * access the top level  classes instance variable and methods 
	 */
	public class Brain{
		public void think(){
			System.out.println("Robot "+id+" is thinking");
		}
	}
	
	/*
	 * This is a static nested class 
	 */
	public static class Battery{
		public void charge(){
			/*
			 * the following wont work because a static class can only work with
			 * static variables of the outer class, hence the following will throw an error
			 * System.out.println("Battery is Charging..." +id);
			 */
			
			System.out.println("Battery is Charging..." +ref);
			
		}
	}
	
	public Robot(int id) {
		//super();
		this.id = id;
	}
	/*
	 *Calling out and creating an object/instance of the inner class 
	 *few things to remember, when you create an instance of ROBOT, we do 
	 *not automatically create an instance of the inner class BRAIN. to do so we would have
	 *to either use the constructor or any method of the outer or upper class or explicitly as shown in the code 
	 *immediately below this comment
	 *or 
	 *call the creation of an instance as follow in an explicit manner
	 *
	 *Robot robot = new Robot(7);
	 *Robot.Brain brain = robot.new Brain();
	 */
	
	public void start(){
		System.out.println("Robot started with ID : " +id);
		System.out.println("");
		Brain brain = new Brain();
		brain.think();
		System.out.println("");
		String name = "Nilanka";
		
		/*
		 * declaring classes within Methods
		 */ 
		class Temp{
			public void doSomething(){
				System.out.println("ID is "+id);
				System.out.println("My name is : "+name);
				System.out.println("");
			}
		
			
			
		}
		Temp temp = new Temp();
			
			temp.doSomething();
	}
	

}
