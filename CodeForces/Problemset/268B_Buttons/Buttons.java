import java.util.*;

public class Buttons {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int counter = 0;
    for (int i = 1; i <= n-1; i++) {
      counter += (n-i)*i;
    }
    counter += n;
    System.out.println(counter);
  }
}
