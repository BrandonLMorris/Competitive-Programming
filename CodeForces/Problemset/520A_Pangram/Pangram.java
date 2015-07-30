import java.util.*;

public class Pangram {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numChars = Integer.parseInt(input.nextLine());
    int[] alphabet = new int[26];
    char[] line = input.nextLine().toUpperCase().toCharArray();
    for (char c : line) {
      alphabet[c-'A']++;
    }
    for (int i : alphabet) {
      if (i < 1) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
