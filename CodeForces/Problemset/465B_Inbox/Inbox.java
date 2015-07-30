import java.util.*;

public class Inbox {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int counter = 0;
    int[] mailbox = new int[n];
    for (int i = 0; i < n; i++) {
      mailbox[i] = input.nextInt();
      if (mailbox[i] == 1) {
        counter += 2;
      }
    }

    if (counter > 0)
      counter--;

    for (int i = 0; i < n-1; i++) {
      if (mailbox[i] == 1 && mailbox[i+1] == 1)
        counter--;
    }

    System.out.println(counter);
  }
}
