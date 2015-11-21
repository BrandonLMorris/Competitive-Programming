import java.util.*;
import java.io.*;

public class Line {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(in.readLine());
    String[] original = new String[n];
    for (int i = 0; i < n; i++) {
      original[i] = in.readLine();
    }
    String[] increasing = Arrays.copyOf(original,  original.length);
    String[] decreasing = Arrays.copyOf(original,  original.length);
    Arrays.sort(increasing);
    Arrays.sort(decreasing, Collections.reverseOrder());

    boolean correct = true;
    for (int i = 0; i < original.length; i++) {
      if (!original[i].equals(increasing[i])) {
        correct = false;
        break;
      }
    }
    if (correct) {
      System.out.println("INCREASING");
      return;
    }

    correct = true;
    for (int i = 0; i < original.length; i++) {
      if (!original[i].equals(decreasing[i])) {
        correct = false;
        break;
      }
    }
    System.out.println(correct ? "DECREASING" : "NEITHER");
  }
}
