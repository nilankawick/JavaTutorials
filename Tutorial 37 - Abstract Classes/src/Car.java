
public class Car extends Machine implements Info {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Starting a car");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Stopping a car");	
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("Car is moving");
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("Car is initiated with the ID :"+this.getId());
	}

}
