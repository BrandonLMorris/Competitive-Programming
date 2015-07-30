import java.util.*;

public class Badge {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] badges = new int[n*2+1];
    int counter = 0;
    for (int i = 0; i < n; i++) {
      badges[input.nextInt()]++;
    }
    for (int i = 0; i < badges.length; i++) {
      while (badges[i] > 1) {
        badges[i]--;
        badges[i+1]++;
        counter++;
      }
    }
    System.out.println(counter);
  }
}
