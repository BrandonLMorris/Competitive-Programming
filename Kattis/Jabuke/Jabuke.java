import java.util.*;
import java.io.*;

public class Jabuke {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // Read the thre points of the triangle
    st = new StringTokenizer(in.readLine());
    int x1 = Integer.parseInt(st.nextToken());
    int y1 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());
    int x2 = Integer.parseInt(st.nextToken());
    int y2 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());
    int x3 = Integer.parseInt(st.nextToken());
    int y3 = Integer.parseInt(st.nextToken());

    double area = triangleArea(x1, y1, x2, y2, x3, y3);
    System.out.println(area);

    // For each point, it's in the triangle if the areas of the triangle from
    // it and each pair of vertices sum to the total area of the triangle
    int count = 0;
    int numTrees = Integer.parseInt(in.readLine());
    for (int i = 0; i < numTrees; i++) {

      st = new StringTokenizer(in.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      // Replace each point and get the area
      double rep1 = triangleArea(x,y,x2,y2,x3,y3);
      double rep2 = triangleArea(x1,y1,x,y,x3,y3);
      double rep3 = triangleArea(x1,y1,x2,y2,x,y);

      if (area == rep1+rep2+rep3)
        count++;
    }

    System.out.println(count);

  }

  // Formula to get the area of a triangle from its points (based on Green's
  // Theorem)
  static double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
    return Math.abs(x1 * (y2 - y3) + x2*(y3-y1) + x3*(y1 - y2)) / 2.0;
  }
}
