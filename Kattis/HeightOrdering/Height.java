import java.util.*;
import java.io.*;

public class Height {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      st = new StringTokenizer(in.readLine());
      int k = Integer.parseInt(st.nextToken());
      int[] kids = new int[20];
      for (int i = 0; i < kids.length; i++) {
        kids[i] = Integer.parseInt(st.nextToken());
      }

      int count = 0;
      for (int i = 0; i < kids.length; i++) {
        for (int j = i + 1; j < kids.length; j++) {
          if (kids[i] > kids[j]) count++;
        }
      }

      System.out.println(k + " " + count);
    }

  }
}
