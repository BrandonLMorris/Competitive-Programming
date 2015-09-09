import java.util.*;

public class Kem {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    char[] line = in.nextLine().toCharArray();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < line.length; i++) {
      sb.append(line[i]);
      if (line[i] == 'a' || line[i] == 'e' || line[i] == 'i' ||
          line[i] == 'o' || line[i] == 'u') {
        i += 2;
      }
    }

    System.out.println(sb.toString());
  }
}
