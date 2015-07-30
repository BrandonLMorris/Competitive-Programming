import java.util.*;

public class Love {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numComps = input.nextInt();
    int maxScore = input.nextInt();
    int minScore = maxScore;
    int amazingCounter = 0;

    for (int i = 0; i < numComps-1; i++) {
      int comp = input.nextInt();
      if (comp < minScore) {
        minScore = comp;
        amazingCounter++;
      }
      if (comp > maxScore) {
        maxScore = comp;
        amazingCounter++;
      }
    }

    System.out.println(amazingCounter);
  }
}
