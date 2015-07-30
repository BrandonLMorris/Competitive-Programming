import java.util.*;

public class Maths {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] line = input.nextLine().toCharArray();
    int numNums = (int) Math.ceil(line.length / 2.0);
    int[] nums = new int[numNums];
    for (int i = 0, j = 0; i < line.length; i += 2) {
      nums[j] = line[i] - '0';
      j++;
    }
    Arrays.sort(nums);
    int k = 0;
    for (int i = 0; i < line.length; i += 2) {
      line[i] = (nums[k] + "").charAt(0);
      k++;
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < line.length; i++) {
      sb.append(line[i]);
    }
    System.out.println(sb.toString());
  }
}
