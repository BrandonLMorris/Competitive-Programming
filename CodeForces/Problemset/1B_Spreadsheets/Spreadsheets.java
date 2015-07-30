import java.util.*;

public class Spreadsheets {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = Integer.parseInt(input.nextLine());
    for (int i = 0; i < numTests; i++) {
      String line = input.nextLine();
      //if (numTests > 100 && i < 840) continue;

      if (line.charAt(0) == 'R' && Character.isDigit(line.charAt(1)) && line.contains("C")) {
        StringBuilder sb = new StringBuilder();
        int j = 1;
        while (j < line.length() && line.charAt(j) != 'C') {
          sb.append(line.charAt(j));
          j++;
        }
        String row = sb.toString();

        j++;
        sb = new StringBuilder();
        while (j < line.length()) {
          sb.append(line.charAt(j));
          j++;
        }

        //if ((convertToAlpha(Integer.parseInt(sb.toString())) + row).equals("ACO595")) {
        //  String breakLine = input.nextLine();
        //  System.out.println("THIS ONE: " + breakLine);
        //}

        System.out.println(convertToAlpha(Integer.parseInt(sb.toString())) + row);

      } else {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (j < line.length() && Character.isLetter(line.charAt(j))) {
          sb.append(line.charAt(j));
          j++;
        }
        String col = sb.toString();

        sb = new StringBuilder();
        while (j < line.length()) {
          sb.append(line.charAt(j));
          j++;
        }

        System.out.println("R"+sb.toString()+"C"+convertToNumer(col));

      }
    }
  }

  public static String convertToAlpha(int col) {
    String result = "";
    int num = col - 1;
    if (num >= 26) result += convertToAlpha(num/26);
    return result + (char)('A' + (num%26));
  }

  public static String convertToNumer(String colString) {
    int counter = 0;
    for (int i = colString.length()-1; i >= 0; i--) {
      counter += Math.pow(26, colString.length()-1-i)*(colString.charAt(i)-'A'+1);
    }
    return ((Integer) counter).toString();
  }
}
