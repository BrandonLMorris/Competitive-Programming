import java.util.*;
import java.io.*;

public class Quite {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (;;) {
      String line = in.readLine();
      if (line == null) break;

      if (line.toUpperCase().contains("PROBLEM")) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }

  }
}