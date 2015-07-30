import java.util.*;

public class UndergroundCables3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n != 0) {
            ArrayList<Point> points = new ArrayList<Point>(n);
            HashSet<Point> visited = new HashSet<Point>();
            PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
            double counter = 0;
            int connections = 0;

            for(int i = 0; i < n; i++) {
                points.add(new Point(input.nextInt(), input.nextInt()));
            }

            visited.add(points.get(0));

            while(connections < n-1) {
                for(Point startP : points) {
                    if(visited.contains(startP)) {
                        for(Point endP : points) {
                            if(!visited.contains(endP)) {
                                pq.add(new Edge(startP, endP));   
                            }
                        }
                    }
                }
                Edge minEdge = pq.poll();
                pq.clear();
                visited.add(minEdge.end);
                counter += minEdge.distance;
                connections++;
            }

            counter *= 100;
            Math.round(counter);
            counter /= 100;
            System.out.printf("%.2f\n", counter);

            n = input.nextInt();
        }
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    Point start;
    Point end;
    double distance; 

    public Edge(Point p1, Point p2) {
        this.start = p1;
        this.end = p2;
        this.distance = Math.sqrt((double)(start.x-end.x)*(start.x-end.x) + (start.y-end.y)*(start.y-end.y));
    }

    public int compareTo(Edge other) {
        if(this.distance > other.distance) return 1;
        else if(this.distance < other.distance) return -1;
        else return 0;
    }
}

/**
 * Basic Algorithm (Prim's)
 * Store the graph as series of points
 * Add arbitrary root to a set of visited verticies
 * Until there are the correct number of edges added (n-1):
 *      Calculate distance from every unvisited vertice to every visted
 *      vertice
 *      Add the minimum to the counter, move that vertice to visited
 * Using a HashSet reduces to O(1) time for contains()
 * Algorithm runs in O(n^2) time
 */
