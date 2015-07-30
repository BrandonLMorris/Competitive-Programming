import java.util.*;

public class Quick {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      char[] line = input.nextLine().toCharArray();
      if (line[0] == '#') break;
      long counter = 0;
      for (int i = 1; i <= line.length; i++) {
        if (line[i-1] == ' ') continue;
        counter += (line[i-1]-'A'+1) * i;
      }
      System.out.println(counter);
    }
  }
}
