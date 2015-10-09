import java.util.*;
import java.io.*;

public class Incognito {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      int numAttr = Integer.parseInt(in.readLine());
      ArrayList<String> attrTypes = new ArrayList<String>(30);
      HashMap<String, Integer> hm = new HashMap<String, Integer>();
      for (int i = 0; i < numAttr; i++) {
        st = new StringTokenizer(in.readLine());
        st.nextToken();
        String s = st.nextToken();
        if (hm.get(s) != null) {
          hm.put(s, hm.get(s)+1);
        } else {
          hm.put(s, 1);
          attrTypes.add(s);
        }
      }

      int counter = 1;
      for (String s : attrTypes) {
        counter *= hm.get(s) + 1;
      }
      counter--;

      System.out.println(counter);
    }
  }
}