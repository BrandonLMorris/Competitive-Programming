import java.util.*;

public class Dubstep {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String line = input.nextLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < line.length() - 3;) {
      if (line.charAt(i) == 'W' && line.charAt(i+1) == 'U' && line.charAt(i+2) == 'B') {
        i += 3;
        if (sb.length() != 0 && sb.charAt(sb.length()-1) != ' ') {
          sb.append(" ");
        }
      }
      else sb.append(line.charAt(i));
      i++;
    }
    int i = line.length() - 3;
    if (!(line.charAt(i) == 'W' && line.charAt(i+1) == 'U' && line.charAt(i+2) == 'B')) {
      sb.append(line.charAt(i));
      sb.append(line.charAt(i+1));
      sb.append(line.charAt(i+2));
    }
    System.out.println(sb.toString().trim());
  }
}
