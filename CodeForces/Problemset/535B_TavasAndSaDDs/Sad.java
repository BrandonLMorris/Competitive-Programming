import java.util.*;

/*
 * Given a lucky number n (the digits of n consist only of 4's and 7's), find
 * the mth index (1 based) after the number is sorted by digit.
 */

public class Sad {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input
    long n = in.nextLong();

    // Set up the list of all lucky number <= 10^9
    ArrayList<Long> luckies = new ArrayList<Long>(1022);

    // Add the two first lucky numbers
    luckies.add(4l);
    luckies.add(7l);

    // Every lucky number can be constructed by adding either a 4 or a 7
    // to a previous lucky number
    for (int i = 0; i < 1020; i++) {
      String temp = Long.toString(luckies.get(i));
      luckies.add(Long.parseLong(temp + "4"));
      luckies.add(Long.parseLong(temp + "7"));
    }

    // Sort the list to be in increasing order
    Collections.sort(luckies);

    // Print out the one-indexed location of the input
    System.out.println((luckies.indexOf(n) + 1));

  }
}
