import java.util.*;

public class Rock {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] track = new int[n];
    for (int i = 0; i < n; i++) {
      track[i] = input.nextInt();
    }

    int minDifficulty = Integer.MAX_VALUE;
    for (int i = 1; i < n-1; i++) {
      int difficulty = 0;
      for (int j = 0; j < n-1; j++) {
        if (i == j+1) 
          difficulty = Math.max(difficulty, track[j+2] - track[j]);
        else
          difficulty = Math.max(difficulty, track[j+1] - track[j]);
      }
      minDifficulty = Math.min(minDifficulty, difficulty);
    }

    System.out.println(minDifficulty);
  }
}
