import java.util.*;
import java.io.*;

public class Ants {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      st = new StringTokenizer(in.readLine());
      int l = Integer.parseInt(st.nextToken());
      int numAnts = Integer.parseInt(st.nextToken());
      int[] positions = new int[numAnts];
      for (int i = 0; i < numAnts; i++) {
        if (!st.hasMoreTokens()) {
          st = new StringTokenizer(in.readLine());
        }
        positions[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(positions);
      /*
      int mid = positions.length / 2;
      int smallest = Math.max(Math.min(positions[mid], l-positions[mid]), Math.min(positions[mid+1], l-positions[mid]));
      */
      int smallest = Integer.MIN_VALUE;
      int largest = Integer.MIN_VALUE;
      for (int i : positions) {
        smallest = Math.max(smallest, Math.min(i, l-i));
        largest = Math.max(largest, Math.max(i, l-i));
      }

      // int largest = Math.max(l-positions[0], positions[positions.length-1]-l);



      System.out.println(smallest + " " + largest);
    }
  }
}