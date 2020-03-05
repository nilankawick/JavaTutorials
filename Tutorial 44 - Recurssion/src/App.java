
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello - example on recurrsion");
		
		/*
		 * use of static methods
		 */
		//int val = 4;
		int fact = factorial(5);
		System.out.println(fact);
		
			

	}
	/*
	 * reason for using STATIC is that we are planning to use calculate() without
	 * having a object of App, i.e 
	 * App app = new App();
	 * app.calculate();
	 * 
	 * with the use of STATIC we are allowed to use calculate method from main method or any other 
	 * method in APP
	 */
	private static int factorial(int value){
		//System.out.println("Ready to calculate");
		System.out.println(value);
		
		/*
		 * example of recursion , 
		 * in this  example we are calling CALCULATE() from within in CALCULATE
		 * this leads up to an infinite loop resulting in an stackoverflow error
		 */
		//calculate(value-1);
		
		/*
		 * to stop the infinite loop the following breaker can be used
		 */
		if (value ==1){
			return 1;
		}
		return factorial(value-1) * value;
	}
}
