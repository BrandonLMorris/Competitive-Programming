import java.util.*;

public class Pascal {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    long startTime = System.currentTimeMillis();
    long[][] pascal = new long[100000][100000];
    for (int i = 0; i < 100000; i++) {
      for (int j = 0; j < 100000; j++) {
        if (i == j) pascal[i][j] = 1;
        else if (i < j) pascal[i][j] = 0;
        else if (j == 0) pascal[i][j] = 1;
        else pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
      }
    }
    System.out.println("Took " + (startTime - System.currentTimeMillis()) + " milliseconds");
  }
}
