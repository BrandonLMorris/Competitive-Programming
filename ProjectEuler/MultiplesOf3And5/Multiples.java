import java.util.*;

public class Multiples {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = input.nextInt();
    for (int t = 0; t < numTests; t++) {
      int n = input.nextInt();
      long sum = 0;
      int counter = 3;
      while (counter < n) {
        sum += counter;
        counter += 3;
      }
      counter = 5;
      while (counter < n) {
        sum += counter;
        counter += 5;
      }
      counter = 15;
      while (counter < n) {
        sum -= counter;
        counter += 15;
      }
      System.out.println(sum);
    }
  }
}
