import java.util.Scanner;

public class Grade {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (int t = 1;; t++) {
      long firstOperand = input.nextLong();
      long secondOperand = input.nextLong();
      if (firstOperand == 0 && secondOperand == 0) break;

      String firstOpStr = ((Long) firstOperand).toString();
      String secondOpStr = ((Long) secondOperand).toString();

      long product = firstOperand * secondOperand;
      int totalLength = ((Long) product).toString().length();

      // Print out first part of result
      System.out.println("Problem " + t);
      for (int i = 0; i < totalLength - firstOpStr.length(); i++) {
        System.out.print(" ");
      }
      System.out.println(firstOpStr);
      for (int i = 0; i < totalLength - secondOpStr.length(); i++) {
        System.out.print(" ");
      }
      System.out.println(secondOpStr);
      for (int i = 0; i < totalLength; i++) {
        System.out.print("-");
      }
      System.out.println();

      // Check if there will be intermediate steps (second operand will have >1 nonzero values)
      int nonZeroCounter = 0;
      for (int i = 0; i < secondOpStr.length(); i++) {
        if (secondOpStr.charAt(i) != '0') {
          nonZeroCounter++;
        }
      }
      if (nonZeroCounter == 1) {
        System.out.println(product);
        continue;
      }

      int offset = 0;
      for (int i = secondOpStr.length()-1; i >= 0; i--) {
        int numZeros = 0;
        while (secondOpStr.charAt(i) == '0') {
          numZeros++;
          i--;
        }
        long intermediateProduct = Long.parseLong(secondOpStr.charAt(i) + "") * firstOperand;
        int interProductLength = ((Long) intermediateProduct).toString().length();
        for (int j = 0; j < totalLength - offset - interProductLength - numZeros; j++) {
          System.out.print(" ");
        }
        System.out.print(intermediateProduct);
        for (int j = 0; j < numZeros; j++) {
          System.out.print("0");
        }
        System.out.println();
        offset += 1 + numZeros;
      }

      for (int i = 0; i < totalLength; i++) {
        System.out.print("-");
      }
      System.out.println();
      System.out.println(product);
    }
  }
}
