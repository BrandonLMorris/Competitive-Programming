import java.util.*;

public class Beautiful {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int year = input.nextInt();
    year++;
    char[] yearArr = Integer.toString(year).toCharArray();
    for (;;) {
      boolean isDone = true;
      HashSet<Character> yearNums = new HashSet<Character>();
      for (char c : yearArr) {
        if (yearNums.contains(c)) {
          isDone = false;
          break;
        } else {
          yearNums.add(c);
        }
      }
      if (isDone) break;
      else year++;
      yearArr = Integer.toString(year).toCharArray();
    }
    System.out.println(year);
  }
}
