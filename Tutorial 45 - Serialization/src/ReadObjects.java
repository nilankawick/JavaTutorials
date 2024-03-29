import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Reading Objects .....");
		
		try(FileInputStream fi = new FileInputStream("people.bin")){
			
			ObjectInputStream os = new ObjectInputStream(fi);
			
			/*
			 * when we read an object we would only get details associated to the
			 * OBJECT parent class. we would then have to upcast to PERSON class
			 */
			Person person1 = (Person)os.readObject();
			Person person2 = (Person)os.readObject();
			os.close();
			
			 
			System.out.println(person1);
			System.out.println(person2);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
