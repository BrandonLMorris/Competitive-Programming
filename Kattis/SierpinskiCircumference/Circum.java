import java.util.*;
import java.math.*;
import java.io.*;

public class Circum {
  public static void main(String[] args) throws Exception {
    //Scanner in = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    BigDecimal x = new BigDecimal("3");
    BigDecimal mul = new BigDecimal("1.5");

    int[] digits = new int[10001];
    digits[0] = 1;


    StringTokenizer in = new StringTokenizer(reader.readLine());
    for (int t = 1;; t++) {

      int y = Integer.parseInt(in.nextToken());
      if (digits[y] == 0) digits[y] =  x.multiply(mul.pow(y)).toString().indexOf(".");

      System.out.println("Case " + t + ": " + digits[y]);
      String nextLine = reader.readLine();
      if (nextLine == null) break;
      in = new StringTokenizer(nextLine);
    }
  }
}
