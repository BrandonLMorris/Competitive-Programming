import java.util.*;

public class Peragram {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int[] counts = new int[26];
    char[] input = in.nextLine().toCharArray();
    for (char c : input) counts[c - 'a']++;

    int evenCount = 0;
    int oddCount = 0;
    for (int i : counts) {
      if (i % 2 == 0)
        evenCount++;
      else
        oddCount++;
    }

    System.out.println(Math.max(0, oddCount-1));

  }
}
