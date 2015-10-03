import java.util.*;

public class Tree {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int height = Integer.parseInt(in.next());
    long nodes = (long)Math.pow(2, height+1) - 1;

    if(!in.hasNext()) {
      System.out.println(nodes);
      return;
    }

    char[] directions = in.next().toCharArray();
    long pos = 0;
    for (char c : directions) {
      if (c == 'R') {
        pos = 2*pos + 2;
      } else {
        pos = 2*pos + 1;
      }
    }

    System.out.println(nodes - pos);
  }
}