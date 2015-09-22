import java.util.*;

public class Bomb {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    char[][] input = new char[5][];
    for (int i = 0; i < 5; i++) {
      input[i] = in.nextLine().toCharArray();
    }

    ArrayList<Character> time = new ArrayList<Character>();
    int current = 0;
    while (current < input[0].length) {
      int x = parse(input, current);
      if (x == -1) {
        System.out.println("BOOM!!");
        return;
      } else {
        time.add((char)(x+'0'));
      }
      current += 4;
    }
    StringBuilder sb = new StringBuilder();
    for (Character c : time) sb.append(c);
    int t = Integer.parseInt(sb.toString());
    System.out.println((t % 6 == 0) ? "BEER!!" : "BOOM!!");
  }

  private static int parse(char[][] i, int current) {
    if (i[0][current] == '*' && i[0][current+1] == '*' && i[0][current+2] == '*' &&
        i[1][current] == '*' && i[1][current+1] == ' ' && i[1][current+2] == '*' &&
        i[2][current] == '*' && i[2][current+1] == ' ' && i[2][current+2] == '*' &&
        i[3][current] == '*' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == '*' && i[4][current+1] == '*' && i[4][current+2] == '*')
      return 0;
    if (i[0][current] == ' ' && i[0][current+1] == ' ' && i[0][current+2] == '*' &&
        i[1][current] == ' ' && i[1][current+1] == ' ' && i[1][current+2] == '*' &&
        i[2][current] == ' ' && i[2][current+1] == ' ' && i[2][current+2] == '*' &&
        i[3][current] == ' ' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == ' ' && i[4][current+1] == ' ' && i[4][current+2] == '*')
      return 1;
    if (i[0][current] == '*' && i[0][current+1] == '*' && i[0][current+2] == '*' &&
        i[1][current] == ' ' && i[1][current+1] == ' ' && i[1][current+2] == '*' &&
        i[2][current] == '*' && i[2][current+1] == '*' && i[2][current+2] == '*' &&
        i[3][current] == '*' && i[3][current+1] == ' ' && i[3][current+2] == ' ' &&
        i[4][current] == '*' && i[4][current+1] == '*' && i[4][current+2] == '*')
      return 2;
    if (i[0][current] == '*' && i[0][current+1] == '*' && i[0][current+2] == '*' &&
        i[1][current] == ' ' && i[1][current+1] == ' ' && i[1][current+2] == '*' &&
        i[2][current] == '*' && i[2][current+1] == '*' && i[2][current+2] == '*' &&
        i[3][current] == ' ' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == '*' && i[4][current+1] == '*' && i[4][current+2] == '*')
      return 3;
    if (i[0][current] == '*' && i[0][current+1] == ' ' && i[0][current+2] == '*' &&
        i[1][current] == '*' && i[1][current+1] == ' ' && i[1][current+2] == '*' &&
        i[2][current] == '*' && i[2][current+1] == '*' && i[2][current+2] == '*' &&
        i[3][current] == ' ' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == ' ' && i[4][current+1] == ' ' && i[4][current+2] == '*')
      return 4;
    if (i[0][current] == '*' && i[0][current+1] == '*' && i[0][current+2] == '*' &&
        i[1][current] == '*' && i[1][current+1] == ' ' && i[1][current+2] == ' ' &&
        i[2][current] == '*' && i[2][current+1] == '*' && i[2][current+2] == '*' &&
        i[3][current] == ' ' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == '*' && i[4][current+1] == '*' && i[4][current+2] == '*')
      return 5;
    if (i[0][current] == '*' && i[0][current+1] == '*' && i[0][current+2] == '*' &&
        i[1][current] == '*' && i[1][current+1] == ' ' && i[1][current+2] == ' ' &&
        i[2][current] == '*' && i[2][current+1] == '*' && i[2][current+2] == '*' &&
        i[3][current] == '*' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == '*' && i[4][current+1] == '*' && i[4][current+2] == '*')
      return 6;
    if (i[0][current] == '*' && i[0][current+1] == '*' && i[0][current+2] == '*' &&
        i[1][current] == ' ' && i[1][current+1] == ' ' && i[1][current+2] == '*' &&
        i[2][current] == ' ' && i[2][current+1] == ' ' && i[2][current+2] == '*' &&
        i[3][current] == ' ' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == ' ' && i[4][current+1] == ' ' && i[4][current+2] == '*')
      return 7;
    if (i[0][current] == '*' && i[0][current+1] == '*' && i[0][current+2] == '*' &&
        i[1][current] == '*' && i[1][current+1] == ' ' && i[1][current+2] == '*' &&
        i[2][current] == '*' && i[2][current+1] == '*' && i[2][current+2] == '*' &&
        i[3][current] == '*' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == '*' && i[4][current+1] == '*' && i[4][current+2] == '*')
      return 8;
    if (i[0][current] == '*' && i[0][current+1] == '*' && i[0][current+2] == '*' &&
        i[1][current] == '*' && i[1][current+1] == ' ' && i[1][current+2] == '*' &&
        i[2][current] == '*' && i[2][current+1] == '*' && i[2][current+2] == '*' &&
        i[3][current] == ' ' && i[3][current+1] == ' ' && i[3][current+2] == '*' &&
        i[4][current] == '*' && i[4][current+1] == '*' && i[4][current+2] == '*')
      return 9;

    return -1;
  }
}
