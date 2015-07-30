import java.util.*;

public class George {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numRooms = input.nextInt();
    int counter = 0;
    for (int i = 0; i < numRooms; i++) {
      int inRoom = input.nextInt();
      int roomCap = input.nextInt();
      if (roomCap - inRoom >= 2) {
        counter++;
      }
    }
    System.out.println(counter);
  }
}
