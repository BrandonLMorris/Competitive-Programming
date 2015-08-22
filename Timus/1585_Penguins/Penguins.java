import java.util.*;

/*
 * Given a list of different types of penguins, output the type of penguin
 * that is most numerous.
 */

public class Penguins {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());

    // Array that holds the counts of the penguins
    int[] counts = new int[3];

    // Increment the counts for each penguin in the input
    for (int i = 0; i < n; i++) {
      switch (in.nextLine()) {
        case "Emperor Penguin":
          counts[0]++; break;
        case "Little Penguin":
          counts[1]++; break;
        case "Macaroni Penguin":
          counts[2]++; break;
      }
    }

    // Find the max and output the result
    int max = -1;
    if (counts[0] > counts[1] && counts[0] > counts[2])
      System.out.println("Emperor Penguin");
    else if (counts[1] > counts[0] && counts[1] > counts[2])
      System.out.println("Little Penguin");
    else
      System.out.println("Macaroni Penguin");

  }
}
