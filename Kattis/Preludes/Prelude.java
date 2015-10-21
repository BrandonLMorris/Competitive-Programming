import java.util.*;
import java.io.*;

public class Prelude {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int t = 1;; t++) {
      String line = in.readLine();
      if (line == null) break;

      st = new StringTokenizer(line);
      String key = st.nextToken();
      String tone = st.nextToken();

      if (key.length() == 1) {
        System.out.println("Case " + t + ": UNIQUE");
        continue;
      }

      String result = "";
      HashMap<String, String> hm = new HashMap<String, String>();
      hm.put("A#", "Bb");
      hm.put("Bb", "A#");
      hm.put("C#", "Db");
      hm.put("Db", "C#");
      hm.put("D#", "Eb");
      hm.put("Eb", "D#");
      hm.put("F#", "Gb");
      hm.put("Gb", "F#");
      hm.put("G#", "Ab");
      hm.put("Ab", "G#");
      result = hm.get(key);

      System.out.println("Case " + t + ": " + result + " " + tone);
    }
  }
}
