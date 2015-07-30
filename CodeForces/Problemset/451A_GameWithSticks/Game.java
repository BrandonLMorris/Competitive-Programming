import java.util.*;

public class Game {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    int counter = 0;
    while (n * m > 0) {
      counter++;
      n--;
      m--;
    }
    System.out.println((counter % 2 != 0 ? "Akshat" : "Malvika"));
  }
}
