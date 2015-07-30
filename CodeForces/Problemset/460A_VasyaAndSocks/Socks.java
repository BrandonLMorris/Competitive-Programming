import java.util.*;

public class Socks {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numSocks = input.nextInt();
    int m = input.nextInt();
    int counter = 0;
    while (numSocks > 0) {
      counter++;
      numSocks--;
      if (counter % m == 0) {
        numSocks++;
      }
    }
    System.out.println(counter);
  }
}
