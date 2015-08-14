import java.util.*;

/*
 * Given the integers n, a, and b, find the product 2 * (n * a * b)
 */

public class Eniya {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the input
    int n = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();

    // Output the result
    System.out.println((2 * n * a * b));
  }
}
