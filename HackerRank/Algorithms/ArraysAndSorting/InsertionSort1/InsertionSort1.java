/*HackerRank :: Algorithms :: Arrays and Sorting :: Insertion Sort Part 1
 *Created by Brandon Morris 10/14/2014
 */
import java.util.*;

public class InsertionSort1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int arraySize = input.nextInt();
		int[] array = new int[arraySize];
		for(int i = 0; i < arraySize-1; i++){		//initialize array up to second to last index
			array[i] = input.nextInt();
		}
		//array[array.length-1] = array[array.length-2];	//copy second to last value to last index
		int insertValue = input.nextInt();
		int emptyIndex = array.length-1;		//keeps up with which index is "empty"
		for(int j = array.length-2; j >= -1; j--){
			if(j == -1){
				array[0] = insertValue;
			}
			else if(insertValue > array[j]){
				array[emptyIndex] = insertValue;
				break;
			}
			else {
				array[emptyIndex] = array[j];
				emptyIndex--;
				for(int value : array){
					System.out.print(value + " ");
				}
				System.out.println();
			}
		}

		//print out final list
		for(int i : array){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
