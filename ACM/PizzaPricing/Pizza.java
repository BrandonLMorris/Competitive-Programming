import java.util.Scanner;

public class Pizza {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (int t = 1;; t++) {
      int numPizzas = input.nextInt();
      if (numPizzas == 0) break;
      int bestSize = 0;
      double bestValue = Integer.MAX_VALUE;
      for (int i = 0; i < numPizzas; i++) {
        int diameter = input.nextInt();
        int price = input.nextInt();
        double value = price / (Math.pow(diameter/2.0, 2));
        if (value < bestValue) {
          bestSize = diameter;
          bestValue = value;
        }
      }
      System.out.println("Menu " + t + ": " + bestSize);
    }
  }
}
