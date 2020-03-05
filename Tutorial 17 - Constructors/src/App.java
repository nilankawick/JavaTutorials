class Machine{
	//Instance variable  
	private String name; 
	private int code;
	
	
	// constructor does not require to have a return type void or any other return type
	// constructor name should match the class name , in this example Machine == Machine
	public Machine() {
		this("default",0);
		System.out.println("Base Constructor Running!");
		//this.name="default";
		//this.code= 0;
		
	}
	
	public Machine(String name){
		this(name,0);
		this.name = name;
		System.out.println("second constructor running");
	}
	
	public Machine(String name, int code)
	{
		this.name = name;
		this.code = code;
		System.out.println("Third Constructor running");
		
	}
	public String getName(){
		return name;
			
	}
	
	public int getCode(){
		return code;
	}
		
}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			
			Machine mach1 = new Machine();
			System.out.println("Name: "+ mach1.getName()+" Code: "+ mach1.getCode());
			
			Machine mach2 = new Machine("T56");
			System.out.println("Name: "+mach2.getName()+" Code: "+mach1.getCode());
			
			Machine mach3 = new Machine("LMG",8004671);
			System.out.println("Name :"+mach3.getName()+" Code :"+mach3.getCode());
	}

}
