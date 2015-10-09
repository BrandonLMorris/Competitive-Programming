import java.util.*;
import java.io.*;

public class QuickFox {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      String line = in.readLine().toLowerCase();
      boolean[] alpha = new boolean[26];
      for (int i = 0; i < line.length(); i++) {
        if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
          alpha[line.charAt(i) - 'a'] = true;
        }
      }

      boolean isPana = true;
      for (boolean b : alpha) {
        if (!b) {
          isPana = false;
          break;
        }
      }

      if (isPana) {
        System.out.println("pangram");
      } else {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
          if (!alpha[i]) {
            sb.append(""+(char)(i+'a'));
          }
        }
        System.out.println("missing " + sb.toString());
      }
    }

  }
}