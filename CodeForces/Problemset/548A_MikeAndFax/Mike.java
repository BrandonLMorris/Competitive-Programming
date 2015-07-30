import java.util.*;

public class Mike {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    int n = Integer.parseInt(in.nextLine());

    if (input.length() % n != 0) {
      System.out.println("NO");
      return;
    }

    int size = input.length() / n;
    boolean isHis = true;

    for (int i = 0; i < input.length(); i += size) {
      StringBuilder sb = new StringBuilder();
      for (int j = i; j < i+size; j++) {
        sb.append(input.charAt(j));
      }
      if(!isPalindrome(sb.toString()))
          isHis = false;
    }

    System.out.println(isHis ? "YES" : "NO");
  }

  public static boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;

    while (j > i) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      j--;
      i++;
    }

    return true;
  }
}
