import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		System.out.println("Working with ArrayList");
		doTimings("ArrayList", arrayList);
		
		System.out.println("Working with LinkedList");
		doTimings("LinkedList", linkedList);
	}

		/*
		 * ArrayList general guidance is to use it where we will remove from the start or the end
		 * LinkedList is to be used for instances where we want to remove or add items to any location
		 */
	
	private static void doTimings(String type, List<Integer> list){
		
		long start = System.currentTimeMillis();
		
		for(int i=0;i<1E5;i++){
			list.add(i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("Initial Time taken to add items :" + (end-start)+" ms for - " + type);
		//System.out.println("Initial Size of List - "+list.size());
		//System.out.println("Last item in List - " + list.get(list.size()-1));
		/*
		for(Integer value: list){
			System.out.println(value);
		}
		*/
		
		System.out.println("");
		System.out.println("Add items at end of list");
		 start = System.currentTimeMillis();
		 
		 //Add items at end of list
		 /*
		  * 
		  */
		 for (int i =0; i<1E5; i++){
			 list.add(list.size(),i*2);
			
		 }
		
		/*
		 System.out.println("Add items at end of list\n");
		 for(Integer value: list){
				System.out.println(value);
			}
		*/
		 
		 
		 end = System.currentTimeMillis();
		 
		 
		 System.out.println("Time taken to add items to the end :" + (end-start)+" ms for - " + type);
		 //System.out.println("Revised Size of List - "+list.size());
		 //System.out.println("Last item in List - " + list.get(list.size()-1));
		 
		 //Add items elsewhere
		 System.out.println("");
		 System.out.println("Add items elsewhere");
		 start = System.currentTimeMillis();
		 for (int i =0; i<1E5; i++){
			 list.add(50,i);
		 }
		 
		 
		 end = System.currentTimeMillis();
		 System.out.println("Time taken to add elsewhere :" + (end-start)+" ms for - " + type);
		// System.out.println("Revised Size of List - "+list.size());
		 //System.out.println("Last item in List - " + list.get(list.size()-1));
		 System.out.println("");
	}
		
}
