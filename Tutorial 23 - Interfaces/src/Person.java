
public class Person implements Info {
	
	private String name;
			
	
	
	public Person(String name) {
		
		this.name = name;
		greet();
	}



	public void greet(){
		System.out.println("Greetings");
	}



	@Override
	public void showInfo() {
		System.out.println("Name of this person :"+name);
		
	}

}
