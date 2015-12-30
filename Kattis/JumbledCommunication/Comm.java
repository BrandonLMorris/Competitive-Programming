import java.util.*;
import java.io.*;

public class Comm {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // Map the scrambled bits to the original
    int[] scrambled = new int[256];
    for (int i = 0; i <= 255; i++) {
      scrambled[i] = i ^ (i << 1);
      if (scrambled[i] > 255) scrambled[i] -= 256;
    }

    int[] unscrambled = new int[256];
    for (int i = 0; i <= 255; i++) {
      unscrambled[scrambled[i]] = i;
    }

    in.readLine();
    StringBuilder sb = new StringBuilder();
    for (String s : in.readLine().split(" ")) sb.append(unscrambled[Integer.parseInt(s)] + " ");
    System.out.println(sb.toString().trim());
  }
}
