import java.util.*;

/*
 * Given an integer n, find the largest even number from swapping exactly
 * two digits in n, if one exists at all
 */

public class Currency {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input as a character array
    char[] today = in.next().toCharArray();


    // Keep count of the swap position
    // -1 is a flag for no even number
    int switchPos = -1;
    for (int i = 0; i < today.length; i++) {
      // Check if the current number is even
      if ((today[i] - '0') % 2 == 0) {
        // If the even number is larger, mark the position but move on
        if (today[i] > today[today.length - 1]) {
          switchPos = i;
        } else {
          // If the even is smaller, go ahead and swap
          char c = today[i];
          today[i] = today[today.length-1];
          today[today.length-1] = c;
          // -2 is flag for already swapped
          switchPos = -2;
          break;
        }
      }
    }

    if (switchPos == -1) {
      // Print -1 if no even digit
      System.out.println(-1);
    } else if (switchPos != -2) {
      // Swap if not done already
      char c = today[switchPos];
      today[switchPos] = today[today.length-1];
      today[today.length - 1] = c;
      System.out.println(new String(today));
    } else {
      // Otherwise print out the already swapped string
      System.out.println(new String(today));
    }

  }
}
