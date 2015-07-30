import java.util.*;

public class Theatre {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long n = input.nextInt();
    long m = input.nextInt();
    long a = input.nextInt();

    long width = (long) Math.ceil((double)n / a);
    long height = (long) Math.ceil((double)m / a);

    System.out.println(width * height);
  }
}
