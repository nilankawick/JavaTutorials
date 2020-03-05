
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Camera cam1 = new Camera();
		
		cam1.setId(001);
		
		Car car1 = new Car();
		
		car1.setId(002);
		
		/*
		 * Abstract classes are classes which cannot exist or does not make any sense
		 * to exist in isolation, most of the time abstract classes feed onto the possibility
		 * of extending out to children classes as parent classes, in which they offer comment
		 * set of functionality that is apparent for all child instances
		 * 
		 * in this example , Machine in isolation does not make any real sense but it cold hold
		 * information that can extend onto child instances such as camera or car
		 * 
		 * When you enforce a class to be Abstract , it will then not allows us to create an instance
		 * of the same class
		 * 
		 * so the following wont work
		 */
		
		//Machine mach1 = new Machine();
		
		/*
		 * you can also have abstract methods. This will force all child instances to have the same
		 * method be enforced rigorously 
		 * 
		 * finally you can have only one abstract class
		 */
		
		cam1.run();
		//cam1.showInfo();
		
		Info inf1 = cam1;
		inf1.showInfo();
		
		System.out.println("");
		car1.run();
		//car1.showInfo();
		
		inf1 = car1;
		inf1.showInfo();
	
	}

}
