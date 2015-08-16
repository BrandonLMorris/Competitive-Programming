import java.util.*;

/*
 * Given that k cars can turn per minute, and the number of cars that arrive
 * for each n minutes, determine the number of cars waiting in line currently
 */

public class Mega {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the input
    int k = in.nextInt();
    int n = in.nextInt();

    // There are 0 cars in line at the start
    int counter = 0;
    for (int i = 0; i < n; i++) {
      // Add the number of cars for that minute
      counter += in.nextInt();

      // Subtract the cars in line by k, but don't go below zero
      counter = Math.max(0, counter - k);
    }

    // Output the result
    System.out.println(counter);
  }
}
