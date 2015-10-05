import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Oddieties_Comp {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      String line = in.readLine();
      System.out.println(line + (Integer.parseInt(line) % 2 == 0 ? " is even" : " is odd"));
    }

  }
}