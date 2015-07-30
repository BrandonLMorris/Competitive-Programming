import java.util.*;

public class Pixels {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    int k = input.nextInt();

    // True means it is black
    boolean[][] board = new boolean[n][m];

    for (int i = 1; i <= k; i++) {
      int x = input.nextInt() - 1;
      int y = input.nextInt() - 1;
      board[x][y] = true;

      // Check to see if lost
      // Upper left square (sort of)
      if ((x-1 >= 0 && y+1 < m) && board[x-1][y] && board[x-1][y+1] && board[x][y+1]) {
        System.out.println(i);
        return;
      } 
      // Upper right square
      else if ((x+1 < n && y+1 < m) && board[x][y+1] && board[x+1][y+1] && board[x+1][y]) {
        System.out.println(i);
        return;
      }
      // Lower right square
      else if ((x+1 < n && y-1 >= 0) && board[x+1][y] && board[x+1][y-1] && board[x][y-1]) {
        System.out.println(i);
        return;
      }
      // Lower left square
      else if ((x-1 >= 0 && y-1 >= 0) && board[x][y-1] && board[x-1][y-1] && board[x-1][y]) {
        System.out.println(i);
        return;
      }
      //System.out.println();
      //System.out.println("x: " + x + " y: " + y);
      //printBoard(board, m, n);
    }
    System.out.println(0);
  }

  private static void printBoard(boolean[][] board, int n, int m) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(board[i][j] ? 1 : 0);
      }
      System.out.println();
    }
  }
}
