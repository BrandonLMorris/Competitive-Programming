import java.util.*;

public class AppleTrees {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read in the ammount of input
    int n = in.nextInt();

    // Heaps to store the trees in sorted order
    PriorityQueue<Tree> posList = new PriorityQueue<Tree>();
    PriorityQueue<Tree> negList = new PriorityQueue<Tree>();

    // Read in the trees, adding them to the corresponding list
    for (int i = 0; i < n; i++) {
      Tree tree = new Tree(in.nextInt(), in.nextInt());
      if (tree.pos > 0) {
        posList.add(tree);
      } else {
        negList.add(tree);
      }
    }

    // Counter for the total apples
    int appleCount = 0;

    // Add apples from tree on each side until one side runs out
    while (!posList.isEmpty() && !negList.isEmpty()) {
      appleCount += negList.poll().apples;
      appleCount += posList.poll().apples;
    }

    // Get one more tree from the nonempty list, if any
    if (!posList.isEmpty()) {
      appleCount += posList.poll().apples;
    } else if (!negList.isEmpty()) {
      appleCount += negList.poll().apples;
    }

    // Output the result
    System.out.println(appleCount);

  }

  // Private class for trees that is sortable
  private static class Tree implements Comparable<Tree>{
    int pos;
    int apples;

    // Public constructor
    public Tree(int posArg, int applesArg) {
      this.pos = posArg;
      this.apples = applesArg;
    }

    // Sorting is unsinged since pos and neg are in separate lists
    public int compareTo(Tree t) {
      return Math.abs(this.pos) - Math.abs(t.pos);
    }
  }
}
