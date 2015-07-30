import java.util.*;


//Implementation of Underground Cables using Kruskal's Algorithm

public class UndergroundCables4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numPoints = input.nextInt();

        for(;;) {
            if(numPoints == 0) break;

            double counter = 0.00;
            Point[] points = new Point[numPoints];

            //Obtain the points from the input, place into array
            for(int i = 0; i < numPoints; i++) {
                points[i] = new Point(input.nextInt(), input.nextInt(), i);
            }

            //Create every possible edge, store in priority queue by weight
            PriorityQueue<Edge> edgePQ = new PriorityQueue<Edge>();
            for(int i = 0; i < numPoints; i++) {
                for(int j = i; j < numPoints; j++) {
                    edgePQ.<Edge>add(new Edge(points[i], points[j]));
                }
            }

            //Add n - 1 edges, keeping track of total weight
            int numConnections = 0;
            while(numConnections < numPoints - 1) {
                Edge e = edgePQ.poll();
                //If edges have same color, they create a cycle and therefore it is an invalid edge
                if(e.p1.color != e.p2.color) {
                    counter += e.weight;
                    recolor(points, e.p2.color, e.p1.color);
                    numConnections++;
                }
            }

            //Print answer in specified format
            System.out.printf("%.2f\n", counter);


            numPoints = input.nextInt();
        }
    }

    //Private method recolors all points of startColor to endColor
    private static void recolor(Point[] pArr, int startColor, int endColor) {
        for(Point p : pArr) {
            if(p.color == startColor) {
                p.color = endColor;
            }
        }
    }
}

class Point {
    int x;
    int y;
    int color;

    public Point(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

class Edge implements Comparable<Edge>{
    Point p1;
    Point p2;
    double weight;

    public Edge(Point point1, Point point2) {
        this.p1 = point1;
        this.p2 = point2;
        this.weight = Math.sqrt((point1.x - point2.x)*(point1.x - point2.x) + (point1.y - point2.y)*(point1.y - point2.y));
    }

    public int compareTo(Edge e) {
        if(this.weight > e.weight) return 1;
        else if(this.weight < e.weight) return -1;
        else return 0;
    }
}