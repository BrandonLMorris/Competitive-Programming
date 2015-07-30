import java.util.*;

public class Crash {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      int numGos = input.nextInt();
      if (numGos == 0) break;

      // Gorealians land one at a time.
      // Once each on lands, see if it can merge with any others
      // Keep merging until not possible

      ArrayList<Gorelian> gos = new ArrayList<Gorelian>();

      for (int i = 0; i < numGos; i++) {
        Gorelian go = new Gorelian(input.nextInt(), input.nextInt(), input.nextInt());
        while (merge(go, gos)) {
          go = gos.remove(gos.size()-1);
        }
      }

      System.out.println(gos.size());

    }
  }

  private static boolean merge(Gorelian g, ArrayList<Gorelian> gorelians) {
    ArrayList<Gorelian> toMerge = new ArrayList<Gorelian>();
    for (Gorelian gorelian : gorelians) {
      if (Math.hypot(g.x-gorelian.x, g.y-gorelian.y) <= g.signalStrength ||
          Math.hypot(g.x-gorelian.x, g.y-gorelian.y) <= gorelian.signalStrength) {
            Gorelian go = gorelian;
            toMerge.add(go);
          }
    }

    if (toMerge.isEmpty()) {
      gorelians.add(g);
      return false;
    }

    double newX = g.x;
    double newY = g.y;
    double newSignalStrength = Math.pow(g.signalStrength, 2);
    for (Gorelian go : toMerge) {
      gorelians.remove(go);
      newX += go.x;
      newY += go.y;
      newSignalStrength += go.signalStrength * go.signalStrength;
    }

    newX /= (double)(toMerge.size() + 1);
    newY /= (double)(toMerge.size() + 1);
    newSignalStrength = Math.sqrt(newSignalStrength);

    gorelians.add(new Gorelian(newX, newY, newSignalStrength));

    return true;
  }


  private static class Gorelian {
    double x;
    double y;
    double signalStrength;

    public Gorelian(double xArg, double yArg, double signalStrengthArg) {
      this.x = xArg;
      this.y = yArg;
      this.signalStrength = signalStrengthArg;
    }
  }
}
