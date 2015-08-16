import java.util.*;

/*
 * Given a number n, determine if the numbers from 1 to n combined with
 * addition and/or subtraction will be even or odd
 */

public class Imps {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input
    int n = in.nextInt();

    // Even and even will be even. Odd and odd will be even. Even and odd
    // will be odd. Pattern will follow: odd, odd, even, even, ...
    if ((int)(Math.ceil(n / 2.0) - 1) % 2 == 1) {
      System.out.println("black");
    } else {
      System.out.println("grimy");
    }
  }
}
