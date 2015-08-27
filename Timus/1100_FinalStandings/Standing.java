import java.util.*;
import java.io.*;

public class Standing {
  public static void main(String[] args) throws Exception {
    //Scanner in = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer in;

    String line = reader.readLine();
    in = new StringTokenizer(line);
    int n = Integer.parseInt(in.nextToken());

    Team[] teams = new Team[n];
    for (int i = 0; i < n; i++) {
      line = reader.readLine();
      in = new StringTokenizer(line);
      teams[i] = new Team(Integer.parseInt(in.nextToken()), Integer.parseInt(in.nextToken()));
    }

    Arrays.sort(teams);

    for (Team t : teams) {
      System.out.println(t);
    }

  }

  private static class Team implements Comparable<Team> {
    int id;
    int score;

    public Team(int idArg, int scoreArg) {
      this.id = idArg;
      this.score = scoreArg;
    }

    public int compareTo(Team other) {
      return other.score - this.score;
    }

    public String toString() {
      return this.id + " " + this.score;
    }
  }
}

