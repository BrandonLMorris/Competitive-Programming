/**
 * Two Arrays
 * HackerRank :: Algorithms :: Arrays and Sorting
 * Created by Brandon Morris 11/4/2014
 */
import java.util.*;

public class TwoArrays{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int arraySize = input.nextInt();
            int minVal = input.nextInt();
            
            ArrayList<Integer> arr1 = new ArrayList<Integer>(arraySize);
            ArrayList<Integer> arr2 = new ArrayList<Integer>(arraySize);
            
            for(int i = 0; i < arraySize; i++) {
                arr1.add(input.nextInt());
            }
            for(int i = 0; i < arraySize; i++) {
                arr2.add(input.nextInt());
            }

            Collections.sort(arr1);
            Collections.sort(arr2);

            boolean isYes = true;
            for(int i = 0; i < arraySize; i++) {
                if(arr1.get(i) + arr2.get(arraySize - i - 1) < minVal) {
                    isYes = false;
                    break;
                }
            }

            System.out.println(isYes ? "YES" : "NO");
        }
    }
}
