import java.util.*;
import java.io.*;

public class English {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    HashSet<String> set = new HashSet<String>();
    for (;;) {
      StringBuilder sb = new StringBuilder();
      String line = in.readLine();
      if (line == null) break;
      st = new StringTokenizer(line);
      while (st.hasMoreTokens()) {
        String orig = st.nextToken();
        String lower = orig.toLowerCase();
        if (set.contains(lower)) {
          sb.append(". ");
        } else {
          sb.append(orig + " ");
          set.add(lower);
        }
      }
      System.out.println(sb.toString().trim());
    }

  }
}