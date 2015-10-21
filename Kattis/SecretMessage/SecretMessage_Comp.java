import java.util.*;
import java.io.*;

public class SecretMessage_Comp {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      String line = in.readLine();
      int dimension = (int)Math.ceil(Math.sqrt(line.length()));
      char[][] board = new char[dimension][dimension];
      int pos = 0;
      for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
          if (pos >= line.length()) {
            board[i][j] = '*';
          } else {
            board[i][j] = line.charAt(pos);
          }
          pos++;
        }
      }

      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < dimension; j++) {
        for (int i = dimension-1; i >= 0; i--) {
          if (board[i][j] != '*') {
            sb.append(board[i][j]);
          }
        }
      }
      System.out.println(sb.toString());
    }
  }
}