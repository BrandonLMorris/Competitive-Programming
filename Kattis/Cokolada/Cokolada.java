import java.util.*;

public class Cokolada {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int x = (int) Math.ceil(Math.log(n) / Math.log(2));
    int y = (int)Math.pow(2, x);

    int result = 0;
    if (n == y) {
      result = 0;
    } else if (n % 2 == 1) {
      result = x;
    } else {
      int counter = 0;
      while (n % 2 == 0) {
        n /= 2;
        counter++;
      }
      result = x - counter;
    }

    System.out.println(y + " " + result);
  }
}
