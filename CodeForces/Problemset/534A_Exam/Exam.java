import java.util.*;

public class Exam {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();

    if (n == 1 || n == 2) {
      System.out.println(1);
      System.out.println(1);
      return;
    } else if (n == 3) {
      System.out.println(2);
      System.out.println("1 3");
      return;
    } else if (n == 4) {
      System.out.println(4);
      System.out.println("3 1 4 2");
      return;
    }

    System.out.println(n);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i += 2) {
      sb.append(i + " ");
    }
    for (int i = 2; i <= n; i+= 2) {
      sb.append(i + " ");
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb.toString());

  }
}
