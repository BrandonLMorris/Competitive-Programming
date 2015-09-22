import java.util.*;

public class Korn {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int[] arr = new int[4];
    for (int i = 0; i < 4; i++) {
      arr[i] = in.nextInt();
    }

    Arrays.sort(arr);


    System.out.println((arr[0] * arr[2]));

  }
}

/*
 * R[1] <= R[3]
 * R[2] <= R[4]
 * Area = min(R[1], R[3]) * min(R[2], R[4])
 * Max area is the minimum times the second-maximum
 *
 * 2 3 1 4 => 3
 * min(2, 1) * min(4, 3)
 */
