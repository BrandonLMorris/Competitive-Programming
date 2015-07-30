import java.util.*;

public class Contest {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    int[] students = new int[n];

    for (int i = 0; i < n; i++) {
      students[i] = input.nextInt();
    }

    int[] places = new int[n];

    for (int i = 0; i < n; i++) {
      int numBetter = 0;
      for (int j = 0; j < n; j++) {
        if (j == i) continue;
        if (students[i] < students[j]) numBetter++;
      }
      places[i] = numBetter + 1;
    }

    for (int i = 0; i < n; i++) {
      if (i == n-1)
        System.out.println(places[i]);
      else
        System.out.print(places[i] + " ");
    }
  }
}
