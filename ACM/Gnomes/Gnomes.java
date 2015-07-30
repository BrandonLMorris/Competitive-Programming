import java.util.*;

public class Gnomes {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = input.nextInt();
    System.out.println("Gnomes:");
    for (int t = 0; t < numTests; t++) {
      //String line = input.nextLine();
      //Scanner lineScanner = new Scanner(line);
      int firstLength = input.nextInt();
      int secondLength = input.nextInt();
      int thirdLength = input.nextInt();
      if (firstLength < secondLength && secondLength < thirdLength) {
        System.out.println("Ordered");
        continue;
      } else if (firstLength > secondLength && secondLength > thirdLength) {
        System.out.println("Ordered");
        continue;
      }
      System.out.println("Unordered");
    }
  }
}
