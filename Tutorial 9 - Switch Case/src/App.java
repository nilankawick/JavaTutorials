import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter command :");

		String usrInput = input.nextLine();

		switch (usrInput) {
		case "Start":
			System.out.println("Machine Started");
			break;

		case "Stop":
			System.out.println("Machine stopped");
			break;

		default:
			System.out.println("Incorrect command");

		}
		System.out.println("exit complete");
	input.close();
	}

}
