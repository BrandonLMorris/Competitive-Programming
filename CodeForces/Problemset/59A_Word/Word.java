import java.util.*;

public class Word {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] line = input.nextLine().toCharArray();
    int upper = 0;
    int lower = 0;
    for (char c : line) {
      if (Character.isUpperCase(c)) upper++;
      else lower++;
    }
    if (lower >= upper) {
      for (int i = 0; i < line.length; i++) {
        line[i] = Character.toLowerCase(line[i]);
      }
    } else {
      for (int i = 0; i < line.length; i++) {
        line[i] = Character.toUpperCase(line[i]);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : line) sb.append(c);
    System.out.println(sb.toString());
  }
}
