import java.util.*;

public class Black {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] cals = new int[4];
    for (int i = 0; i < 4; i++) {
      cals[i] = Integer.parseInt(input.next());
    }
    
    int counter = 0;
    String line = input.next();
    for (int i = 0; i < line.length(); i++) {
      counter += cals[line.charAt(i)-'0'-1];
    }
    System.out.println(counter);
  }
}
