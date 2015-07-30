import java.util.*;

public class Gravity {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] nums = new int[input.nextInt()];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = input.nextInt();
    }

    Arrays.sort(nums);

    for (int i : nums) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
