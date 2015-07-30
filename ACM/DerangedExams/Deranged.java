import java.util.*;

public class Deranged {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = input.nextInt();
    for (int i = 1; i <= numTests; i++) {
      int j = input.nextInt();
      int n = input.nextInt();
      int k = input.nextInt();
      System.out.println(j + " " + S(n,k));
    }
  }

  private static long S(long n, long k) {
    if (k == 0) return factorial(n);
    return S(n,k-1)-S(n-1,k-1);
  }

  private static long factorial(long n) {
    long counter = 1;
    for (long i = n; i > 0; i--) {
      counter *= i;
    }
    return counter;
  }
}
