import java.util.*;
import java.io.*;

public class Friday13 {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      st = new StringTokenizer(in.readLine());
      int numDaysInYear = Integer.parseInt(st.nextToken());
      int numMonths = Integer.parseInt(st.nextToken());
      int[] monthDays = new int[numMonths];
      st = new StringTokenizer(in.readLine());
      for (int i = 0; i < numMonths; i++) {
        monthDays[i] = Integer.parseInt(st.nextToken());
      }

      int dayOfWeek = 0;  // Friday is day 5
      int friday13Counter = 0;
      for (int i = 0; i < numMonths; i++) {
        int days = monthDays[i];
        for (int j = 1; j <= days; j++) {
          if (dayOfWeek == 5 && j == 13) {
            friday13Counter++;
          }
          dayOfWeek = (dayOfWeek + 1) % 7;
        }
      }

      System.out.println(friday13Counter);

    }
  }
}