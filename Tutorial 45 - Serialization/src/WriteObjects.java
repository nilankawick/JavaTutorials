import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Writing Objects.......");
		
		Person mike = new Person(23,"Mike");
		Person nilanka = new Person(12,"Nilanka");
		
		System.out.println(mike);
		System.out.println(nilanka);
		
		/*
		 * Using try with resources
		 */
		try(FileOutputStream fs = new FileOutputStream("people.bin")){
			
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(mike);
			os.writeObject(nilanka);
			
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
