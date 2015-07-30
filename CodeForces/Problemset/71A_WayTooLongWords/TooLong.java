import java.util.*;

public class TooLong {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = Integer.parseInt(input.nextLine());
    for (int t = 0; t < numTests; t++) {
      String word = input.nextLine();
      if (word.length() > 10) {
        // Reset word to abbreviated form
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(((Integer) (len - 2)).toString());
        sb.append(word.charAt(len-1));
        word = sb.toString();
      }
      System.out.println(word);
    }
  }
}
