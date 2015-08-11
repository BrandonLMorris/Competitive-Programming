import java.util.*;

/*
 * Given a number n of wallets and an array where a[i] is the number of coins
 * to put in a wallet, print instructions for a robot to insert the correct
 * number of coins in each wallet
 */

public class Present {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of wallets
    int n = in.nextInt();

    // Read in the number of coins for each wallet
    int[] wallets = new int[n];
    for (int i = 0; i < n; i++) {
      wallets[i] = in.nextInt();
    }

    // StringBuilder to store the result
    StringBuilder sb = new StringBuilder();

    // Move left to right, adding coins to each wallet as needed
    for (int pos = 0; pos < n; pos++) {
      // Add all the coins to each wallet
      while (wallets[pos] > 0) {
        sb.append("P");
        wallets[pos]--;

        // Move one position then back (since can't deposit two coins)
        if (wallets[pos] > 0) {
          if (pos < n-1) {
            sb.append("RL");
          } else {
            // Move left if at the right end
            sb.append("LR");
          }
        }
      }

      // Add an 'R' while moving along
      if (pos < n-1) {
        sb.append("R");
      }
    }

    System.out.println(sb.toString());
  }
}
