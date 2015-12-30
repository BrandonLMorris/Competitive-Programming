import java.util.*;
import java.io.*;

public class Sorta {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    boolean first = true;
    while (true) {
      int n = Integer.parseInt(in.readLine());
      if (n == 0) break;
      if (first) {
        first = false;
      } else {
        System.out.println();
      }

      ArrayList<Name> names = new ArrayList<Name>();
      for (int i = 0; i < n; i++) {
        names.add(new Name(in.readLine()));
      }
      Collections.sort(names);
      for (Name na : names) {
        System.out.println(na.str);
      }
    }
  }

  private static class Name implements Comparable<Name> {
    String str;
    public Name(String s) {
      str = s;
    }
    public int compareTo(Name other) {
      return this.str.substring(0,2).compareTo(other.str.substring(0,2));
    }
  }
}
