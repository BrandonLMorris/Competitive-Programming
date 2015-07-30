/*HackerRank :: Algorithms :: Warmup :: Filling Jars
 *Created by Brandon Morris 10/13/2014
 */
import java.util.*;

public class FillingJars{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long numJars = input.nextInt();
		long numOperations = input.nextInt();
		long candyCounter = 0;				//keeps up with total number of candies added
		for(int i = 0; i < numOperations; i++){
			long a = input.nextInt();		//first jar bound of operation
			long b = input.nextInt();		//second jar bound of operation
			long numCandies = input.nextInt(); 	//number of candies added to each jar
			candyCounter += (b-a+1)*numCandies;	//total candies added to jars from operation (bounds inclusive)
		}
		long avgCandies = candyCounter/numJars;
		System.out.println(avgCandies);
	}
}
