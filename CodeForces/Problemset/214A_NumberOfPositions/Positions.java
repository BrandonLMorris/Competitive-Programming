import java.util.*;

public class Positions {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int atLeastInFront = input.nextInt();
    int atMostBehind = input.nextInt();

    System.out.println(Math.min(atMostBehind+1, n-atLeastInFront));
  }
}
