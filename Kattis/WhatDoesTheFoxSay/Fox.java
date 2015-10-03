import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Fox {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int i = 0; i < numTests; i++) {
      ArrayList<String> sounds = new ArrayList<String>();
      st = new StringTokenizer(in.readLine());
      while (st.hasMoreTokens()) {
        sounds.add(st.nextToken());
      }
      String line = in.readLine();
      while (!line.equals("what does the fox say?")) {
        st = new StringTokenizer(line);
        st.nextToken();
        st.nextToken();
        String sound = st.nextToken();
        while (sounds.contains(sound)) sounds.remove(sound);
        line = in.readLine();
      }

      StringBuilder sb = new StringBuilder();
      for (String s : sounds) {
        sb.append(s + " ");
      }
      System.out.println(sb.toString().trim());
    }


  }
}