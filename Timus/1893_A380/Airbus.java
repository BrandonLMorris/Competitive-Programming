import java.util.*;

public class Airbus {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String seatStr = in.nextLine();
    char[] seat = seatStr.toCharArray();
    StringBuilder sb = new StringBuilder();

    // Pull out the seat number from the ticket
    int i = 0;
    while (Character.isDigit(seat[i])) {
      sb.append(seat[i]);
      i++;
    }

    int seatNum = Integer.parseInt(sb.toString());
    char seatLetter = Character.toUpperCase(seat[i]);

    // Premium class: A BC D
    if (seatNum <= 2) {
      if (seatLetter == 'A' || seatLetter == 'D') {
        System.out.println("window");
      } else {
        System.out.println("aisle");
      }
    } else if (seatNum <= 20) {
      // Business class: AB CD EF
      if (seatLetter == 'A' || seatLetter == 'F') {
        System.out.println("window");
      } else {
        System.out.println("aisle");
      }
    } else {
      // Economy class: ABC DEFG HJK
      if (seatLetter == 'A' || seatLetter == 'K') {
        System.out.println("window");
      } else if (seatLetter == 'D' || seatLetter == 'C' ||
                 seatLetter == 'G' || seatLetter == 'H') {
        System.out.println("aisle");
      } else {
        System.out.println("neither");
      }
    }
  }
}

/*
 * A BC D
 * AB CD EF
 * ABC DEFG HJK
 */
