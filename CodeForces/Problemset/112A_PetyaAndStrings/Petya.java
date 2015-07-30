import java.util.*;

public class Petya {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String line1 = input.nextLine().toUpperCase();
    String line2 = input.nextLine().toUpperCase();
    if (line1.equals(line2)) {
      System.out.println(0);
      return;
    }
    if (line1.compareTo(line2) < 0) {
      System.out.println(-1);
    } else {
      System.out.println(1);
    }
  }
}
