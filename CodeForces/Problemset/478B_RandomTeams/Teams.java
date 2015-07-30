import java.util.*;

public class Teams {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    long participants = input.nextLong();
    long teams = input.nextLong();

    long biggestGroup = participants - (teams - 1);
    long kmax = sum(biggestGroup);

    long div = participants / teams;
    long remainder = participants % teams;

    long t1 = teams - (participants % teams);
    long t2 = participants % teams;

    long counter = (t1 * sum(participants/teams)) + (t2 * sum((participants/teams) + 1));

    System.out.println(counter + " " + kmax);

  }

  private static long sum(long n) {
    return n * (n-1) / 2;
  }
}
