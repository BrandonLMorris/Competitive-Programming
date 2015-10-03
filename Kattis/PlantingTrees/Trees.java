import java.util.*;
import java.io.*;

public class Trees {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(in.readLine());
    String treeLine = in.readLine();
    StringTokenizer st = new StringTokenizer(treeLine);
    long days = n;
    int[] trees = new int[n];
    for (int i = 0; i < n; i++) {
      trees[i] = Integer.parseInt(st.nextToken());
    }

    // Sort and reverse
    Arrays.sort(trees);
    for (int i = 0; i < n/2; i++) {
      int temp = trees[i];
      trees[i] = trees[n-i-1];
      trees[n-i-1] = temp;
    }

    // For each tree, days will either be greater because of new tree or stay
    // the same
    int count = n;
    for (int i = 0; i < n; i++) {
      count = Math.max(count, i + trees[i] + 2);
    }

    System.out.println(count);

  }
}
