class Robot{
	public void speak(String text){
		System.out.println(text + " Nilanka");
		
		
	}
	public void age(int age){
		System.out.println("and my age is "+age);
	}
	
	public void dob(int day,int month, int year){
		System.out.println("DOB is :"+day+"-"+month+"-"+year);
	}
}



public class App {

	public static void main(String[] args) {
		Robot nilanka = new Robot();
		
		nilanka.speak("Hi my name is");
		
		int usrAge = 35;
		nilanka.age(usrAge);
		
		nilanka.dob(23,12,1982);
		
			
		
		
	}
	

}
