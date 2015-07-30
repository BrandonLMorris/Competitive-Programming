import java.util.*;

public class Sticks {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] sticks = new int[10];
    for (int i = 0; i < 6; i++) {
      sticks[input.nextInt()]++;
    }
    boolean isAlien = true;
    for (int i : sticks) {
      if (i >= 4)
        isAlien = false;
    }
    if (isAlien) {
      System.out.println("Alien");
    } else {
      boolean isElephant = false;
      for (int i : sticks) {
        if (i == 2 || i == 6) {
          isElephant = true;
        }
      }
      if (isElephant) {
        System.out.println("Elephant");
      } else {
        System.out.println("Bear");
      }
    }
  }
}
