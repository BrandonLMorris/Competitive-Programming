import java.util.*;

public class Fractions {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    for (;;) {
      int a = in.nextInt();
      int b = in.nextInt();

      if (a == 0 && b == 0) break;

      int whole = a / b;
      int remainder = a % b;

      System.out.println(whole + " " + remainder + " / " + b);
    }
  }
}
