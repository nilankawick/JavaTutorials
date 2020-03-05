import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Writing Objects.......");
		
		Person[] people = {new Person(001,"Methsala"),new Person(002,"Lasen"), new Person(003,"Nilanka")};
		
		ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
		
		
		/*
		 * Using try with resources
		 */
		try(FileOutputStream fs = new FileOutputStream("people.bin")){
			
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(people);
			os.writeObject(peopleList);
			
			os.writeInt(peopleList.size());
			
			for(Person person: peopleList){
				 os.writeObject(person); 
			}
			
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
