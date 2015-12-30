import java.util.*;
import java.io.*;

public class Sequence {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      st = new StringTokenizer(in.readLine());
      int n = Integer.parseInt(st.nextToken());

      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }

      int dist = nums[0] - nums[1];
      boolean isArithmetic = true;
      for (int i = 1; i < nums.length-1; i++) {
        if (nums[i] - nums[i+1] != dist) {
          isArithmetic = false;
          break;
        }
      }

      if (isArithmetic) {
        System.out.println("arithmetic");
        continue;
      }

      Arrays.sort(nums);
      dist = nums[0] - nums[1];
      isArithmetic = true;
      for (int i = 1; i < nums.length-1; i++) {
        if (nums[i] - nums[i+1] != dist) {
          isArithmetic = false;
          break;
        }
      }

      System.out.println(isArithmetic ? "permuted arithmetic" : "non-arithmetic");
    }
  }
}
