import java.util.*;
import java.io.*;

// Thank you IntelliJ for knowing how to spell that
public class Spavansdlkf {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String line = in.readLine();
    st = new StringTokenizer(line);
    int hour = Integer.parseInt(st.nextToken());
    int min = Integer.parseInt(st.nextToken());

    min -= 45;
    if (min < 0) {
      hour--;
      min += 60;
    }
    if (hour < 0) {
      hour += 24;
    }

    System.out.println(hour + " " + min);
  }
}