import java.util.*;

/*
 * Given a list of n integers, find the maximum and mimum difference for
 * every element in the list
 */

public class Mail {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the number of elements
    int n = in.nextInt();

    // Store the list of cities in an array
    int[] cities = new int[n];
    for (int i = 0; i < n; i++) {
      cities[i] = in.nextInt();
    }

    // Since the list is in ascending order (as specified in the problem
    // statement), the minimum difference will be to either the left or right
    // of the element, and the maximum will either be to the first or last
    // element
    for (int i = 0; i < n; i++) {
      int left = Integer.MAX_VALUE;
      int right = Integer.MAX_VALUE;
      if (i > 0) {
        left = Math.abs(cities[i] - cities[i-1]);
      }
      if (i < n-1) {
        right = Math.abs(cities[i] - cities[i+1]);
      }
      int min = Math.min(left, right);

      left = Math.abs(cities[i] - cities[0]);
      right = Math.abs(cities[i] - cities[n-1]);
      int max = Math.max(left, right);

      System.out.println(min + " " + max);
    }
  }
}
