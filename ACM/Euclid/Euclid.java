import java.util.*;

public class Euclid {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      double ax = input.nextDouble();
      double ay = input.nextDouble();
      double bx = input.nextDouble();
      double by = input.nextDouble();
      double cx = input.nextDouble();
      double cy = input.nextDouble();

      // Triangle points
      double dx = input.nextDouble();
      double dy = input.nextDouble();
      double ex = input.nextDouble();
      double ey = input.nextDouble();
      double fx = input.nextDouble();
      double fy = input.nextDouble();

      if (ax == 0 && ay == 0 && bx == 0 && by == 0 && cx == 0 && cy == 0 && dx == 0 && dy == 0 && ex == 0 && ey ==  0 && fx == 0 && fy == 0) break;

      double a = Math.hypot(dx-ex, dy-ey);
      double b = Math.hypot(ex-fx, ey-fy);
      double c = Math.hypot(fx-dx, fy-dy);

      double s = (0.5) * (a+b+c);
      double triangleArea = Math.sqrt(s*(s-a)*(s-b)*(s-c));

      // Find the distance of ah for areas to equal
      double cbInnerProd = (cx-ax)*(bx-ax) + (cy-ay)*(by-ay);
      double theta = Math.acos(cbInnerProd / (Math.hypot(ay-cy,ax-cx)*Math.hypot(ay-by,ax-bx)));
      double ahDist = triangleArea / (Math.hypot(ay-by,ax-bx)*Math.sin(theta));


      //double ahDist = triangleArea / Math.hypot(ax-bx,ay-by);

      Point hPoint = pointOnLine2(new Point(ax,ay), new Point(cx,cy), ahDist);
      double hx = hPoint.x;
      double hy = hPoint.y;

      double rectArea = ahDist * Math.hypot(by-ay,bx-ax);

      double gx = hx - (ax - bx);
      double gy = hy - (ay - by);

      System.out.printf("%.3f %.3f %.3f %.3f\n", gx, gy, hx, hy);


    }

  }

  public static Point pointOnLine2(Point p1, Point p2, double dist) {
    double d = Math.hypot(p2.x-p1.x,p2.y-p1.y);
    double newX = p1.x + (dist/d)*(p2.x-p1.x);
    double newY = p1.y + (dist/d)*(p2.y-p1.y);
    return new Point(newX, newY);
  }

  public static Point pointOnLine(Point p1, Point p2, double dist) {

    // Test for infinite slope
    if (p2.x == p1.x) {
      return new Point(p1.x, p1.y + dist);
    }

    double m = (p2.y - p1.y) / (p2.x - p1.x);

    double a = 1 + (m*m);
    double b = (-2)*p1.x + (-2)*p1.x*m*m;
    double c = p1.x*p1.x + m*m*p1.x*p1.x - dist*dist;

    double firstX = ((-1)*b + Math.sqrt(b*b - 4*a*c)) / (2*a);
    double secondX = ((-1)*b - Math.sqrt(b*b - 4*a*c)) / (2*a);

    if (Math.hypot(firstX, p2.x) > Math.hypot(secondX, p2.x)) {
      double y = m*firstX - m*p1.x + p1.y;
      return new Point(firstX, y);
    } else {
      double y = m*secondX - m*p1.x + p1.y;
      return new Point(secondX, y);
    }
  }

  private static class Point {
    double x;
    double y;
    public Point(double xArg, double yArg) {
      this.x = xArg;
      this.y = yArg;
    }
  }

}
