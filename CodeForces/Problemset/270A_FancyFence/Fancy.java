import java.util.*;

public class Fancy {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = input.nextInt();
    for (int t = 0; t < numTests; t++) {
      int angle = input.nextInt();
      boolean isYes = false;
      for (int i = 3; i <= 360; i++) {
        if (angle == (i-2)*(180.0/i)) {
          System.out.println("YES");
          isYes = true;
          break;
        }
      }
      if (!isYes) System.out.println("NO");
    }
  }
}
