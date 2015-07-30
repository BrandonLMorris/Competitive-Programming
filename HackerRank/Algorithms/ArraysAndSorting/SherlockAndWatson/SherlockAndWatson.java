/** 
 * Sherlock and Watson
 * HackerRank :: Algorithms :: Arrays and Sorting
 * Created by Brandon Morris 11/5/2014
 */
import java.util.*;

public class SherlockAndWatson {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int numElements = input.nextInt();
        int numOperations = input.nextInt();
        int numQueries = input.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>(numElements);
        for(int i = 0; i < numElements; i++) {
            arr.add(0);
        }
        for(int i = 0; i < numElements; i++) {
            if(numOperations + i < numElements) {
                arr.set(i + numOperations, input.nextInt());
            } else {
                arr.set((i+numOperations) % numElements, input.nextInt());
            }
        }

        for(int i = 0; i < numQueries; i++) {
            System.out.println(arr.get(input.nextInt()));
        }
    }
}
