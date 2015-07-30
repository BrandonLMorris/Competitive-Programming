import java.util.*;

public class Bits {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    char[] bits = input.nextLine().toCharArray();

    boolean zeroFound = false;
    for (int i = 0; i < bits.length; i++) {
      if (bits[i] == '0' && !zeroFound) {
        bits[i] = 'X';
        zeroFound = true;
      }
    }

    StringBuilder sb = new StringBuilder();
    if (!zeroFound) {
      for (int i = 1; i < bits.length; i++) {
        sb.append(bits[i]);
      }
    } else {
      for (int i = 0; i < bits.length; i++) {
        if (bits[i] != 'X')
          sb.append(bits[i]);
      }
    }

    System.out.println(sb.toString());

  }
}
