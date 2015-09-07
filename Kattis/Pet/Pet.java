import java.util.*;

public class Pet {
  public static void main(String[] args) {
    int[] scores = new int[5];
    Scanner in = new Scanner(System.in);

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 4; j++) {
        scores[i] += in.nextInt();
      }
    }

    int max = 0;
    for (int i = 0; i < 5; i++) {
      if (scores[i] > scores[max])
        max = i;
    }

    System.out.println((max+1) + " " + scores[max]);


  }
}
