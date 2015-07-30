import java.util.*;

public class Lock {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = Integer.parseInt(input.nextLine());
    int[] lock = new int[n];
    int[] key = new int[n];

    String s1 = input.nextLine();
    String s2 = input.nextLine();

    for (int i = 0; i < n; i++) {
      lock[i] = s1.charAt(i) - '0';
      key[i] = s2.charAt(i) - '0';
    }


    int counter = 0;
    for (int i = 0; i < n; i++) {
      // Turns will be equal to abs the difference or
      // 9 - lock pos + key pos (going around)
      int direct = Math.abs(lock[i] - key[i]);
      int around = 10 - direct;

      counter += (direct < around ? direct : around);

      //System.out.println("Direct: " + direct + " Around: " + around);
      //System.out.println("From " + lock[i] + " to " + key[i] + " " + Math.min(direct, around));

    }

    System.out.println(counter);

  }
}
