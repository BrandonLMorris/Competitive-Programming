import java.util.*;

/*
 * Given two numbers A and B, find the number of odd integers between
 * them (inclusive).
 */

public class Fuse {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();

    // The count is inclusive, so increment b if its odd
    if (b % 2 != 0) b++;

    // Divide the difference by two and round up
    System.out.println((int)Math.ceil((b-a)/2.0));
  }
}
