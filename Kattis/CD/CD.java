import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class CD {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (;;) {

      st = new StringTokenizer(in.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      if (n == 0 && m == 0) break;

      HashSet<Integer> hs = new HashSet<Integer>();

      for (int i = 0; i < n; i++) hs.add(Integer.parseInt(in.readLine()));
      int counter = 0;
      for (int i = 0; i < m; i++) {
        if (hs.contains(Integer.parseInt(in.readLine()))) {
          counter++;
        }
      }

      System.out.println(counter);
    }
  }
}