import java.util.*;

public class Next {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numContestants = input.nextInt();
    int k = input.nextInt();
    int counter = k;
    int[] scores = new int[numContestants];
    for (int i = 0; i < numContestants; i++) {
      scores[i] = input.nextInt();
    }
    int kthScore = scores[k-1];
    if (kthScore <= 0) {
      int posCounter = 0;
      for (int i = 0; i < k; i++) {
        if (scores[i] > 0) posCounter++;
      }
      System.out.println(posCounter);
      return;
    }
    int i = k;
    while (i < numContestants && scores[i] == kthScore) {
      i++;
      counter++;
    }
    System.out.println(counter);
  }
}
