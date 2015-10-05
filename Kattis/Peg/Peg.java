import java.util.*;
import java.io.*;

public class Peg {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    char[][] board = new char[7][7];
    for (int i = 0; i < 7; i++) {
      board[i] = in.readLine().toCharArray();
    }

    long moves = 0;
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (board[i][j] != 'o') continue;
        if (j - 2 >= 0 && board[i][j-1] == 'o' && board[i][j-2] == '.') moves++;
        if (j + 2 < 7 && board[i][j+1] == 'o' && board[i][j+2] == '.') moves++;
        if (i - 2 >= 0 && board[i-1][j] == 'o' && board[i-2][j] == '.') moves++;
        if (i + 2 < 7 && board[i+1][j] == 'o' && board[i+2][j] == '.') moves++;
      }
    }

    System.out.println(moves);


  }
}