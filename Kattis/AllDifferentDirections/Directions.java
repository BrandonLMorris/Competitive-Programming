import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Directions {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(in.readLine());
    while (n != 0) {
      double[] xfinals = new double[n];
      double[] yfinals = new double[n];

      for (int i = 0; i < n; i++) {

        StringTokenizer line = new StringTokenizer(in.readLine());

        double x = Double.parseDouble(line.nextToken());
        double y = Double.parseDouble(line.nextToken());

        line.nextToken();
        double angle = Double.parseDouble(line.nextToken());

        while (line.hasMoreTokens()) {
          String instruction = line.nextToken();
          if (instruction.equals("turn")) {
            angle += Double.parseDouble(line.nextToken());
          } else {
            double dist = Double.parseDouble(line.nextToken());
            x += dist * Math.cos(Math.toRadians(angle));
            y += dist * Math.sin(Math.toRadians(angle));
          }
        }

        xfinals[i] = x;
        yfinals[i] = y;

      }

      double avgx = 0.0;
      double avgy = 0.0;
      for (int i = 0; i < n; i++) {
        avgx += xfinals[i];
        avgy += yfinals[i];
      }
      avgx /= (double)n;
      avgy /= (double)n;

      double worstOff = Integer.MIN_VALUE;
      int worst = -1;
      for (int i = 0; i < n; i++) {
        double off = Math.sqrt(Math.pow(avgx-xfinals[i], 2) + Math.pow(avgy-yfinals[i], 2));
        if (off > worstOff) {
          worstOff = off;
          worst = i;
        }
      }

      System.out.println(avgx + " " + avgy + " " + worstOff);

      n = Integer.parseInt(in.readLine());
    }
  }
}