import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class App {
	public static void main(String[] args) {
		File file = new File("testfilewriter.txt");
		
		
		/*
		 * When you use try with resources as shown below we do not
		 * need to explicitly close any resources that are being used
		 *in this example we do not need to use br.close()
		 */
		try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
			br.write("This is line 1");
			br.newLine();
			br.write("This is line 2");
			br.newLine();
			br.write("This is line 3");
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			 //e.printStackTrace();
			System.out.println("Cannot read file - "+file.toString());
		}
		
		/*
		 * refer tutorial 45
		 */
		
		/*
		try(FileOutputStream fs = new FileOutputStream("people.txt")){
			
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeChars("Kasun");
			os.writeChars("/n");
			os.writeChars("Arienda");
			os.writeChars("Nilanka");
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		

	}
}
