import java.util.*;

public class Taxi {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numGroups = input.nextInt();
    int[] sizes = new int[5];
    for (int i = 0; i < numGroups; i++) {
      sizes[input.nextInt()]++;
    }
    
    // Every group of four needs its own taxi
    int taxiCounter = sizes[4];

    // Groups of three can ride with groups of 1
    taxiCounter += sizes[3];
    sizes[1] = Math.max(sizes[1]-sizes[3], 0);

    // Groups of two can ride w/ groups of two, integer division
    taxiCounter += sizes[2]/2;
    if (sizes[2] % 2 != 0) {
      taxiCounter++;
      if (sizes[1] >= 2) {
        sizes[1] -= 2;
      } else if (sizes[1] == 1) {
        sizes[1] = 0;
      }
    }

    if (sizes[1] >= 4) {
      taxiCounter += sizes[1] / 4;
      sizes[1] = sizes[1] % 4;
    }

    if (sizes[1] != 0) {
      taxiCounter++;
    }

    System.out.println(taxiCounter);
  }
}
