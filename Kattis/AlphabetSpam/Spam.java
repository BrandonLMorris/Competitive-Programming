import java.util.*;

public class Spam {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] input = in.nextLine().toCharArray();

    int total = input.length;
    int white = 0;
    int lower = 0;
    int upper = 0;
    int symbol = 0;

    for (int i = 0; i < total; i++) {
      if (input[i] == '_') white++;
      else if (input[i] >= 97 && input[i] <= 122)
        lower++;
      else if (input[i] >= 65 && input[i] <= 90)
        upper++;
      else
        symbol++;
    }

    System.out.println(((double)white / (double)total));
    System.out.println(((double)lower / (double)total));
    System.out.println(((double)upper / (double)total));
    System.out.println(((double)symbol / (double)total));
  }
}
