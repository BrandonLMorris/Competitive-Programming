import java.util.*;

public class Pylon {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int height = 0;
    int counter = 0;
    for (int i = 0; i < n; i++) {
      int j = input.nextInt();
      if (j > height) {
        counter += j - height;
        height = j;
      }
    }
    System.out.println(counter);
  }
}
