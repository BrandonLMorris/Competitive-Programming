import java.util.*;

public class Task {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    StringBuilder sb = new StringBuilder(input.next().toLowerCase());
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == 'a' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i' || sb.charAt(i) == 'o' || sb.charAt(i) == 'u' || sb.charAt(i) == 'y') {
        sb.deleteCharAt(i);
        i--;
      }
    }
    for (int i = 0; i < sb.length(); i += 2) {
      sb.insert(i, '.');
    }
    System.out.println(sb.toString());
  }
}
