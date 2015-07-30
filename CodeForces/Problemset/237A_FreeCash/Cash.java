import java.util.*;

public class Cash {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numCustomers = input.nextInt();
    int counter = 1;

    int[][] times = new int[24][60];

    for (int i = 0; i < numCustomers; i++) {
      times[input.nextInt()][input.nextInt()]++;
    }

    for (int i = 0; i < 24; i++) {
      for (int j = 0; j < 60; j++) {
        if (times[i][j] > 1 && times[i][j] > counter) {
          counter = times[i][j];
        }
      }
    }
    System.out.println(counter);
  }
}
