import java.util.*;

public class Movie {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int skip = in.nextInt();

    int pos = 1;
    int counter = 0;

    for (int i = 0; i < n; i++) {
      int start = in.nextInt();
      int end = in.nextInt();

      counter += (start - pos) % skip;
      counter += end - start + 1;
      pos = end + 1;

    }

    System.out.println(counter);

  }
}
