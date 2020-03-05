//import world.Oak;
import world.Plant;

public class Grass extends Plant {

	public Grass(){
		/*
		 *  this wont work even though we 
		 *  extend PLANT when creating GRASS, simply because GRASS is not in the 
		 *  same package as PLANT
		 */
		//System.out.println(this.height);
		
		System.out.println("");
		
		System.out.println("welcom to Grass in default package");

		/*
		 *  this will work since PLANT is public and extended when we created 
		 *  GRASS
		 */
		Plant plant = new Plant("Default grass");

		// will work since the instance variable is public in PLANT
		System.out.println(" " + plant.name);

		// will not work since the instance variable is private
		// System.out.println(" "+plant.type);
		
		/*
		 *  this will not work since the size is a protected variable in class PLANT
		 *  and since GRASS is not within the same package as PLANT , it wont be accessible 
		 *  from GRASS even though PLANT is extended for GRASS
		 *  
		 */
		//System.out.println(""+ plant.size);
		
		/*
		 * Will not work since height has no access specifier and due to the same its not 
		 * Available outside of the package 
		 */
		//System.out.println(""+ plant.height);
		
		// will work since the static variable is public
		System.out.println(" " + plant.ID);
	}
}
