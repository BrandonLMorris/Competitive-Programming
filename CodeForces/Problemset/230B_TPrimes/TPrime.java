import java.util.*;

/*
 * Determine which, if any, of the numbers in a list have exactly 3 divisors
 */

public class TPrime {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    boolean[] isNotPrime = new boolean[1000005];
    isNotPrime[2] = false;
    for (int i = 2; i < 1000005; i++) {
      if (!isNotPrime[i]) {
        int x = i + i;
        while (x <= 1000005) {
          isNotPrime[x] = true;
          x += x;
        }
      }
    }

    // Read in the number of numbers
    int n = in.nextInt();

    // Test each number
    for (int i = 0; i < n; i++) {
      long x = in.nextLong();

      // Edge case where x == 1
      if (x == 1) {
        System.out.println("NO");
        continue;
      }

      // x has 3 divisors if and only if it is a perfect square. The divisors
      // will be 1, x, and the square root of x.
      double y = Math.sqrt(x);
      if (y == Math.round(y) && !isNotPrime[(int)y]) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }

  }
}
