import java.util.*;
import java.io.*;

public class Parking {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    int aRate = Integer.parseInt(st.nextToken());
    int bRate = Integer.parseInt(st.nextToken());
    int cRate = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(in.readLine());
    int start1 = Integer.parseInt(st.nextToken());
    int end1 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(in.readLine());
    int start2 = Integer.parseInt(st.nextToken());
    int end2 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(in.readLine());
    int start3 = Integer.parseInt(st.nextToken());
    int end3 = Integer.parseInt(st.nextToken());

    int longest = Math.max(end1, Math.max(end2, end3));
    boolean[] times1 = new boolean[longest];
    boolean[] times2 = new boolean[longest];
    boolean[] times3 = new boolean[longest];

    for (int i = start1-1; i < end1-1; i++) {
      times1[i] = true;
    }
    for (int i = start2-1; i < end2-1; i++) {
      times2[i] = true;
    }
    for (int i = start3-1; i < end3-1; i++) {
      times3[i] = true;
    }

    int counter = 0;
    for (int i = 0; i < longest; i++) {
      int count = 0;
      if (times1[i]) count++;
      if (times2[i]) count++;
      if (times3[i]) count++;

      if (count == 1) counter += aRate;
      else if (count == 2) counter += (2*bRate);
      else if (count == 3) counter += (3*cRate);
    }
    System.out.println(counter);
  }
}