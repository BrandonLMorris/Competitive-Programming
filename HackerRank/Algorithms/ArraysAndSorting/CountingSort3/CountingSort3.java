/* HackerRank :: Algorithms :: Arrays and Sorting :: Counting Sort 2
 * Created by Brandon Morris 10/29/2014
 */
import java.util.*;

public class CountingSort3 {
    public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int[] numbers = new int[101];
	int n = Integer.parseInt(input.nextLine());

	for(int i = 0; i < n; i++){
	    int num = input.nextInt();
	    numbers[num]++;
	    input.nextLine();
	}

	int counter = 0;

	for(int i = 0; i < 100; i++) {
	   counter += numbers[i];
	   System.out.print(counter + " ");
	}
    }
}
