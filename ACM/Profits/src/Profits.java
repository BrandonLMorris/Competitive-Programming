/**
 * Created by bmorris on 11/24/14.
 * Kadane's Algorithm
 */
import java.util.*;

public class Profits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numDays = input.nextInt();
        while (numDays != 0) {
            int[] days = new int[numDays];

            for (int i = 0; i < numDays; i++) {
                days[i] = input.nextInt();
            }

            int maxEndingHere = days[0];
            int maxSoFar = days[0];

            //System.out.println("i\tMEH\tMSF");
            for(int i = 1; i < days.length; i++) {
                maxEndingHere = Math.max(days[i], maxEndingHere + days[i]);
                maxSoFar = Math.max(maxEndingHere, maxSoFar);
                //System.out.println(Integer.toString(days[i]) + '\t' + Integer.toString(maxEndingHere) + '\t' + Integer.toString(maxSoFar));
            }

            System.out.println(maxSoFar);

            numDays = input.nextInt();
        }
    }
}

/**
 * Kadane's Algorithm
 * Computes at each position the maximum subarray ending in that position
 * Subarray is either the element itself (starting a new subarray) or
 * consists of one more element than the maximum subarray ending at the
 * previous position
 *
 * 1. First element set as maximum subarray
 * 2. For each element after the first:
 *       maxEndingHere either set to current element or current element plus previous maximum subarray
 *       If current subarray is greatest so far, set to maxSoFar
 * 3. Return maxSoFar
 */
