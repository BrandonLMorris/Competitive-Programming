/**
 * ACM Count Your Cousins
 * Created by bmorris on 10/10/14.
 */
import java.util.*;

public class CountYourCousins {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();                        //Number of values within tree
        int cousinValue = input.nextInt();              //Value the progam will find the cousins of
        int valueCounter = 1;                           //Counts the number of values taken in
        int value = input.nextInt();                    //First value
        Node root = new Node(0);                        //Root node of the tree
        ArrayList<Integer> values = new ArrayList<Integer>(n);
        values.add(value);

        for(;;){
            int nextVal = input.nextInt();
            valueCounter++;
            if(nextVal > value + 1 || valueCounter == n){
                //Logic for adding values to tree

                break;
            }
            else {          //Executes if nextInt is sequential and more values are needed
                values.add(nextVal);
                value = nextVal;
            }
        }

    }
}

//Used as to create the tree. Contains a reference to a parent Node, a value, and an ArrayList of children
class Node {
    public Node(int val){                       //constructor for the root node, where parent is null
        this.parent = null;
        this.value = val;
        this.children = new ArrayList<Node>();
    }
    public Node(Node parent, int val){
        this.parent = parent;
        this.value = val;
        this.children = new ArrayList<Node>();
    }

    int value;
    Node parent;
    ArrayList<Node> children;
}


