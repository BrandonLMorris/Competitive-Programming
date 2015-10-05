import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class IntList {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      char[] instructions = in.readLine().toCharArray();
      int listSize = Integer.parseInt(in.readLine());
      int[] lst = new int[listSize];
      String line = in.readLine();
      int pos = 0;
      for (int i = 0; i < lst.length; i++) {
        if (line.charAt(pos) == ',' || line.charAt(pos) == '[') pos++;
        StringBuilder sb = new StringBuilder();
        while (pos < line.length() && line.charAt(pos) != ',' && line.charAt(pos) != ']') {
          sb.append(line.charAt(pos));
          pos++;
        }
        lst[i] = Integer.parseInt(sb.toString());
      }


      boolean isPossible = true;
      int size = lst.length;
      boolean isReversed = false;

      int head = 0;
      int tail = lst.length-1;

      for (char c : instructions) {
        if (c == 'D') {
          size--;
          if (isReversed) {
            tail--;
          } else {
            head++;
          }
          if (size < 0) {
            isPossible = false;
          }
        }
        if (c == 'R') {
          isReversed = !isReversed;
        }

        if (!isPossible) break;
      }

      if (!isPossible) {
        System.out.println("error");
        continue;
      }

      ArrayList<Integer> result = new ArrayList<Integer>();
      if (!isReversed) {
        while (head <= tail) {
          result.add(lst[head++]);
        }
      } else {
        while (tail >= head) {
          result.add(lst[tail--]);
        }
      }

      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for (int i = 0; i < result.size(); i++) {
        sb.append(result.get(i));
        if (i < result.size() - 1) {
          sb.append(",");
        }
      }
      sb.append("]");

      System.out.println(sb.toString());

    }
  }
}