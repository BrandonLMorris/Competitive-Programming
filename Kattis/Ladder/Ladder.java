import java.util.*;

public class Ladder {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int height = in.nextInt();
    int angle = in.nextInt();
    double angleRadians = angle * Math.PI / 180.0;

    double hypot = height / Math.sin(angleRadians);
    System.out.println((int)(Math.ceil(hypot)));
  }
}
