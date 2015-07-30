import java.util.*;

public class Pie {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = Integer.parseInt(input.nextLine());

    HashSet<Character> hs = new HashSet<Character>();
    int buyCounter = 0;

    char[] str = input.nextLine().toCharArray();
    int[] counts = new int[26];

    for (int i = 0; i < n-1; i++) {
      counts[str[2*i]-'a']++;
      char c = str[(2*i)+1];
      if (counts[Character.toLowerCase(c)-'a'] == 0)
        buyCounter++;
      else
        counts[Character.toLowerCase(c)-'a']--;
    }

    System.out.println(buyCounter);
  }
}
