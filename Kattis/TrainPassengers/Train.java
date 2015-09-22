import java.util.*;

public class Train {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    long capacity = in.nextLong();
    long numStops = in.nextLong();
    long current = 0;
    long numWait = 0;

    for (int i = 0; i < numStops; i++) {
      boolean possible = true;

      current -= in.nextLong();
      if (current < 0) possible = false;

      current += in.nextLong();
      if (current > capacity) possible = false;

      numWait = in.nextLong();
      if (current < capacity && numWait != 0) possible = false;

      if (!possible) {
        System.out.println("impossible");
        return;
      }

    }

    if (current != 0 || numWait != 0) {
      System.out.println("impossible");
    } else {
      System.out.println("possible");
    }

  }
}
