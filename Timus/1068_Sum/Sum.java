import java.util.*;

/*
 * Given a number n, find the sum of all the values between 1 and n,
 * inclusive.
 */

public class Sum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in n
    int n = in.nextInt();

    // Three possible cases: If n is > 0, sum is n(n+1)/2. If n == 0, sum is
    // 1. If n < 0, sum is (-1 * sum(|n|)) + 1
    int answer = 0;
    if (n > 0) {
      answer = (n*(n+1)/2);
    } else if (n == 0) {
      answer = 1;
    } else {
      // Negate n so the summation works
      n *= -1;
      // Find the summation, revert to negative, and add one back
      answer = (-1 * (n*(n+1)/2)) + 1;
    }

    // Print the result
    System.out.println(answer);
  }
}
