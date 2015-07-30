import java.util.Scanner;

public class Fly {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = input.nextInt();
    for (int t = 1; t <= numTests; t++) {
      input.nextInt();
      double distance = input.nextDouble();
      double bikeAMph = input.nextDouble();
      double bikeBMph = input.nextDouble();
      double flyMph = input.nextDouble();

      double time = distance / (bikeAMph + bikeBMph);
      double result = time * flyMph;
      System.out.printf("%d %.2f\n", t, result);
    }
  }
}
