import java.util.*;
import java.io.*;

public class CD_Comp {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (;;) {
      st = new StringTokenizer(in.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      if (n == 0 && m == 0) break;

      int[] jack = new int[n];
      int[] jill = new int[m];

      for (int i = 0; i < n; i++) {
        jack[i] = Integer.parseInt(in.readLine());
      }
      for (int i = 0; i < m; i++) {
        jill[i] = Integer.parseInt(in.readLine());
      }

      int counter = 0;
      int i = 0, j = 0;
      while (i < n && j < m) {
        if (jack[i] == jill[j]) {
          counter++;
          i++;
          j++;
        } else if (jack[i] < jill[j]) {
          i++;
        } else {
          j++;
        }
      }

      System.out.println(counter);
    }
  }
}