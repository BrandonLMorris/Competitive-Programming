import java.util.*;

public class Fridge {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      String line = input.nextLine().trim();
      if (line.equals("END")) break;
      HashSet<Character> hs = new HashSet<Character>();
      boolean canWrite = true;
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c == ' ') continue;
        if (hs.contains(c)) {
          canWrite = false;
          break;
        } else {
          hs.add(c);
        }
      }
      if (canWrite) {
        System.out.println(line);
      }
    }
  }
}
