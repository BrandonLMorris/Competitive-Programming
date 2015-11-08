import java.util.*;
import java.io.*;

public class TwentyFortyEight {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[][] board = new int[4][4];
    for (int i = 0; i < 4; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < 4; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int direction = Integer.parseInt(in.readLine());
    // Move to the left <-
    if (direction == 0) {
      while (shiftLeft(board));
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[i][j+1] == board[i][j]) {
            board[i][j] += board[i][j+1];
            board[i][j+1] = 0;
          }
        }
      }
      while (shiftLeft(board));
    }
    // Move to the up ^
    if (direction == 1) {
      while (shiftUp(board));
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
          if (board[i+1][j] == board[i][j]) {
            board[i][j] += board[i+1][j];
            board[i+1][j] = 0;
          }
        }
      }
      while (shiftUp(board));
    }

    // Move to the right ->
    if (direction == 2) {
      while (shiftRight(board));
      for (int i = 0; i < 4; i++) {
        for (int j = 3; j > 0; j--) {
          if (board[i][j-1] == board[i][j]) {
            board[i][j] += board[i][j-1];
            board[i][j-1] = 0;
          }
        }
      }
      while (shiftRight(board));
    }

    // Move to the down
    if (direction == 3) {
      while (shiftDown(board));
      for (int i = 3; i > 0; i--) {
        for (int j = 0; j < 4; j++) {
          if (board[i][j] == board[i-1][j]) {
            board[i][j] += board[i-1][j];
            board[i-1][j] = 0;
          }
        }
      }
      while (shiftDown(board));
    }

    for (int i = 0; i < 4; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < 4; j++) {
        sb.append(board[i][j] + " ");
      }
      System.out.println(sb.toString().trim());
    }
  }

  private static boolean shiftLeft(int[][] arr) {
    boolean didChange = false;
    for (int i = 0; i < 4; i++) {
      for (int j = 3; j > 0; j--) {
        if (arr[i][j-1] == 0 && arr[i][j] != 0) {
          arr[i][j-1] = arr[i][j];
          arr[i][j] = 0;
          didChange = true;
        }
      }
    }
    return didChange;
  }
  private static boolean shiftRight(int[][] arr) {
    boolean didChange = false;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if (arr[i][j+1] == 0 && arr[i][j] != 0) {
          arr[i][j+1] = arr[i][j];
          arr[i][j] = 0;
          didChange = true;
        }
      }
    }
    return didChange;
  }
  private static boolean shiftDown(int[][] arr) {
    boolean didChange = false;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        if (arr[i+1][j] == 0 && arr[i][j] != 0) {
          arr[i+1][j] = arr[i][j];
          arr[i][j] = 0;
          didChange = true;
        }
      }
    }
    return didChange;
  }
  private static boolean shiftUp(int[][] arr) {
    boolean didChange = false;
    for (int i = 3; i > 0; i--) {
      for (int j = 0; j < 4; j++) {
        if (arr[i-1][j] == 0 && arr[i][j] != 0) {
          arr[i-1][j] = arr[i][j];
          arr[i][j] = 0;
          didChange = true;
        }
      }
    }
    return didChange;
  }
}