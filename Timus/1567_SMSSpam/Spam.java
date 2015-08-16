import java.util.*;

/*
 * Given a string phrase, determine how many presses on a phone it will
 * take to write out that phrase
 */

public class Spam {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input as a character array
    char[] line = in.nextLine().toCharArray();

    // Initialize the counter
    int counter = 0;

    // Iterate over each character in the string
    for (char c : line) {
      switch (c) {
        // The 1 key
        case 'a': counter += 1; break;
        case 'b': counter += 2; break;
        case 'c': counter += 3; break;

        // The 2 key
        case 'd': counter += 1; break;
        case 'e': counter += 2; break;
        case 'f': counter += 3; break;

        // The 3 key
        case 'g': counter += 1; break;
        case 'h': counter += 2; break;
        case 'i': counter += 3; break;

        // The 4 key
        case 'j': counter += 1; break;
        case 'k': counter += 2; break;
        case 'l': counter += 3; break;

        // The 5 key
        case 'm': counter += 1; break;
        case 'n': counter += 2; break;
        case 'o': counter += 3; break;

        // The 6 key
        case 'p': counter += 1; break;
        case 'q': counter += 2; break;
        case 'r': counter += 3; break;

        // The 7 key
        case 's': counter += 1; break;
        case 't': counter += 2; break;
        case 'u': counter += 3; break;

        // The 8 key
        case 'v': counter += 1; break;
        case 'w': counter += 2; break;
        case 'x': counter += 3; break;

        // The 9 key
        case 'y': counter += 1; break;
        case 'z': counter += 2; break;

        // The 0 key
        case '.': counter += 1; break;
        case ',': counter += 2; break;
        case '!': counter += 3; break;

        // The pound key
        case ' ': counter += 1; break;
      }
    }

    // Output the result
    System.out.println(counter);
  }
}
