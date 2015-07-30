import java.util.*;

public class Candy {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int squared = (int) Math.pow(n, 2);
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < n/2; j++) {
        System.out.print((i+(j*n) + " " + (squared-i+1-(j*n))));
        if (j != n/2 - 1) System.out.print(" ");
      }
      System.out.println();
    }
  }
}
