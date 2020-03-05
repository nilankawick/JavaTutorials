import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * the FILE object is a representation of files
		 * allows u to access a file
		 */
		File file = new File("test.txt");
		BufferedReader br = null;

		try {
			/*
			 * FILEREADER is used to read a file or will allow you to open
			 * a file 
			 * CATCH BLOCK 1
			 */
			FileReader fr = new FileReader(file);
			
			/*
			 * BufferedReader allows you read file line-by-line
			 */
			br = new BufferedReader(fr);

			String line;
			/*
			 * CATCH BLOCK 2 - file can be opened but cannot be read
			 */
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			/*
			 * catch for FilerReader , which is a indication of the file not being found
			 * or not being able to find file 
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("File not Found - " + file.toString());
			System.out.println("");
			/*
			 *Catch for being unable to read file  
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			System.out.println("Unable to Read file - " + file.toString());
			System.out.println("");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("Unable to close file - " + file.toString());
			} catch (NullPointerException ex) {
				// file was never opened
			}
		}

	}

}
