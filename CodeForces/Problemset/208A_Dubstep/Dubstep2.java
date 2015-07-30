import java.util.*;

public class Dubstep2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String line = input.nextLine();
    StringBuilder sb = new StringBuilder();
    while (line.length() > 0) {
      while(line.length() >= 3 && line.indexOf("WUB") == 0) {
        line = line.substring(3, line.length());
        if (sb.length() != 0 && sb.charAt(sb.length() - 1)  != ' ') {
          sb.append(" ");
        }
      }
      if (line.length() > 0) {
        sb.append(line.charAt(0));
        line = line.substring(1, line.length());
      }
    }
    System.out.println(sb.toString());
  }
}
