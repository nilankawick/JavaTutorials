
public class Machine implements Info {
	
	private int id;
	
	public Machine (int id){
		this.id = id;
		start();
	}
	
	public void start(){
		System.out.println("Machine Started ");
	}

	@Override
	public void showInfo() {
		System.out.println("ID of this machine :"+id);
		
	}

}
