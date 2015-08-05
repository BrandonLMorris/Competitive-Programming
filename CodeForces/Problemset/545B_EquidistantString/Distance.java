import java.util.*;

/*
 * Given two strings consisting of 0's and 1's, find a third string that is
 * of equal Hamming distance to both the strings
 */

public class Distance {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the two strings in as character arrays
    char[] s1 = in.nextLine().toCharArray();
    char[] s2 = in.nextLine().toCharArray();

    // Iterate through the arrays and calculate the distance
    int distance = 0;
    for (int i = 0; i < s1.length; i++) {
      if (s1[i] != s2[i]) {
        distance++;
      }
    }

    // If distance is odd, not possible
    if (distance % 2 == 1) {
      System.out.println("impossible");
      return;
    }

    // Otherwise, change the first (distance / 2) differences
    distance /= 2;
    int i = 0;
    while (distance > 0) {
      if (s1[i] != s2[i]) {
        s1[i] = s2[i];
        distance--;
      }
      i++;
    }

    // Print the result
    System.out.println(new String(s1));
  }
}
