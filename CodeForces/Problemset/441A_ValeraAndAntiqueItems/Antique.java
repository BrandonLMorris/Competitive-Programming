import java.util.*;

public class Antique {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int v = input.nextInt();
    boolean[] canBuy = new boolean[n];
    int canBuyCounter = 0;
    for (int i = 0; i < n; i++) {
      int n1 = input.nextInt();
      int[] prices = new int[n1];
      for (int j = 0; j < n1; j++) {
        prices[j] = input.nextInt();
      }
      for (int j : prices) {
        if (v > j) {
          canBuyCounter++;
          canBuy[i] = true;
          break;
        }
      }
    }

    System.out.println(canBuyCounter);
    boolean firstPrint = true;
    for (int i = 0; i < n; i++) {
      if (canBuy[i]) {
        if (firstPrint) {
          firstPrint = false;
        } else {
          System.out.print(" ");
        }
        System.out.print((i+1));
      }
    }
    System.out.println();
  }
}
