import java.util.*;
import java.io.*;

public class Alien {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 1; t <= numTests; t++) {
      st = new StringTokenizer(in.readLine());

      char[] alienNum = st.nextToken().toCharArray();
      ArrayList<Character> alienList =
          new ArrayList<Character>(alienNum.length);
      for (char c : alienNum) alienList.add(c);

      char[] source = st.nextToken().toCharArray();
      ArrayList<Character> sourceList =
          new ArrayList<Character>(alienNum.length);
      for (char c : source) sourceList.add(c);

      char[] dest = st.nextToken().toCharArray();
      long alienVal = 0;

      // Convert the alien num to decimal (guaranteed to be < 1 billion)
      for (int i = 0; i < alienNum.length; i++) {
        alienVal += sourceList.indexOf(alienList.get(alienList.size()-1-i)) *
            Math.pow(source.length, i);
      }

      // Convert the decimal to the base of the destination, using it's numbers
      StringBuilder sb = new StringBuilder();
      while (alienVal > 0) {
        sb.append(dest[(int)(alienVal % dest.length)]);
        alienVal /= dest.length;
      }

      System.out.println("Case #" + t + ": " +sb.reverse().toString());
    }
  }
}
