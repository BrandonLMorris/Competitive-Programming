import java.util.*;

/*
 * Given a nxn matrix of characters (n is odd), determine if it is an "X" as
 * defined by:
 *  1) The letters along both diagonals are all the same
 *  2) The letters not on the diagonals are all the same
 */

public class X {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the size of the matrix
    int n = Integer.parseInt(in.nextLine());

    // Initialize and read the 2D array
    char[][] paper = new char[n][n];
    for (int i = 0; i < n; i++) {
      paper[i] = in.nextLine().toCharArray();
    }

    // Grab reference characters
    char diagChar = paper[0][0];
    char nonDiagChar = paper[0][1];

    // If the reference chars match, it fails
    if (diagChar == nonDiagChar) {
      System.out.println("NO");
      return;
    }

    // Iterate through, and check as you go
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // Check diagonal spots
        if (i == j || i + j == n-1) {
          if (paper[i][j] != diagChar) {
            System.out.println("NO");
            return;
          }
        } else {
          // Check the non-diagonal spots
          if (paper[i][j] != nonDiagChar) {
            System.out.println("NO");
            return;
          }
        }
      }
    }

    // If you made it this far, it passes
    System.out.println("YES");

  }
}
