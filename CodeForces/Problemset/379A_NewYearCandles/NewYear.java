import java.util.*;

public class NewYear {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    int b = input.nextInt();
    int counter = a;
    int burntCandles = a;
    while (burntCandles >= b) {
        counter += burntCandles / b;
        burntCandles = (burntCandles / b) + (burntCandles % b);
    }
    System.out.println(counter);
  }
}
