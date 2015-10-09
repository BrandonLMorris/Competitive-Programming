import java.util.*;
import java.io.*;

public class Circle {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (;;) {
      st = new StringTokenizer(in.readLine());
      double radius = Double.parseDouble(st.nextToken());
      double totalDots = Double.parseDouble(st.nextToken());
      double dotsInCircle = Double.parseDouble(st.nextToken());

      if (radius == 0) break;

      double actArea = Math.PI * Math.pow(radius, 2);
      double estimate = Math.pow(radius*2, 2) * (dotsInCircle / totalDots);

      System.out.println(actArea + " " + estimate);
    }

  }
}