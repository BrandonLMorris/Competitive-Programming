import java.util.*;

/*
 * Imagine a string created by concatenating all the powers of 10 (1, 10,
 * 100, 1000, ...). Given a number k, find the kth (1 indexed) character
 * in such a string.
 */

public class Binary {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of test cases
    int n = in.nextInt();

    // Initialize a StringBuilder to store the result
    StringBuilder result = new StringBuilder();

    // Precompute all the locations of the ones into a has set
    HashSet<Integer> hs = new HashSet<Integer>();
    long i = 0;
    long counter = 0;
    while (true) {
      // See below for pattern
      counter += i;
      if (counter > Integer.MAX_VALUE) break;
      hs.add((int)counter);
      i++;
    }

    // Evaluate each test case
    for (int t = 0; t < n; t++) {
      int k = in.nextInt();

      // If the index is a location of a one, print 1, otherwise it's zero
      if (hs.contains(k-1)) {
        result.append("1 ");
      } else {
        result.append("0 ");
      }
    }

    // Get rid of the trailing space
    result.deleteCharAt(result.length()-1);

    // Print the result
    System.out.println(result.toString());

  }
}

/*
 * Locations of ones follow the pattern (zero-based indeces)
 * 0 1 3 6 10
 *
 * Distance from the previous one
 * - 1 2 3 4
 *
 * The pattern forms the following recurrance relation
 * P(0) = 0
 * P(n) = n + P(n-1)
 *
 * Therefore, a counter can be used to track P(n-1) and the loop index can
 * be used to form n. Their sum equals P(n).
 */
