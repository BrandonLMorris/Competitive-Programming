import java.util.*;

public class Lecture {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = Integer.parseInt(input.next());
    int m = Integer.parseInt(input.next());

    HashMap<String, String> hm = new HashMap<String, String>();

    for (int i = 0; i < m; i++) {
      String s1 = input.next();
      String s2 = input.next();
      String shorter = "";

      if (s1.length() > s2.length()) {
        hm.put(s1, s2);
        hm.put(s2, s2);
      } else {
        hm.put(s1, s1);
        hm.put(s2, s1);
      }

    }

    String[] lecture = new String[n];
    for (int i = 0; i < n; i++) {
      lecture[i] = hm.get(input.next());
    }

    for (int i = 0; i < n-1; i++) {
      System.out.print(lecture[i] + " ");
    }
    System.out.println(lecture[n-1]);
  }
}
