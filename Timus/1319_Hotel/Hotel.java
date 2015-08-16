import java.util.*;

/*
 * Given an integer n, print an n by n matrix of numbers ascending from one
 * starting from the top right corner and moving diagonally from left to
 * right
 *
 * Example: 3
 * 4 2 1
 * 7 5 3
 * 9 8 6
 */

public class Hotel {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the dimension of the matrix
    int n = in.nextInt();

    // Initialize the matrix
    int[][] matrix = new int[n][n];

    // Start the counter that will be used to fill the matrix
    int counter = 1;

    // Iterate along the top from right to left, moving diagonally
    for (int i = n-1; i >= 0; i--) {
      int col = i;
      while (col <= n-1) {
        matrix[col-i][col] = counter;
        counter++;
        col++;
      }
    }

    // Iterate along the left column top to bottom, moving diagonally
    for (int i = 1; i <= n-1; i++) {
      int row = i;
      while (row <= n-1) {
        matrix[row][row-i] = counter;
        counter++;
        row++;
      }
    }


    // Print out the matrix line by line
    StringBuilder sb;
    for (int i = 0; i < n; i++) {
      sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        sb.append(matrix[i][j] + " ");
      }
      System.out.println(sb.toString().trim());
    }

  }
}
