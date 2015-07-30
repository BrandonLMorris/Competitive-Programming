import java.util.*;

public class Diploma {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int min1 = in.nextInt();
    int max1 = in.nextInt();
    int min2 = in.nextInt();
    int max2 = in.nextInt();
    int min3 = in.nextInt();
    int max3 = in.nextInt();

    int count1 = min1;
    int count2 = min2;
    int count3 = min3;

    n -= (min1 + min2 + min3);

    if (n > 0) {
      count1 += (max1 - min1);
      n -= (max1 - min1);

      if (n < 0) {
        count1 += n;
      }
    }

    if (n > 0) {
      count2 += (max2 - min2);
      n -= (max2 - min2);

      if (n < 0) {
        count2 += n;
      }
    }

    if (n > 0) {
      count3 += (max3 - min3);
      n -= (max3 - min3);

      if (n < 0) {
        count3 += n;
      }
    }

    System.out.println(count1 + " " + count2 + " " + count3);

  }
}
