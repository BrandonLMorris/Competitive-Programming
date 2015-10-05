import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Compromise {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      st = new StringTokenizer(in.readLine());
      int numLines = Integer.parseInt(st.nextToken());
      int numIssues = Integer.parseInt(st.nextToken());

      char[][] issues = new char[numLines][numIssues];
      for (int i = 0; i < numLines; i++) {
        issues[i] = in.readLine().toCharArray();
      }

      StringBuilder sb = new StringBuilder();
      boolean tieBroken = false;
      for (int j = 0; j < numIssues; j++) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < numLines; i++) {
          if (issues[i][j] == '0') {
            zeroCount++;
          } else {
            oneCount++;
          }
        }
        if (zeroCount > oneCount) {
          sb.append(0);
        } else if (oneCount > zeroCount) {
          sb.append(1);
        } else {
          sb.append((tieBroken ? 1 : 0));
          tieBroken = !tieBroken;
        }
      }

      System.out.println(sb.toString());
    }
  }
}