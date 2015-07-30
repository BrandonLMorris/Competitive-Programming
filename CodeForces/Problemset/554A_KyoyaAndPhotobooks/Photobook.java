import java.util.*;

/*
 * Given a string of characters, output how many distinct strings can be
 * formed by adding a single character.
 */

public class Photobook {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextLine().length();

    // 26 letters times n+1 spaces, minus the n duplicates
    int answer = 26 * (n + 1) - n;

    System.out.println(answer);

  }
}

