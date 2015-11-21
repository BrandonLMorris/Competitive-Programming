import java.util.*;
import java.io.*;

public class Sync {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    boolean first = true;
    while (true) {
      int n = Integer.parseInt(in.readLine());
      if (n == 0) break;

      if (!first) {
        first = false;
        System.out.println();
      }

      int[] list1 = new int[n];
      int[] list1Copy = new int[n];
      int[] list2 = new int[n];
      int[] result = new int[n];

      for (int i = 0; i < n; i++) {
        list1[i] = list1Copy[i] = Integer.parseInt(in.readLine());
      }
      for (int i = 0; i < n; i++) {
        list2[i] = Integer.parseInt(in.readLine());
      }

      Arrays.sort(list1Copy);
      Arrays.sort(list2);

      TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
      for (int i = 0; i < n; i++) {
        map.put(list1Copy[i], list2[i]);
      }

      for (int i = 0; i < n; i++) {
        System.out.println(map.get(list1[i]));
      }
    }
  }
}
