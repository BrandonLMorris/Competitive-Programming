import java.util.*;

public class Root {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      int b = input.nextInt();
      int n = input.nextInt();
      if (b == 0) break;
      double closest = Double.MAX_VALUE;
      int result = 0;
      for (int i = 1; i <= 1000000; i++) {
        double val = Math.pow(i, n);
        //System.out.println(val);
        if (Math.abs(val - b) < Math.abs(closest - b)) {
          //System.out.println(val + " is closer to " + b + " than " + closest);
          closest = val;
          result = i;
        }
      }
      System.out.println(result);
    }
  }
}
