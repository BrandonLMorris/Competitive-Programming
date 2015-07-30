import java.util.*;

public class Letters {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] line = input.nextLine().toCharArray();
    HashSet<Character> chars = new HashSet<Character>();
    for (char c : line) {
      if(Character.isAlphabetic(c)) {
        chars.add(c);
      }
    }
    System.out.println(chars.size());
  }
}
