import java.util.*;

public class Garden {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x1 = input.nextInt();
    int y1 = input.nextInt();
    int x2 = input.nextInt();
    int y2 = input.nextInt();

    if (x1-x2 == 0) {
      int length = Math.abs(y1-y2);
      System.out.println((x1+length) + " " + y1 + " " + 
          (x2+length) + " " + y2);
    } else if (y1-y2 == 0) {
      int length = Math.abs(x1-x2);
      System.out.println(x1 + " " + (y1+length) + " " + 
          x2 + " " + (y2+length));
    } else if (Math.abs(x1-x2) == Math.abs(y1-y2)) {
      System.out.println(x2 + " " + y1 + " " + x1 + " " +
          y2);
    } else {
      System.out.println(-1);
    }
  }
}
