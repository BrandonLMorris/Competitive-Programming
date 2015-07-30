import java.util.*;

public class Rock {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      String player1 = input.nextLine();
      String player2 = input.nextLine();
      if (player1.charAt(0) == 'E') break;
      int player1Wins = 0;
      int player2Wins = 0;
      for (int i = 0; i < player1.length(); i++) {
        char oneMove = player1.charAt(i);
        char twoMove = player2.charAt(i);
        if (oneMove == twoMove) {
          continue;
        }
        if (oneMove == 'R') {
          if (twoMove == 'S')
            player1Wins++;
          else player2Wins++;
        }
        if (oneMove == 'P') {
          if (twoMove == 'R')
            player1Wins++;
          else player2Wins++;
        }
        if (oneMove == 'S') {
          if (twoMove == 'P')
            player1Wins++;
          else player2Wins++;
        }
      }
      System.out.println("P1: " + player1Wins);
      System.out.println("P2: " + player2Wins);
    }
  }
}
