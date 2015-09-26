import java.util.*;
import java.io.*;

/*
 * Given a list of phone numbers, determine if any are prefixes of others
 *
 * Using a trie data structure.
 */

public class Phone {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // Iterate through each test case
    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      int numNumbers = Integer.parseInt(in.readLine());

      // Create the new trie
      Node head = new Node('\0');
      boolean isValid = true;

      // Iterate for each phone number in the list
      for (int i = 0; i < numNumbers; i++) {
        String number = in.readLine();
        Node current = head;

        // Iterate through each character in the phone number
        for (int j = 0; j < number.length(); j++) {
          boolean found = false;

          // Try to find a child of the current node that has the same digit
          for (int k = 0; k < current.children.size() && !found; k++) {
            Node n = current.children.get(k);
            if (n.digit == number.charAt(j)) {
              current = n;
              found = true;

              // If the last number for either phone number, the list isn't valid
              if (j == number.length() - 1 || current.isLasLetterOfWord) {
                isValid = false;
              }
            }
          }

          // If we couldn't find an existing child, create one
          if (!found) {
            Node n = new Node(number.charAt(j));
            current.children.add(n);
            current = n;
          }

          // Mark the end of a branch
          if (j == number.length() - 1) {
            current.isLasLetterOfWord = true;
          }
        }

      }

      // Output the result
      System.out.println(isValid ? "YES" : "NO");
    }
  }

  // Private Node for trie structure
  private static class Node {
    public ArrayList<Node> children;
    public Character digit;
    public boolean isLasLetterOfWord;

    public Node(char c) {
      children = new ArrayList<Node>();
      digit = c;
    }
  }
}
