import java.util.Scanner;

public class App {
	public static void main(String[] args) {
	
		// Scanner object for capturing usr input
		Scanner usrInput = new Scanner(System.in);
		
		// variable to capture user input
		int usrInputNum = 0;
		
		//do while user input is not equal to 5
		do{
			//Prompt user to enter number 
			System.out.println("Input Number :");
			// storing user input 
			usrInputNum = usrInput.nextInt();
			// displaying the user entered input 
			System.out.println("the number entered : "+ usrInputNum);
		
			
		}
		while(usrInputNum != 5);
		
		// confirming that the user exited the loop
		System.out.println("You have entered 5!!! Now exiting");
			
	
		usrInput.close();
		
	}
}
