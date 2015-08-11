import java.util.*;

/*
 * Given an integer n, find the permuatation (if it exists) of numbers from
 * 1 to n such that p[p[i]] = i and p[i] != i
 */

public class Perm {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the input
    int n = in.nextInt();

    // If n is odd, the permutation is impossible
    if (n % 2 != 0) {
      System.out.println(-1);
      return;
    }

    // Print the numbers from 1 to n, swapping each consecutive pair
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 1) {
        System.out.print((i+1) + " ");
      } else {
        System.out.print((i-1) + " ");
      }
    }
    System.out.println();
  }
}
