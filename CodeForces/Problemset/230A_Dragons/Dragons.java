import java.util.*;

public class Dragons {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    long strength = input.nextLong();
    int numDragons = input.nextInt();

    Dragon[] dragons = new Dragon[numDragons];
    for (int i = 0; i < numDragons; i++) {
      dragons[i] = new Dragon(input.nextInt(), input.nextInt());
    }

    Arrays.sort(dragons);

    for (Dragon d : dragons) {
      if (strength <= d.strength) {
        System.out.println("NO");
        return;
      } else {
        strength += d.powerBonus;
      }
    }

    System.out.println("YES");

  }
}

class Dragon implements Comparable<Dragon>{
  int strength;
  int powerBonus;
  public Dragon(int strArg, int powArg) {
    this.strength = strArg;
    this.powerBonus = powArg;
  }

  public int compareTo(Dragon d) {
    if (this.strength > d.strength) {
      return 1;
    } else if (this.strength < d.strength) {
      return -1;
    } else {
      return ((Integer) this.powerBonus).compareTo(d.powerBonus);
    }
  }
}
