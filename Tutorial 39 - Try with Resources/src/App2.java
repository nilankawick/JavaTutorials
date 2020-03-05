import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("test.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("cant find file"+ file.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); 
			System.out.println("Could not read the file"+file.toString());
		}
		

	}

}
