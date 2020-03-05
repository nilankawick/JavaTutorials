import java.util.Random;

public class App {
	public static void main(String[] args) {
		
		int[] valArray;
		
		valArray = new int[3];
		
		//System.out.println(valArray [0]);
		
		valArray [0] = 1;
		valArray [1] = 30;
		valArray [2] = 12;
		
		Random rand = new Random();
		int y = rand.nextInt(valArray.length);
		System.out.println("Getting a random value from array");
		System.out.println(valArray[y]);
		System.out.println("");
		
		
		for(int i = 0; i<valArray.length; i++){
			System.out.println(valArray[i]);
		}
	}

}
