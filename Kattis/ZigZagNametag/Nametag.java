import java.util.*;

public class Nametag {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String stem = "a";
    int current = 'a';
    while (true) {
      break;
    }

  }

  public static int encode(String str) {
    int counter = 0;
    for (int i = 0; i < str.length() - 1; i++) {
      counter += Math.abs(str.charAt(i) - str.charAt(i));
    }
    return counter;
  }
}
