import java.util.*;
import java.io.*;

public class Flexible {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    int width = Integer.parseInt(st.nextToken());
    int numPartitions = Integer.parseInt(st.nextToken());

    // Build an array of all partition locations, beginning, and end
    int[] partitions = new int[numPartitions + 2];
    partitions[0] = 0;
    st = new StringTokenizer(in.readLine());
    for (int i = 1; i <= numPartitions; i++) {
      partitions[i] = Integer.parseInt(st.nextToken());
    }
    partitions[numPartitions+1] = width;

    // Prevent duplicates
    HashSet<Integer> sizes = new HashSet<Integer>();

    // Add width for every pair of partitions
    ArrayList<Integer> sizeList = new ArrayList<Integer>();
    for (int i = 0; i < numPartitions+2; i++) {
      for (int j = i; j < numPartitions+2; j++) {
        int temp = partitions[j] - partitions[i];
        if (!sizes.contains(temp) && temp != 0) {
          sizes.add(temp);
          sizeList.add(temp);
        }
      }
    }

    // Sort for descending order
    Collections.sort(sizeList);

    StringBuilder sb = new StringBuilder();
    for (int i : sizeList) {
      sb.append(i + " ");
    }

    // Get rid of trailing space
    System.out.println(sb.toString().trim());


  }
}
