import java.util.*;

/*
 * Two baskets are filled with berries. Given the weight of each basket with
 * its berries, the baskets where the first has all the berries, then the
 * baskets where the second has all the berries, find the weight of the
 * berries only
 */

public class Berries {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Initial baskets with berries
    int a = in.nextInt();
    int b = in.nextInt();

    // Eat the next input, then find the weight of basket b's berries
    in.nextInt();
    int bBerries = b - in.nextInt();

    // Find the weight of basket a's berries, then eat the last input
    int aBerries = a - in.nextInt();
    in.nextInt();

    // Output the result
    System.out.println(aBerries + " " + bBerries);
  }
}
