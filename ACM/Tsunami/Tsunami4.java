//THIS ONE WORKS

import java.util.*;

public class Tsunami4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            int numPoints = input.nextInt();
            if(numPoints == 0) break;

            double counter = 0.00;

            Point[] points = new Point[numPoints];
            HashMap<Integer, Integer> colorRoot = new HashMap<Integer, Integer>();
            for(int i = 0; i < numPoints; i++) {
                Point p = new Point(input.nextInt(), input.nextInt(), i);
                points[i] = p;
                colorRoot.put((Integer)i, (Integer)p.y);
            }



            PriorityQueue<Edge> edgePQ = new PriorityQueue<Edge>();
            for(int i = 0; i < numPoints; i++) {
                for(int j = i; j < numPoints; j++) {
                    if(i != j)
                        edgePQ.add(new Edge(points[i], points[j]));
                }
            }

            int connections = 0;
            while(connections < numPoints - 1) {
                //An edge is considered valid iff:
                    //The two points are of different color,
                    //The higher of the two points must be the root of its color
                Edge e = edgePQ.poll();
                if(e.p1.color != e.p2.color && higherIsRoot(e.p1, e.p2, colorRoot)) {
                    counter += e.weight;
                    connections++;
                    if(e.p1.y != colorRoot.get(e.p1.color)) {
                        //Recolor to p1's color
                        recolor(points, e.p2.color, e.p1.color);
                    } else if(e.p2.y != colorRoot.get(e.p2.color)) {
                        //Recolor to p2's color
                        recolor(points, e.p1.color, e.p2.color);
                    } else if(e.p1.y < e.p2.y) {
                        //Recolor to p1's color
                        recolor(points, e.p2.color, e.p1.color);
                    } else if(e.p2.y < e.p1.y) {
                        //Recolor to p2's color
                        recolor(points, e.p1.color, e.p2.color);
                    } else { //Both colors are roots and same y-value
                        //Recolor to p1's color
                        recolor(points, e.p2.color, e.p1.color);
                    }  
                }
            }

            System.out.printf("%.2f\n", counter);

        }
    }

    private static boolean higherIsRoot(Point p1, Point p2, HashMap<Integer, Integer> map) {
        if(p1.y > p2.y && p1.y == map.get(p1.color)) {
            return true;
        }
        if(p2.y > p1.y && p2.y == map.get(p2.color)) {
            return true;
        }
        if(p1.y == p2.y && (p1.y == map.get(p1.color) || p2.y == map.get(p2.color))) {
            return true;
        }
        return false;
    }

    private static void recolor(Point[] points, int startColor, int endColor) {
        for(Point p : points) {
            if(p.color == startColor)
                p.color = endColor;
        }
    }
}

class Point {
    int x;
    int y;
    int color;

    public Point(int xArg, int yArg, int colorArg) {
        this.x = xArg;
        this.y = yArg;
        this.color = colorArg;
    }

}

class Edge implements Comparable<Edge> {
    Point p1;
    Point p2;
    double weight;

    public Edge(Point p1Arg, Point p2Arg) {
        this.p1 = p1Arg;
        this.p2 = p2Arg;
        this.weight = Math.sqrt(Math.pow(p1.x - p2.x, 2.00) + Math.pow(p1.y - p2.y, 2.00));
    }

    public int compareTo(Edge e) {
        if(this.weight > e.weight) return 1;
        if(this.weight < e.weight) return -1;
        return 0;
    }
}

/*
P1 is higher => P1 should be root of its color
P2 is higher => P2 should be root of its color
P1 == P2     => Either P1 or P2 should be root of its color
*/