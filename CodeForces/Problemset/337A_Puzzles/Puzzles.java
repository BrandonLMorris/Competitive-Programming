import java.util.*;

public class Puzzles {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();

    int[] sizes = new int[m];
    for (int i = 0; i < m; i++) {
      sizes[i] = input.nextInt();
    }

    Arrays.sort(sizes);

    int smallestDiff = Integer.MAX_VALUE;
    for (int i = 0; i <= m - n; i++) {
      int diff = sizes[n-1+i] - sizes[i];
      if (diff < smallestDiff) {
        smallestDiff = diff;
      }
    }

    System.out.println(smallestDiff);
  }
}
