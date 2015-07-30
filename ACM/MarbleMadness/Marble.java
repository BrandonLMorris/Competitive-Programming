import java.util.*;

public class Marble {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    int[] bins = new int[n];

    int sum = 0;
    for (int i = 0; i < n; i++) {
      bins[i] = input.nextInt();
      sum += bins[i];
    }

    if (n == 1) {
      System.out.println("0 0");
      return;
    }

    if (n == 2) {
      int minDist = Math.min(bins[0], bins[1]);
      System.out.println(sum + " " + minDist);
      return;
    }

    int maxScore = sum * 2;

    int dist = 0;

    // Move the edges inside
    int x = bins[0];
    bins[1] += x;
    dist += x;
    bins[0] = 0;

    x = bins[bins.length-1];
    bins[bins.length-2] += x;
    dist += x;
    bins[bins.length-1] = 0;

    if (n == 3) {
      System.out.println(maxScore + " " + dist);
      return;
    }

    for (int i = 1; i < n-1; i++) {

      /*
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for (int j = 0; j < n; j++) {
        sb.append(bins[j] + " ");
      }
      sb.append("]");
      System.out.println(sb.toString());
      */

      if (bins[i] == 0) continue;

      if (bins[i+1] <= bins[i]) {
        dist += bins[i+1];
        bins[i] += bins[i+1];
        bins[i+1] = 0;
      } else {
        dist += bins[i];
        bins[i+1] += bins[i];
        bins[i] = 0;
      }


    }

    System.out.println(maxScore + " " + dist);

  }
}
