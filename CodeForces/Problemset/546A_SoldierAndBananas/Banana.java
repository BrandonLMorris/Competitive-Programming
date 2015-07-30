import java.util.*;

public class Banana {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    long costOfFirst = input.nextLong();
    long numDollars = input.nextLong();
    long numWants = input.nextLong();

    long counter = 0;
    for (int i = 1; i <= numWants; i++) {
      counter += i * costOfFirst;
    }

    System.out.println(counter - numDollars > 0 ? counter - numDollars : 0);
  }
}
