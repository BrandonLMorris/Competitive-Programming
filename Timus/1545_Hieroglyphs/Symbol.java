import java.util.*;

public class Symbol {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());
    HashMap<Character, ArrayList<String>> hm = new HashMap<Character, ArrayList<String>>();

    for (int i = 0; i < n; i++) {
      String str = in.nextLine();
      char start = str.charAt(0);
      if (hm.get(start) == null) {
        hm.put(start, new ArrayList<String>());
      }
      hm.get(start).add(str);
    }

    char query = in.nextLine().charAt(0);
    if (hm.get(query) != null) {
      for (String str : hm.get(query)) {
        System.out.println(str);
      }
    }
  }
}
