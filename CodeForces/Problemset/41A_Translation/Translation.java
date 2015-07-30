import java.util.*;

public class Translation {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] line1 = input.nextLine().toCharArray();
    char[] line2 = input.nextLine().toCharArray();
    if (line1.length != line2.length) {
      System.out.println("NO");
      return;
    }
    for (int i = 0; i < line1.length; i++) {
      if (line1[i] != line2[line2.length-1-i]) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
