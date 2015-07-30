import java.util.*;

public class ARG {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = Integer.parseInt(input.nextLine());
    char[] line = input.nextLine().toCharArray();
    int counter = 1;
    int j = 0;
    while (j < n && line[j] != '0') {
      counter++;
      j++;
    }
    System.out.println(counter > n ? n : counter);
  }
}
