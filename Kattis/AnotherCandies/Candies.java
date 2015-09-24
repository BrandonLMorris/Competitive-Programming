import java.util.*;

public class Candies {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int numTests = Integer.parseInt(in.nextLine());
    for (int t = 0; t < numTests; t++) {
      in.nextLine();

      long n = Long.parseLong(in.nextLine());
      long counter = 0l;

      for (long i = 0; i < n; i++) {
        counter = ((Long.parseLong(in.nextLine()) % n) + counter) % n;
      }

      System.out.println(counter == 0 ? "YES" : "NO");
    }
  }
}