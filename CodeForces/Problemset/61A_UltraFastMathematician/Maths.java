import java.util.*;

public class Maths {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] num1Char = input.nextLine().toCharArray();
    char[] num2Char = input.nextLine().toCharArray();
    int[] num1 = new int[num1Char.length];
    int[] num2 = new int[num2Char.length];
    for (int i = 0; i < num1Char.length; i++) {
      num1[i] = num1Char[i] == '1' ? 1 : 0;
      num2[i] = num2Char[i] == '2' ? 1 : 0;
    }

    int[] sum = new int[num1.length];
    for (int i = 0; i < sum.length; i++) {
      sum[i] = num1Char[i] == num2Char[i] ? 0 : 1;
    }

    // Print result
    for (int i = 0; i < num1.length; i++) {
      System.out.print(sum[i]);
    }
    System.out.println();
  }
}
