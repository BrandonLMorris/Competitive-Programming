import java.util.*;

public class Easy {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    for (;;) {
      int n = in.nextInt();
      if (n == 0) break;

      int sum = sumDigits(n);
      int i = 11;
      while (sumDigits(i * n) != sum) i++;
      System.out.println(i);
    }
  }

  private static int sumDigits(int n) {
    int count = 0;
    for (char c : Integer.toString(n).toCharArray()) {
      count += c - '0';
    }
    return count;
  }
}
