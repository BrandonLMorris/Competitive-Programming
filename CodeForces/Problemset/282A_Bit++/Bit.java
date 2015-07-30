import java.util.*;

public class Bit {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numLines = Integer.parseInt(input.nextLine());
    int value = 0;
    for (int i = 0; i < numLines; i++) {
      String line = input.nextLine();
      if (line.contains("-")) {
        value--;
      } else {
        value++;
      }
    }
    System.out.println(value);
  }
}
