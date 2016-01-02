import java.util.*;
import java.io.*;

public class Mosquito {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      String line = in.readLine();
      if (line == null) break;
      st = new StringTokenizer(line);

      int mos = Integer.parseInt(st.nextToken());
      int pupae = Integer.parseInt(st.nextToken());
      int larvae = Integer.parseInt(st.nextToken());
      int eggsPerMos = Integer.parseInt(st.nextToken());
      int larvaeRate = Integer.parseInt(st.nextToken());
      int pupaeRate = Integer.parseInt(st.nextToken());
      int numWeeks = Integer.parseInt(st.nextToken());

      // egg -> larva -> pupa -> mosquito
      for (int i = 0; i < numWeeks; i++) {
        int futureEggs = mos * eggsPerMos;
        mos = pupae / pupaeRate;
        pupae = larvae / larvaeRate;
        larvae = futureEggs;
      }

      System.out.println(mos);
    }
  }
}
