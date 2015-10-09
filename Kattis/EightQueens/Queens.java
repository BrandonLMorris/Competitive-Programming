import java.util.*;
import java.io.*;

public class Queens {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    char[][] board = new char[8][8];
    for (int i = 0; i < 8; i++) {
      board[i] = in.readLine().toCharArray();
    }

    int[] queenX = new int[8];
    int[] queenY = new int[8];
    int count = 0;
    boolean isValid = true;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == '*') {
          queenX[count] = i;
          queenY[count] = j;
          count++;
        }
      }
    }

    for (int i = 0; i < 8; i++) {
      for (int j = i+1; j < 8; j++) {
        if (queenX[i] == queenX[j] || queenY[i] == queenY[j]) {
          System.out.println("invalid");
          return;
        }
        if (Math.abs(queenX[i] - queenX[j]) == Math.abs(queenY[i] - queenY[j])) {
          System.out.println("invalid");
          return;
        }
      }
    }
    System.out.println("valid");
  }
}