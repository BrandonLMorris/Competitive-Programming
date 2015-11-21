import java.util.*;
import java.io.*;

public class Everywhere {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      HashSet<String> places = new HashSet<String>();
      int n = Integer.parseInt(in.readLine());
      for (int i = 0; i < n; i++) {
        places.add(in.readLine());
      }
      System.out.println(places.size());
    }
  }
}
