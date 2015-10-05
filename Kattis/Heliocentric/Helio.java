import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Helio {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int t = 1;;t++) {
      String line = in.readLine();
      if (line == null) break;
      st = new StringTokenizer(line);
      long earth = Long.parseLong(st.nextToken());
      long mars = Long.parseLong(st.nextToken());

      if (earth == 0 && mars == 0) {
        System.out.println("Case " + t + ": " + 0);
        continue;
      }

      long earthDays = 365 - earth;
      long count = earthDays;
      mars = mars + earthDays;
      earth = 365;
      while (!(mars % 687 == 0 && earth % 365 == 0)) {
        mars += 365;
        count += 365;
        earth += 365;
      }
      System.out.println("Case " + t + ": " + count);
    }


  }
}