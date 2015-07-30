import java.util.*;

public class Even {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long n = input.nextLong();
    long k = input.nextLong();
    long nOver2 = (long) Math.ceil(n/2.0);
    if (nOver2 >= k) {
      System.out.println((2*k-1));
    } else {
      System.out.println(2*(k-nOver2));
    }
  }
}
