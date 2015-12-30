import java.util.*;
import java.io.*;

public class Queen {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(in.readLine());
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(in.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        if (x[i] == x[j] || y[i] == y[j] ||
            Math.abs(x[i] - x[j]) == Math.abs(y[i] - y[j])) {
              System.out.println("INCORRECT");
              return;
            }
      }
    }
    System.out.println("CORRECT");
  }
}
