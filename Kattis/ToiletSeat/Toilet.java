import java.util.*;

public class Toilet {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] input = in.nextLine().toCharArray();

    int alwaysUpCounter = 0;
    int alwaysDownCounter = 0;
    int preferenceCounter = 0;

    if (input[0] == 'D') {
      alwaysUpCounter++;
      if (input[1] == 'U') alwaysDownCounter += 2;
    } else if(input[0] == 'U') {
      alwaysDownCounter++;
      if (input[1] == 'D') alwaysUpCounter += 2;
    }

    // Count for always up
    for (int i = 2; i < input.length; i++) {
      if (input[i] == 'D') alwaysUpCounter += 2;
    }

    // Count for always down
    for (int i = 2; i < input.length; i++) {
      if (input[i] == 'U') alwaysDownCounter += 2;
    }

    // Count for leave it like you want it
    for (int i = 1; i < input.length; i++) {
      if (input[i] != input[i-1]) preferenceCounter++;
    }

    System.out.println(alwaysUpCounter);
    System.out.println(alwaysDownCounter);
    System.out.println(preferenceCounter);
  }
}

/*
 *       Always up | Always down
 * D D      +1       +0
 * D U      +1       +2
 * U U      +0       +1
 * U D      +2       +1
 */
