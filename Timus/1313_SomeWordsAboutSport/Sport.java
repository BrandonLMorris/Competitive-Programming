import java.util.*;

/*
 * Given an n by n matrix, list the element by traversing the matrix bottom
 * left to upper right around the left border.
 * i.e
 * 1 3
 * 2 4  =>  1 2 3 4
 */

public class Sport {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the matrix dimension
    int n = in.nextInt();

    // Read the maxtrix as a 2D array
    int[][] screen = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        screen[i][j] = in.nextInt();
      }
    }

    // Initialize a StringBuilder for the result
    StringBuilder sb = new StringBuilder();

    // Go down the left size of the matrix, traversing the diagonal
    for (int i = 0; i < n; i++) {
      int row = i;
      while (row >= 0) {
        sb.append(screen[row][i - row] + " ");
        row--;
      }
    }

    // Go across the bottom of the matrix, traversing the diagonal
    for (int i = 1; i < n; i++) {
      int col = i;
      while (col < n) {
        sb.append(screen[n-1-(col-i)][col] + " ");
        col++;
      }
    }

    // Delete the trailing space
    sb.deleteCharAt(sb.length()-1);

    // Output the result
    System.out.println(sb.toString());
  }
}
