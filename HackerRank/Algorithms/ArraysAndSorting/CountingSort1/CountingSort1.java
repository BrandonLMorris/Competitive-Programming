/* HackerRank :: Algorithms :: Arrays and Sorting :: Counting Sort 1
 * Created by Brandon Morris 10/29/2014
 */
import java.util.*;

public class CountingSort1 {
    public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int[] numbers = new int[101];
	int n = input.nextInt();

	for(int i = 0; i < n; i++){
	    numbers[input.nextInt()]++;
	}

	for(int i = 0; i < 100; i++) {
	    System.out.print(numbers[i] + " ");
	}
    }
}
