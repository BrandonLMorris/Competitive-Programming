import java.util.*;

public class Training {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    int m = input.nextInt();

    int teams = 0;

    teams = Math.min((n+m)/3, Math.min(m,n));

    //for (int i = 0; i <= m; i++) {
    //  int numTeams = Math.min(m - 2 * i, n - i);
    //  System.out.println("With " + i + " experienced teams, " + numTeams + " teams can be formed");
    //  teams = Math.max(teams, i + numTeams);
    //}

    System.out.println(teams);
  }
}
