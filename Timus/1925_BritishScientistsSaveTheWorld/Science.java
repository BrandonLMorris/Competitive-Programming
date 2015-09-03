import java.util.*;

public class Science {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int k = in.nextInt();

    int screenTotal = 0;
    int inputTotal = 0;
    for (int i = 0; i < n; i++) {
      screenTotal += in.nextInt();
      inputTotal += in.nextInt();
    }

    int diff = screenTotal - inputTotal;
    //System.out.println("Difference btw screen and input: " + diff);
    int offset = diff - (n * 2);
    //System.out.println("How far we're off: " + offset);
    int result = offset + k - 2;
    //System.out.println("What we should put in: " + result);

    if (result < 0)
      System.out.println("Big Bang!");
    else
      System.out.println(result);
  }
}
