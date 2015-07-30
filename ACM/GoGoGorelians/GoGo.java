import java.util.*;

public class GoGo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      int numPlanets = input.nextInt();
      if (numPlanets == 0) break;

      boolean[][] adjacency = new boolean[numPlanets][numPlanets];
      for (int i = 0; i < numPlanets; i++) {
        for (int j = 0; j < numPlanets; j++) {
          adjacency[i][j] = i == j ? true : false;
        }
      }

      ArrayList<Planet> planets = new ArrayList<Planet>();
      planets.add(new Planet(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt()));
      for (int i = 1; i < numPlanets; i++) {
        Planet p = new Planet(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
        double distance = Double.MAX_VALUE;
        Planet adjacent = null;
        for (Planet planet : planets) {
          double d = p.distance(planet);
          if (d < distance) {
            distance = d;
            adjacent = planet;
          }
        }
        planets.add(p);
        adjacency[i][planets.indexOf(adjacent)] = true;
        adjacency[planets.indexOf(adjacent)][i] = true;
      }

      int[][] W = new int[numPlanets][numPlanets];
      for (int i = 0; i < numPlanets; i++) {
        for (int j = 0; j < numPlanets; j++) {
          if (adjacency[i][j]) W[i][j] = 1;
          else W[i][j] = numPlanets;
        }
      }

      for (int k = 0; k < numPlanets; k++) {
        for (int i = 0; i < numPlanets; i++) {
          for (int j = 0; j < numPlanets; j++) {
            W[i][j] = Math.min(W[i][j], W[i][k] + W[k][j]);
          }
        }
      }

      int[] maxes = new int[numPlanets];
      for (int j = 0; j < numPlanets; j++) {
        int max = 0;
        for (int i = 0; i < numPlanets; i++) {
          max = Math.max(max, W[i][j]);
        }
        maxes[j] = max;
      }

      int min = Integer.MAX_VALUE;
      for (int i = 0; i < numPlanets; i++) {
        min = Math.min(min, maxes[i]);
      }

      ArrayList<Planet> results = new ArrayList<Planet>();
      for (int i = 0; i < numPlanets; i++) {
        if (maxes[i] == min)
          results.add(planets.get(i));
      }
      Collections.sort(results);

      String result = "";
      for (Planet p : results) {
        result += p.id + " ";
      }

      System.out.println(result.trim());

    }


  }

  private static class Planet implements Comparable<Planet> {
    int id;
    int x;
    int y;
    int z;

    public double distance(Planet p) {
      double xDiff = this.x - p.x;
      double yDiff = this.y - p.y;
      double zDiff = this.z - p.z;
      return Math.sqrt(xDiff*xDiff + yDiff*yDiff + zDiff*zDiff);
    }

    public Planet(int idArg, int xArg, int yArg, int zArg) {
      this.id = idArg;
      this.x = xArg;
      this.y = yArg;
      this.z = zArg;
    }

    public int compareTo(Planet p) {
      return this.id - p.id;
    }

  }

}
