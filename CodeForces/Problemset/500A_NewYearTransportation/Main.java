import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt() - 1;
    int t = input.nextInt();
    int[] transit = new int[n+1];
    for (int i = 1; i <= n; i++) {
      transit[i] = input.nextInt();
    }
    int i = 1;
    while (i <= n) {
      if (i == t) {
        System.out.println("YES");
        return;
      }
      i += transit[i];
    }
    if (i == t) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
