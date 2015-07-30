import java.util.*;

public class Tsunami3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        for(;;) {
            if(n == 0) break;

            //Counter to store the result
            double counter = 0.00;

            //Array to store each point
            Point[] points = new Point[n];
            for(int i = 0; i < n; i++) {
                points[i] = new Point(input.nextInt(), input.nextInt(), i);
            }

            //Sort the points, reset the color value (whoops)
            Arrays.sort(points);
            for(int i = 0; i < n; i++) {
                points[i].color = i;
            }


            //Hash map to map each color to its root y-value
            HashMap<Integer, HashSet<Point>> colorRoot = new HashMap<Integer, HashSet<Point>>();
            for(int i = 0; i < n; i++) {
                HashSet<Point> hs = new HashSet<Point>();
                hs.add(points[i]);
                colorRoot.put(i, hs);
            }

            //PriorityQueue that stores the points by weight
            PriorityQueue<Edge> edgePQ = new PriorityQueue<Edge>();
            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    if(i != j /*&& points[i].y <= points[j].y*/)
                        edgePQ.add(new Edge(points[i], points[j]));
                }
            }

            //For and edge to be valid it must:
                //have points of different colors
                //the higher of the two points mus be the root of its tree (or of same y-value as the root) 
            //Once an edge is pulled:
                //The higher point's color must be recolored to that of the lower point's color
                //If the lower point is a root of its color and shares the same height as the higher point, the higher point must be added to its root set


            //Connects the points, keeping track of total weight
            int connections = 0;
            while(connections < n - 1) {
                Edge e = edgePQ.poll();
                if(e.p1.color != e.p2.color && colorRoot.get(e.p2.color).contains(e.p2)) {
                    counter += e.weight;
                    connections++;
                    if(colorRoot.get(e.p1.color).contains(e.p1) && e.p2.y == e.p1.y) {
                        colorRoot.get(e.p1.color).add(e.p2);
                    }
                    recolor(points, e.p2.color, e.p1.color);
                }
            }

            System.out.printf("%.2f\n", counter);

            n = input.nextInt();
        }
    }

    //Recolors anything in the array with color startColor to color endColor
    private static void recolor(Point[] ptArr, int startColor, int endColor) {
        for(Point p : ptArr) {
            if(p.color == startColor)
                p.color = endColor;
        }
    }

    private static boolean higherIsRoot(Point p1, Point p2, HashMap<Integer, Integer> colorRoot) {
        if(p1.y == p2.y) return true;
        if(p1.y < p2.y && p2.y == colorRoot.get(p2.color)) return true;
        if(p2.y < p1.y && p1.y == colorRoot.get(p1.color)) return true;
        return false;
    }
}

class Point implements Comparable<Point>{
    int x;
    int y;
    int color;
    boolean isColorRoot;

    public Point(int xVal, int yVal, int colorVal) {
        this.x = xVal;
        this.y = yVal;
        this.color = colorVal;
        this.isColorRoot = true;
    }

    public String toString() {
        return x + " " + y;
    }

    public int compareTo(Point p) {
        return this.y - p.y;
    }
}

class Edge implements Comparable<Edge>{
    Point p1;
    Point p2;
    double weight;

    public Edge(Point p1Val, Point p2Val) {
        this.p1 = p1Val;
        this.p2 = p2Val;
        this.weight = Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
    }

    public int compareTo(Edge e) {
        if(this.weight > e.weight) return 1;
        else if(this.weight < e.weight) return -1;
        else return 0;
    }
}