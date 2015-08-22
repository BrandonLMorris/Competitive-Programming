import java.util.*;

/*
 * There are n groups of k droids lined up. For each group, i "booms" have
 * been set aside to destroy that group. Each fired boom will kill exactly
 * one droid. Find out how many remaining booms and remaining droids there
 * will be after the battle.
 */

public class Battle {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input
    int n = in.nextInt();
    int k = in.nextInt();

    // Initialize the counter
    int boomCount = 0;
    int droidCount = 0;

    for (int i = 0; i < n; i++) {
      // Read the number of booms for this group
      int booms = in.nextInt();

      // If more droids than booms, add to droid count
      if (booms < k) {
        droidCount += k - booms;
      } else if (booms > k) {
        // More booms than droids
        boomCount += booms - k;
      }
    }

    // Output the result
    System.out.println(boomCount + " " + droidCount);
  }
}
