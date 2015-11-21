import java.util.*;

public class Apaxian {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    char[] name = in.nextLine().toCharArray();
    String result = "";   // Max is 250, so string concatentation will suffice
    int pos = 1;
    result += name[0];
    while (pos < name.length) {
      if (name[pos] != name[pos-1]) result += name[pos];
      pos++;
    }

    System.out.println(result);
  }
}
