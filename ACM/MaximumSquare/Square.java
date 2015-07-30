import java.util.*;

public class Square {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    for (;;) {
      int N = input.nextInt();
      int M = input.nextInt();
      if (N == 0 && M == 0) break;

      int[][] matrix = new int[N][M];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          matrix[i][j] = input.nextInt();
        }
      }


      for (int i = 1; i < N; i++) {
        for (int j = 1; j < M; j++) {
          if (matrix[i][j] == 0) continue;
          //System.out.println("["+i+","+j+"]: " + squareAt);
          if (matrix[i-1][j] != 0 && matrix[i][j-1] != 0 && matrix[i-1][j-1] != 0) {

            if (matrix[i-1][j] == matrix[i][j-1] && matrix[i][j-1] == matrix[i-1][j-1]) {

              matrix[i][j] = matrix[i-1][j] + 1;

            } else {

              matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1])) + 1;

            }
          }
        }
      }

      int maxSquare = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          maxSquare = Math.max(maxSquare, matrix[i][j]);
        }
      }

      System.out.println(maxSquare);

    }
  }
}
