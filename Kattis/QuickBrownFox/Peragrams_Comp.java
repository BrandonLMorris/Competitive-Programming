import java.util.*;
import java.io.*;

public class Peragrams_Comp {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      String line = in.readLine().toLowerCase();
      boolean[] alphabet = new boolean[26];
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c >= 'a' && c <= 'z') {
          alphabet[c-'a'] = true;
        }
      }
      boolean isPera = true;
      for (boolean b : alphabet) {
        if (!b) {
          isPera = false;
          break;
        }
      }
      if (isPera) {
        System.out.println("pangram");
      } else {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
          if (!alphabet[i]) {
            sb.append(""+(char)(i+'a'));
          }
        }
        System.out.println("missing " + sb.toString());
      }

    }
  }
}