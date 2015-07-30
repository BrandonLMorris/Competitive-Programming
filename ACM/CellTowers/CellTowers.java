import java.util.*;

public class CellTowers {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      int numTowers = input.nextInt();
      if (numTowers == 0) break;
      int numSegments = input.nextInt();
      Tower[] towers = new Tower[numTowers];
      Point[] road = new Point[numSegments+1];
      StringBuilder result = new StringBuilder();

      //Input the towers
      for (int i = 0; i < numTowers; i++) {
        int xPos = input.nextInt();
        int yPos = input.nextInt();
        int pow = input.nextInt();
        towers[i] = new Tower((char)(i+'A'), xPos, yPos, pow);
      }

      //Input the road points
      for (int i = 0; i < numSegments+1; i++) {
        road[i] = new Point(input.nextInt(), input.nextInt());
      }




      Tower currentTower = null;
      //Go through each point on the road
      for (int i = 0; i < road.length; i++) {
        System.out.println("At point " + road[i].x + " " + road[i].y);
        Tower closestTower = towers[0];
        //Find best signal at that point
        for (int j = 0; j < towers.length; j++) {
          if (towers[j].getSignal(road[i]) > closestTower.getSignal(road[i])) {
            closestTower = towers[j];
          }
        }
        //Update result if neccessary
        if (closestTower != currentTower) {
          System.out.println("Signal of tower " + closestTower.label + " " + closestTower.getSignal(road[i]));
          if (currentTower != null)
          System.out.println("Signal of tower " + currentTower.label + " " + currentTower.getSignal(road[i]));
          result.append("(" + (i+1) + ", " + closestTower.label + ") ");
          currentTower = closestTower;
        }

        System.out.println("Closest tower is " + closestTower.label);
      }


      System.out.println(result.toString());
    }
  }
}

class Tower {
  char label;
  Point position;
  int power;

  public Tower(char labelArg, int xArg, int yArg, int powerArg) {
    this.label = labelArg;
    this.position = new Point(xArg, yArg);
    this.power = powerArg;
  }

  public int getSignal(Point p) {
    double xDist = Math.abs(position.x - p.x);
    double yDist = Math.abs(position.y - p.y);
    double distance = Math.hypot(xDist, yDist);
    return (int)Math.round(power / Math.pow(distance, 2));
  }
}

class Point {
  double x;
  double y;
  public Point(int xArg, int yArg) {
    this.x = xArg;
    this.y = yArg;
  }
}
