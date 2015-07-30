import java.util.*;

public class Cake2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (;;) {
            double cRadius = (double)input.nextInt();
            double cX = (double)input.nextInt();
            double cY = (double)input.nextInt();
            int numLines = input.nextInt();
            Point cPoint = new Point(cX, cY);
            if(cRadius == 0 && cX == 0 && cY == 0 && numLines == 0) break;

            Line[] lines = new Line[numLines];
            for(int i = 0; i < numLines; i++) {
                lines[i] = new Line(input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble());
            }

            int numEnterCircle = 0;
            for(Line l : lines) {
                if(l.m == Integer.MAX_VALUE) {
                    if(distance(new Point(l.x1, cY), cPoint) < cRadius) {
                        numEnterCircle++;
                    }
                } else {
                    double A = 1 + Math.pow(l.m, 2);
                    double B = ((-2)*cX) + (2*l.m*l.b) - (2*l.m*cY);
                    double C = Math.pow(cX, 2) + Math.pow(l.b, 2) - (2*cY*l.b) + Math.pow(cY,2) - Math.pow(cRadius, 2);
                    if(Math.pow(B, 2) - (4*A*C) > 0) {
                        numEnterCircle++;
                        //System.out.println("Line " + l.x1 + " " + l.x2 + " enters the circle");
                    }
                }
            }
            //System.out.println(numEnterCircle + " lines enter the circle");


            int numIntersectInCirlce = 0;
            for (int i = 0; i < lines.length; i++) {
                for (int j = i + 1; j < lines.length; j++) {
                    Point intersect = lines[i].intersects(lines[j]);
                    if (intersect == null) continue;
                    double dist = distance(intersect, cPoint);
                    if(dist < cRadius)
                        numIntersectInCirlce++;
                }
            }
            //System.out.println(numIntersectInCirlce + " lines intersect inside the circle");

            System.out.println(numEnterCircle + numIntersectInCirlce + 1);

        }
    }

    private static double distance(Point p1, Point p2) {
        return Math.hypot(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
    }
}

class Line {
    double x1;
    double y1;
    double x2;
    double y2;

    double m; //Slope of the line, created by rise-over-run (edge of infinite slope)
    double b; //b in the mx+b; equal to mx1 + y1

    public Line(double x1arg, double y1arg, double x2arg, double y2arg) {
        this.x1 = x1arg;
        this.x2 = x2arg;
        this.y1 = y1arg;
        this.y2 = y2arg;

        if (x2 - x1 != 0) {
            this.m = (y2 - y1) / (x2 - x1);
            this.b = (-1)*(m * x1) + y1;
        } else {
            this.m = Integer.MAX_VALUE;
            this.b = Integer.MAX_VALUE;
        }
    }

    //Returns null if both lines are vertical, or if both lines are parallel
    public Point intersects(Line l) {
        double intX;
        double intY;
        if (this.m == Integer.MAX_VALUE && l.m == Integer.MAX_VALUE)
            return null;
        else if (this.m == l.m)
            return null;
        else if (this.m == Integer.MAX_VALUE) {
            return new Point(this.x1, l.yAt(this.x1));
        } else if (l.m == Integer.MAX_VALUE) {
            return new Point(l.x1, this.yAt(l.x1));
        }
        intX = (l.b - this.b) / (this.m - l.m);
        return new Point(intX, this.yAt(intX));
    }

    public double yAt(double x) {
        if (this.m != Integer.MAX_VALUE) {
            return (this.m * x) + this.b;
        }
        return Integer.MAX_VALUE;
    }

}

class Point {
    double x;
    double y;

    public Point(double xArg, double yArg) {
        this.x = xArg;
        this.y = yArg;
    }
}
