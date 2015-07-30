import java.util.*;

public class Bet {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int counter = 0;
    for (int i = 0; i < 5; i++) {
      counter += input.nextInt();
    }
    if (counter % 5 == 0 && counter != 0) {
      System.out.println(counter / 5);
    } else {
      System.out.println(-1);
    }
  }
}
