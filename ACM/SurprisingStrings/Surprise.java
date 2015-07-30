import java.util.*;

public class Surprise {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      char[] line = input.nextLine().toCharArray();
      if (line[0] == '*') break;
      boolean isSurprising = true;
      for (int i = 0; i < line.length; i++) {
        HashSet<String> hs = new HashSet<String>();
        for (int j = 0; j < line.length; j++) {
          if (j + i + 1 < line.length) {
            if (hs.add("" + line[j] + line[j+i+1]) == false) {
                  String str = to_string(line);
                  System.out.println(str + " is NOT surprising.");
                  isSurprising = false;
                  break;
                }
            if (!isSurprising) break;
          }
        }
      }
      if (isSurprising) {
        String str = to_string(line);
        System.out.println(str + " is surprising.");
      }
    }
  }

  static String to_string(char[] arr) {
    StringBuilder sb = new StringBuilder();
    for (char c : arr) {
      sb.append(c);
    }
    return sb.toString();
  }

}
