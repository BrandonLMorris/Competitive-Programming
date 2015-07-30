import java.util.*;

public class Digits {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();

    int fiveCount = 0;
    int zeroCount = 0;

    for (int i = 0; i < n; i++) {
      int x = input.nextInt();
      if (x == 5) fiveCount++;
      else zeroCount++;
    }

    if (zeroCount == 0) {
      System.out.println(-1);
      return;
    }

    if (fiveCount < 9) {
      System.out.println(0);
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < fiveCount / 9; i++) {
      sb.append("555555555");
    }

    for (int i = 0; i < zeroCount; i++) {
      sb.append("0");
    }

    System.out.println(sb.toString());
  }
}
