
public enum Animal {
	CAT("fergie"),DOG("Rufus"),MOUSE("Jerry"),RAT("Kevin");
	
	/*
	 * Since we have a constructor we now need to instantiate all the enumn variable above with a 
	 * name
	 */
	
	private String name;
	Animal(String name){
		this.name = name;
		
	}
	
	/*
	 * you can have methods with enums
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "This animal is named : "+this.name;
	}
	
}
