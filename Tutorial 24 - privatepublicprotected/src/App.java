import world.Oak;
import world.Plant;
import world.World;

// imports the above classes from package world

public class App {

	public static void main(String[] args) {
		
		Plant plant1 = new Plant("Nilanka");
		
		// will work since the instance variable is public
		System.out.println(" "+plant1.name);
		
		/*
		 *  will not work since the instance variable is private
		 */
		//System.out.println(" "+plant1.type);
		
		/*
		 * this wont work since height has no access specifier hence by default it
		 * will only available for the package in which plant
		 *exists in this example all classes of "world package"
		 */
		
		//System.out.println(" "+ plant1.height);
		
		/*
		 *  will work since the static variable that is public
		 */
		System.out.println(" "+plant1.ID);
		
		
		/*
		 * will not work since protected instance variables are only available for 
		 * child and the class in which is declared + the package
		 */
		//System.out.println(""+ plant1.size);
		
		System.out.println("");
		System.out.println("Creating an oak object");
		Oak oak1 = new Oak();
		
		System.out.println(" "+ oak1.name);
		
		/*
		 *  will not work since its private in the parent class which is the PLANT CLASS
		 */
		//System.out.println(" "+ oak1.type);
		
		/*
		 * this wont work since height is by default is only available for the package
		 */
		//System.out.println(" "+ oak1.height);
		
		/*
		 *  will work since the static variable that is public
		 */
		System.out.println(" "+oak1.ID);
		
		/*
		 *  this wont work since Oak class variable "size" is in a
		 *   different package that of the current class App
		 */
		//System.out.println(" "+oak1.size);
		
		/*
		 * grass is a class that resides in the same package as APP
		 * therefore we do not need to import the same as we have done for OAK and PLANT
		 * which belongs to the WORLD package
		 * 
		 * with grass it extends on the PLANT class, hence
		 *  GRASS is the child of parent PLANT class
		 */
		Grass grass1 = new Grass();
		
		
		
		//
		System.out.println("");
		System.out.println("Lets look at world");
		World world1 = new World();
		
		String[] args1 = {};
		
		world1.main(args1);
		
		
		
		
	}
}
