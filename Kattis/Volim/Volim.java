import java.util.*;
import java.io.*;

public class Volim {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int pos = Integer.parseInt(in.readLine()) - 1;
    int numQs = Integer.parseInt(in.readLine());

    int timeLeft = 210;
    while (timeLeft > 0) {
      st = new StringTokenizer(in.readLine());
      timeLeft -= Integer.parseInt(st.nextToken());
      if (timeLeft > 0 && st.nextToken().charAt(0) == 'T') {
        pos = (pos + 1) % 8;
      }
    }

    System.out.println((pos+1));

  }
}
