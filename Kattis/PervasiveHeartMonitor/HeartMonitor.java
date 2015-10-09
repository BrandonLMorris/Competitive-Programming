import java.util.*;
import java.io.*;

public class HeartMonitor {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (;;) {
      String line = in.readLine();
      if (line == null) break;

      st = new StringTokenizer(line);
      StringBuilder name = new StringBuilder();
      double total = 0.0;
      int counter = 0;
      while (st.hasMoreTokens()) {
        String current = st.nextToken();
        if ((current.charAt(0) >= 'a' && current.charAt(0) <= 'z') || (
            current.charAt(0) >= 'A' && current.charAt(0) <= 'Z' )) {
          name.append(current);
          name.append(" ");
        } else {
          total += Double.parseDouble(current);
          counter++;
        }
      }
      double avg = total / counter;
      System.out.println(avg + " " + name.toString().trim());
    }
  }
}