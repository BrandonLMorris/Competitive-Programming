import java.util.*;

public class Bishops {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      int n = in.nextInt();
      if (n == 1) {
        System.out.println(1);
      } else {
        System.out.println((2*n-2));
      }
    }
  }
}