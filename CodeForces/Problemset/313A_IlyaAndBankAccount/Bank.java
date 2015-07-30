import java.util.*;

public class Bank {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long n = input.nextLong();
    if (n >= 0) {
      System.out.println(n);
      return;
    }
    char[] nums = Long.toString(n).toCharArray();
    char[] newNums = new char[nums.length-1];
    if (nums[nums.length-1] > nums[nums.length-2]) {
      // Delete the last digit
      for (int i = 0; i < nums.length-1; i++) {
        newNums[i] = nums[i];
      }
    } else {
      // Delete the second to last digit
      for (int i = 0; i < nums.length-1; i++) {
        newNums[i] = nums[i];
      }
      newNums[newNums.length-1] = nums[nums.length-1];
    }
    StringBuilder sb = new StringBuilder();
    for (char c : newNums) {
      sb.append(c);
    }
    System.out.println(Long.parseLong(sb.toString()));
  }
}
