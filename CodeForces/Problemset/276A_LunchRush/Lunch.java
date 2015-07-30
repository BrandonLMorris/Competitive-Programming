import java.util.*;

public class Lunch {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    int t = input.nextInt();

    int maxJoy = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int f = input.nextInt();
      int ti = input.nextInt();
      int joy = Integer.MIN_VALUE;
      if (ti > t) {
        joy = f - (ti - t);
      } else {
        joy = f;
      }

      maxJoy = Math.max(joy, maxJoy);

    }

    System.out.println(maxJoy);
  }
}
