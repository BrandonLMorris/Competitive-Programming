import java.util.*;

/*
 * Given a string s of .'s and #'s, and a number of queries l and r, find
 * the number of indexes i : l <= i < r where s[i] == s[i+1] for each query
 */

public class Query {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the string as a char array
    char[] s = in.nextLine().toCharArray();

    // Store array of 1 and 0: s[i] = 1 if s[i] == s[i+1]
    int[] isSameAsToRight = new int[s.length];
    for (int i = 0; i < s.length - 1; i++) {
      if (s[i] == s[i+1]) {
        isSameAsToRight[i] = 1;
      } else {
        isSameAsToRight[i] = 0;
      }
    }

    // The sum of isSameAsToRight[0] to isSameAsToRight[i] for each element
    int[] sum = new int[s.length];
    int sumCounter = 0;
    for (int i = 0; i < s.length; i++) {
      sum[i] = sumCounter;
      sumCounter += isSameAsToRight[i];
    }

    //Now any query (l, r) is sum[r] - sum[l]

    // Read the number of queries
    int n = in.nextInt();

    // Loop through each query
    for (int i = 0; i < n; i++) {

      // Input indices are 1 indexed
      int l = in.nextInt() - 1;
      int r = in.nextInt() - 1;

      int answer = sum[r] - sum[l];

      System.out.println(answer);
    }
  }
}
