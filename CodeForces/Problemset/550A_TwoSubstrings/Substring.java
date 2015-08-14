import java.util.*;

/*
 * Given a string s, determine if the s contains two non-overlapping
 * substrings "AB" and "BA" (any order is permitted)
 */

public class Substring {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input string as a character array
    char[] s = in.next().toCharArray();

    // Initialize the list to store the positions
    ArrayList<Integer> abPos = new ArrayList<Integer>();
    ArrayList<Integer> baPos = new ArrayList<Integer>();

    for (int i = 0; i < s.length - 1; i++) {
      if (s[i] == 'A' && s[i+1] == 'B')
        abPos.add(i);
      else if (s[i] == 'B' && s[i+1] == 'A')
        baPos.add(i);
    }

    // Output NO if either of the lists is empty
    if (abPos.isEmpty() || baPos.isEmpty()) {
      System.out.println("NO");
      return;
    }

    // Compare each points, see if they're off by more than one
    for (int i : abPos) {
      for (int j : baPos) {
        if (i != j+1 && i != j-1) {
          System.out.println("YES");
          return;
        }
      }
    }

    // If nothing found, must be false
    System.out.println("NO");
  }
}
