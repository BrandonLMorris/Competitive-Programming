import java.util.*;
import java.io.*;

public class Hiding {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[][] moves = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      /* True means can visit, false means can't */
      boolean[][] board = new boolean[8][8];
      String startPos = in.readLine();
      int startX = startPos.charAt(0) - 'a';
      int startY = startPos.charAt(1) -  '0' - 1;
      board[startX][startY] = true;
      Pair start = new Pair(startX, startY);
      LinkedList<Pair> q = new LinkedList<Pair>();
      q.addLast(start);

      int[][] numJumps = new int[8][8];
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          numJumps[i][j] = -1;
        }
      }

      numJumps[startX][startY] = 0;

      // BFS!!!BFS!!!
      while (!q.isEmpty()) {
        Pair current = q.removeFirst();
        board[current.first][current.second] = true;

        for (int[] m : moves) {
          if (inBounds(current.first+m[0], current.second+m[1])) {
            if (!board[current.first+m[0]][current.second+m[1]]) {
              q.addLast(new Pair(current.first+m[0], current.second+m[1]));
              numJumps[current.first+m[0]][current.second+m[1]] = 1 + numJumps[current.first][current.second];
            }
          }
        }
      }


      // Find the maximum number of jumps
      int maxJumps = 0;
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          if (maxJumps < numJumps[i][j])
            maxJumps = numJumps[i][j];
        }
      }

      // Record all the spots with that max jumps
      ArrayList<Pair> spots = new ArrayList<Pair>(64);
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          if (numJumps[i][j] == maxJumps) {
            spots.add(new Pair(i, j));
          }
        }
      }

      // Sort based of their silly ordering
      Collections.sort(spots);

      // Print result
      System.out.print(maxJumps);
      for (Pair p : spots) {
        char x = (char)(p.first + 'a');
        int y = p.second + 1;
        System.out.print(" " + x + y);
      }
      System.out.println();

    }
  }

  private static boolean inBounds(int x, int y) {
    return (x >= 0 && x < 8 && y >= 0 && y < 8);
  }

  private static class Pair implements Comparable<Pair> {
    int first;
    int second;
    public Pair(int x, int y) {
      this.first = x;
      this.second = y;
    }
    public int compareTo(Pair other) {
      if (this.second != other.second) {
        return other.second - this.second;
      } else {
        return this.first - other.first;
      }
    }
  }
}