import java.util.*;

public class Flip {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int maxEndingHere = 0;
    int maxSoFar = 0;
    int[] lights = new int[n];
    int[] lights2 = new int[n];
    for (int i = 0; i < n; i++) {
      lights[i] = input.nextInt();
      lights2[i] = lights[i] == 1 ? -1 : 1;
    }
    
    // If no value is zero, answer will be number of ones - 1
    boolean hasZero = false;
    int startOnes = 0;
    for (int i : lights) {
      if (i == 1) startOnes++;
      if (i == 0) hasZero = true;
    }
    if (!hasZero) {
      System.out.println(startOnes - 1);
      return;
    }

    int flippedOnesEndingHere = 0;
    int flippedOnesSoFar = 0;
    for (int i = 0; i < n; i++) {
      int j = lights2[i];
      if (maxEndingHere+j > 0) {
        maxEndingHere = maxEndingHere + j;
        if (j == -1) {
          flippedOnesEndingHere++;
        }
      } else {
        maxEndingHere = 0;
        flippedOnesEndingHere = 0;
      }
      if (maxEndingHere > maxSoFar) {
        maxSoFar = maxEndingHere;
        flippedOnesSoFar = flippedOnesEndingHere;
      }
    }
    System.out.println("startOnes " + startOnes + " flippedOnesSoFar " + flippedOnesSoFar);
    System.out.println(startOnes - flippedOnesSoFar + maxSoFar);
  }
}
