import java.util.*;

public class Dice {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int a = input.nextInt();
    int b = input.nextInt();

    int aWin = 0;
    int bWin = 0;
    int draw = 0;

    for (int i = 1; i <= 6; i++) {
      if (Math.abs(a - i) < Math.abs(b - i))
        aWin++;
      else if (Math.abs(b - i) < Math.abs(a - i))
        bWin++;
      else
        draw++;
    }

    System.out.println(aWin + " " + draw + " " + bWin);

  }
}
