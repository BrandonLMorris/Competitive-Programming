import java.util.*;

/*
 * Given a list of n numbers, find the maximum sum of three consecutive
 * elements. Output that sum and the position of the middle index.
 */

public class Titan {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the number of elements
    int n = in.nextInt();

    // Read the list and store as an array
    int[] wall = new int[n];
    for (int i = 0; i < n; i++) {
      wall[i] = in.nextInt();
    }

    // Counters to keep up with current max sum and postion
    int max = 0;
    int pos = -1;

    // Try every possible triple
    for (int i = 0; i < n - 2; i++) {
      int sum = wall[i] + wall[i+1] + wall[i+2];
      if (sum > max) {
        max = sum;
        // i is the left element, so add one. Add another one since 
        // zero-indexed
        pos = i+2;
      }
    }

    // Output the result
    System.out.println(max + " " + pos);
  }
}
