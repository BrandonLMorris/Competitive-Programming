import java.util.*;

public class Games {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numIn = input.nextInt();
    int[] homes = new int[numIn];
    int[] aways = new int[numIn];
    int counter = 0;

    for (int i = 0; i < numIn; i++) {
      homes[i] = input.nextInt();
      aways[i] = input.nextInt();
    }

    for (int i = 0; i < numIn; i++) {
      for (int j = 0; j < numIn; j++) {
        if (homes[i] == aways[j]) {
          counter++;
        }
      }
    }

    System.out.println(counter);
  }
}
