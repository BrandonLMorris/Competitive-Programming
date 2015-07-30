import java.util.*;

public class Football {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] players = input.nextLine().toCharArray();
    int currentCount = 1;
    int maxCount = 1;
    char currentTeam = players[0];
    for (int i = 1; i < players.length; i++) {
      if (players[i] == currentTeam) {
        currentCount++;
        if (currentCount > maxCount) {
          maxCount = currentCount;
        }
      } else {
        currentCount = 1;
        currentTeam = players[i];
      }
    }
    System.out.println((maxCount >= 7) ? "YES" : "NO");
  }
}
