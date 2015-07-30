import java.util.*;

public class Magnets {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numMags = input.nextInt();
    int numGroups = 1;
    int current = -1;
    for (int i = 0; i < numMags; i++) {
      if (i == 0) {
        current = input.nextInt();
      } else {
        int next = input.nextInt();
        if (next != current)
          numGroups++;
        current = next;
      }
    }
    System.out.println(numGroups);
  }
}
