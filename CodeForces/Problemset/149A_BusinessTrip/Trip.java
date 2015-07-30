import java.util.*;

public class Trip {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int k = input.nextInt();
    int[] months = new int[12];
    for (int i = 0; i < 12; i++) {
      months[i] = input.nextInt();
    }
    Arrays.sort(months);
    int i = 11;
    int counter = 0;
    int monthsNum = 0;
    while (i >= 0 && counter < k) {
      counter += months[i];
      monthsNum++;
      i--;
    }
    System.out.println(counter < k ? "-1" : monthsNum);
  }
}
