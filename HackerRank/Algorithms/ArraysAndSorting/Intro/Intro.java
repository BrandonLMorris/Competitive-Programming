/*HackerRank :: Algorithms :: Arrays and Sorting :: Intro to Challenges
 *Created by Brandon Morris 10/14/14
 */
import java.util.*;

public class Intro{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int searchNum = input.nextInt();
		int arraySize = input.nextInt();
		int indexLocation = 0;
		for(int i = 0; i < arraySize; i++){
			if (searchNum == input.nextInt()){
				indexLocation = i;
			}
		}
		System.out.println(indexLocation);
	}
}
