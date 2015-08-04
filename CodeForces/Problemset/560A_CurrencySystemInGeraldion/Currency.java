import java.util.*;

/*
 * Given a set of numbers, find the minimum number that can't be represented
 * by a linear combination of the elements in the set, or -1 if all natural
 * numbers can be represented.
 */

public class Currency {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of elements in the set
    int n = in.nextInt();

    // Store the elements in an array
    int[] banknotes = new int[n];
    for (int i = 0; i < n; i++) {
      banknotes[i] = in.nextInt();

      // If there is a 1, exit with -1 since it can represent anything
      if (banknotes[i] == 1) {
        System.out.println(-1);
        return;
      }
    }

    // Minimum number will be the smallest value not in the set
    Arrays.sort(banknotes);
    int i = 1;
    while (i-1 < banknotes.length) {
      if (banknotes[i-1] != i) {
        System.out.println(i);
        return;
      }
      i++;
    }


  }
}
