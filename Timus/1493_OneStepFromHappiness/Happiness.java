import java.util.*;

public class Happiness {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Ticket 1 is the ticket right after the input. Ticket 2 is the one
    // right before the input
    int ticket1 = in.nextInt() + 1;
    int ticket2 = ticket1 - 2;

    // nextInt() will strip any preceding 0's, need to put them back in
    String ticket1Str = Integer.toString(ticket1);
    while (ticket1Str.length() < 6) {
      ticket1Str = "0" + ticket1Str;
    }
    String ticket2Str = Integer.toString(ticket2);
    while (ticket2Str.length() < 6) {
      ticket2Str = "0" + ticket2Str;
    }

    char[] ticket2Arr = ticket2Str.toCharArray();
    char[] ticket1Arr = ticket1Str.toCharArray();

    // Sum counters for the first and second half
    int firstSum = 0;
    int secondSum = 0;

    for (int i = 0; i < 3; i++) {
      firstSum += ticket1Arr[i] - '0';
    }
    for (int i = 3; i < 6; i++) {
      secondSum += ticket1Arr[i] - '0';
    }

    if (firstSum == secondSum) {
      System.out.println("Yes");
      return;
    }

    // Reset the counters and try ticket 2
    firstSum = 0;
    secondSum = 0;
    for (int i = 0; i < 3; i++) {
      firstSum += ticket2Arr[i] - '0';
    }
    for (int i = 3; i < 6; i++) {
      secondSum += ticket2Arr[i] - '0';
    }
    if (firstSum == secondSum) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

  }
}
