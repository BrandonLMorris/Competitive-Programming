/*HackerRank :: Algorithms :: Warmup :: Sherlock and Squares
 *Created by Brandon Morris 10/13/14
 */
import java.util.*;

public class SherlockAndSquares{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int numTestCases = input.nextInt();
		for(int i = 0; i < numTestCases; i++){
			long a = input.nextInt();
			long b = input.nextInt();
			int squareCounter = 0;
			for(int j = (int) Math.ceil(Math.sqrt(a));;j++){
				long numSquared = j*j;
				if(numSquared > b) break;
				squareCounter++;
			}
			System.out.println(squareCounter);
		}
	}
}
