import java.util.*;
import java.io.*;

public class Simon_Comp {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numLines = Integer.parseInt(in.readLine());
    for (int t = 0; t < numLines; t++) {
      String line = in.readLine();
      if (line.startsWith("Simon says ")) {
        String result = line.substring("Simon says ".length());
        System.out.println(result);
      }
    }
    
  }
}