import java.util.*;

public class Erase {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());

    char[] before = in.nextLine().toCharArray();
    char[] after = in.nextLine().toCharArray();

    if (n % 2 == 0) {
      for (int i = 0; i < before.length; i++) {
        if (before[i] != after[i]) {
          System.out.println("Deletion failed");
          return;
        }
      }
    } else {
      for (int i = 0; i < before.length; i++) {
        if (before[i] == after[i]) {
          System.out.println("Deletion failed");
          return;
        }
      }
    }

    System.out.println("Deletion succeeded");

  }
}
