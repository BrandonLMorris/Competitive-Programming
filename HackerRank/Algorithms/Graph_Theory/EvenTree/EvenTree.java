import java.util.*;

public class EvenTree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numVertices = input.nextInt();
        int numEdges = input.nextInt();
        int removedEdges = 0;

        Node[] nodeArr = new Node[numVertices + 1];
        for(int i = 1; i <= numVertices; i++) {
            nodeArr[i] = new Node(i);
        }
        for(int i = 0; i < numEdges; i++) {
            int startVal = input.nextInt();
            int endVal = input.nextInt();
            if(startVal < endVal) {
                nodeArr[startVal].children.add(nodeArr[endVal]);
            } else {
                nodeArr[endVal].children.add(nodeArr[startVal]);
            }
        }
        for(int i = 2; i <= numVertices; i++) {
            if((nodeArr[i].getAllChildren() + 1) % 2 == 0) {
                removedEdges++;
            }
        } 

        System.out.println(removedEdges);
    }
}

class Node {
    int value;
    //Node parent;
    ArrayList<Node> children = new ArrayList<Node>();
    public Node(int value) {
        this.value = value;
    }
    
    int getAllChildren() {
        int counter = 0;
        for(Node n : children) {
            counter++;
            counter += n.getAllChildren();
        }
        return counter;
    }
}

