import java.util.*;

public class Oddity {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int numTests = in.nextInt();

    for (int t = 0; t < numTests; t++) {
      int n = in.nextInt();
      if (Math.abs(n) % 2 == 0) {
        System.out.println(n + " is even");
      } else {
        System.out.println(n + " is odd");
      }
    }
  }
}
