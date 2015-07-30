import java.util.*;

public class Cheap {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    int a = input.nextInt();
    int b = input.nextInt();

    int totalCost = 0;

    double costPerRideM = ((double) b) / m;

    if (costPerRideM < a) {
      int rides = n / m;
      totalCost += rides * b;
      totalCost += Math.min((n % m) * a, b);
      System.out.println(totalCost);
    } else {
      totalCost = n * a;
      System.out.println(totalCost);
    }
  }
}
