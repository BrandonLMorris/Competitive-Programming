import java.util.*;

public class Duplicate {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for(;;) {
      int numInput = input.nextInt();
      if (numInput == 0) break;
      int nextVal = input.nextInt();
      StringBuilder sb = new StringBuilder();
      sb.append(nextVal + " ");
      int lastVal = nextVal;
      for (int i = 1; i < numInput; i++) {
        nextVal = input.nextInt();
        if (nextVal != lastVal) {
          sb.append(nextVal + " ");
        }
        lastVal = nextVal;
      }
      sb.append("$");
      System.out.println(sb.toString());
    }
  }
}
