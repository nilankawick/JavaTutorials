 
public class App {

	
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal animal = Animal.MOUSE;
		animal.setName("meeya");

	
		
		/*
		 * usage of switch with enums
		 */
		switch (animal){
		case CAT:
			System.out.println("Pet is a cat...");
			break;
		case DOG:
			System.out.println("Pet is a dog...");
			break;
		case MOUSE:
			System.out.println("Pet is a mouse...");
			break;
		case RAT:
			System.out.println("Pet is a rat...");
			break;
			
		default:
			System.out.println("No pet selected");
			break;
		
		}
		System.out.println(animal.MOUSE);
		System.out.println("");
		
		/*
		 * Because we have overriden toString() in Animal enum, we will now get the 
		 * name of the animal we have specified hence, the following line
		 * will give you the pet name
		 */
		System.out.println(animal.DOG);
		
		/*
		 * with enums by using name() which automatically inherited we can get the ename type
		 */
		System.out.println("enum name or type is : "+animal.DOG.name());
		
		/*
		 * enums are special classes or objects when initiated
		 * hence the following will get you the confirmation 
		 */
		System.out.println(animal.DOG.getClass());
		
		
		/*
		 * usage of methods with enums 
		 * please note that when we initiated a enum at the very top
		 */
		System.out.println("Animal name is "+animal.getName());
		
		
		Animal animal2 = Animal.valueOf("CAT");
		System.out.println(animal2);

	}

}
