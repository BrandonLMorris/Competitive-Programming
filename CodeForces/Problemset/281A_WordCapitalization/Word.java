import java.util.*;

public class Word {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] wordArr = input.nextLine().toCharArray();
    if (Character.isLowerCase(wordArr[0])) {
      wordArr[0] = Character.toUpperCase(wordArr[0]);
    }
    StringBuilder sb = new StringBuilder();
    for (char c : wordArr) {
      sb.append(c);
    }
    System.out.println(sb.toString());
  }
}
