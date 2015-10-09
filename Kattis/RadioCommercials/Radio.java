import java.util.*;
import java.io.*;

public class Radio {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    int numSpots = Integer.parseInt(st.nextToken());
    int costPerSpot = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(in.readLine());
    int maxEndingHere = 0, maxSoFar = 0;
    for (int i = 0; i < numSpots; i++) {
      int current = Integer.parseInt(st.nextToken()) - costPerSpot;
      maxEndingHere = Math.max(0, maxEndingHere + current);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    System.out.println(maxSoFar);
  }
}