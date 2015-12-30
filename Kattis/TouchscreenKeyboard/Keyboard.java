import java.util.*;
import java.io.*;

public class Keyboard {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    char[][] keyboard = {
      {'q','w','e','r','t','y','u','i','o','p'},
      {'a','s','d','f','g','h','j','k','l'},
      {'z','x','c','v','b','n','m'}
    };

    TreeMap<String, Integer> dist = new TreeMap<String, Integer>();
    for (int y = 0; y < keyboard.length; y++) {
      for (int x = 0; x < keyboard[y].length; x++) {
        for (int i = 0; i < keyboard.length; i++) {
          for (int j = 0; j < keyboard[i].length; j++) {
            dist.put("" + keyboard[y][x] + keyboard[i][j],
                Math.abs(y - i) + Math.abs(x - j));
          }
        }
      }
    }

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      String line = in.readLine();
      st = new StringTokenizer(line);
      char[] start = st.nextToken().toCharArray();
      int n = Integer.parseInt(st.nextToken());

      ArrayList<Pair> lst = new ArrayList<Pair>();
      for (int i = 0; i < n; i++) {
        int count = 0;
        char[] end = in.readLine().toCharArray();
        for (int j = 0; j < start.length; j++) {
          count += dist.get("" + start[j] + end[j]);
        }
        // System.out.println(new String(end) + " " + count);
        lst.add(new Pair(new String(end), count));
      }

      Collections.sort(lst);

      for (Pair p : lst) {
        System.out.println(p.s + " " + p.i);
      }
    }
  }

  private static class Pair implements Comparable<Pair> {
    String s;
    int i;

    public Pair(String s, int i) {
      this.s = s;
      this.i = i;
    }

    public int compareTo(Pair other) {
      if (this.i != other.i) {
        return this.i - other.i;
      }
      return this.s.compareTo(other.s);
    }
  }
}
