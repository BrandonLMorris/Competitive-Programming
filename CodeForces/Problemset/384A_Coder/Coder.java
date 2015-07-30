import java.util.*;

public class Coder {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    //char[][] board = new char[n][n];
    //for (int i = 0; i < n; i++) {
    //  board[0][i] = i % 2 == 0 ? 'C' : '.';
    //}
    //for (int i = 1; i < n; i++) {
    //  for (int j = 0; j < n; j++) {
    //    board[i][j] = board[i-1][j] == 'C' ? '.' : 'C';
    //  }
    //}

    int coderCount = (int) Math.ceil(Math.pow(n, 2) / 2);

    System.out.println(coderCount);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(((i+j) % 2 == 0 ? 'C' : '.'));
      }
      System.out.println();
    }
  }
}
