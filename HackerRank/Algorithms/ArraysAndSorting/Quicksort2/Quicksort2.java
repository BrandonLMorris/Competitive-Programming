/*HackerRank :: Algorithms :: Arrays and Sorting :: Quicksort 2 - Sorting
 *Created by Brandon Morris 10/14/14
 */
import java.util.*;

public class Quicksort2{
	public static int depthCounter = 0;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int numElements = input.nextInt();
		ArrayList<Integer> array = new ArrayList<Integer>(numElements);
		//initialize the array with values
		for(int i = 0; i < numElements; i++){
			array.add(input.nextInt());
		}
		partition(array, 0, array.size()-1);
	}
	
	static void partition(ArrayList<Integer> array, int left, int right){
	    	int pivot = array.get(left);
		ArrayList<Integer> lessList = new ArrayList<Integer>(right - left);
		ArrayList<Integer> greaterList = new ArrayList<Integer>(right - left);
		for(int i = left + 1; i <= right; i++){
		    if(array.get(i) < pivot){
			lessList.add(array.get(i));
		    } else {
			greaterList.add(array.get(i));
		    }
		}

		//store the lengths of the subarrays
		int lessLength = lessList.size();
		int greaterLength = greaterList.size();

		//Reconstruct the array with the pivot in the middle
		int index = left;
		for(int i : lessList) {
		    array.set(index, i);
		    index++;
		}
		array.set(index, pivot);
		index++;
		for(int i : greaterList) {
		    array.set(index, i);
		    index++;
		}

		//repeat recursively until subarrays <= 1 in length
		if(lessList.size() > 1) {
		    partition(array, left, left+lessList.size()-1);
		}
		if(greaterList.size() > 1) {
		    partition(array, left+lessList.size()+1, left+lessList.size()+greaterList.size());
		}
		
		//Print out final sorted array
		for(int i = left; i <= right; i++) {
		    System.out.print(array.get(i) + " ");
		}
		System.out.println();

	}
}
