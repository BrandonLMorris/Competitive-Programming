import java.util.*;

public class Insomnia {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int k = input.nextInt();
    int l = input.nextInt();
    int m = input.nextInt();
    int n = input.nextInt();
    int numDragons = input.nextInt();
    int counter = 0;
    for (int i = 1; i <= numDragons; i++) {
      if (i % k == 0) counter++;
      else if (i % l == 0) counter++;
      else if (i % m == 0) counter++;
      else if (i % n == 0) counter++;
    }
    System.out.println(counter);
  }
}
