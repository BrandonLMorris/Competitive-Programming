import java.util.*;

public class Domino {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int m = input.nextInt();
    int n = input.nextInt();

    int numDominos = (int) Math.floor((m*n)/2.0);
    System.out.println(numDominos);
  }
}
