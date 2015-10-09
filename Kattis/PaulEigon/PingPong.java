import java.util.*;
import java.io.*;

public class PingPong {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    long n = Long.parseLong(st.nextToken());
    long p = Long.parseLong(st.nextToken());
    long q = Long.parseLong(st.nextToken());

    // p + q is number of turns. Divide by n, and determine if even
    System.out.println(((p + q) / n) % 2 == 0 ? "paul" : "opponent");

  }
}