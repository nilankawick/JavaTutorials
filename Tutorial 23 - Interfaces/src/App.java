
public class App {

	public static void main(String[] args) {
		
		Machine mach1 = new Machine(7);
		mach1.showInfo();
		
		System.out.println("");
		
		Person person1 = new Person("Nilanka");
		System.out.println("");
		
		/*
		 * with this you can only access what is defined in the interfqce
		 * `for example since the interface is implemented on machine and person class
		 * when you create an interface variable , you can only access the interface method 
		 * through that initiation
		 * 
		 * info2 allows us to access the interface that is already part of the Machine object 
		 * that was created with Mach1
		 * 
		 * info1 , we create a new machine but only with the interface methods
		 * 
		 * info3 same as info2 but for a person object person1
		 * 
		 */
		
		System.out.println("interface examples 1");
		
		Info info2 = mach1;
		
		info2.showInfo();
		
		System.out.println("");
		
		System.out.println("interface examples 2");
		Info info1 = new Machine(12);
		info1.showInfo();
		System.out.println("");
		
		System.out.println("interface examples 3");
		Info info3 = person1;
		info3.showInfo();
		System.out.println("");
		
		
		System.out.println("interface examples 4 ");
		/*
		 * You can pass any object that implements Info interface
		 */
		outputInfo(mach1);
		
		/*
		 * or You can pass the Interface variable that is directly referring to an
		 * interface method of an interface
		 */
		outputInfo(info3);
		outputInfo(info1);
	
	}
	
	
	private static void outputInfo (Info infor){
		infor.showInfo();
		
	}
}
