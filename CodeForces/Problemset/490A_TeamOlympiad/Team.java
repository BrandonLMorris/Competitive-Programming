import java.util.*;

public class Team {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numKids = input.nextInt();
    ArrayList<Integer> programmers = new ArrayList<Integer>();
    ArrayList<Integer> maths = new ArrayList<Integer>();
    ArrayList<Integer> jocks = new ArrayList<Integer>();
    for (int i = 1; i <= numKids; i++) {
      int next = input.nextInt();
      switch (next) {
        case 1: programmers.add(i); break;
        case 2: maths.add(i); break;
        case 3: jocks.add(i); break;
      }
    }

    int minTeams = Math.min(programmers.size(), Math.min(maths.size(),
          jocks.size()));
    System.out.println(minTeams);

    for (int i = 0; i < minTeams; i++) {
      System.out.println(programmers.get(i) + " " + maths.get(i) +
          " " + jocks.get(i));
    }
  }
}
