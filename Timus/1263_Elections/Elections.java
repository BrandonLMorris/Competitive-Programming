import java.util.*;

/*
 * Given a number of candidates and a number of votes, determine the
 * percentage of votes each candidate receives.
 */

public class Elections {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the number of candidates and voters
    int candidates = in.nextInt();
    int voters = in.nextInt();

    // Store the vote counts in an array
    int[] votes = new int[candidates];

    // Increment the vote count for each vote
    for (int i = 0; i < voters; i++) {
      votes[in.nextInt() - 1]++;
    }

    // Output the result
    for (int i = 0; i < candidates; i++) {
      double percent = ((double)votes[i] / voters) * 100;
      System.out.printf("%.2f%%\n", percent);
    }
  }
}
