import java.util.*;

/*
 * Given the position of a knight on a chessboard, determine how many
 * distinct positions can be attacked by that knight
 *
 * Example board
 * 8 . . . . . . . .
 * 7 . . . . . . . .
 * 6 . . . . . . . .
 * 5 . . . . . . . .
 * 4 . . . . . . . .
 * 3 . . . . . . . .
 * 2 . . . . . . . .
 * 1 . . . . . . . .
 *   a b c d e f g h
 */

public class Knight {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of tests
    int n = Integer.parseInt(in.next());

    for (int i = 0; i < n; i++) {
      // Read the input and parse the coordinates
      char[] pos = in.next().toCharArray();
      int x = pos[0] - 'a';
      int y = pos[1] - '0' - 1;

      // Count all the possible moves that are in bounds
      int counter = 0;
      if (inBounds(x+2) && inBounds(y-1)) counter++;
      if (inBounds(x+2) && inBounds(y+1)) counter++;
      if (inBounds(x-2) && inBounds(y-1)) counter++;
      if (inBounds(x-2) && inBounds(y+1)) counter++;

      if (inBounds(y+2) && inBounds(x-1)) counter++;
      if (inBounds(y+2) && inBounds(x+1)) counter++;
      if (inBounds(y-2) && inBounds(x-1)) counter++;
      if (inBounds(y-2) && inBounds(x+1)) counter++;

      // Print the result
      System.out.println(counter);
    }
  }

  // Helper method to determine if position is in bounds (zero-indexed)
  private static boolean inBounds(int x) {
    return (x >= 0 && x <= 7);
  }
}
