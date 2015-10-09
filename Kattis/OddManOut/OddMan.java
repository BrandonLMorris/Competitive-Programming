import java.util.*;
import java.io.*;

public class OddMan {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 1; t <=numTests; t++) {
      HashSet<Long> hs = new HashSet<Long>();
      int g = Integer.parseInt(in.readLine());
      st = new StringTokenizer(in.readLine());
      for (int i = 0; i < g; i++) {
        long l = Long.parseLong(st.nextToken());
        if (hs.contains(l)) {
          hs.remove(l);
        } else {
          hs.add(l);
        }
      }
      long result = 0;
      for (long l : hs) {
        result = l;
      }
      System.out.println("Case #" + t + ": " + result);
    }
  }
}