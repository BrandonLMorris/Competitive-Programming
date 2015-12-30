import java.util.*;
import java.io.*;

public class Message {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      String original = in.readLine();
      int dim = (int)Math.sqrt(original.length());
      char[][] board = new char[dim][dim];

      int start = dim-1;
      StringBuilder sb = new StringBuilder();
      while (start >= 0) {
        int pos = start;
        while (pos < original.length()) {
          sb.append(original.charAt(pos) + "");
          pos += dim;
        }
        start--;
      }
      System.out.println(sb.toString());
    }
  }
}
