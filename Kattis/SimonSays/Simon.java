import java.util.*;

public class Simon {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int numTests = Integer.parseInt(in.nextLine());
    for (int t = 0; t < numTests; t++) {
      String str = in.nextLine();
      if (str.startsWith("simon says ")) {
        System.out.println(str.substring(11, str.length()));
      } else {
        System.out.println();
      }
    }
  }
}
