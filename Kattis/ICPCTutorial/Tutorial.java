import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Tutorial {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    long m = in.nextLong();
    long n = in.nextLong();
    int t = in.nextInt();

    boolean pass = false;
    switch (t) {
      case 1:
        long fact = factorial(n);
        pass = (fact != 0) && fact <= m;
        break;
      case 2:
        pass = Math.pow(2, n) <= m;
        break;
      case 3:
        pass = Math.pow(n, 4) <= m;
        break;
      case 4:
        pass = Math.pow(n, 3) <= m;
        break;
      case 5:
        pass = Math.pow(n, 2) <= m;
        break;
      case 6:
        pass = (n * (Math.log(n)/Math.log(2))) <= m;
        break;
      case 7:
        pass = n <= m;
        break;
      default:
        System.out.println("YOU DONE MESSED UP AARON!");
    }
    System.out.println((pass ? "AC" : "TLE"));

  }

  private static long factorial(long n) {
    long result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }
}