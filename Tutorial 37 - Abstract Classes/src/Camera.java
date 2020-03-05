
public class Camera extends Machine implements Info {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Starting a Camera");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Stopping a Camera");
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("Camera snapping");
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("Camera is initiated with the ID :"+this.getId());
	}
	

}
