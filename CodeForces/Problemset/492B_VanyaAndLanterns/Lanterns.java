import java.util.*;

public class Lanterns {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numLanterns = input.nextInt();
    int streetLength = input.nextInt();

    int[] lamps = new int[numLanterns];

    for (int i = 0; i < numLanterns; i++) {
      lamps[i] = input.nextInt();
    }

    Arrays.sort(lamps);

    int endDist = lamps[0];
    int maxDist = 0;

    for (int i = 0; i < numLanterns - 1; i++) {
      maxDist = Math.max(maxDist, lamps[i+1] - lamps[i]);
    }

    endDist = Math.max(endDist, streetLength - lamps[numLanterns - 1]);
    double minRadius = Math.max(maxDist / 2.0, (double)endDist);

    System.out.printf("%.10f\n", minRadius);

  }
}
