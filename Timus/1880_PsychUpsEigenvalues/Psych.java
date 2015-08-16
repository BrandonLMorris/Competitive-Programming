import java.util.*;

/*
 * Given three lists of numbers, determine how many numbers are common to all
 * three lists
 */

public class Psych {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the first list and store the values in a hash set
    int n = in.nextInt();
    HashSet<Integer> hs = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      hs.add(in.nextInt());
    }

    // Read the second list and store values common to it and the first list
    // in a different hash set
    n = in.nextInt();
    HashSet<Integer> firstAndSecond = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      int j = in.nextInt();
      if (hs.contains(j)) {
        firstAndSecond.add(j);
      }
    }

    // Read in the last list and store values common to all three lists in
    // another hash set (first HashSet reference reused)
    n = in.nextInt();
    hs = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      int j = in.nextInt();
      if (firstAndSecond.contains(j)) {
        hs.add(j);
      }
    }

    // Print out the size of the last hash set
    System.out.println(hs.size());
  }
}
