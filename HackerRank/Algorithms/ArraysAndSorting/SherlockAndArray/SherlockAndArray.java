/**
 * Sherlock and Array
 * HackerRank :: Algorithms :: Arrays and Sorting
 * Created by Brandon Morris 11/4/2014
 */
import java.util.*;

public class SherlockAndArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int n = input.nextInt();
            int[] arr = new int[n];
            int arrCounter = 0;
            for(int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
                arrCounter += arr[i];
            }

            boolean foundElement = false; 
            int leftSum = 0;
            int rightSum = arrCounter;
            for(int i = 0; i < n; i++) {
               rightSum -= arr[i];
               if(rightSum == leftSum){
                   foundElement = true;
                   break;
               }
               leftSum += arr[i];
            }

            System.out.println(foundElement ? "YES" : "NO");
        }
    }
}
