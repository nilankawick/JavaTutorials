class Frog {
	private String name;
	private int age;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setInfo(String name, int age){
		setName(name);
		setAge(age);
	}
}


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frog frog1 = new Frog();
		
		//frog1.setName("bertie");
		//frog1.setAge(30);
		
		frog1.setInfo("bertie",34);
		
		System.out.println("Name is: "+ frog1.getName());
		System.out.println("age : " +frog1.getAge());
				
	}

}
