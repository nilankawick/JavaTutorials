package demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test1.txt");

		try {
			FileReader fr = new FileReader(file);
			
			System.out.println("File Found, Continuing.....");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found: "+  file.toString());
			
			//e.printStackTrace();
		}
		System.out.println("Shall progress!!!");
	}

}
