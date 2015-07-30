import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by bmorris on 3/4/15.
 */
public class Strahler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for (int t = 0; t < numTests; t++) {
            input.nextInt();
            int numNodes = input.nextInt();
            int numEdges = input.nextInt();
            Node[] nodes = new Node[numNodes];
            for (int i = 0; i < numNodes; i++) {
                nodes[i] = new Node(i+1);
            }

            for (int i = 0; i < numEdges; i++) {
                int from = input.nextInt();
                int to = input.nextInt();
                nodes[to-1].prevNodes.add(nodes[from-1]);
            }


            System.out.println((t+1) + " " + getStrahler(nodes[numNodes-1]));
        }
    }

    static public int getStrahler(Node node) {
        if (node.order == 0) {
            if (node.prevNodes.size() == 0) {
                node.order = 1;
            } else {
                ArrayList<Integer> prevOrders = new ArrayList<Integer>();
                for (Node n : node.prevNodes) {
                    prevOrders.add(getStrahler(n));
                }
                Collections.sort(prevOrders, Collections.reverseOrder());
                if (prevOrders.size() > 1 && prevOrders.get(0).equals(prevOrders.get(1))) {
                    node.order = prevOrders.get(0) + 1;
                } else {
                    node.order = prevOrders.get(0);
                }
            }
        }
        return node.order;
    }
}

class Node {
    ArrayList<Node> prevNodes = new ArrayList<Node>();
    int order = 0;
    int label;
    public Node(int labelArg) {
        this.label = labelArg;
    }
}

class Edge {

}
