import java.util.*;

/*
 * Reversed Binary Numbers
 * Kattis id: reversebinary
 */

public class Binary {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int num = in.nextInt();

    String bin = Integer.toBinaryString(num);

    String result = new StringBuffer(bin).reverse().toString();

    int resultInt = Integer.valueOf(result, 2);

    System.out.println(resultInt);

  }
}
