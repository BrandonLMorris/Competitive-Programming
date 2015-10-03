import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Speed {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    for (;;) {
      String firstLine = in.readLine();
      if (Integer.parseInt(firstLine) == -1) break;

      int n = Integer.parseInt(firstLine);
      int counter = 0;
      int current = 0;
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(in.readLine());
        int speed = Integer.parseInt(st.nextToken());
        int hours = Integer.parseInt(st.nextToken());
        counter += (speed * (hours - current));
        current = hours;
      }
      System.out.println(counter + " miles");

    }

  }
}