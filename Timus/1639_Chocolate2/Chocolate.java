import java.util.*;

/*
 * Given an m x n chocolate bar, two players will keep breaking it along the
 * lines. Determine whether the player who goes first or second will win
 * if the last person able to break the chocolate wins.
 */

public class Chocolate {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the dimensions of the chocolate bar
    int m = in.nextInt();
    int n = in.nextInt();

    // There are m*n - 1 breaks in the chocolate bar. The winner will be
    // determined by whether the number of breaks is even or odd
    boolean isEven = ((m * n) - 1) % 2 == 0;

    // Output the result
    System.out.println(isEven ? "[second]=:]" : "[:=[first]");
  }
}
