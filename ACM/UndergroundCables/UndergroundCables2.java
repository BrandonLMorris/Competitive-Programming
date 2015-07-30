import java.util.*;

public class UndergroundCables2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n != 0) {
            double counter = 0;
            int connections = 0;

            //Store each point
            ArrayList<Point> points = new ArrayList<Point>(n);
            for(int i = 0; i < n; i++) {
               points.add(new Point(input.nextInt(), input.nextInt())); 
            }
            
            //Set keeps up with which verticies have been visited
            HashSet<Point> visited = new HashSet<Point>();

            //PriorityQueue manages the shortest edge from point
            PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
            for(Point p : points) {
                if(p == points.get(0)) continue;
                pq.add(new Edge(points.get(0), p));
            }
            Edge minEdge = pq.poll();
            pq.clear();
            visited.add(minEdge.start);
            visited.add(minEdge.end);
            counter += minEdge.weight;
            connections++;

            //Continue adding edges until every vertice is connected
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
                minEdge = pq.poll();
                pq.clear();
                visited.add(minEdge.end); 
                connections++;
                counter += minEdge.weight;
            }

            counter *= 100;
            Math.round(counter);
            counter /= 100;
            System.out.printf("%.2f\n", counter);

            n = input.nextInt();
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt((double)((this.x - p.x)*(this.x - p.x) + (this.y - p.y)*(this.y - p.y)));
    }
}

class Edge implements Comparable<Edge> {
    Point start;
    Point end;
    double weight;
    
    public Edge(Point p1, Point p2) {
        this.start = p1;
        this.end = p2;
        this.weight = p1.distance(p2);
    }

    public int compareTo(Edge e) {
        if(this.weight > e.weight) return 1;
        else if(this.weight < e.weight) return -1;
        else return 0;
    }
}
