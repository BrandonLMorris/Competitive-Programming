import java.util.*;

public class Paper {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long a = input.nextLong();
    long b = input.nextLong();

    long counter = 0;
    while (a > 0 && b > 0) {
      if (a > b) {
        counter += a / b;
        a = a % b;
      } else {
        counter += b / a;
        b = b % a;
      }
    }
    System.out.println(counter);
  }
}
