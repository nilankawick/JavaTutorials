
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { { 23, 12, 1982 }, { 10, 05, 1984 }, { 9, 12, 1948 } };

		//System.out.println(grid [1][2]);
		
		for (int row=0; row<grid.length; row++){
			System.out.print("row"+ row +".\t");
			
			//System.out.print(col+".\t");
			for (int col=0; col<grid[row].length;col++){
				
				System.out.print(grid[row][col] +"\t");
			}
			System.out.println();
		}
	}
	
	
}
