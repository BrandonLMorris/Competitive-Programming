import java.util.*;
import java.io.*;

public class Server {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(in.readLine());
    int n = Integer.parseInt(st.nextToken());
    int max = Integer.parseInt(st.nextToken());
    int[] vals = new int[n];
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      vals[i] = Integer.parseInt(st.nextToken());
    }
    int current = 0;
    int i = 0;
    for (; i < vals.length; i++) {
      if (current + vals[i] <= max) {
        current += vals[i];
      } else {
        break;
      }
    }

    System.out.println(i);
  }
}
