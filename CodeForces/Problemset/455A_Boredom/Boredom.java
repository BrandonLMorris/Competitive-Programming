import java.util.*;

public class Boredom {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] cnt = new int[100002];
    for (int i = 0; i < n; i++) {
      cnt[input.nextInt()]++;
    }
    long[] a = new long[100002];
    a[0] = 0;
    a[1] = cnt[1];
    for (int i = 2; i <= 100001; i++) {
      a[i] = Math.max(a[i-1], a[i-2] + cnt[i]*(long)i);
    }
    //for (int i = 0; i <= n; i++) {
    //  System.out.print(a[i] + " ");
    //}
    //System.out.println();
    System.out.println(a[100001]);
  }
}
