import java.util.*;

public class Apple {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long num = input.nextLong();
    long score = 0;

    long[] numbers = new long[(int)num];
    for (int i = 0; i < num; i++) {
      numbers[i] = input.nextLong();
    }

    Arrays.sort(numbers);

    for (int i = 0; i < num - 1; i++) {
      score += (i+2)*numbers[i];
    }
    score += num * numbers[(int)num-1];

    System.out.println(score);
  }
}
