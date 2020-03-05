
public class App {
	
	public static void main(String[] args) {
		
		Plant plant1 = new Plant();
		Tree tree = new Tree();
		
		/*
		 * polymorphism allows us to use child initiations to access or create parent objects
		 * but you can only access the common methods between the child and parent classes
		 */
		Plant plant2 = tree;
		
		plant2.grow();
		
		plant1.grow();
	
		tree.shedLeaves();
		
		doGrow(tree);  

	}

	public static void doGrow(Plant plant){
		plant.grow();
	}
}
