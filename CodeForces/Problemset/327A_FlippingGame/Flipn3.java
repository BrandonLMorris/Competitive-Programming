import java.util.*;

public class Flipn3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] original = new int[n];
    int maxOnes = 0;
    for (int i = 0; i < n; i++) {
      original[i] = input.nextInt();
    }
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n ; j++) {
        int[] flipped = new int[n];
        for (int k = 0; k < n; k++) {
          if (k >= i && k <= j) {
            flipped[k] = original[k] == 1 ? 0 : 1;
          } else {
            flipped[k] = original[k];
          }
          int numOnes = 0;
          for (int l : flipped) {
            if (l == 1) numOnes++;
          }
          if (numOnes > maxOnes)
            maxOnes = numOnes;
        }
      }
    }
    System.out.println(maxOnes);
  }
}
