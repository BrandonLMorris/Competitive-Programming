/**ACM ICPC Knitting
 *Solution by Brandon Morris
 *Created 10/11/2014
*/
import java.util.*;

public class Knitting{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int rowStiches = input.nextInt();		//inputs the number of stiches on the first row
		while(rowStiches != 0){
			int totalRows  = input.nextInt();		//number of rows in the knitting project
			int numPattern = input.nextInt();		//number of rows in the pattern
			int[] pattern = new int[numPattern];		//integer array to store the pattern
			int stitchCounter = 0;				//counter for the number of stiches
	
			//initialize the pattern array
			for(int i = 0; i < numPattern; i++){
				pattern[i] = input.nextInt();
			}
	
			//iterate through each row in the project, adding the number of stiches to the project
			for(int i = 0; i < totalRows; i++){
				stitchCounter += rowStiches;		//add current row
				rowStiches += pattern[(i%numPattern)];	//modify the row based on the pattern
			}
			
			//print result
			System.out.println(stitchCounter);
			rowStiches = input.nextInt();
		}
	}
}
