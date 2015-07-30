import java.util.*;

public class Rip2 {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    for (;;) {
      int N = input.nextInt();
      if (N == 0) break;

      int S = input.nextInt();
      int T = input.nextInt();

      int[] space = new int[N+1];
      for (int i = 0; i < N; i++) {
        space[i] = input.nextInt();
      }

      int[][] refund = new int[T][N+1];
      for (int i = 0; i < T; i++) {
        for (int j = 0; j < N+1; j++) {
          refund[i][j] = Integer.MIN_VALUE;
        }
      }

      for (int i = 0; i < S; i++) {
        refund[0][i] = space[i];
      }

      for (int i = 0; i < T-1; i++) {
        for (int j = 0; j < N; j++ ) {
          if (refund[i][j] == Integer.MIN_VALUE) continue;
          for (int k = 1; k <= S; k++) {
            if (j + k < N+1) {
              if (refund[i+1][j+k] == Integer.MIN_VALUE ||
                  refund[i+1][j+k] < refund[i][j] + space[j+k]) {
                    refund[i+1][j+k] = refund[i][j] + space[j+k];
                  }
            }
          }
        }
      }

      int max = Integer.MIN_VALUE;
      for (int i = 0; i < T; i++) {
        max = Math.max(max, refund[i][N]);
      }

      System.out.println(max);

    }
  }
}
