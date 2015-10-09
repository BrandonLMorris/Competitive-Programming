import java.util.*;
import java.io.*;

public class Message {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    ArrayList<Integer> squares = new ArrayList<Integer>(350);
    for (int i = 1; ; i++) {
      squares.add(i*i);
      if (i*i > 100000) break;
    }

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      char[] message = in.readLine().toCharArray();

      if (message.length == 1) {
        System.out.println(message[0]);
        continue;
      }

      int size = 0;
      for (int i = 0; squares.get(i) < message.length; i++) size = squares.get(i+1);
      int pos = 0;
      int dimension = (int)Math.sqrt(size);
      char[][] board = new char[dimension][dimension];
      for (int ii = 0; ii < dimension; ii++) {
        for (int jj = 0; jj < dimension; jj++) {
          if (pos >= message.length) {
            board[ii][jj] = '*';
          } else {
            board[ii][jj] = message[pos];
          }
          pos++;
        }
      }

      /* DEBUG */
      // for (char[] cArr : board) {
      //   for (char c : cArr) {
      //     System.out.print(c + " ");
      //   }
      //   System.out.println();
      // }

      StringBuilder sb = new StringBuilder();
      for (int jj = 0; jj < dimension; jj++) {
        for (int ii = dimension-1; ii >= 0; ii--) {
          if (board[ii][jj] == '*') continue;
          sb.append(board[ii][jj]);
        }
      }

      System.out.println(sb.toString());
    }
  }
}