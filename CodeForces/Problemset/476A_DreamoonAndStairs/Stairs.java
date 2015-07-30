import java.util.*;

public class Stairs {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    if (m > n) {
      System.out.println(-1);
      return;
    }
    int x = 0;
    int y = 0;

    if (n % 2 == 0) {
      x = n / 2;
    } else {
      x = n / 2;
      y = 1;
    }

    while (x >= 0) {
      // System.out.println("x: " + x + " y: " + y);
      if ((x+y) % m == 0) {
        System.out.println((x+y));
        return;
      }
      x--;
      y += 2;
    }
    System.out.println(-1);
  }
}
