import java.util.*;

public class Queue {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    int[] groups = new int[n];
    for (int i = 0; i < n; i++) {
      groups[i] = input.nextInt();
    }
    int counter = 0;
    int index = 0;
    while (index < n) {
      int currentBus = 0;
      while (index < n && currentBus + groups[index] <= m) {
        currentBus += groups[index];
        index++;
      }
      counter++;
    }
    System.out.println(counter);
  }
}
