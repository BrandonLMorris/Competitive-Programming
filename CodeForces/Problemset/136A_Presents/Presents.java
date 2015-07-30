import java.util.*;

public class Presents {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int[] result = new int[num];
    for (int i = 0; i < num; i++) {
      result[input.nextInt() - 1] = i+1;
    }
    for (int i : result) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
