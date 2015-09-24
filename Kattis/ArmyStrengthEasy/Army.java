import java.util.*;

public class Army {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numTests = Integer.parseInt(in.nextLine());

    for (int t = 0; t < numTests; t++) {
      in.nextLine();
      int gArmySize = in.nextInt();
      int mgArmySize = in.nextInt();

      int[] gArmy = new int[gArmySize];
      for (int i = 0; i < gArmySize; i++) {
        gArmy[i] = in.nextInt();
      }
      Arrays.sort(gArmy);

      int[] mgArmy = new int[mgArmySize];
      for (int i = 0; i < mgArmySize; i++) {
        mgArmy[i] = in.nextInt();
      }
      Arrays.sort(mgArmy);

      int gpos = 0, mpos = 0;
      while (gpos < gArmySize && mpos < mgArmySize) {
        if (gArmy[gpos] < mgArmy[mpos]) {
          gpos++;
        } else {
          mpos++;
        }
      }

      System.out.println(gpos < gArmySize ? "Godzilla" : "MechaGodzilla");

      in.nextLine();
    }
  }
}