import java.util.*;

public class Ribbon {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int ribbon = input.nextInt();
    int l1 = input.nextInt();
    int l2 = input.nextInt();
    int l3 = input.nextInt();

    int maxCount = 0;
    for (int i = 0; i < (ribbon/l1)+2; i++) {
      for (int j = 0; j < (ribbon/l2)+2; j++) {
        if ((ribbon - (i*l1 + j*l2)) % l3 == 0 ) {
          int z = (ribbon - (i*l1 + j*l2)) / l3;
          if (z >= 0 && (i*l1 + j*l2 + z*l3) == ribbon) {
            maxCount = Math.max(maxCount, i + j + ((ribbon-(i*l1+j*l2))/l3));
            // System.out.println("Adding to max count: " + maxCount);
            // System.out.println("a: " + i);
            // System.out.println("b: " + j);
            // System.out.println("c: " + ((ribbon-(i*l1+j*l2))/l3));
          }
        }
      }
    }

    System.out.println(maxCount);
  }
}
