import java.util.*;

public class Bear {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int numDays = input.nextInt();
    int thanks = input.nextInt();

    int[] days = new int[numDays];
    for (int i = 0; i < numDays; i++) {
      days[i] = input.nextInt();
    }

    int maxDiff = 0;
    for (int i = 0; i < numDays-1; i++) {
      maxDiff = Math.max(maxDiff, days[i] - days[i+1]);
    }

    int profit = maxDiff - thanks;

    System.out.println(Math.max(0, profit));
  }
}
