
public class Machine {
	
	private String name = "This is a machine";
	
	
	public void start(){
		System.out.println("machine Started");
	}

	public void stop(){
		System.out.println("Machine Stopped");
	}
	
	public void setName(String name){
		this.name=name;
		
	}
	
	public String getName(){
		return this.name;
	}
}
