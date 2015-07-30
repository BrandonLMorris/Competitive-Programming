import java.util.*;

public class More {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      int firstNum = input.nextInt();
      int secondNum = input.nextInt();
      if (firstNum == 0 && secondNum == 0) break;
      int product = firstNum * secondNum;

      int firstNumLength = Integer.toString(firstNum).length();
      int secondNumLength = Integer.toString(secondNum).length();

      String productString = Integer.toString(product);
      while (productString.length() < firstNumLength + secondNumLength)
        productString = " " + productString;

      int productLength = productString.length();

      StringBuilder sb = new StringBuilder();
      sb.append("+-");
      for (int i = 0; i < firstNumLength; i++) {
        sb.append("----");
      }
      sb.append("--+");

      String bigBoxEdge = sb.toString();

      int[][] matrix = new int[secondNumLength][firstNumLength];
      for (int i = 0; i < secondNumLength; i++) {
        for (int j = 0; j < firstNumLength; j++) {
          matrix[i][j] = ((int)(Integer.toString(secondNum).charAt(i)) - 48)
                         * ((int)(Integer.toString(firstNum).charAt(j)) - 48);
        }
      }


      boolean printZeros = false;
      boolean printSlashes = false;

      int numRows = (4*secondNumLength)+5;
      for (int row = 0; row < numRows; row++) {
        if (row == 0 || row == numRows-1) System.out.println(bigBoxEdge);

        else if (row == 1) {
          // First row displays first number
          sb = new StringBuilder();
          sb.append("|   ");
          for (int i = 0; i < firstNumLength; i++) {
            sb.append(Integer.toString(firstNum).charAt(i));
            sb.append("   ");
          }
          sb.append("|");
          System.out.println(sb.toString());

        } else if (row == numRows - 2) {
          // Print out bottom row of product
          sb = new StringBuilder();
          sb.append("|");
          for (int i = productLength - firstNumLength; i < productLength; i++) {
            sb.append(printSlashes ? "/ " : "  ");
            char num = productString.charAt(i);
            sb.append(num + " ");
            if (num != ' ') {
              printZeros = true;
              printSlashes = true;
            }
          }
          sb.append("   |");
          System.out.println(sb.toString());

        } else if ((row - 2) % 4 == 0) {
          // Print out the little box edges
          sb = new StringBuilder();
          sb.append("| ");
          for (int i = 0; i < firstNumLength; i++) {
            sb.append("+---");
          }
          sb.append("+ |");
          System.out.println(sb.toString());

        } else if ((row - 2) % 4 == 1) {
          // Top row of mini boxes: lines and first digit of multiplications
          sb = new StringBuilder();
          sb.append("|");
          sb.append(printSlashes ? "/" : " ");
          for (int i = 0; i < firstNumLength; i++) {
            sb.append("|");
            int num = matrix[(row - 2) / 4][i] / 10;
            sb.append(num);
            sb.append(" /");
          }
          sb.append("| |");
          System.out.println(sb.toString());

        } else if ((row - 2) % 4 == 2) {
          // Second row of mini boxes: lines and digit of second number
          sb = new StringBuilder();
          sb.append("| ");
          for (int i = 0; i < firstNumLength; i++) {
            sb.append("| / ");
          }
          sb.append("|");
          sb.append(Integer.toString(secondNum).charAt((row-2)/4));
          sb.append("|");
          System.out.println(sb.toString());

        } else if ((row - 2) % 4 == 3) {
          // Last row of miniboxes: product digit, lines, ones digit of multiplications
          sb = new StringBuilder();
          sb.append("|");
          char num = productString.charAt((row-2)/4);
          sb.append(num);
          if (num != ' ') {
            printZeros = true;
            printSlashes = true;
          }
          //if (num == '0') {
          //  if (printZeros) sb.append(num);
          //  else sb.append(" ");
          //} else {
          //  sb.append(num);
          //  printZeros = true;
          //  printSlashes = true;
          //}
          for (int i = 0; i < firstNumLength; i++) {
            sb.append("|/ ");
            sb.append(matrix[(row-2)/4][i] % 10);
          }
          sb.append("| |");
          System.out.println(sb.toString());

        }

      }
    }
  }
}
