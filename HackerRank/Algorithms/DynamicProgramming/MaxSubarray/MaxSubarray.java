import java.util.*;

public class MaxSubarray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int numInts = input.nextInt();
            int[] arr = new int[numInts];
            for(int i = 0; i < numInts; i++) {
                arr[i] = input.nextInt();
            }

            int maxEndingHere = arr[0];
            int maxSoFar = arr[0];
            int nonContigMax = 0;

            for(int i = 1; i < arr.length; i++) {
                maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
                maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }
            //maxSoFar is the contiguous maximum

            int arrMax = arr[0];
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > 0) {
                    nonContigMax += arr[i];
                }
                if(arr[i] > arrMax)
                    arrMax = arr[i];
            }
            if(nonContigMax == 0)
                nonContigMax = arrMax;

            System.out.println(maxSoFar + " " + nonContigMax);
        }
    }
}