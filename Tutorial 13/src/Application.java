
class Person {
	String name = "nilanka" ;
	int age = 35;
	String dob = "23-12-1982";
	double mobile = 077 ;
	
	
	
		
}


public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Intro into Objects");
		
		Person person1 = new Person();
		System.out.println("default person details:");
		System.out.println(person1.name);
		person1.age = 28;
		person1.name = "Methsala";
		person1.dob = "10-05-1984";
		
		
		System.out.println(person1.name);
		System.out.println(person1.age);
		System.out.println(person1.dob);
		
				
	}

}
