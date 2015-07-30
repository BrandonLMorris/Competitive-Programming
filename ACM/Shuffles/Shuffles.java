import java.util.*;

public class Shuffles {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numCards = input.nextInt();
    int[] deck = new int[numCards+1];
    for (int i = 0; i < numCards; i++) {
      deck[input.nextInt()] = i+1;
    }
    int breakCount = 1;
    for (int i = 1; i < numCards; i++) {
      if (deck[i] > deck[i+1]) {
        breakCount++;
      }
    }
    //System.out.println("breakCount = " + breakCount);
    int shuffleCount = (int) Math.ceil(Math.log(breakCount)/Math.log(2));
    System.out.println(shuffleCount);
  }
}
