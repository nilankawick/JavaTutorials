package world;

public class Oak extends Plant {
	
	
	
	public Oak() {
		
		/*
		 * if there is not a constructor with no args we will have to use
		 * the following "super()" and pass on the arguments that is there to meet
		 * the parameters defined in the constructor
		 */
		
		//super("Oak Tree");
		
		
		//wont work since type is private and is only available in Plant class
		//type = "Tree";
		
		/*
		 * This works since size is a protected instance variable, meaning that the 
		 * same will be available for child classes and the parent package
		 */
		this.size = "large";
		this.size = "very large";
		
		/*
		 * Height has no access specifier thus will only be available for access within 
		 * the package that houses plan class
		 */
		this.height = 12;
		
		
	}
	
	

}
