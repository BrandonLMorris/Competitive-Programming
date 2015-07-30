/*Hacker Rank :: Algorithms :: Arrays and Sorting :: Quicksort 1
 *Created by Brandon Morris 10/14/14
 */
import java.util.*;

public class Quicksort1{
    public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int pivot;
	ArrayList<Integer> lessList = new ArrayList<Integer>();
	ArrayList<Integer> greaterList = new ArrayList<Integer>();
	
	int numElements = input.nextInt();
	pivot = input.nextInt();
	for(int i = 0; i < numElements-1; i++){
	    int element = input.nextInt();
	    if(element < pivot) lessList.add(element);
	    else greaterList.add(element);
	}

	//print results
	for(int i : lessList) System.out.print(i + " ");
	System.out.print(pivot + " ");
	for(int i : greaterList) System.out.print(i + " ");
	System.out.println();
    }
}
