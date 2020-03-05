
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] text = {"one","two","three"} ;
		
		
		
		/*
		 * runtime exceptions are ones that need not necessarily to be handled by try catch
		 * 
		 */
		try{
			System.out.println(text[3]);
		}catch(RuntimeException e){
			System.out.println(e.toString());
		}

	}

}
