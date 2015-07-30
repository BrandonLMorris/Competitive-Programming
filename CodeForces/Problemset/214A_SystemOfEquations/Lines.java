import java.util.*;

public class Lines {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    int counter = 0;
    for (int a = 0; a <= 100; a++) {
      for (int b = 0; b <= 100; b++) {
        if (Math.pow(a,2) + b == n &&
            Math.pow(b,2) + a == m)
          counter++;
      }
    }
    System.out.println(counter);
  }
}
