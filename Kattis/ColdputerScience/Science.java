import java.util.*;
import java.io.*;

public class Science {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(in.readLine());
    int count = 0;
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      if (Integer.parseInt(st.nextToken()) < 0) count++;
    }
    System.out.println(count);
  }
}
