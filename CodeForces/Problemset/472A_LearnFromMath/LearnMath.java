import java.util.*;

public class LearnMath {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int num1 = num - 1;
    int num2 = 1;
    while (!isComposite(num1) || !isComposite(num2)) {
      num1--;
      num2++;
    }

    System.out.println(num1 + " " + num2);
  }

  public static boolean isComposite(int number) {
    if (number == 1) return false;
    if (number == 2) return false;
    for (int i = 2; i*i <= number; i++) {
      if (number % i == 0) return true;
    }
    return false;
  }
}
