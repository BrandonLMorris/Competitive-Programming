import java.util.*;

/* 
 * Given a number n, determine if that number is less than or equal to 7
 */

public class About {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input
    int n = in.nextInt();

    // Output the result
    System.out.println((n >= 7 ? "YES" : "NO"));
  }
}
