
public abstract class Machine {
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * We have created an abstract class
	 * the way we define a abstract class is quite similar to interfaces
	 * but the key is to override the same in the child classes
	 */
	public abstract void start();
	public abstract void stop();
	public abstract void doSomething();
	/*
	 * you can call abstract methods as shown below
	 */
	
	public void run(){
		start();
		doSomething();
		stop();
			
	}
		
	
	

}
