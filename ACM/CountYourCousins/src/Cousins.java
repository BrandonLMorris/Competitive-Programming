import java.util.*;

public class Cousins {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n != 0) {
            //stores the value of the node of interest
            int interestVal = input.nextInt();
            Node interest = null;
            int counter = 0;

            //array to store nodes initially
            Node[] nodesArr = new Node[n];
            for(int i = 0; i < n; i++) {
                nodesArr[i] = new Node(input.nextInt());
            }

            Node root = nodesArr[0];
            int parentIndex = 0;

            //Loop through each node, adding to parent to construct tree
            //when non-consecutive value found, move on to next parent
            for(int i = 1; i < n; i++) {
                nodesArr[i].parent = nodesArr[parentIndex];
                nodesArr[parentIndex].children.add(nodesArr[i]);

                //moves to next parent if next value is non-consecutive
                if(i < n-1 && nodesArr[i].value != nodesArr[i+1].value - 1) {
                    parentIndex++;
                }
            }

            //find the node of interest using the initial array
            for(Node no : nodesArr) {
                if(no.value == interestVal) {
                    interest = no;
                    break;
                }
            }

            if(interest != null && interest.parent != null && interest.parent.parent != null) {
                Node grandparent = interest.parent.parent;
                for(Node no : grandparent.children) {
                    if(no == interest.parent) continue;
                    counter += no.children.size();
                }
                System.out.println(counter);
            } else {
                System.out.println(0);
            }


            n = input.nextInt();
        }
    }
}

class Node {
    int value;
    Node parent;
    ArrayList<Node> children;

    public Node(int num) {
        this.value = num;
        children = new ArrayList<Node>();
    }
}
