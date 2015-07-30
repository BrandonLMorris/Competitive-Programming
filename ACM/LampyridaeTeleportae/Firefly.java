import java.util.*;

public class Firefly {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (int t = 1;; t++) {
      int maxDist = input.nextInt();
      if (maxDist == 0) break;
      Point currentPos = new Point(input.nextInt(), input.nextInt());
      Point caughtAt = new Point(-1, -1);
      boolean didCatch = false;
      while (true) {
        Point p = new Point(input.nextInt(), input.nextInt());
        if (p.x == -1 && p.y == -1) break;
        if (!didCatch) {
          if (Math.hypot((p.x-currentPos.x), (p.y-currentPos.y)) <= (1+maxDist)) {
            caughtAt = p;
            didCatch = true;
          } else {
            currentPos = currentPos.moveTowards(p, maxDist);
            //System.out.println("Moved to: " + (int)currentPos.x + " " + (int)currentPos.y + " chasing " + (int)p.x + " " + (int)p.y);
          }
          //System.out.println("Current position: " + currentPos.x + " " + currentPos.y);
        }

      }

      if (didCatch) {
        System.out.println("Firefly "+t+" caught at ("+(int)caughtAt.x+","+(int)caughtAt.y+")");
      } else {
        System.out.println("Firefly "+t+" not caught");
      }
    }
  }


  private static class Point {

    double x;
    double y;

    public Point(double xArg, double yArg) {
      this.x = xArg;
      this.y = yArg;
    }

    public Point moveTowards(Point towards, double maxDist) {

      // Special case of infinite slope
      if (this.x == towards.x) {
        //System.out.println("Infinite slope encountered");
        return new Point(this.x, this.y > towards.y ? this.y - maxDist : this.y + maxDist);
      }

      double m = (towards.y - this.y) / (towards.x - this.x);

      double a = 1 + Math.pow(m, 2);
      double b = (-2)*this.x + (-2)*this.x*Math.pow(m,2);
      double c = Math.pow(this.x,2) + Math.pow(m, 2)*Math.pow(this.x, 2) - Math.pow(maxDist, 2);


      // Use quadratic formula to find where circle intersects line
      double firstX = ((-1)*b + Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a);
      double secondX = ((-1)*b - Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a);

      // Use the point of intersection on the side closer to where we're moving
      if ( Math.abs(firstX - towards.x) < Math.abs(secondX - towards.x) ) {
        double newY = m*firstX - m*this.x + this.y;
        //if (Math.hypot(this.x - firstX, this.y - newY) > maxDist) 
          //System.out.println("Something has gone horribly wrong");
          //System.out.println("\tMoved " + Math.hypot(this.x-firstX, this.y-newY));
        return new Point(firstX, newY);
      } else {
        double newY = m*secondX - m*this.x + this.y;
        //if (Math.hypot(this.x - secondX, this.y - newY) > maxDist) 
          //System.out.println("Something has gone horribly wrong");
          //System.out.println("\tMoved " + Math.hypot(this.x-secondX, this.y-newY));
        return new Point(secondX, newY);
      }

    }
  }
}
