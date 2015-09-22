import java.util.*;

public class Okvir {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int M = in.nextInt();
    int N = in.nextInt();

    int above = in.nextInt();
    int left = in.nextInt();
    int right = in.nextInt();
    int below = in.nextInt();

    char[][] result = new char[above+below+M][left+right+N];
    char[][] board = new char[M][N];
    for (int i = 0; i < M; i++) {
      board[i] = in.next().toCharArray();
    }

    // Even rows have # on even columns
    // Odd rows have # on odd columns
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        if (i >= above && i < above + M &&
            j >= left && j <left + N) {
              result[i][j] = board[i-above][j-left];
        } else {
          if (i % 2 == 0) {
            if (j % 2 == 0) {
              result[i][j] = '#';
            } else {
              result[i][j] = '.';
            }
          } else {
            if (j % 2 != 0) {
              result[i][j] = '#';
            } else {
              result[i][j] = '.';
            }
          }
        }
      }
    }

    for (char[] c : result) {
      System.out.println(new String(c));
    }

  }
}
