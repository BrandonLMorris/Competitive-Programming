import java.util.*;
import java.io.*;

public class Words {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    ArrayList<String> first = new ArrayList<String>(100);

    while (true) {
      String line = in.readLine();
      if (line == null) break;
      st = new StringTokenizer(line);
      while (st.hasMoreTokens()) {
        first.add(st.nextToken());
      }
      st = new StringTokenizer(in.readLine());
      while (st.hasMoreTokens()) {
        first.add(st.nextToken());
      }
    }

    ArrayList<String> result = new ArrayList<String>();
    HashSet<String> hs = new HashSet<String>();
    for (int i = 0; i < first.size(); i++) {
      for (int j = i+1; j < first.size(); j++) {
        if (!hs.contains(first.get(i) + first.get(j))) {
          result.add(first.get(i) + first.get(j));
          hs.add(first.get(i) + first.get(j));
        }
        if (!hs.contains(first.get(j) + first.get(i))) {
          result.add(first.get(j) + first.get(i));
          hs.add(first.get(j) + first.get(i));
        }
      }
    }

    Collections.sort(result);
    for (String s : result) {
      System.out.println(s);
    }

  }
}