 package demo3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			openFile();
			System.out.println("File Found, Continuing.....");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		System.out.println("File not could be found!!!!");
		}
		System.out.println("Shall progress!!!");
		
	}

	public static void openFile() throws FileNotFoundException{ 
		File file = new File("test1.txt");
		FileReader fr = new FileReader(file); 
	}
}
