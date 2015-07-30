import java.util.*;

public class Horse {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    HashSet<Long> hs = new HashSet<Long>();
    for (int i = 0; i < 4; i++) {
      hs.add(input.nextLong());
    }
    System.out.println(4 - hs.size());
  }
}
