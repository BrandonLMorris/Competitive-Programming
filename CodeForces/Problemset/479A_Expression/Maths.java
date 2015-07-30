import java.util.*;

public class Maths {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numOnes = 0;
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();

    if (a == 1) {
      b++;
    }
    if (b == 1) {
      if (c < a) {
        c++;
      } else {
        a++;
      }
    }
    if (c == 1) {
      b++;
    }
    
    System.out.println(a*b*c);

  }
}
