import java.util.*;

/*
 * Given two numbers, m and s, find the smallest and largest m-digit number
 * whose digits sum to s.
 * Example
 *  2 15
 *  smallest => 69 (6 + 9 = 15)
 *  largest => 96 (9 + 6 = 15)
 *
 * If not possible, print -1 -1
 *
 * Note, leading zeros are not allowed
 */

public class Digits {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the length and sum
    int numDigits = in.nextInt();
    int sumDigits = in.nextInt();

    // Edge Case Check: The only time sumDigits is allowed to be 0 is if
    // numDigits is also 1. Then the answer is "0 0" since technically it's
    // not a leading zero
    if (numDigits == 1 && sumDigits == 0) {
      System.out.println("0 0");
      return;
    }

    /* Find the largest number */

    // If s > (9 * m), not possible
    if (sumDigits > (9 * numDigits) || sumDigits == 0) {
      System.out.println("-1 -1");
      return;
    }

    // Add the largest numbers possible
    StringBuilder sb = new StringBuilder();
    int counter = sumDigits;
    // Continously add 9's
    for (int i = 0; i < counter / 9; i++) {
      sb.append("9");
    }
    counter %= 9;

    // Append the leftover if any
    if (counter != 0) {
      sb.append(counter);
    }

    // Pad the ending with 0's
    while (sb.length() < numDigits) {
      sb.append(0);
    }

    // Store result as string
    String largest = sb.toString();


    /* Find the smallest possible number */

    // Change the largest result to an array
    char[] smallestArr = largest.toCharArray();

    // Sort the array, now smallest possible
    Arrays.sort(smallestArr);

    // If the smalles result contains any leading zeros, steal one from the
    // first nonzero digit and put it at the front
    if (smallestArr[0] == '0') {
      int i = 0;
      while (smallestArr[i] == '0') {
        i++;
      }
      smallestArr[0] = '1';
      smallestArr[i]--;
    }

    String smallest = new String(smallestArr);


    // Print the result
    System.out.println(smallest + " " + largest);


  }
}
