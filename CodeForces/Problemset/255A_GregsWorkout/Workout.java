import java.util.*;

public class Workout {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int chestCtr = 0;
    int bicepsCtr = 0;
    int backCtr = 0;
    for (int i = 0; i < n; i++) {
      if (i % 3 == 0) {
        chestCtr += input.nextInt();
      } else if (i % 3 == 1) {
        bicepsCtr += input.nextInt();
      } else {
        backCtr += input.nextInt();
      }
    }
    int max = Math.max(chestCtr, Math.max(bicepsCtr, backCtr));
    if (chestCtr == max)
      System.out.println("chest");
    else if (bicepsCtr == max)
      System.out.println("biceps");
    else
      System.out.println("back");
  }
}
