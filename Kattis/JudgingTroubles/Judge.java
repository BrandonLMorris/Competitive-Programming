import java.util.*;

public class Judge {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());

    ArrayList<String> results = new ArrayList<String>();
    HashMap<String, Integer> katCount = new HashMap<String, Integer>();
    HashMap<String, Integer> domCount = new HashMap<String, Integer>();
    ArrayList<String> keys = new ArrayList<String>();

    for (int i = 0; i < 2*n; i++) {
      String str = in.nextLine();
      results.add(str);
      if (katCount.get(str) == null) {
        katCount.put(str, 0);
        domCount.put(str, 0);
        keys.add(str);
      }
    }

    for (int i = 0; i < 2*n; i++) {
      if (i < n) {
        katCount.put(results.get(i), katCount.get(results.get(i))+1);
      } else {
        domCount.put(results.get(i), domCount.get(results.get(i))+1);
      }
    }

    int counter = 0;
    for (int i = 0; i < keys.size(); i++) {
      String str = keys.get(i);
      counter += Math.min(katCount.get(keys.get(i)), domCount.get(keys.get(i)));
    }
    System.out.println(counter);
  }
}
