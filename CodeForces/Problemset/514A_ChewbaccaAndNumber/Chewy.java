import java.util.*;

public class Chewy {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] line = input.nextLine().toCharArray();
    for (int i = 0; i < line.length; i++) {
      int j = Character.getNumericValue(line[i]);
      if (j > 4 && !(j == 9 && i == 0)) {
        j = 9 - j;
        line[i] = (char)(j + '0');
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : line) {
      sb.append(c);
    }
    System.out.println(Long.parseLong(sb.toString()));
  }
}
