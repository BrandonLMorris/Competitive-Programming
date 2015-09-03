import java.util.*;

public class Taxi {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();


    int i = 0;
    int j = 0;
    while (a + (b*i) < c - (d*j)) {
      i++;
      if (a + (b*i) > c - (d*j)) {
        System.out.println((c-(d*j)));
        return;
      } else {
        j++;
      }
    }

    if (a + (b*i) > c - (d*i)) {
      System.out.println((a+(b*i)));
    } else {
      System.out.println((c-(d*i)));
    }
  }
}
