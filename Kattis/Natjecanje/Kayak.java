import java.util.*;

public class Kayak {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int numTeams = in.nextInt();
    int numBroken = in.nextInt();
    int numExtra = in.nextInt();

    boolean[] needKayak = new boolean[numTeams];
    boolean[] hasExtra = new boolean[numTeams];

    for (int i = 0; i < numBroken; i++) {
      needKayak[in.nextInt()-1] = true;
    }
    for (int i = 0; i < numExtra; i++) {
      hasExtra[in.nextInt()-1] = true;
    }

    int minCantStart = minCantStart(0, numBroken, needKayak, hasExtra);

    System.out.println(minCantStart);

  }

  private static int minCantStart(int pos, int currentMin, boolean[] needKayak, boolean[] hasExtra) {
    if (pos == needKayak.length) return currentMin;

    // Move forward if the current doesn't need a kayak
    if (!needKayak[pos]) return minCantStart(pos+1, currentMin, needKayak, hasExtra);

    // If a team needs a kayak and has an extra, it will use it
    if (needKayak[pos] && hasExtra[pos]) return minCantStart(pos+1, currentMin-1, needKayak, hasExtra);

    // Skip forward if cannot take kayak from left or right
    boolean canTakeLeft = pos > 0 && hasExtra[pos-1] && !needKayak[pos-1];
    boolean canTakeRight = pos < needKayak.length-1 && hasExtra[pos+1] && !needKayak[pos+1];
    if (!canTakeLeft && !canTakeRight) return minCantStart(pos+1, currentMin, needKayak, hasExtra);

    // Flags for taking from the left and the right
    int fromLeft = Integer.MAX_VALUE;
    int fromRight = Integer.MAX_VALUE;

    // If it can, find the min taking a canoe from the left
    if (pos > 0 && hasExtra[pos-1] && !needKayak[pos-1]) {
      hasExtra[pos-1] = false;
      needKayak[pos] = false;

      // Recurse with taking a kayak from the left
      fromLeft = minCantStart(pos+1, currentMin-1, needKayak, hasExtra);

      // Reset my changes
      needKayak[pos] = true;
      hasExtra[pos-1] = true;

    } else if (pos < needKayak.length-1 && hasExtra[pos+1] && !needKayak[pos+1]) {
      // If can, find the min taking a canoe from the right
      hasExtra[pos+1] = false;
      needKayak[pos] = false;

      // Recurse with taking a kayak from the right
      fromRight = minCantStart(pos+1, currentMin-1, needKayak, hasExtra);

      // Reset  my changes
      needKayak[pos] = true;
      hasExtra[pos+1] = true;
    }

    // Set currentMin the the best so far and return it
    currentMin = Math.min(currentMin, Math.min(fromLeft, fromRight));
    return currentMin < 0 ? 0 : currentMin;
  }
}
