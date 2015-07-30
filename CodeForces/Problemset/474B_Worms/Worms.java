import java.util.*;

public class Worms {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int counter = 0;
    int[] piles = new int[n];
    for (int i = 0; i < n; i++) {
      counter += input.nextInt();
      piles[i] = counter;
    }

    int m = input.nextInt();
    for (int i = 0; i < m; i++) {
      int worm = input.nextInt();

      // Binary search goes here
      int left = 0;
      int right = n-1;
      int j = (n+1)/2;
      while (j > 0 && !(worm <= piles[j] && worm > piles[j-1])) {
        if (worm < piles[j]) {
          // Move left
          right = j;
          j = (j+left)/2;
        } else {
          // Move right
          left = j;
          j = (j+right+1)/2;
        }
      }

      System.out.println((j+1));
    }
  }
}
