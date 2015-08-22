import java.util.*;

/*
 * A flag can be created by combining red, blue, and white strips of
 * clothes, according to the following rules:
 * 1. No two pieces of the same color can be adjacent
 * 2. Blue can only occur between red and white
 *
 * How many different flags can be created if n strips are used?
 */

public class Flag {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the input
    int n = in.nextInt();

    // Store all possible input values into an array
    long[] arr = new long[50];

    // Sequence is similar to the Fibbonacci sequence, where P(n) = P(n-1) +
    // P(n-2). Set the inital values
    arr[1] = 2;
    arr[2] = 2;

    // Loop through the input values
    for (int i = 3; i <= 45; i++) {
      arr[i] = arr[i-1] + arr[i-2];
    }

    // Output the result
    System.out.println(arr[n]);
  }
}
