import java.util.*;

public class Flowers {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numFlowers = input.nextInt();
    int[] flowers = new int[numFlowers];
    int max = 0;
    for (int i = 0; i < numFlowers; i++) {
      flowers[i] = input.nextInt();
    }

    Arrays.sort(flowers);

    boolean allEqual = false;

    int maxDiff = flowers[flowers.length-1] - flowers[0];
    int lowestOccurance = 0;
    int i = 0;
    while (i < flowers.length && flowers[i] == flowers[0]) {
      lowestOccurance++;
      i++;
    }
    if (i == flowers.length) allEqual = true;
    int maxOccurance = 0;
    i = flowers.length-1;
    while (i >= 0 && flowers[i] == flowers[flowers.length-1]) {
      maxOccurance++;
      i--;
    }

    long possible = 0;
    if (!allEqual) {
      possible = (long)lowestOccurance * maxOccurance;
    } else {
      possible = (long)((long)numFlowers * (numFlowers-1)/2.0);
    }

    System.out.println(maxDiff + " " + possible);
  }
}
