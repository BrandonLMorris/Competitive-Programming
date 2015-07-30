import java.util.*;

public class Game {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    ArrayList<Integer> cards = new ArrayList<Integer>(n);
    for (int i = 0; i < n; i++) {
      cards.add(input.nextInt());
    }

    int a = 0;
    int b = 0;

    int i = 0;
    while (cards.size() > 0) {
      int first = cards.get(0);
      int last = cards.get(cards.size() - 1);
      int removed = 0;
      if (first > last) {
        removed = first;
        cards.remove(0);
      } else {
        removed = last;
        cards.remove(cards.size()-1);
      }
      if (i % 2 == 0) {
        a += removed;
      } else {
        b += removed;
      }
      i++;
    }
    System.out.println(a + " " + b);
  }
}
