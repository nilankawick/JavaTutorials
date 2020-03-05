import java.io.Serializable;

/*
 * to allow a class to be serializable we import the serializable interface
 */
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 701633306273802062L;
	private int id;
	private String name;
	
	
	public Person(int id, String name){
		this.id = id;
		this.name = name;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		
		return "Person [id=" + id + ", name=" + name + "]";
		
	}
	
	

}
