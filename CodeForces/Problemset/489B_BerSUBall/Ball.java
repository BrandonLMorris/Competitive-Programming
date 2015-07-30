import java.util.*;

public class Ball {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int numBoys = input.nextInt();
    int[] boys = new int[numBoys];
    for (int i = 0; i < numBoys; i++) {
      boys[i] = input.nextInt();
    }

    int numGirls = input.nextInt();
    int[] girls = new int[numGirls];
    for (int i = 0; i < numGirls; i++) {
      girls[i] = input.nextInt();
    }

    Arrays.sort(boys);
    Arrays.sort(girls);

    int counter = 0;
    for (int i = 0; i < numBoys; i++) {
      for (int j = 0; j < numGirls; j++) {
        if (Math.abs(boys[i] - girls[j]) <= 1) {
          counter++;
          girls[j] = 1000;
          break;
        }
      }
    }

    System.out.println(counter);

  }
}
