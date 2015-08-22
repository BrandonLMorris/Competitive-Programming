import java.util.*;

public class Centipede {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();

    System.out.println(Math.max((2 * b + 40), (a * 2 + 39)));
  }
}
