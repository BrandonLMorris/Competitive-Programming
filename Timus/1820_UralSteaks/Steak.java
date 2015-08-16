import java.util.*;

/* Given a number of steaks n and the number of steaks that can be fried at
 * once k, determine the minimum number of seconds needed to fry both sides
 * of every steak (each side only needs to be fried for one second)
 */

public class Steak {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the input
    int n = in.nextInt();
    int k = in.nextInt();


    // 2 sides per steak, divided by k and rounded up
    int count = (int)Math.ceil((2.0 * n) / k);

    // The lowest possible value is 2 (since both sides can't be fried at
    // once)
    if (count == 1) count++;

    // Output the result
    System.out.println(count);
  }
}
