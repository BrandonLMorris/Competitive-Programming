import java.util.*;

/*
 * Given integers n and k, find the permutation of integers 1 to n where the
 * absolute difference of each adjacent pair contains exactly k distinct
 * elements
 */

public class Perm {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input
    int n = in.nextInt();
    int k = in.nextInt();

    // Initialize the array to store the result
    int[] perm = new int[n];

    // The max k (k = n-1) will be the pattern 1, n-1, 2, n-2, ...
    // Take the first k elements from the sequence
    for (int i = 0; i < k; i++) {
      if (i % 2 == 0) {
        perm[i] = (i / 2) + 1;
      } else {
        perm[i] = n - ((i-1)/2);
      }
    }

    // The rest of the sequence will have distance one, so find the last
    // generated element and either increment or decrement
    boolean increment = perm[k-1] <= n/2;
    for (int i = k; i < n; i++) {
      if (increment) {
        perm[i] = perm[i-1] + 1;
      } else {
        perm[i] = perm[i-1] - 1;
      }
    }

    // Output the result
    for (int i = 0; i < n; i++) {
      if (i < n-1) {
        System.out.print(perm[i] + " ");
      } else {
        System.out.println(perm[i]);
      }
    }

  }
}
