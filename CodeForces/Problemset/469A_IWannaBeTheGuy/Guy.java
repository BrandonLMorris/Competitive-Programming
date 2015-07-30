import java.util.*;

public class Guy {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    //int num = input.nextInt();

    boolean[] nums = new boolean[input.nextInt()];
    
    for (int i = input.nextInt(); i > 0; i--) {
      nums[input.nextInt() - 1] = true;
    }
    for (int i = input.nextInt(); i > 0; i--) {
      nums[input.nextInt() -1] = true;
    }
    
    for (Boolean b : nums) {
      if (!b) {
        System.out.println("Oh, my keyboard!");
        return;
      }
    }
    System.out.println("I become the guy.");
  }
}
