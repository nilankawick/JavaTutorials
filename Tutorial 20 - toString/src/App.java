class Frog {
	private int id;
	private String name;
	
	public Frog (int id, String name){
		this.setID(id);
		this.setName(name);
	}
	
	// to string method
	/*
	 * when you use System.out.println, the toString() method is initiated by default, 
	 * you can access the toString by just referring to the instance name within a System.out.println call
	 * see line number 65, 66
	 * 
	 * if you don't have toString method defined System.out.println and call the class name you will
	 * see the output as follows
	 * "class name@class hashcode", to see the output comment the toString()
	 */
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.getID())
		.append(": ")
		.append(this.getName());
		
		
		return sb.toString();
		
	}
	
	public String getName(){
		return this.name;
		
	}
	
	public void  setName(String name){
		this.name = name;
	}
	
	public int getID(){
		return this.id;
		
	}
	
	public void setID(int id){
		this.id = id;
		
	}
	
	
}

public class App {

	public static void main(String[] args) {
	
		/*
		 * creating an instance of Frog, and by default since there is a constructor,
		 *  the constructor is called
		 */
		Frog frog1 = new Frog(7,"Nilanka");
		Frog frog2 = new Frog(3,"methsala");
		
		System.out.println(frog1);
		System.out.println(frog2);
	}
}
