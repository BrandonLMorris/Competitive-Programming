import java.util.*;

public class Teams {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numMembers = input.nextInt();
    int k = input.nextInt();
    int minNum = 5 - k;
    int counter = 0;
    for (int i = 0; i < numMembers; i++) {
      int num = input.nextInt();
      if (num <= minNum)
        counter++;
    }
    System.out.println((counter/3));
  }
}
