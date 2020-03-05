import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String[] words = new String[3];
		String usrInput = null;

		for (int i = 0; i < words.length; i++) {
			System.out.println("Enter String:");
			usrInput = input.nextLine();
			words[i] = usrInput;

		}
		System.out.println("All required data has been entered");
		System.out.println("please enter Y to show the entry or N to exit:");

		usrInput = input.nextLine();

		switch (usrInput) {
		case "Y":
			System.out.println("The details entered into the system are:");
			for (String usrEntry : words) {
				System.out.println(usrEntry);
			}
			break;

		case "N":
			System.out.println("Program exit initiated");
			break;

		default:
			System.out.println("invalid command");

		}
		input.close();

	}
}
