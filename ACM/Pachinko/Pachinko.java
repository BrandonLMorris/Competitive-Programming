import java.util.*;

public class Pachinko {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      char[] line = input.nextLine().toCharArray();
      if (line[0] == '#') break;
      int[] probs = new int[line.length];
      for (int i = 0; i < line.length; i++) {
        if (line[i] == '.') {
          probs[i] = 100;
        }
        if (line[i] == '_') {
          probs[i] = 0;
        }
        if (line[i] == '\\') {
          if (rollRight(i, line))
            probs[i] = 100;
          else probs[i] = 0;
        }
        if (line[i] == '/') {
          if (rollLeft(i, line))
            probs[i] = 100;
          else probs[i] = 0;
        }
        if (line[i] == '|') {
          if (rollLeft(i, line))
            probs[i] += 50;
          if (rollRight(i, line))
            probs[i] += 50;
        }
      }

      int counter = 0;
      for (int i : probs) {
        counter += i;
      }
      double probability = counter / (10.0 * probs.length);
      System.out.println((int)(probability * 10));
    }

  }

  static boolean rollRight(int i, char[] line) {
    for (int j = i+1; j < line.length; j++) {
      if (line[j] == '.') return true;
      if (line[j] == '|' || line[j] == '/') return false;
    }
    return true;
  }

  static boolean rollLeft(int i, char[] line) {
    for (int j = i-1; j >= 0; j--) {
      if (line[j] == '.') return true;
      if (line[j] == '|' || line[j] == '\\') return false;
    }
    return true;
  }
}
