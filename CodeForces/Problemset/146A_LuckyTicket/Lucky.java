import java.util.*;

/*
 * Given a postive integer n and an n-digit postive integer m, determine if
 * m consists only of 4's and 7's, and that the sum of the first n/2 digits
 * is equal to the last n/2 digits
 */

public class Lucky {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the number of digits
    int n = Integer.parseInt(in.nextLine());

    // Keep counters for left and right sums
    int leftSum = 0;
    int rightSum = 0;

    // Read the input as a character array
    char[] ticket = in.nextLine().toCharArray();

    // Iterate throught the input, checking for invalid number and building
    // up the sums
    for (int i = 0; i < n; i++) {
      char x = ticket[i];
      if (x != '4' && x != '7') {
        System.out.println("NO");
        return;
      }
      if (i+1 <= n/2) {
        leftSum += (x - '0');
      }
      if (i+1 > n/2) {
        rightSum += (x - '0');
      }
    }

    // System.out.println("left: " + leftSum + " right: " + rightSum);
    System.out.println((leftSum == rightSum ? "YES" : "NO"));
  }
}
