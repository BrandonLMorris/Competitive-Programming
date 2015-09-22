import java.util.*;

public class Paradox {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int numTests = in.nextInt();

    for (int t = 0; t < numTests; t++) {
      int numCS = in.nextInt();
      int numEco = in.nextInt();

      int[] cs = new int[numCS];
      // int[] eco = new int[numEco];
      long csTotal = 0;
      long ecoTotal = 0;


      for (int i = 0; i < numCS; i++) {
        cs[i] = in.nextInt();
        csTotal += cs[i];
      }
      for (int i = 0; i < numEco; i++) {
        // eco[i] = in.nextInt();
        ecoTotal += in.nextInt();
      }

      double csAvg = csTotal / (double)numCS;
      double ecoAvg = ecoTotal / (double)numEco;

      // System.out.println("CS Average: " + csAvg);
      // System.out.println("EC Average: " + ecoAvg);

      int counter = 0;
      for (int i : cs) {
        double newCSAvg = (csTotal - i) / (double)(numCS-1);
        double newEcoAvg = (ecoTotal + i) / (double)(numEco+1);

        // System.out.println("New CS Average: " + newCSAvg);
        // System.out.println("New EC Average: " + newEcoAvg);

        if (newCSAvg > csAvg && newEcoAvg > ecoAvg) counter++;
      }

      System.out.println(counter);
    }

  }
}
