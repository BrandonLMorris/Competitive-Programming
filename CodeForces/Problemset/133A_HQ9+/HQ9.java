import java.util.*;

public class HQ9 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String line = input.nextLine();
    if (line.contains("H") || line.contains("Q") || line.contains("9")) {
      System.out.println("YES");
      return;
    }
    System.out.println("NO");
  }
}
