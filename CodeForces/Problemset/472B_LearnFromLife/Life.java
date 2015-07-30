import java.util.*;

public class Life {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    int[] floors = new int[n];
    for (int i = 0; i < n; i++) {
      floors[i] = input.nextInt() - 1;
    }

    Arrays.sort(floors);

    int counter = 0;
    int i = n-1;
    while (i >= 0) {
      counter += 2 * (floors[i]);
      i -= k;
    }

    System.out.println(counter);
  }
}
