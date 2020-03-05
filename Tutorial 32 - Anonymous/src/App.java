 class Machine {
	public void Start() {
		System.out.println("Machine Starting......");
	}
}

interface Plant {
	public void grow();
}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * In this example we overriding the parent class method without a child
		 * initiation(child class that extends parent) this is known as
		 * anonymous class
		 */
		Machine machine1 = new Machine() {
			@Override
			public void Start() {
				System.out.println("Machine is a camera, and its snapping!!!!!");
			}
		};

		machine1.Start();

		/*
		 * Example of anonymous classes with an interface
		 */
		Plant plant1 = new Plant() {
			@Override
			public void grow() {
				// TODO Auto-generated method stub
				System.out.println("Plant is Growing.....");
			}
		};

		plant1.grow();
	}

}
