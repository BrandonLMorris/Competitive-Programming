import java.util.*;

public class Xenia {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long numHouses = input.nextLong();
    long numTasks = input.nextLong();
    long currentHouse = 0;
    long counter = 0;

    for (int i = 0; i < numTasks; i++) {
      long next = input.nextLong()-1;
      if (next >= currentHouse) {
        counter += next - currentHouse;
        currentHouse = next;
      } else {
        counter += numHouses - (currentHouse - next);
        currentHouse = next;
      }
    }
    System.out.println(counter);
  }
}
