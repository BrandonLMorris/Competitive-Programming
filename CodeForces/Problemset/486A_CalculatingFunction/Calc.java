import java.util.*;

public class Calc {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long num = input.nextLong();
    if (num % 2 == 0) {
      System.out.println(num / 2);
    } else {
      System.out.println((num / -2 - 1));
    }
 }
}
