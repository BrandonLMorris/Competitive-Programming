import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Hay_Comp {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(in.readLine());
    int numWords = Integer.parseInt(st.nextToken());
    int numJobs = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> points = new HashMap<String, Integer>();
    for (int i = 0; i < numWords; i++) {
      st = new StringTokenizer(in.readLine());
      points.put(st.nextToken(), Integer.parseInt(st.nextToken()));
    }
    for (int i = 0; i < numJobs; i++) {
      long pointCount = 0;
      String line = in.readLine().trim();
      while (!line.equals(".")) {
        st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
          String word = st.nextToken();
          if (points.get(word) != null) {
            pointCount += points.get(word);
          }
        }
        line = in.readLine().trim();
      }
      System.out.println(pointCount);
    }

  }
}