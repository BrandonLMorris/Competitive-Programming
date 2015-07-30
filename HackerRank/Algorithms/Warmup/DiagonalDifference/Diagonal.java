import java.util.*;

public class Diagonal {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();

    int d1 = 0;
    int d2 = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j == i && j == n-i-1) {
          int x = input.nextInt();
          d1 += x;
          d2 += x;
        }
        else if (j == i) d1 += input.nextInt();
        else if (j == n-i-1) d2 += input.nextInt();
        else input.nextInt();
      }
    }
    System.out.println(Math.abs(d1 - d2));
  }
}
