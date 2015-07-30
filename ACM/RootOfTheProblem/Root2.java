import java.util.*;

public class Root2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      int B = input.nextInt();
      int N = input.nextInt();
      if (B == 0 && N == 0) break;
      int result = 0;
      double closest = Double.MAX_VALUE;
      for (int i = 0; i <= B; i++) {
        double val = Math.pow(i, N);
        if ( Math.abs(B - val) < Math.abs(B - closest)) {
          closest = val;
          result = i;
        }
      }
      System.out.println(result);
      //System.out.println(Math.pow(result, N));
      //System.out.println(Math.pow(result-1, N));
      //System.out.println(Math.pow(result+1, N));
    }
  }
}
