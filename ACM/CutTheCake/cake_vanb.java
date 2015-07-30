
import java.io.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Solution to Cake Cutting
 * 
 * Here's the key: Every line that crosses the circle creates one new section.
 * Every time a line crosses another line inside the circle, it creates one new section.
 * So, we've just got to count the number of lines that cross the circle
 * and the number of line intersections that are inside the circle.
 * 
 * @author vanb
 */
public class cake_vanb
{
    public Scanner sc;
    public PrintStream ps;
    
    /**
     * A Line, defined by two points.
     * 
     * @author vanb
     */
    public class Line
    {
        /** (x1,y1) and (x2,y2) */
        public int x1, y1, x2, y2;
        
        /**
         * Create a Line.
         * 
         * @param x1 X coord of first point
         * @param y1 Y coord of first point
         * @param x2 X coord of second point
         * @param y2 Y coors of second point
         */
        public Line( int x1, int y1, int x2, int y2 )
        {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        
        public String toString()
        {
            return "(" + x1 + "," + y1 + ") - (" + x2 + "," + y2 + ")";
        }
    }
    
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( System.in ); //new File( "cake.judge" ) );
        ps = System.out; //new PrintStream( new FileOutputStream( "cake.solution" ) );

        List<Line> lines = new LinkedList<Line>();
        
        HashSet<String> points = new HashSet<String>();
        
        int testcase = 0;
        for(;;)
        {
            double r = sc.nextDouble();
            double xc = sc.nextDouble();
            double yc = sc.nextDouble();
            int n = sc.nextInt();
            if( r<0.5 ) break;
            
            int intersectCircle = 0;
            int intersectInCircle = 0;


            ++testcase;
                       
            // We always start with 1 - that's the circle itself
            int count = 1;
            lines.clear();    
            for( int i=0; i<n; i++ )
            {
                // Read in a line
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();
                
                // Find the closest point on the line to the center point of the circle
                //
                // First, express the line parametrically:
                //     x = x1 + (x2-x1)*t, y = y1 + (y2-y1)*t
                // For convenience, we'll set dx=x2-x1, dy=y2-y1
                // So, the parametric equations for the line become:
                //     x = x1 + dx*t, y = y1 + dx*t
                // Note that when t=0, x=x1 and y=y1. When t=1, x=x2 and y=y2.
                // If we were only interested in the line segment, then 0<=t<=1
                // But, in this case, we're interested in the whole line.
                double dx = x2-x1;
                double dy = y2-y1;

                // OK, now a trick: the smallest distance will also be the smallest distance squared.
                // So, by minimizing distance squared instead of distance, we'll get the same
                // answer, but we won't have to deal with that messy square root.
                //
                // Now, plugging our parametric equations into the distance (squared) formula,
                // and doing some algebra, yields this, where (xc,yc) is the center of the circle:
                //     (dx^2+dy^2)*t^2 + 2*((x1-xc)*dx + (y1-yc)*dy)*t + (x1-xc)^2 + (y1-yc)^2
                // We want to minimize this. Well, it's a quadratic in t, so it forms a nice parabola.
                // The minimum will be at the bottom of the bowl, which is where the derivative is zero.
                // So, take the derivative, set it equal to zero.
                //
                //     2*(dx^2+dy^2)*t + 2*((x1-xc)*dx + (y1-yc)*dy) = 0
                //
                // Solve for t, and we get this:
                double t = -((x1-xc)*dx+(y1-yc)*dy) / (dx*dx+dy*dy);
                
                // Now, we can get the (x,y) by just plugging t back into our parametric equations
                double x = x1+dx*t;
                double y = y1+dy*t;
                
                // If the distance is less than the radius of the circle,
                // then the line enters the circle, and cuts it.
                // If not, then the line can be completely ignored.
                if( Math.abs( Math.hypot(yc-y,xc-x) - r ) < 0.01  )
                {
                    System.err.println( "PANIC! Test case " + testcase + " has a line tangent to the circle!" );
                }
                if( Math.hypot(yc-y,xc-x) < r )
                {
                    // Count it
                    ++count;
                    intersectCircle++;
                    
                    // Check for intersections with previous lines
                    for( Line line : lines )
                    {
                        // We'll use Cramer's Rule to find the intersection.
                        // Cramer's Rule sez that, given two linear equations:
                        //    a*x + b*y = c
                        //    d*x + e*y = f
                        // Then the intersection is:
                        //
                        //    |c b|      |a c|
                        //    |f e|      |d f|
                        //x = -----  y = -----
                        //    |a b|      |a b|
                        //    |d e|      |d e|
                        // 
                        // Where each of those little boxes is the determinant of a 2x2 matrix, like so:
                        //  |w x|
                        //  |y z| = w*z - y*x
                        //
                        // So,
                        //     c*e-f*b      a*f-d*c
                        // x = -------  y = -------
                        //     a*e-d*b      a*e-d*b
        
                        // Now, we've got to figure out a,b,c and d,e,f.
                        // We know that the equation of a line can be expressed as y = m*x + b, where m is the slope.
                        // m = (y2-y1)/(x2-x1). Multiplying by (x2-x1) gives us:
                        //    (x2-x1)*y = (y2-y1)*x + K (where K is some constant we're not worried about yet.)
                        // So, 
                        //    (y2-y1)*x - (x2-x1)*y = -K
                        // And flip the x's to change the sign, 
                        //    (y2-y1)*x + (x1-x2)*y = -K
                        //
                        // So, a=y2-y1, b=x1-x2, and we can find c by just plugging in one of the points.
                        long a = y2-y1;
                        long b = x1-x2;
                        long c = a*x1 + b*y1;
                        
                        // Do the same trick to find d,e,f from the other line
                        long d = line.y2-line.y1;
                        long e = line.x1-line.x2;
                        long f = d*line.x1 + e*line.y1;
                        
                        // If the denominator is 0, then the lines are parallel and don't intersect.
                        // Because we've kept everything as integers so far, we can directly compare with 0.
                        // No chance of roundoff error, no need for an epsilon.
                        long denom = a*e - b*d;
                        if( denom!=0 )
                        {
                            // Get the point of intersection, see if it's inside the circle.
                            x = (double)(c*e-f*b)/(double)denom;
                            y = (double)(a*f-d*c)/(double)denom;
                            if( Math.hypot(yc-y,xc-x) < r ){
                                ++count;
                                intersectInCircle++;
                            }
                            
                            if( Math.abs( Math.hypot(yc-y,xc-x) - r ) < 0.0001 )
                            {
                                System.err.println( "PANIC! Test case " + testcase + " has an intersection on the circle!" );   
                                System.err.println( "r=" + r + ", xc=" + xc + ", yc=" + yc + ", n=" + n );
                            }
                            String point = String.format( "%.2f %.2f", x, y );
                            if( points.contains( point ) ) 
                            {
                                System.err.println( "PANIC! Test case " + testcase + " has more than 2 lines intersecting at a single point!" );
                            }
                        }
                        else
                        {
                            if( d*x1 + e*y1 == f )
                            {
                                System.err.println( "PANIC! Test case " + testcase + " has coincident lines!" );                                
                            }
                        }
                    }
                    
                    // Add this line to the list of lines to compare future lines against
                    lines.add( new Line( x1, y1, x2, y2 ) );
                }
            }

            System.out.println(intersectCircle + " lines intersect the circle");
            System.out.println(intersectInCircle + " lines intersect in the circle");
            
            // Print the count!
            ps.println( count );
        }
    }
    
    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new cake_vanb().doit();                
    }   
}
