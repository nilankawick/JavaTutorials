import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Test {

	public void run() throws IOException, ParseException{
		
		//throw  new IOException();
		
		throw new ParseException("Error in Command: ",2);
		
		
	}
	
	/*
	 * In this example  we are parsing parent and child exceptions 
	 * parent - IOException
	 * Child - FileNotFoundException
	 */
	public void input() throws IOException, FileNotFoundException {
		
		throw new FileNotFoundException("File not found");
	}
}
