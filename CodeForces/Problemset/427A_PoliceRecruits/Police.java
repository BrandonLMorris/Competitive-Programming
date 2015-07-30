import java.util.*;

public class Police {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int crimeCounter = 0;
    int police = 0;
    for (int i = 0; i < num; i++) {
      int m = input.nextInt();
      if (m > 0) {
        police += m;
      } else {
        if (police == 0) {
          crimeCounter++;
        } else {
          police--;
        }
      }
    }
    System.out.println(crimeCounter);
  }
}
