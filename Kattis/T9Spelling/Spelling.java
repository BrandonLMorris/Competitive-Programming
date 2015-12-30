import java.util.*;
import java.io.*;

public class Spelling {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String[] map = {"2", "22", "222", "3", "33", "333", "4", "44", "444",
        "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777",
        "8", "88", "888", "9", "99", "999", "9999"};

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      StringBuilder sb = new StringBuilder();
      char[] line = in.readLine().toCharArray();
      for (int i = 0; i < line.length; i++) {
        if (sb.length() > 0 &&
            line[i] != ' ' &&
            sb.charAt(sb.length()-1) == map[line[i]-'a'].charAt(0)) {
          sb.append(' ');
        } else if (i > 0 && line[i] == ' ' && line[i-1] == ' ') {
          sb.append(' ');
        }
        if (line[i] == ' ') {
          sb.append("0");
        } else {
          sb.append(map[line[i]-'a']);
        }
      }
      System.out.println("Case #" + (t+1) + ": " + sb.toString().trim());
    }
  }
}
