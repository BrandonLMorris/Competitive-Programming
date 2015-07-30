import java.util.*;

public class Pisano {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = input.nextInt();
    for (int t = 1; t <= numTests; t++) {
      input.nextInt();
      int m = input.nextInt();
      long period = 2;
      long current = 1;
      long prev = 1;
      long modCurrent = 1;
      long modPrev = 1;
      for (;;) {
        long total = current + prev;
        prev = current;

        if (total >= m) {
          current = total % m;
        } else {
          current = total;
        }

        if (current == 1 && prev  == 0) break;
        period++;
      }
      System.out.println(t + " " + period);
      

    }
  }
}
