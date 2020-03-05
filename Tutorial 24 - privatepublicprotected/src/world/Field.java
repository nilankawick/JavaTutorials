package world;

public class Field {
	private Plant plant = new Plant();
	
	//constructor
	public Field(){
		
		// this works since size is protected and is available for the
		//package or any inherited(extended) 
		//objects or any classes that are part of the package
		System.out.println(" " + plant.size);
	}
	
	
}
