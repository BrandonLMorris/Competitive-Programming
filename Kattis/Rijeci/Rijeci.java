import java.util.*;

public class Rijeci {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int K = in.nextInt();
    String str = "A";

    int aCount = 1;
    int bCount = 0;

    for (int i = 0; i < K; i++) {
      int temp = aCount;
      aCount = bCount;
      bCount = temp + bCount;
    }

    System.out.println(aCount + " " + bCount);
  }
}

/*
 * A => B
 * B => BA
 *
 * P(N[B]) = P(N-1[B] + P(N-1[A])
 * P(N[A]) = P(N-1[B])
 */
