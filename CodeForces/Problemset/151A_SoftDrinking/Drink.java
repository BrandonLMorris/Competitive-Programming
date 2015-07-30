import java.util.*;

public class Drink {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    int l = input.nextInt();
    int c = input.nextInt();
    int d = input.nextInt();
    int p = input.nextInt();
    int nl = input.nextInt();
    int np = input.nextInt();

    int x = (k * l) / nl;
    int y = (c * d);
    int z = p / np;
    int count = Math.min(x, Math.min(y, z)) / n;
    System.out.println(count);
  }
}
