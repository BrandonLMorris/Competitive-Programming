import java.util.*;

public class Cinema {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long num25 = 0;
    long num50 = 0;
    long num100 = 0;

    for (int i = 0; i < n; i++) {
      int next = input.nextInt();
      if (next == 25) {
        num25++;
      } else if (next == 50) {
        num50++;
        num25--;
        if (num25 < 0) {
          System.out.println("NO");
          return;
        }
      } else {
        num100++;
        if (num50 != 0) {
          num50--;
          num25--;
        } else {
          num25 -= 3;
        }
        if (num25 < 0) {
          System.out.println("NO");
          return;
        }
      }
    }
    System.out.println("YES");
  }
}
