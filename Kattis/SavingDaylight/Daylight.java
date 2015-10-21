import java.util.*;
import java.io.*;

public class Daylight {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (;;) {
      String line = in.readLine();
      if (line == null) break;
      st = new StringTokenizer(line);

      StringBuilder sb = new StringBuilder();
      sb.append(st.nextToken() + " ");
      sb.append(st.nextToken() + " ");
      sb.append(st.nextToken());

      String startTime = st.nextToken();
      String endTime = st.nextToken();

      StringBuilder hr = new StringBuilder();
      StringBuilder min = new StringBuilder();
      for (int i = 0; startTime.charAt(i) != ':'; i++)
        hr.append(startTime.charAt(i));
      for (int i = startTime.indexOf(':')+1; i < startTime.length(); i++)
        min.append(startTime.charAt(i));

      int startHour = Integer.parseInt(hr.toString());
      int startMin = Integer.parseInt(min.toString());

      hr = new StringBuilder();
      min = new StringBuilder();
      for (int i = 0; endTime.charAt(i) != ':'; i++)
        hr.append(endTime.charAt(i));
      for (int i = endTime.indexOf(':')+1; i < endTime.length(); i++)
        min.append(endTime.charAt(i));

      int endHour = Integer.parseInt(hr.toString());
      int endMin = Integer.parseInt(min.toString());

      int hour = endHour - startHour;
      int minutes = endMin - startMin;
      if (minutes < 0) {
        minutes += 60;
        hour--;
      }

      sb.append(" ");
      sb.append(hour);
      sb.append(" hours ");
      sb.append(minutes);
      sb.append(" minutes");

      System.out.println(sb.toString());

    }
  }
}