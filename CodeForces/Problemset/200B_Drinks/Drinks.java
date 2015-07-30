import java.util.*;

public class Drinks {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    double counter = 0.0;
    for (int i = 0; i < n; i++) {
      counter += (input.nextInt()/100.0);
    }
    System.out.println((counter/n)*100);
  }
}
