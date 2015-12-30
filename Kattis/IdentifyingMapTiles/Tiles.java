import java.util.*;
import java.io.*;

public class Tiles {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    char[] key = in.readLine().toCharArray();
    int len = key.length;
    long xlower = 0, ylower = 0;
    long xupper;
    long yupper = xupper = (long)Math.pow(2, len) - 1;
    for (int i = 0; i < len; i++) {
      switch (key[i]) {
        case '0':
          xupper = (xupper + xlower) / 2;
          yupper = (yupper + ylower) / 2;
          break;
        case '2':
          xupper = (xupper + xlower) / 2;
          ylower += Math.pow(2, len-i-1);
          break;
        case '1':
          xlower += Math.pow(2, len-i-1);
          yupper = (yupper + ylower) / 2;
          break;
        case '3':
          xlower += Math.pow(2, len-i-1);
          ylower += Math.pow(2, len-i-1);
          break;
      }
    }
    System.out.println(len + " " + xlower + " " + ylower);
  }
}
