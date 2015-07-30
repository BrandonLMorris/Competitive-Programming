/**
 * Running Time of Quick Sort
 * HackerRank :: Algorithms :: Arrays and Sorting
 * Created by Brandon Morris 11/4/14
 */
import java.util.*;

public class RunningTimeOfQuickSort {
	static int qsCount = 0;
	static int isCount = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		ArrayList<Integer> copy = new ArrayList<Integer>(n);

		for(int i = 0; i < n; i++){
			array[n] = input.nextInt();
			copy.add(array[n]);
		}

	}

	private static void insertionSort(int[] numbers){
		for(int i = 1; i < numbers.length; i++){
			for(int j = i; j > 0; j--){
				if(numbers[j] < numbers[j-1]){
					int temp = numbers[j-1];
					numbers[j-1] = numbers[j];
					numbers[j] = temp;
					isCount++;
				}
			}
		}
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