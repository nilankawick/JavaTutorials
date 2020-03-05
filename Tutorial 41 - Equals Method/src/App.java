 class Person{
	private int id;
	private String name;
	
	public Person(int id, String name){
		this.name = name;
		this.id = id;
				
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	 
	
}


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new Object());
		System.out.println("");
		
		Person person1 = new Person(24,"nilanka");
		Person person2 = new Person(24,"nilanka");
		
		/*
		 * Shows that both Person1 and Person2 are not equal, with  equal/equal "=="
		 * what is being checked is if that the references are pointing to the same object 
		 * therefore in line 71 we are saying that the person2 is referring or pointing to person 1
		 * which is false
		 * 
		 * in other words for primitive type
		 * int,char,string,double they check if the values are equal 
		 * and for non-primitive (objects) == would check if they point at the same object
		 */
		//
		System.out.println("check through primitive mechanism");
			System.out.println(person1 == person2);
		
		/*
		 * with the follwing statement Person2 points at the same reference of Person 1
		 * hence person1==person2 would be TRUE
		 */
			System.out.println("check through primitive mechanism when pointing at the same reference");
		person2 = person1;
		System.out.println(person1 == person2);
		
		
		/*
		 * Using equals method to examine the content to see if both are the same
		 */
		System.out.println("");
		
		System.out.println("Using equals method to examine the content to see if both are the same");	
			
		System.out.println(person1.equals(person2));
		System.out.println("");
		
		Double value1 = 7.2;
		Double value2 = 7.2;
		System.out.println("check through primitive mechanism");
		System.out.println(value1==value2);
		System.out.println("");
		System.out.println("Using equals method to examine the content to see if both are the same");
		System.out.println(value1.equals(value2));
		System.out.println("");
		
		Integer number1 = 6;
		Integer number2 = 6;
		System.out.println("check through primitive mechanism");
		System.out.println(number1==number2);
		System.out.println("");
		
		String text1 = "Hello";
		String text2 = "Hello Nilanka".substring(0,5);
		System.out.println(text2);
		
		System.out.println(text1==text2);
				
	}

}
