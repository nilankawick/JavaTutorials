import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		/*
		 * Please use the following path schemes
		 */
		//String filePath = "/Users/nilanka/Desktop/example.txt";
		String filePath = "example.txt";
		File txtFile = new File(filePath);
		
		Scanner scanDoc = new Scanner(txtFile);
		
		int value = scanDoc.nextInt();
		
		System.out.println("Number : " + value);
		
		
		
		int lineCount = 2;
		scanDoc.nextLine();
		
		/*
		 * hasNextLine - has a next line to read
		 */
		while(scanDoc.hasNextLine()){
			String line = scanDoc.nextLine();
			System.out.println("Line no:"+lineCount+"-"+line);
			lineCount ++;
			
		}
		
		
		// closing the file 
		scanDoc.close();
	}

}

