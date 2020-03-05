package world;

public class World {

	public static void main(String[] args) {

		System.out.println("welcom to world package");

		// this will work since plant is in the same package as world
		Plant plant = new Plant("New Package");

		// will work since the instance variable is public
		System.out.println(" " + plant.name);

		// will not work since the instance variable is private
		//System.out.println(" "+plant.type);
		
		// this will work since the protected variable is within the same package as World class
		System.out.println(""+ plant.size);
		
		// will work since it is within the same package
		System.out.println(""+ plant.height);
		
		// will work since the static variable is public
		System.out.println(" " + plant.ID);
		
	}

}
