import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DVD {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      int numDVDs = Integer.parseInt(in.readLine());
      st = new StringTokenizer(in.readLine());
      int counter = 0;
      int current = 1;
      for (int i = 1; i <= numDVDs; i++) {
        if (Integer.parseInt(st.nextToken()) != current)
          counter++;
        else
          current++;
      }
      System.out.println(counter);
    }

  }
}