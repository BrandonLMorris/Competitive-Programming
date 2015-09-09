import java.util.*;

public class Dice {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int counter = 0;

    int a1 = in.nextInt();
    int b1 = in.nextInt();
    int a2 = in.nextInt();
    int b2 = in.nextInt();
    int gunnarCount = 0;
    for (int i = a1; i <= b1; i++) {
      for (int j = a2; j <= b2; j++) {
        counter++;
        gunnarCount += i + j;
      }
    }
    double gunnar = gunnarCount / (double)counter;


    a1 = in.nextInt();
    b1 = in.nextInt();
    a2 = in.nextInt();
    b2 = in.nextInt();
    counter = 0;
    int emmaCount = 0;
    for (int i = a1; i <= b1; i++) {
      for (int j = a2; j <= b2; j++) {
        counter++;
        emmaCount += i+j;
      }
    }
    double emma = emmaCount / (double)counter;

    // System.out.println("Gunnar: " + gunnar);
    // System.out.println("Emma: " + emma);

    if (gunnar > emma) {
      System.out.println("Gunnar");
    } else if (emma > gunnar) {
      System.out.println("Emma");
    } else {
      System.out.println("Tie");
    }

  }

  private static int sumTo(int n) {
    return (n * (n+1)) / 2;
  }
}
