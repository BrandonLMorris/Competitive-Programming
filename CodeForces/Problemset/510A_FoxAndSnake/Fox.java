import java.util.*;

public class Fox {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i % 2 == 0) {
          System.out.print("#");
        } else if ((i-1) % 4 == 0) {
          if (j == m-1) {
            System.out.print("#");
          } else {
            System.out.print(".");
          }
        } else {
          if (j == 0) {
            System.out.print("#");
          } else {
            System.out.print(".");
          }
        }

      }
      System.out.println();
    }
  }
}
