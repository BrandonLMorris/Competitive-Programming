import java.util.*;

public class Pony {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    char[][] diamond = new char[n][n];
    
    // Fill in the first half
    for (int i = 0; i <= n/2; i++) {
      int numDs = i*2 + 1;
      int numStars = n - numDs;
      for (int j = 0; j < n; j++) {
        if (j < numStars/2) {
          diamond[i][j] = '*';
        } else if (j >= (numStars/2) + numDs) {
          diamond[i][j] = '*';
        } else {
          diamond[i][j] = 'D';
        }
      }

   }

    // Fill in the middle line
    for (int j = 0; j < n; j++) {
      diamond[(n/2)][j] = 'D';
    }

    // Fill in the bottom half
    for (int i = n/2 + 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        diamond[i][j] = diamond[n-i-1][j];
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(diamond[i][j]);
      }
      System.out.println();
    }

  }
}
