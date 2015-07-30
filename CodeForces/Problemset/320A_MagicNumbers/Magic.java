import java.util.*;

public class Magic {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String strStr = input.nextLine();
    char[] str = strStr.toCharArray();
    for (int i = 0; i < str.length; i++) {
      if (!(str[i] == '1' || str[i] == '4')) {
        System.out.println("NO");
        return;
      }
    }
    if (strStr.contains("444")) {
      System.out.println("NO");
      return;
    }
    if (str[0] == '4') {
      System.out.println("NO");
      return;
    }
    System.out.println("YES");
    
  }
}
