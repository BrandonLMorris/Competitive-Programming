/**
 * Polar Angles
 * HackerRank :: Algorithms :: Arrays and Sorting
 * Created by Brandon Morris 11/6/2014
 */
import java.util.*;

public class PolarAngles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        ArrayList<Point> pointList = new ArrayList<Point>(numCases);
        for(int i = 0; i < numCases; i++) {
            pointList.add(new Point(input.nextDouble(), input.nextDouble()));
        }
        Collections.sort(pointList);
        for(Point p : pointList) {
            System.out.println(p.x + " " + p.y + " " + p.theta);
        }
    }
} 

class Point implements Comparable<Point> { 
    double x;
    double y;
    double theta;
    double r;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.theta = Math.atan2(x, y);
        this.r = Math.sqrt((x*x + y*y));
    }

    //@Override
    public int compareTo(Point p2) {
        if(this.theta != p2.theta) {
            if(this.theta > p2.theta) {
                return 1;
            } else {
                return -1;
            }
        } else {
            if(this.r > p2.r) {
                return 1;
            } else if(this.r < p2.r) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

