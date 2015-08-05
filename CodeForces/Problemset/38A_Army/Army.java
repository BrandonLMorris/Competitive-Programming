import java.util.*;

/*
 * Given an integer n and a list d of n integers where d[i] represents the
 * distance from i to i+1, find the total distance from a and b.
 */

public class Army {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of ranks
    int n = in.nextInt();

    // Store the rank distances in an array
    // d[i] represents the years to go from rank i to rank i+1
    int[] distances = new int[n-1];
    for (int i = 0; i < n-1; i++) {
      distances[i] = in.nextInt();
    }

    // Read the start and ending ranks
    int startRank = in.nextInt();
    int endRank = in.nextInt();

    // Loop through the ranks, accumulating each distance
    int total = 0;
    for (int i = startRank-1; i < endRank-1; i++) {
      total += distances[i];
    }

    System.out.println(total);

  }
}
