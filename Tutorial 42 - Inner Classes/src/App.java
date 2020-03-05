
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Robot robot = new Robot(7);
		
		robot.start();
		System.out.println("");
		
		
		/*
		 *Calling out and creating an object/instance of a nested inner class 
		 *few things to remember, when you create an instance of ROBOT, we do 
		 *not automatically create an instance of the inner class BRAIN. to do so we would have
		 *to either use the constructor or any method of the outer or upper class or explicitly 
		 *call the creation of an instance as follow
		 *
		 *Robot robot = new Robot(7);
		 *Robot.Brain brain = robot.new Brain();
		 */
		Robot.Brain brain = robot.new Brain();
		brain.think();
		
		System.out.println("");
		/*
		 * Calling static inner classes
		 */
		
		Robot.Battery battery = new Robot.Battery();
		
		battery.charge();
		
		
	}

}
