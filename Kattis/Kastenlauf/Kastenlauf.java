import java.util.*;
import java.io.*;

public class Kastenlauf {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {

      // Keep a list of points and edges in our graph
      PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
      ArrayList<Point> points = new ArrayList<Point>();

      // Read in home
      int n = Integer.parseInt(in.readLine());
      st = new StringTokenizer(in.readLine());
      int count = 0;
      Point home = new Point(Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()), count);
      points.add(home);
      count++;

      // Read in all the store positions
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(in.readLine());
        String firstT = st.nextToken();
        String secT = st.nextToken();
        points.add(new Point(Integer.parseInt(firstT), 
              Integer.parseInt(secT), count));
        count++;
      }

      // Read in the home position
      st = new StringTokenizer(in.readLine());
      Point end = new Point(Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()), count);
      points.add(end);

      // Create every possible edge
      for (int i = 0; i < points.size(); i++) {
        for (int j = i+1; j < points.size(); j++) {
          edges.add(new Edge(points.get(i), points.get(j)));
          count++;
        }
      }

      boolean isHappy = true;
      while (home.color != end.color) {
        Edge e = edges.poll();
        // No valid edge can be greater than 20 beers * 50 meters
        if (e.distance > (20*50)) {
          isHappy = false;
          break;
        }

        // Recolor to show connection
        if (e.p1.color != e.p2.color) {
          int color = e.p1.color;
          for (Point p : points) {
            if (p.color == color) {
              p.color = e.p2.color;
            }
          }
        }
      }
      System.out.println(isHappy ? "happy" : "sad");
    }


  }

  // Edge - simple edge class that calculates distance from two points and is
  // sortable based on that distance
  private static class Edge implements Comparable<Edge> {
    Point p1;
    Point p2;
    int distance;

    public Edge(Point first, Point second) {
      this.p1 = first;
      this.p2 = second;
      this.distance = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public int compareTo(Edge other) {
      if (this.distance == other.distance) return 0;
      return (this.distance - other.distance);
    }
  }

  // Point - simple point class that stores the x and y coordinate and its color
  private static class Point {
    int x,y, color;
    public Point(int x, int y, int color) {
      this.x = x;
      this.y = y;
      this.color = color;
    }
  }
}
