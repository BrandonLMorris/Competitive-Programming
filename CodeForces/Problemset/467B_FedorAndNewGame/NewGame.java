import java.util.*;

public class NewGame {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int types = input.nextInt();
    int numPlayers = input.nextInt() + 1;
    int mostDiff = input.nextInt();
    String[] players = new String[numPlayers];
    for (int i = 0; i < numPlayers; i++) {
      String str = Integer.toBinaryString(input.nextInt());
      while (str.length() < types) str = "0" + str;
      players[i] = str;
    }

    int numFriends = 0;
    for (int i = 0; i < numPlayers-1; i++) {
        int numDiffs = 0;
        for (int k = 0; k < types; k++) {
          if (players[i].charAt(k) != players[numPlayers-1].charAt(k))
            numDiffs++;
        }
        if (numDiffs <= mostDiff) numFriends++;
    }
    
    System.out.println(numFriends);
  }
}
