import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Writing Objects.......");
		
		/*
		 * Person[] people = {new Person(004,"Anoja"),new Person(005,"Ranjith")};
		 */
		/*
		ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
		*/
		
		Person person = new Person(004,"Anoja&Ranjith");
		
		/*
		 * since set count is a static method, you cannot access it via a new Person object
		 * i.e; person.setCount();
		 * when accessing static methods you will have to access the same via the class
		 * i.e; Person.setCount();
		 * 
		 */
		Person.setCount(1982);
		
		
		/*
		 * Using try with resources
		 */
		try(FileOutputStream fs = new FileOutputStream("test.ser"); ObjectOutputStream os = new ObjectOutputStream(fs)){
			
			
			/*os.writeObject(people);
			os.writeObject(peopleList);
			
			os.writeInt(peopleList.size());
			
			for(Person person: peopleList){
				 os.writeObject(person); 
			}
			*/
			
			os.writeObject(person);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
