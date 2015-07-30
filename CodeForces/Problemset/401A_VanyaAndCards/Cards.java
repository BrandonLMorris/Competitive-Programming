import java.util.*;

public class Cards {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numCards = input.nextInt();
    int maxVal = input.nextInt();

    int startVal = 0;
    for (int i = 0; i < numCards; i++) {
      startVal += input.nextInt();
    }

    int cardsNeeded = (int)Math.ceil(Math.abs(startVal) / (double)maxVal);

    System.out.println(cardsNeeded);
  }
}
