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

      int maxSquare = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if(matrix[i][j] == 0) continue;
          int squareAt = biggestSquare(matrix, i, j, N, M);
          System.out.println("["+i+","+j+"]: " + squareAt);
          maxSquare = Math.max(maxSquare, squareAt);
        }
      }

      System.out.println(maxSquare);

    }
  }

  public static int biggestSquare(int[][] matrix, int i, int j, int N, int M) {
    System.out.println();
    System.out.println("biggestSquare("+i+","+j+")");
    int counter = 0;
    boolean foundZero = false;
    while (!foundZero) {
      for (int a = 0; a <= counter; a++) {
        for (int b = 0; b <= counter; b++) {
          if (i+a < N && j+b < M) {
            System.out.println("Checking ["+(a+i)+","+(j+b)+"]: " + matrix[i+a][j+b]);
            if (matrix[i+a][j+b] == 0) return counter;
            foundZero = matrix[i+a][j+b] == 0;
          } else return counter;
        }
      }
      counter++;
    }

    return counter;
  }
}
