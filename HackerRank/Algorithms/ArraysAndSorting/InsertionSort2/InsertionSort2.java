/*HackerRank :: Algorithms :: Arrays and Sorting :: Insertion Sort 2
 *Created by Brandon Morris 10 14/14
 */
import java.util.*;

public class InsertionSort2{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int arraySize = input.nextInt();
		int []array = new int[arraySize];
		for(int i = 0; i < arraySize; i++){
			array[i] = input.nextInt();
		}
		insertionSort(array);
	}

	static void insertionSort(int[] numbers){
		for(int i = 1; i < numbers.length; i++){
			for(int j = i; j > 0; j--){
				if(numbers[j] < numbers[j-1]){
					int temp = numbers[j-1];
					numbers[j-1] = numbers[j];
					numbers[j] = temp;
				}
			}
			//print out array each iterartion
			for(int k : numbers){
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}
