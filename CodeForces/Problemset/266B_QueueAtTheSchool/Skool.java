import java.util.*;

public class Skool {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numLine = input.nextInt();
    int numSecs = input.nextInt();
    input.nextLine();
    char[] line = input.nextLine().toCharArray();
    for (int i = 0; i < numSecs; i++) {
      for (int j = line.length-2; j >= 0; j--) {
        if (line[j] == 'B' && line[j+1] == 'G') {
          line[j+1] = 'B';
          line[j] = 'G';
          j--;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : line) {
      sb.append(c);
    }
    System.out.println(sb.toString());
  }
}
