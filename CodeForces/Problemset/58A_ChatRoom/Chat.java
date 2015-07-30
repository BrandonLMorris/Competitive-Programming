import java.util.*;

public class Chat {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] line = input.nextLine().toCharArray();
    char[] hello = new String("hello").toCharArray();
    int helloCount = 0;
    int lineCount = 0;
    while (helloCount < hello.length && lineCount < line.length) {
      if (hello[helloCount] == line[lineCount]) {
        helloCount++;
        lineCount++;
      } else {
        lineCount++;
      }
    }
    if (helloCount == hello.length) {
      System.out.println("YES");
    }
    else {
      System.out.println("NO");
    }
  }
}
