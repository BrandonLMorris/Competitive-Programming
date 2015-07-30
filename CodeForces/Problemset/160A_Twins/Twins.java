import java.util.*;

public class Twins {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numCoins = input.nextInt();
    int[] coins = new int[numCoins];
    for (int i = 0; i < numCoins; i++) {
      coins[i] = input.nextInt();
    }
    Arrays.sort(coins);
    int coinCounter = 1;
    int mySum = coins[coins.length-1];
    int otherSum = 0;
    for (int i = 0; i < coins.length-1; i++) {
      otherSum += coins[i];
    }
    int j = coins.length - 1;
    while (mySum <= otherSum) {
      j--;
      mySum += coins[j];
      otherSum -= coins[j];
      coinCounter++;
    }
    System.out.println(coinCounter);
  }
}
