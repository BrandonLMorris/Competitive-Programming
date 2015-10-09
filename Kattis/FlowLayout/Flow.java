import java.util.*;
import java.io.*;

public class Flow {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (;;) {
      int maxWidth = Integer.parseInt(in.readLine());
      if (maxWidth == 0) break;

      ArrayList<Integer> widths = new ArrayList<Integer>(15);
      ArrayList<Integer> heigths = new ArrayList<Integer>(15);
      st = new StringTokenizer(in.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      while (x != -1 && y != -1) {
        widths.add(x);
        heigths.add(y);
        st = new StringTokenizer(in.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
      }

      int currentHeight = 0;
      int currentRowHeight = 0;
      int currentWidth = 0;
      int realMaxWith = 0;

      boolean dontAdd = false;
      for (int i = 0; i < widths.size(); i++) {
        if (currentWidth + widths.get(i) <= maxWidth) {
          currentWidth += widths.get(i);
          if (currentRowHeight < heigths.get(i)) {
            currentRowHeight = heigths.get(i);
          }
        } else {
          if (i == widths.size() - 1) dontAdd = true;
          currentHeight += currentRowHeight;
          currentRowHeight = heigths.get(i);
          if (currentWidth > realMaxWith) {
            realMaxWith = currentWidth;
          }
          currentWidth = widths.get(i);
        }
        if (currentWidth > realMaxWith) {
          realMaxWith = currentWidth;
        }
      }
      currentHeight += currentRowHeight;

      System.out.println(realMaxWith + " x " + currentHeight);
    }

  }
}