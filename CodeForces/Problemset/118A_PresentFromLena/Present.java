import java.util.*;

public class Present {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();

    int[] nums = new int[n+1];
    for (int i = 0; i < n+1; i++) {
      nums[i] = i;
    }

    for (int i = 0; i < n ; i++) {
      int maxNum = i;

      // Print out the spaces
      for (int j = 0; j < n-i; j++) {
        System.out.print("  ");
      }

      for (int j = 0; j < maxNum; j++) {
        System.out.print(nums[j]+" ");
      }

      for (int j = maxNum; j >= 0; j--) {
        System.out.print(nums[j]);
        if (j > 0) System.out.print(" ");
      }

      System.out.println();
    }

    // Print out the middle line
    for (int i = 0; i < nums.length; i++) {
      System.out.print(i+" ");
      //if (i < nums.length-1) System.out.print(" ");
    }
    for (int i = nums.length-2; i >= 0; i--) {
        System.out.print(nums[i]);
        if (i > 0) System.out.print(" ");
    }
    System.out.println();

    for (int i = n-1; i >= 0; i--) {
      int maxNum = i;
      for (int j = 0; j < n-i; j++) System.out.print("  ");
      for (int j = 0; j < maxNum; j++) System.out.print(nums[j]+ " ");
      for (int j = maxNum; j >= 0; j--) {
          System.out.print(nums[j]);
          if (j > 0) System.out.print(" ");
      }
      System.out.println();
    }
  }
}

// Number of spaces on line: n - 1 - i
// Number of numbers on line: i * 2 + 1
// Number of ascending numbers on line: i + 1
