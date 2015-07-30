import java.util.*;

public class Epic {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    int b = input.nextInt();
    int heap = input.nextInt();

    boolean simonTurn = true;
    while (heap > 0) {
      int turnNum = simonTurn ? a : b;
      //if (heap < turnNum) {
      //  System.out.println((simonTurn ? "1" : "0"));
      //  return;
      //}
      int gcd = gcd(turnNum, heap);
      heap -= gcd;
      simonTurn = !simonTurn;
    }
    System.out.println((simonTurn ? "1" : "0"));
  }

  public static int gcd(int a, int b) {
    int smaller = Math.min(a,b);
    if (smaller == 0) {
      return (a == 0 ? b : a);
    }
    while (a % smaller != 0 || b % smaller != 0) {
      smaller--;
    }
    //System.out.println("GCD of " + a + " " + b + " is " + smaller);
    return smaller;
  }
}
