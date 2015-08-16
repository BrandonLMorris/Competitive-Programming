import java.util.*;

/* Given n and m, determine how many comparisons are needed to count how
 * often the numbers 0 to m occur in an n element array
 */

public class Work {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input
    int n = in.nextInt();
    int m = in.nextInt();

    // m is zero based, so add one
    m += 1;

    // Output m times n
    System.out.println((m*n));
  }
}
