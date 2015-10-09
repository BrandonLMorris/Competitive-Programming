import java.util.*;
import java.io.*;

public class Minute {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    double runSec = 0;
    double runSL = 0;
    for (int t = 0; t < numTests; t++) {
      st = new StringTokenizer(in.readLine());
      int m = Integer.parseInt(st.nextToken());
      int sec = Integer.parseInt(st.nextToken());
      runSec += m*60;
      runSL += sec;
    }

    double avg = runSL / runSec;
    if (avg <= 1.0) {
      System.out.println("measurement error");
    } else {
      System.out.println(avg);
    }
  }
}