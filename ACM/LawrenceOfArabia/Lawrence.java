import java.util.*;

public class Lawrence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            int numRails = input.nextInt();
            int numAttacks = input.nextInt();
            if(numRails == 0) break;

            PriorityQueue<Edge> edgePQ = new PriorityQueue<Edge>();

            Point[] points = new Point[numRails];
            for(int i = 0; i < numRails; i++) {
                points[i] = new Point(input.nextInt());
            }
            for(int i = 0; i < points.length - 1; i++) {
                points[i].next = points[i+1];
                edgePQ.add(new Edge(points[i], points[i+1]));
            }

            for(int i = 0; i < numAttacks; i++) {
                Edge e = edgePQ.poll();
                //System.out.println("Destroying edge between " + e.p1.value + " and " + e.p2.value);
                e.p1.next = null;
            }

            int counter = 0;
            for(int i = 0; i < points.length; i++) {
                Point p = points[i];
                Point next = p.next;
                while(next != null) {
                    //System.out.println("Multiplying " + p.value + " and " + next.value);
                    counter += (p.value * next.value);
                    next = next.next;
                }

            }

            System.out.println(counter);

        }
    }
}

class Point {
    int value;
    Point next;

    public Point(int val) {
        this.value = val;
    }
}

class Edge implements Comparable<Edge> {
    Point p1;
    Point p2;
    int weight;

    public Edge(Point p1Arg, Point p2Arg) {
        this.p1 = p1Arg;
        this.p2 = p2Arg;
        this.weight = p1.value + p2.value;
    }

    public int compareTo(Edge e) {
        return e.weight - this.weight;
    }
}