import java.util.*;

public class Phone {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int numTests = Integer.parseInt(in.nextLine());
    for (int t = 0; t < numTests; t++) {
      int numNumbers = Integer.parseInt(in.nextLine());

    }
  }

  private static class Node {
    public ArrayList<Node> children;
    public Character digit;
    public boolean isLasLetterOfWord;
  }
}
