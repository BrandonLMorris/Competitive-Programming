import java.util.*;

public class Apple {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = Integer.parseInt(input.nextLine());
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      String line = input.nextLine();
      for (int j = 0; j < n; j++) {
        board[i][j] = line.charAt(j);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int oCounter = 0;
        if (i > 0 && board[i-1][j] == 'o') oCounter++;
        if (j > 0 && board[i][j-1] == 'o') oCounter++;
        if (i < n-1 && board[i+1][j] == 'o') oCounter++;
        if (j < n-1 && board[i][j+1] == 'o') oCounter++;
        if (oCounter % 2 != 0) {
          System.out.println("NO");
          return;
        }
      }
    }
    System.out.println("YES");
  }
}
