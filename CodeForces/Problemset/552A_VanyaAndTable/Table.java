import java.util.*;

public class Table {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int counter = 0;

    int n = input.nextInt();

    for (int i = 0; i < n; i++) {
      int a1 = input.nextInt();
      int a2 = input.nextInt();
      int b1 = input.nextInt();
      int b2 = input.nextInt();

      int x = b1 - a1 + 1;
      int y = b2 - a2 + 1;

      counter += x * y;
    }

    System.out.println(counter);
  }
}
