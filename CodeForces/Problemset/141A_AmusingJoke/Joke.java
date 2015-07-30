import java.util.*;

public class Joke {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] letters = new int[256];
    int[] names = new int[256];

    char[] line1 = input.nextLine().toCharArray();
    char[] line2 = input.nextLine().toCharArray();
    char[] line3 = input.nextLine().toCharArray();

    for (char c : line1) {
      names[c - 'A']++;
    }

    for (char c : line2) {
      names[c - 'A']++;
    }

    for (char c : line3) {
      letters[c - 'A']++;
    }

    for (int i = 0; i < 256; i++) {
      if (letters[i] != names[i]) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
