import java.util.*;

/*
 * Given two integers, determine if the first is even or the second is odd
 */

public class Bike {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input
    int first = in.nextInt();
    int second = in.nextInt();

    // Test and output the result
    if (first % 2 == 0 || second % 2 == 1) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
  }
}
