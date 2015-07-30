import java.util.*;

public class Young {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int xCounter = 0;
    int yCounter = 0;
    int zCounter = 0;

    int n = input.nextInt();
    for (int i = 0; i < n; i++) {
      xCounter += input.nextInt();
      yCounter += input.nextInt();
      zCounter += input.nextInt();
    }


    if (xCounter == 0 && yCounter == 0 && zCounter == 0)
      System.out.println("YES");
    else 
      System.out.println("NO");
  }
}
