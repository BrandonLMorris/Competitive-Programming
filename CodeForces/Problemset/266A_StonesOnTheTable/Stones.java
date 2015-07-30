import java.util.*;

public class Stones {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numStones = Integer.parseInt(input.nextLine());
    char[] stones = input.nextLine().toCharArray();
    int i = 1;
    int counter = 0;
    while (i < stones.length) {
      if (stones[i] == stones[i-1]) {
        counter++;
      }
      i++;
    }
    System.out.println(counter);
  }
}
