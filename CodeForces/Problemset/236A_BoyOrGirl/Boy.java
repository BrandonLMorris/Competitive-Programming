import java.util.*;

public class Boy {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] word = input.nextLine().toCharArray();
    HashSet<Character> set = new HashSet<Character>();
    for (char c : word) {
      set.add(c);
    }
    if (set.size() % 2 == 0) System.out.println("CHAT WITH HER!");
    else System.out.println("IGNORE HIM!");
  }
}
