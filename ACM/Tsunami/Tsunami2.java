import java.util.*;

public class Tsunami2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numPoints = input.nextInt();
        for(;;) {
            if(numPoints == 0) break;

            HashSet<Point> connectedPoints = new HashSet<Point>();
            HashSet<Point> unconnectedPoints = new HashSet<Point>();
            ArrayList<Point> points = new ArrayList<Point>(numPoints);
            double counter = 0.0;

            //Store each point in an ArrayList, add to unconnectedPoints set
            for(int i = 0; i < numPoints; i++) {
                Point p = new Point(input.nextInt(), input.nextInt());
                points.add(p);
                unconnectedPoints.add(p);
            }

            //Sort the points based on y value, move root (base) from unconnected to connected
            Collections.sort(points);
            Point base = points.get(0);
            connectedPoints.add(base);
            unconnectedPoints.remove(base);

            for(int i = 1; i < points.size(); i++) {
                Point p = points.get(i);
                Iterator<Point> itr = connectedPoints.iterator();
                PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
                while(itr.hasNext()) {
                    Point con = itr.next();
                    pq.add(new Edge(con, p));
                }
                Edge edge = pq.poll();
                counter += edge.weight;
                connectedPoints.add(edge.p2);
                System.out.println("Connected points " + edge.p1.x + " " + edge.p1.y + " and " + edge.p2.x + " " + edge.p2.y + " for weight of " + edge.weight);
            }

            // while(!unconnectedPoints.isEmpty()) {
            //     PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
            //     Iterator<Point> connItr = connectedPoints.iterator();

            //     // //printout for debug
            //     // System.out.println("================================");
            //     // System.out.println("CONNECTED AND UNCONNECTED POINTS");
            //     // Iterator connectedItr = connectedPoints.iterator();
            //     // Iterator unconnectedItr = unconnectedPoints.iterator();
            //     // System.out.println("CONNECTED:");
            //     // while(connectedItr.hasNext()) {
            //     //     System.out.println(connectedItr.next());
            //     // }
            //     // System.out.println("UNCONNECTED:");
            //     // while(unconnectedItr.hasNext()) {
            //     //     System.out.println(unconnectedItr.next());
            //     // }

            //     //Connect every connected point to every connected point, as valid
            //     while(connItr.hasNext()) {
            //         Point conPt = connItr.next();
            //         Iterator<Point> unItr = unconnectedPoints.iterator();
            //         while(unItr.hasNext()) {
            //             Point unPt = unItr.next();
            //             //System.out.println("Comparing points " + conPt.x + " " + conPt.y + " and " + unPt.x + " " + unPt.y);
            //             if(conPt.compareTo(unPt) <= 0) {
            //                 pq.add(new Edge(conPt, unPt));
            //                 //System.out.println("DOES THIS CODE GET RUN?");
            //             } else{
            //                 //System.out.println("\tUnable to connect points " + conPt.x + " " + conPt.y + " and " + unPt.x + " " + unPt.y);
            //             }
            //         }
            //     }

            //     //if(pq.isEmpty()) System.out.println("PQ IS EMPTY");
            //     Edge e = pq.poll();
            //     unconnectedPoints.remove(e.p2);
            //     connectedPoints.add(e.p2);
            //     counter += e.weight;
            //     //System.out.println("\t\tConnected points " + e.p1.x + " " + e.p1.y + " and " + e.p2.x + " " + e.p2.y + " for weight of " + e.weight);

            // }

            System.out.printf("%.2f\n", counter);

            numPoints = input.nextInt();
        }
    }
}

class Point implements Comparable<Point>{
    public int x;
    public int y;

    //Orders first by y, then by x value
    public int compareTo(Point p) {
        if(this.y != p.y) {
            return ((Integer)this.y).compareTo(p.y);
        }
        return ((Integer)this.x).compareTo(p.y);
    }

    public Point(int xArg, int yArg) {
        this.x = xArg;
        this.y = yArg;
    }

    public String toString() {
        return this.x + " " + this.y;
    }
}

class Edge implements Comparable<Edge> {
    Point p1;
    Point p2;
    double weight;

    public Edge(Point point1, Point point2) {
        p1 = point1;
        p2 = point2;
        weight = Math.sqrt(Math.pow((p1.x - p2.x),2) + Math.pow((p1.y - p2.y),2));
    }

    public int compareTo(Edge e) {
        return (int)(this.weight - e.weight);
    }
}