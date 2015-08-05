import java.util.*;

/*
 * Given a lucky number n (the digits of n consist only of 4's and 7's), find
 * the mth index (1 based) after the number is sorted by digit.
 */

public class Sad {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();

    ArrayList<String> luckies = new ArrayList<String>(510);
    luckies.add("4");
    luckies.add("7");

    for (int i = 0; i < 508; i++) {
      int temp = Integer.parseInt(luckies.get(i));
    }

    Collections.sort(luckies);
    System.out.println((luckies.indexOf(Integer.toString(n)) + 1));



  }
}

/*
 * 4 7 44 47 74 77 444 447 474 477 744 747
 * 0 1 00 01 10 11 000 001 010 011 100
 *
 * 2 1 digit
 * 4 2 digits
 * 8 3 digits
 * 16 4 digits
 * 32 5 digits
 * 64 6 digits
 * 128 7 digits
 * 256 8 digits
 */
