import java.util.*;

public class Books {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();

    long counter = 0;

    if (n > 0) {
      counter += n;
    }

    if (n > 9) {
      counter += n - 9;
    }

    if (n > 99) {
      counter += n - 99;
    }

    if (n > 999) {
      counter += n - 999;
    }

    if (n > 9999) {
      counter += n - 9999;
    }

    if (n > 99999) {
      counter += n - 99999;
    }

    if (n > 999999) {
      counter += n - 999999;
    }

    if (n > 9999999) {
      counter += n - 9999999;
    }

    if (n > 99999999) {
      counter += n - 99999999;
    }

    if (n > 999999999) {
      counter += n - 999999999;
    }

    System.out.println(counter);

  }
}
