import java.util.*;
import java.io.*;

public class Meta {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb;

    HashMap<String, Integer> hm = new HashMap<String, Integer>();

    for (;;) {
      String line = in.readLine();
      if (line == null) break;

      st = new StringTokenizer(line);
      if (st.nextToken().equals("define")) {
        int x = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        sb.append(st.nextToken());
        while (st.hasMoreTokens()) {
          sb.append(" ");
          sb.append(st.nextToken());
        }

        hm.put(sb.toString(), x);
      } else {
        sb = new StringBuilder();
        String current = st.nextToken();
        sb.append(current);
        current = st.nextToken();
        while (!current.equals(">") && !current.equals("<") && !current.equals("=")) {
          sb.append(" ");
          sb.append(current);
          current = st.nextToken();
        }
        String first = sb.toString();
        String operator = current;
        sb = new StringBuilder();
        sb.append(st.nextToken());
        while (st.hasMoreTokens()) {
          sb.append(" ");
          sb.append(st.nextToken());
        }
        String second = sb.toString();
        if (hm.get(first) == null || hm.get(second) == null) {
          System.out.println("undefined");
          continue;
        }
        if (operator.equals("<")) {
          if (hm.get(first) < hm.get(second)) {
            System.out.println("true");
          } else {
            System.out.println("false");
          }
        } else if (operator.equals(">")) {
          if (hm.get(first) > hm.get(second)) {
            System.out.println("true");
          } else {
            System.out.println("false");
          }
        } else {
          if (hm.get(first) == hm.get(second)) {
            System.out.println("true");
          } else {
            System.out.println("false");
          }
        }
      }

    }
  }
}