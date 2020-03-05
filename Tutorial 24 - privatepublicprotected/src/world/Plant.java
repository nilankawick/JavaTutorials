package world;

public class Plant {
	/*
	 * Exposing instance variables is bad practice, what would be accepted 
	 * is to create them to be private and use getters and setter
	 */
	public String name;
	
	/*
	 * If there is a requirement to expose a instance variable , the practice is to 
	 * expose only constant variables  , that is public static final
	 */
	public final static int ID = 23121982;
	
	// by declaring a variable to  be private you can only access within this class
	private String type;
	
	// this will only be accessible with the parent class and child classes
	protected String size ;
	
	
	// when there is no access specifier the variable can only be accessed within the package
	//even if you extend this wont work. look at Grass
	int height;
	
	// constructor
	public Plant(String name){
		this.name = name;
		this.type = "Plant";
		
		this.size = "Medium";
		this.height = 8;
	}
	
	/*
	 * no arg constructor 
	 */
	public Plant(){
		
	}
}
