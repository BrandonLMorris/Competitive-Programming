import java.util.*;

public class Booking {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    boolean[] takenRooms = new boolean[n];

    int r = in.nextInt();
    for (int i = 0; i < r; i++) {
      takenRooms[in.nextInt()-1] = true;
    }

    for (int i = 0; i < n; i++) {
      if (!takenRooms[i]) {
        System.out.println((i+1));
        return;
      }
    }

    System.out.println("too late");


  }
}
