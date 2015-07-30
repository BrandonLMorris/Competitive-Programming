import java.util.*;

public class Case {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());

    char[] arr = in.nextLine().toCharArray();

    int zeroCounter = 0;
    int oneCounter = 0;

    for (char c : arr) {
      if (c == '1')
        oneCounter++;
      else
        zeroCounter++;
    }

    int result = Math.abs(oneCounter - zeroCounter);

    System.out.println(result);

  }
}
