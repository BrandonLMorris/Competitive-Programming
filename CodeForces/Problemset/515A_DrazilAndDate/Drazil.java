import java.util.*;

public class Drazil {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long a = input.nextInt();
    long b = input.nextInt();
    long s = input.nextInt();
    long absSum = Math.abs(a) + Math.abs(b);

    if (absSum % 2 == 0 && s % 2 != 0) {
      System.out.println("No");
      return;
    } else if (absSum % 2 != 0 && s % 2 == 0) {
      System.out.println("No");
      return;
    } else if (s < absSum) {
      System.out.println("No");
      return;
    }
    System.out.println("Yes");
  }
}
