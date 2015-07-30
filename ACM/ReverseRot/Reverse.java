import java.util.*;

public class Reverse {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] alphabet = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ_.").toCharArray();
    for (;;) {
      int rotation = input.nextInt();
      if (rotation == 0) break;
      char[] message = input.nextLine().trim().toCharArray();
      char[] messageReversed = new char[message.length];
      for (int i = 0; i < messageReversed.length; i++) {
        messageReversed[i] = message[message.length-i-1];
      }
      for (int i = 0; i < messageReversed.length; i++) {
        int j = 0;
        while (alphabet[j] != messageReversed[i]) j++;
        messageReversed[i] = alphabet[(j+rotation)%alphabet.length];
      }

      StringBuilder sb = new StringBuilder();
      for (char c : messageReversed) {
        sb.append(c);
      }
      System.out.println(sb.toString());
    }
  }
}
