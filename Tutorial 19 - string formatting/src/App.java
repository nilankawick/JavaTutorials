
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//inefficient way of managing string and associated memory management
		
		String info = "";
		
		info += "Hello my name is nilanka";
		info += " and";
		info += " I am Project Manager.";
		
		System.out.println(info);
		
		StringBuilder sb = new StringBuilder("");
		
		sb.append("hello");
		sb.append(" My name is nilanka");
		sb.append(" and i am sleepy");
		
		System.out.println(sb.toString());
		
		StringBuilder s = new StringBuilder();
		
		s.append("Hi")
		.append(" My name is FCUK")
		.append(" enjoy");
		
		System.out.println(s.toString());
		
		////string formatting////
		
		System.out.print("here is some text \n and we used a new line");
		System.out.println("");
		
		// character replacement and formatting integers
		System.out.printf("my age is: %d and my sons name is : Lasen \n he is %d months old\n",34,10);
	
		for (int i =1; i<=15; i++){
			System.out.printf("%-"+i+"d *wow %s*\n",i,"!!! ");
		}
		
		//formatting floating point values
		System.out.printf("total value is : %.2f\n", 5.678);
		System.out.printf("total value is : %6.3f\n",12.234567);
		
				
	}

}
