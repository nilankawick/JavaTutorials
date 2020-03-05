
class Plant{
	
	public static final int ID = 7;
	
	private String name;
	
	// Constructor
	public Plant (String name){
		setName(name);
		
	}
	
	public String getData(){
		String dataToBeReturned = "This is the Growth data (growth index per year): "+ calculateGrowth();
		return dataToBeReturned;
	}
	
	private int calculateGrowth(){
		return 10;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Plant plant1 = new Plant("Nilanka");
		
		System.out.println("Plant name: "+plant1.getName());
		System.out.println(plant1.getData());
		
		

	}

}
