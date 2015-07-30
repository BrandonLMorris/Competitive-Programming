import java.util.*;

public class Contest {
  public static void main(String[] Args) {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();
    int d = input.nextInt();

    int misha = points(a, c);
    int vasya = points(b, d);

    if (misha > vasya) {
      System.out.println("Misha");
    } else if (misha < vasya) {
      System.out.println("Vasya");
    } else {
      System.out.println("Tie");
    }

  }

  private static int points(int p, int t) {
    return Math.max((3*p)/10, p - (p/250) * t);
  }
}
