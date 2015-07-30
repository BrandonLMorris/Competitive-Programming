import java.util.*;

public class Ugly {
  public static void main(String[] args) {
    boolean[] uglies = new boolean[20000000];
    uglies[1] = true;
    int counter = 0;
    ArrayList<Integer> uglyList = new ArrayList<Integer>(1500);
    uglyList.add(1);
    for (int i = 0; uglyList.size()<1500; i++) {
      int j = uglyList.get(i);
      System.out.println("Working with " + j);
      if (!uglyList.contains(j*2)) uglyList.add(j*2);
      if (!uglyList.contains(j*3)) uglyList.add(j*3);
      if (!uglyList.contains(j*5)) uglyList.add(j*5);
    }
    Collections.sort(uglyList);
    System.out.println(uglyList.get(1499));
  }

  public static boolean isUgly(int i, boolean[] uglies) {
    if (i == 1) return true;
    if (uglies[i]) return true;

    if (i % 2 == 0) {
      if (isUgly(i/2, uglies)) {
        uglies[i] = true;
        return true;
      }
    }

    if (i % 3 == 0) {
      if (isUgly(i/3, uglies)) {
        uglies[i] = true;
        return true;
      }
    }

    if (i % 5 == 0) {
      if (isUgly(i/5, uglies)) {
        uglies[i] = true;
        return true;
      }
    }

    return false;
  }
}
