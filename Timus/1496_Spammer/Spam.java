import java.util.*;

public class Spam {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());
    ArrayList<String> spammers = new ArrayList<String>();
    HashSet<String> hs = new HashSet<String>();

    for (int i = 0; i < n; i++) {
      String team = in.nextLine();
      if (!hs.contains(team)) {
        hs.add(team);
      } else if (!spammers.contains(team)) {
        spammers.add(team);
      }
    }

    for (String s : spammers) {
      System.out.println(s);
    }
  }
}
