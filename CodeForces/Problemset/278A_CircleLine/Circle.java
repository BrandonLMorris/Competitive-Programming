import java.util.*;

public class Circle {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] line = new int[n];
    for (int i = 0; i < n; i++) {
      line[i] = input.nextInt();
    }
    int s = input.nextInt()-1;
    int t = input.nextInt()-1;

    int rightCounter = 0;
    int leftCounter = 0;

    // To the right
    int i = s;
    while (i != t) {
      rightCounter += line[i];
      i = (i + 1) % n;
    }

    // To the left (simulated by going from t to s to the right)
    while (i != s) {
      leftCounter += line[i];
      i = (i+1) % n;
    }

    System.out.println(Math.min(leftCounter, rightCounter));
  }
}
