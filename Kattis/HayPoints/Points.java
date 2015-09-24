import java.util.*;

public class Points {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int m = Integer.parseInt(in.next());
    int n = Integer.parseInt(in.next());

    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    for (int i = 0; i < m; i++) {
      hm.put(in.next(), Integer.parseInt(in.next()));
    }

    for (int i = 0; i < n; i++) {
      int points = 0;
      String word = in.next();
      while (!word.equals(".")) {
        if (hm.containsKey(word)) {
          points += hm.get(word);
        }
        word = in.next();
      }

      System.out.println(points);
    }

  }
}