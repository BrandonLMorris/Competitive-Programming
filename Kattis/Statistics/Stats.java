import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Stats {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int t = 1;; t++) {
      String line = in.readLine();
      if (line == null) break;
      st = new StringTokenizer(line);
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      int n = Integer.parseInt(st.nextToken());
      for (int i = 0; i < n; i++) {
        int x = Integer.parseInt(st.nextToken());
        min = Math.min(min, x);
        max = Math.max(max, x);
      }

      int range = max - min;
      System.out.println("Case " + t + ": " + min + " " + max + " " + range);
    }

  }
}