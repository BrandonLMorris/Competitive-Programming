import java.util.*;

/*
 * Given two times in the form hh:mm, find the differene between them
 */

public class Sleep {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the input as a character array
    char[] input = in.nextLine().toCharArray();

    // Parse the first two digits as the hour and the last two as the minute
    StringBuilder sb = new StringBuilder();
    sb.append(input[0]).append(input[1]);
    int h1 = Integer.parseInt(sb.toString());
    sb = new StringBuilder();
    sb.append(input[3]).append(input[4]);
    int m1 = Integer.parseInt(sb.toString());

    // Parse the second line of input the same as the first
    input = in.nextLine().toCharArray();
    sb = new StringBuilder();
    sb.append(input[0]).append(input[1]);
    int h2 = Integer.parseInt(sb.toString());
    sb = new StringBuilder();
    sb.append(input[3]).append(input[4]);
    int m2 = Integer.parseInt(sb.toString());

    // Perform the actual subtraction
    int hourDiff = h1 - h2;
    int minDiff = m1 - m2;

    // Do correction is one of the differences is negative
    if (minDiff < 0) {
      hourDiff--;
      minDiff = minDiff + 60;
    }
    if (hourDiff < 0) {
      hourDiff += 24;
    }

    // Format the output to hh:mm
    sb = new StringBuilder();
    if (hourDiff < 10) sb.append("0");
    sb.append(hourDiff);
    sb.append(":");
    if (minDiff < 10) sb.append("0");
    sb.append(minDiff);

    // Print the result
    System.out.println(sb.toString());
  }
}
