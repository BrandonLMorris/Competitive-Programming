import java.util.*;

public class Game {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n1 = input.nextInt();
    int n2 = input.nextInt();

    System.out.println((n1 > n2 ? "First" : "Second"));

  }
}
