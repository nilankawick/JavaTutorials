import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		
		// Create scanner object
		Scanner input = new Scanner(System.in);
		
		// user prompt
		System.out.println("Enter string : ");
		
		// capture user entry
		String line = input.nextLine();
		
		//user prompt for a integer
		System.out.println("Enter number : ");
		int num = input.nextInt();
		
		//Output the entry
		System.out.println("You have entered: "+ line);
		System.out.println("and the number :"+ num);
		input.close();
	}
}
