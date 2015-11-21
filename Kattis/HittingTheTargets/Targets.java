import java.util.*;
import java.io.*;

public class Targets {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int numShapes = Integer.parseInt(in.readLine());
    ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
    ArrayList<Circle> circles = new ArrayList<Circle>();
    for (int i = 0; i < numShapes; i++) {
      st = new StringTokenizer(in.readLine());
      if (st.nextToken().equals("circle")) {
        circles.add(new Circle(Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())));
      } else {
        rects.add(new Rectangle(Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())));
      }
    }

    int numPoints = Integer.parseInt(in.readLine());
    Point[] points = new Point[numPoints];
    for (int i = 0; i < numPoints; i++) {
      st = new StringTokenizer(in.readLine());
      points[i] = new Point(Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()));
    }

    for (Point p : points) {
      int count = 0;
      for (Circle c : circles) { if (c.isIn(p)) count++; }
      for (Rectangle r : rects) { if (r.isIn(p)) count++; }
      System.out.println(count);
    }

  }

  private static class Point {
    int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static class Rectangle {
    Point bl, tr;
    public Rectangle (int x1, int y1, int x2, int y2) {
      this.bl = new Point(x1, y1);
      this.tr = new Point(x2, y2);
    }

    public boolean isIn(Point p) {
      return p.x >= this.bl.x && p.x <= this.tr.x
             && p.y >= this.bl.y && p.y <= this.tr.y;
    }
  }

  private static class Circle {
    Point center;
    int radius;

    public Circle(int x, int y, int r) {
      this.center = new Point(x, y);
      this.radius = r;
    }

    public boolean isIn(Point p) {
      return Math.hypot(p.x - this.center.x, p.y - this.center.y) <= radius;
    }
  }
}
