import java.util.*;

public class Meat {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int[] needs = new int[n];
    int[] prices = new int[n];
    long count = 0;
    for (int i = 0; i < n; i++) {
      needs[i] = in.nextInt();
      prices[i] = in.nextInt();
    }

    int[] minPriceSoFar = new int[n];
    minPriceSoFar[0] = prices[0];
    for (int i = 1; i < n; i++) {
      minPriceSoFar[i] = Math.min(minPriceSoFar[i-1], prices[i]);
    }

    for (int i = 0; i < n; i++) {
      count += needs[i] * minPriceSoFar[i];
    }
    System.out.println(count);
  }
}