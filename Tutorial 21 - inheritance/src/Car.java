
public class Car extends Machine {
	
	/*
	 * override of parent class method(non-Javadoc)
	 * @see Machine#start()
	 */
	@Override
	public void start(){
		System.out.println("Car Started");
	}
	@Override
	public void stop(){
		System.out.println("Car Stopped");
	}

	/*
	 * shown below is a method that is only available for Car Method
	 */
	public void wipeWindShield(){
		System.out.println("Wipping wind shields");
	}
	
	public void showInfo(){
		System.out.println("Type: ");
		System.out.println(this.getName());
		
	}
	
}
