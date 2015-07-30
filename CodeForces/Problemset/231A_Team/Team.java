import java.util.*;

public class Team {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = input.nextInt();
    int counter = 0;
    for (int t = 0; t < numTests; t++) {
      int one = input.nextInt();
      int two = input.nextInt();
      int three = input.nextInt();

      if (one + two + three > 1) {
        counter++;
      }
    }

    System.out.println(counter);
  }
}
