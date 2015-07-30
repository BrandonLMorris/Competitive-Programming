import java.util.*;

public class Test {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numNums = input.nextInt();
    boolean[] evens = new boolean[numNums];
    for (int i = 0; i < numNums; i++) {
      evens[i] = input.nextInt() % 2 == 0;
    }
    int evenCount = 0;
    for (int i = 0; i < 3; i++) {
      evenCount += evens[i] ? 1 : 0;
    }
    if (evenCount >= 2) {
      // Majority of list is even. Find the oddball
      for (int i = 1; i <= numNums; i++) {
        if (!evens[i-1]) {
          System.out.println(i);
          return;
        }
      }
    } else {
      for (int i = 1; i <= numNums; i++) {
        if(evens[i-1]) {
          System.out.println(i);
          return;
        }
      }
    }
  }
}
