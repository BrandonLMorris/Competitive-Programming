import java.util.*;
//Number of sections = number of lines that go into the circle + number of lines that intersect inside the circle + 1

//How many lines go into the circle?
    //From x = center - radius to x = center + radius, does the line come within radius of center in y direction?
//How many lines intersect inside the circle?
    //Is point of intersection within radius distance of the center of the circle?

public class Cake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for(;;){
            int circleRadius = input.nextInt();
            int circleX = input.nextInt();
            int circleY = input.nextInt();
            int numLines = input.nextInt();
            Point circlePoint = new Point(circleX, circleY);
            //System.out.println("New Test: " + circleRadius + " " + circleX + " " + circleY + " " + numLines);
            if(circleRadius == 0 && circleX == 0 && circleY == 0 && numLines == 0) break;

            Line[] lines = new Line[numLines];

            for(int i = 0; i < numLines; i++) {
                lines[i] = new Line(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
            }

            int numEnterCircle = 0;
            for(Line line : lines) {
                //System.out.println("New line");
                // double yVal;
                // Point testPoint;
                // if(line.slope == Integer.MAX_VALUE) {
                //     //Infite slope: only defined at one x-value
                //     if(line.x1 > circleX - circleRadius && line.x1 < circleX + circleRadius) {
                //         numEnterCircle++;
                //         //System.out.println("Infinite slope encountered, added");
                //     }
                // } else {
                //     //Check points along line from lowest x to highest possible x, increment by factor of distance away from circle
                //     for(double x = circleX - circleRadius; x < circleX + circleRadius; x += Math.max(((distance(testPoint, circlePoint) - circleRadius)*0.001), 0.0001)) {
                //         testPoint = new Point(x, line.yAt(x));
                //         if(distance(testPoint, circlePoint) < circleRadius) {
                //             numEnterCircle++;
                //             break;
                //         }
                //         //System.out.println("Help, I'm trapped! " + x);
                //     }
                // }

                // double m = line.slope;
                // double A = 1 + Math.pow(line.slope, 2);
                // double B = circleX - (2*Math.pow(m, 2)*line.x1) + (2*m*line.y1) - (m*circleY);
                // double C = Math.pow(circleX, 2) + (Math.pow(m,2)*Math.pow(line.x1,2)) - (2*m*line.x1*line.y1) + Math.pow(line.y1,2) - (m*line.x1*circleY) + (line.y1*circleY) - Math.pow(circleRadius, 2);
                // if(Math.pow(B, 2) - (4*A*C) >= 0) {
                //     numEnterCircle++;
                //     System.out.println("Line " + line.x1 + " " + line.y1 + " intersects the circle");
                // }

                double m = line.slope;
                double q = (m*line.x1) + line.y1 - circleY;
                if( 4*Math.pow((m*q) - circleX, 2) - (4 * (1 - Math.pow(m, 2)) * (Math.pow(circleX, 2) + Math.pow(q, 2) - Math.pow(circleRadius, 2))) >= 0) {
                    numEnterCircle++;
                    //System.out.println("Line " + line.x1 + " " + line.y1 + " intersects the circle");
                }  

            }

            System.out.println(numEnterCircle + " lines enter circle");

            int numIntersectInCircle = 0;

            for(int i = 0; i < lines.length; i++) {
                for(int j = i + 1; j < lines.length; j++) {
                    Point intersect = lines[i].intersection(lines[j]);
                    if (intersect == null) continue;
                    System.out.println("Intersect at " + intersect.x + " " + intersect.y);
                    //if(intersect.x != Integer.MAX_VALUE) {  //Ensures the lines are not parallel
                        double dist = distance(intersect, circlePoint);
                        System.out.println("Distance of " + dist);
                        if(dist < circleRadius) {
                            numIntersectInCircle++;
                        }
                    //}
                }
            }

            System.out.println(numIntersectInCircle + " intersect in the circle");

            System.out.println(numEnterCircle + numIntersectInCircle + 1);

        }
    }

    public static double distance(Point p1, Point p2) {
        return Math.hypot(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
    }
}

class Line {
    int x1;
    int y1;
    int x2;
    int y2;

    //Used to turn points into equation of form Ax + By = C
    int a;
    int b;
    int c;

    double slope;
    double lineB;

    public Line(int x1Arg, int y1Arg, int x2Arg, int y2Arg) {
        this.x1 = x1Arg;
        this.y1 = y1Arg;
        this.x2 = x2Arg;
        this.y2 = y2Arg;

        this.a = y2 - y1;
        this.b = x1 - x2;
        this.c = (this.a * x1) + (this.b * y1);


        if((this.x2 - this.x1) != 0) {
            this.slope = (double)this.a / this.b;
        } else {
            this.slope = Integer.MAX_VALUE;
        }

        if (this.slope != Integer.MAX_VALUE) {
            this.lineB = (this.slope * this.x1) + this.y1;
        } else {
            this.lineB = Integer.MAX_VALUE;
        }
    }

    public Point intersection(Line l) {
        double intX;
        double intY;

        //int det = (this.a * l.b) - (l.a * this.b);
        ////Lines are parallel if determinant is 0
        //if(det == 0) return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);

        //double intX = ((l.b * this.c) - (this.b * l.c)) / det;
        //double intY = ((this.a * l.c) - (l.a * this.c)) / det;
        if (this.slope == Integer.MAX_VALUE && l.slope == Integer.MAX_VALUE) {
            return null;
        }
        if (this.slope == Integer.MAX_VALUE) {
            intX = this.x1;
            intY = l.yAt(this.x1);
            return new Point(intX, intY);
        } else if (l.slope == Integer.MAX_VALUE) {
            intX = l.x1;
            intY = this.yAt(l.x1);
            return new Point(intX, intY);
        }
        if (this.slope == l.slope) return null;
        intX = (l.lineB - this.lineB) / (this.slope - l.slope);
        intY = this.yAt(intX);
        return new Point(intX, intY);
    }

    public double yAt(double xArg) {
        //Edge case of B == 0 (infinite slope)
        if(this.b == 0) {
            //Line has infinite slope, only defined at one x value
            //Return max value if defined at that point, min value otherwise
            if(xArg == this.x1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return (this.c - (this.a * xArg)) / this.b;
    }

    public double xAt(double yArg) {
        //Edge case of A == 0 (no slope)
        if(this.a == 0) {
            if(yArg == this.y1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return (this.c - (this.b * yArg)) / this.a;
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
