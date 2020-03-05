import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();

		/*
		 * Handling exceptions
		 * 
		 */
		/*
		 * try { 
		 * test.run(); 
		 * } catch (IOException e) { 
		 * e.printStackTrace(); 
		 * } catch (ParseException e) { 
		 * e.printStackTrace();
		 * System.out.println("Could not parse command file"); 
		 * }
		 */

		/*
		 * example of multi catch
		 */
		/*
		 * try { 
		 * test.run(); 
		 * } catch (IOException | ParseException e) { 
		 * //e.printStackTrace();
		 * System.out.println("Multi catch: Could not parse command file"); 
		 * }
		 */

		/*
		 * Because of polymorphism the same principles can be used to exception handling
		 *  in this particular instance Exception is the parent class for all exceptions
		 *  therefore the following example the parent is used to handle all exceptions   
		 */
		try {
			test.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Catching through Parent Exception: Could not parse command file");
		} 


		
		/*
		 * In this example we have Parent and child Exceptions
		 * parent - IOException
	 * 			Child - FileNotFoundException
	 * therefore for the catch to work as expected we would have to first list the child exception
	 * and then list the parent exception
		 */
		try {
			test.input();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("File not found exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("IO exception");
		}
		
		System.out.println("Complete");
	}

}
