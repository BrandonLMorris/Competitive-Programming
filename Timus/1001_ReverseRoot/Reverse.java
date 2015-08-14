import java.util.*;

/*
 * Given a list of integer, print the square roots of the integers in
 * reverse order
 */

public class Reverse {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read each input, take the square root, and push onto the stack
    LinkedList<Double> results = new LinkedList<Double>();
    while (in.hasNext()) {
      results.push(Math.sqrt(Long.parseLong(in.next())));
    }

    // Pop each element of the stack and print it to 4 decimal places
    while (!results.isEmpty()) {
      System.out.printf("%.4f\n", results.pop());
    }
  }
}
