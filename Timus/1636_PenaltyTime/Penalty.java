import java.util.*;

public class Penalty {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int qxx = in.nextInt();
    int zzz = in.nextInt();

    int penaltyCounter = 0;
    for (int i = 0; i < 10; i++) {
      penaltyCounter += in.nextInt();
    }

    int zzzTime = zzz - (20 * penaltyCounter);

    if (zzzTime < qxx) {
      System.out.println("Dirty debug :(");
    } else {
      System.out.println("No chance.");
    }

  }
}
