import java.util.*;

public class Tram {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numLines = input.nextInt();
    int numOnTrain = 0;
    int maxCap = 0;
    for (int i = 0; i < numLines; i++) {
      numOnTrain -= input.nextInt();
      numOnTrain += input.nextInt();
      if (numOnTrain > maxCap) {
        maxCap = numOnTrain;
      }
    }
    System.out.println(maxCap);
  }
}
