import java.util.*;

public class Caps {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] wordArr = input.nextLine().toCharArray();
    boolean changeIt = true;
    for (int i = 1; i < wordArr.length; i++) {
      if (Character.isLowerCase(wordArr[i])) {
        changeIt = false;
      }
    }

    if (changeIt) {
      for (int i = 0; i < wordArr.length; i++) {
        if(Character.isLowerCase(wordArr[i])) {
          wordArr[i] = Character.toUpperCase(wordArr[i]);
        } else {
          wordArr[i] = Character.toLowerCase(wordArr[i]);
        }
      }
    }

    // Convert back to string
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < wordArr.length; i++) {
      sb.append(wordArr[i]);
    }

    System.out.println(sb.toString());
  }
}
