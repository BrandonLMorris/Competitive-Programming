import java.util.*;

public class Rewards {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int cups = input.nextInt() + input.nextInt() + input.nextInt();
    int medals = input.nextInt() + input.nextInt() + input.nextInt();
    int shelves = input.nextInt();

    int cupShelves = (int) Math.ceil(cups / 5.0);
    int medalShelves = (int) Math.ceil(medals / 10.0);

    System.out.println((shelves >= cupShelves + medalShelves ? "YES" : "NO"));
  }
}
