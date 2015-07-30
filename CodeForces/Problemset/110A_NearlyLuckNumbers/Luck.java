import java.util.*;

public class Luck {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long counter = 0;
    char[] line = input.nextLine().toCharArray();
    for (char c : line) {
      if (c == '4' || c == '7') {
        counter++;
      }
    }
    char[] counterArr = Long.toString(counter).toCharArray();
    for (char c : counterArr) {
      if (c != '4' && c != '7') {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
