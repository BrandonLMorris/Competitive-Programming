import java.util.*;

public class Towers {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numBars = input.nextInt();
    int[] bars = new int[1001];
    for (int i = 0; i < numBars; i++) {
      bars[input.nextInt()]++;
    }
    int towerCounter = 0;
    int maxTower = 0;
    for (int i : bars) {
      if (i != 0) towerCounter++;
      if (i > maxTower) maxTower = i;
    }

    System.out.println(maxTower + " " + towerCounter);
  }
}
