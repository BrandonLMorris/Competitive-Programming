import java.util.*;

/*
 * a  horizontal size
 * b  vertical size
 * s  seconds from launch
 * m  bounces of vertical sides
 * n  bounces of horizontal sides
 */

public class Billiard {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (true) {
      int a = in.nextInt(); // Horizontal size
      int b = in.nextInt(); // Vertical size
      int s = in.nextInt(); // Seconds from launch
      int m = in.nextInt(); // Bounces of vertical sides
      int n = in.nextInt(); // Bounces of horizontal sides

      if (a == 0 && s == 0) break;

      long yLength = b * n;
      long xLength = a * m;

      double hypot = Math.sqrt(yLength*yLength+xLength*xLength);
      double angle = Math.atan(yLength/ (double)xLength);
      angle = angle * 180 / Math.PI;
      if (angle < 0) angle = -1 * angle;
      if (angle > 90) angle = 180 - angle;
      double speed = hypot / (double) s;
      System.out.printf("%.2f %.2f\n", angle, Math.sqrt(yLength*yLength + xLength * xLength) / (double)s);

    }

  }
}
