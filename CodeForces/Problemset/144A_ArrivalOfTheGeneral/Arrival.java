import java.util.*;

public class Arrival {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numSoldiers = input.nextInt();
    int[] soldiers = new int[numSoldiers];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int maxIndex = -1;
    int minIndex = -1;
    for (int i = 0; i < numSoldiers; i++) {
      soldiers[i] = input.nextInt();
      if (soldiers[i] <= min) {
        min = soldiers[i];
        minIndex = i;
      }
      if (soldiers[i] > max) {
        max = soldiers[i];
        maxIndex = i;
      }
    }


    int time = maxIndex + (numSoldiers - minIndex - 1);
    if (minIndex < maxIndex) time--;
    System.out.println(time);
  }
}
