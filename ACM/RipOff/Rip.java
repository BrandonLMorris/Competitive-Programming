import java.util.*;

public class Rip {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      int numSquares = input.nextInt();
      if (numSquares == 0) break;
      int maxSpaces = input.nextInt();
      int turnLimit = input.nextInt();
      int maxRebate = Integer.MIN_VALUE;
      int[] board = new int[numSquares];
      for (int i = 0; i < numSquares; i++) {
        board[i] = input.nextInt();
      }
      for (int i = 0; i < maxSpaces; i++) {
        int reb = rebate(board, i, turnLimit-1, board[i], numSquares, turnLimit, maxSpaces);
        if (reb > maxRebate)
          maxRebate = reb;
      }
      System.out.println(maxRebate);
    }
  }

  private static int rebate(int[] board, int curSq, int turnsLeft, int curRebate, int numSq, int turnLim, int maxSpace) {
    if (turnsLeft <= 1 && curSq + maxSpace < numSq + 1)
      return Integer.MIN_VALUE;
    int maxRebate = Integer.MIN_VALUE;
    for (int i = 1; i <= maxSpace; i++) {
      if(curSq+ i >= board.length) return curRebate;
      int reb = rebate(board, curSq + i, turnsLeft-1, curRebate+board[curSq+i], numSq, turnLim, maxSpace);
      if (reb > maxRebate)
        maxRebate = reb;
    }
    return maxRebate;
  }
}
