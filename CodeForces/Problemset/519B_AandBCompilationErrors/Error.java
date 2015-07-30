import java.util.*;

public class Error {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long x = 0;
    for (int i = 0; i < n; i++) {
        x = x ^ input.nextInt();
    }
    long y = x;
    for (int i = 0; i < n-1; i++) {
        y = y ^ input.nextInt();
    }
    long z = x ^ y;
    for (int i = 0; i < n-2; i++) {
        z = z ^ input.nextInt();
    }
    System.out.println(y + "\n" + z);
  }
}
