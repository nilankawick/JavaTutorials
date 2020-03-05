class Person {

	// instance variable of class
	String name = "nilanka";
	int age = 35;
	String dob = "23-12-1982";
	double mobile = 077;

	// creating subroutine (or subroutine)
	 

	void speak() {
		System.out.println("Hello My Name is: " + name);
	}

	int yearsRemainingForRetirement() {
		int yearsLeft = 65 - age;
		// System.out.println(yearsLeft);
		return yearsLeft;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
		
	}
	
	public String getDob(){
		return dob;
		
	}
		

}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Intro into Objects");
		System.out.println();

		Person person1 = new Person();
		System.out.println("default person details:");
		
		// System.out.println(person1.name);
		int age = person1.getAge();
		String dateOfBirth = person1.getDob();
		int yearsTillRet = person1.yearsRemainingForRetirement();
		person1.speak();
		System.out.println("Age is:"+age);
		System.out.println("DOB:"+dateOfBirth);
		System.out.println(yearsTillRet);
		System.out.println();
		
		// new attributes for pearson 1
		person1.age = 28;
		person1.name = "Methsala";
		person1.dob = "10-05-1984";

		person1.speak();
		yearsTillRet = person1.yearsRemainingForRetirement();
		System.out.println("Age is:"+person1.getAge());
		System.out.println("DOB:"+person1.getDob());
		System.out.println(yearsTillRet);
		
		//person1.yearsRemainingForRetirement();
		// System.out.println(person1.name);
		// System.out.println(person1.age);
		// System.out.println(person1.dob);

	}

}
