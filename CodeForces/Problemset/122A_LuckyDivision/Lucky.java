import java.util.*;

public class Lucky {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();

    for (int i = 1; i <= num; i++) {
      if (num % i == 0) {
        char[] numStr = Integer.toString(i).toCharArray();
        boolean isLucky = true;
        for (char c : numStr) {
          if (c != '4' && c != '7') {
            isLucky = false;
          }
        }
        if (isLucky) {
          System.out.println("YES");
          return;
        }
      }
    }
    System.out.println("NO");
  }
}
