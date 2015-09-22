import java.util.*;

public class Friday {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int[] rolls = new int[n];
    int[] counts = new int[6];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      rolls[i] = x;
      counts[x - 1]++;
    }

    int highest = -1;
    for (int i = 5; i >= 0; i--) {
      if (counts[i] == 1) {
        highest = i+1;
        break;
      }
    }

    if (highest == -1) {
      System.out.println("none");
      return;
    }

    for (int i = 0; i < n; i++) {
      if (rolls[i] == highest) {
        System.out.println(i+1);
      }
    }


  }
}
