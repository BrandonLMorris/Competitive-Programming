import java.util.*;

/*
 * Given a string of numbers, output another string of numbers that shows
 * the number of contiguous occurances of the number, then that number.
 *
 * For example:
 * 1 1 2 3 3 3 10 10
 * becomes:
 * 2 1 1 2 3 3 2 10
 *
 * As in "two ones, one two, two threes, two tens"
 */

public class Team {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the length of the list
    int n = in.nextInt();

    // Keep track of two lists: the numbers themselves and their contiguous
    // lengths
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    ArrayList<Integer> counts = new ArrayList<Integer>();

    // Iterate each element in the list
    for (int i = 0; i < n; i++) {
      int j = in.nextInt();
      // Check if the number is another contiguous element, If it is,
      // increase its count
      if (!numbers.isEmpty() && j == numbers.get(numbers.size() - 1)) {
        counts.set(counts.size()-1, counts.get(counts.size()-1) + 1);
      } else {
        // Otherwise tack it onto the list with a count of 1
        numbers.add(j);
        counts.add(1);
      }
    }

    // Create the output as a space separated list
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numbers.size(); i++) {
      sb.append(counts.get(i) + " " + numbers.get(i) + " ");
    }

    // Print out the result minus the trailing space
    System.out.println(sb.toString().trim());
  }
}
