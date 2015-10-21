import java.util.*;
import java.io.*;

public class Conundrum {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String line = in.readLine().toLowerCase();
    int count = 0;
    for (int i = 0; i < line.length(); i++) {
      if (i % 3 == 0 && line.charAt(i) != 'p') count++;
      else if (i % 3 == 1 && line.charAt(i) != 'e') count++;
      else if (i % 3 == 2 && line.charAt(i) != 'r') count++;
    }
    System.out.println(count);
  }
}