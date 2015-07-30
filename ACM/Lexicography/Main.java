import java.util.*;

class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.realMain();
  }

  void realMain() {
    Scanner input = new Scanner(System.in);

    for(;;) {
      String str = input.next();
      if (str.charAt(0) == '#') break;
      long k = Long.parseLong(input.next());


      char[] strArr = str.toCharArray();
      // Sort the list to ensure alphabetical order in determining anagrams
      Arrays.sort(strArr);

      // Count the number of each character (for repetitions)
      int[] counts = new int[26];
      for (char c : strArr) {
        counts[c-'A']++;
      }

      // ArrayList to store the final result
      ArrayList<Character> result = new ArrayList<Character>();

      // For each character that will be in the result string
      for (int i = 1; i <= str.length(); i++) {

        // Try each letter
        for (int j = 0; j < 26; j++) {
          // If we don't have any more of that letter, move on
          if (counts[j] == 0) continue;

          // Reduce count, as if using that character
          counts[j] -= 1;

          // Determine number of permutations after removing character
          long p = perm(str.length()-i, counts);

          if (p >= k) {
            result.add((char)('A' + j));
            //System.out.println("Adding " + (char)('A'+j));
            break;
          }

          // Since we didn't use the char, add its count back
          counts[j] += 1;

          // Reduce k
          k -= p;
        }
      }

      StringBuilder sb = new StringBuilder();
      for (char c : result) sb.append(c);
      System.out.println(sb.toString());
    }


  }

  public static long factorial(long n) {
    long count = 1;
    for (int i = 1; i <= n; i++) {
      count *= i;
    }
    return count;
  }

  public static long perm(int n, int[] arr) {
    long p = factorial(n);
    //int[] counts = new int[26];
    //for (char c : arr) {
    //  counts[c-'A']++;
    //}
    for (int i : arr) {
      p /= factorial(i);
    }

    return p;
  }

}
