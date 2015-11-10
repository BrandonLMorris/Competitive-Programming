import java.util.*;
import java.io.*;

public class Scoring {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    boolean[] solved = new boolean[26];
    int[] times = new int[26];

    while (true) {
      String line = in.readLine();
      if (line.equals("-1")) break;
      st = new StringTokenizer(line);
      int time = Integer.parseInt(st.nextToken());
      char letter = st.nextToken().charAt(0);
      boolean didSolve = st.nextToken().equals("right");
      solved[letter-'A'] = didSolve;
      if (solved[letter-'A']) {
        times[letter - 'A'] += time;
      } else {
        times[letter - 'A'] += 20;
      }
    }

    // Print the result
    int solveCount = 0;
    int timeCount = 0;
    for (int i = 0; i < 26; i++) {
      if (solved[i]) {
        solveCount++;
        timeCount += times[i];
      }
    }
    System.out.println(solveCount + " " + timeCount);
  }
}