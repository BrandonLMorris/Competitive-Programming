import java.util.*;
import java.io.*;

public class Base {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      st = new StringTokenizer(in.readLine());
      String firstOperand   = st.nextToken();
      String operation      = st.nextToken();
      String secondOperand  = st.nextToken();
      st.nextToken(); // Just an equals sign
      String result         = st.nextToken();
      StringBuilder sb = new StringBuilder();

      int start = findMinBase(firstOperand, secondOperand, result) + 1;
      for (int base = start; base <= 36; base++) {
        boolean valid = false;
        double first      = toDecimal(firstOperand, base);
        double second     = toDecimal(secondOperand, base);
        double resultDec  = toDecimal(result, base);
        switch (operation.charAt(0)) {
          case '+': valid = first + second == resultDec; break;
          case '-': valid = first - second == resultDec; break;
          case '*': valid = first * second == resultDec; break;
          case '/': valid = first / second == resultDec;
        }
        if (valid) {
          if (base < 10) {
            sb.append(base);
          } else if (base == 36) {
            sb.append('0');
          } else {
            char toAppend = (char)(base - 10 + 'a');
            sb.append(toAppend);
          }
        }
      }
      if (sb.toString().length() == 0) {
        System.out.println("invalid");
      } else {
        System.out.println(sb.toString());
      }
    }
  }

  // Find the minimum valid base for a set of three numbers
  private static int findMinBase(String first, String second, String third) {
    int max = 0;
    boolean unaryValid = true;      // Unary only possible if all 1's

    for (int i = 0; i < first.length(); i++) {
      char c = first.charAt(i);
      if (c >= '0' && c <= '9') {
        max = Math.max(max, c - '0');
      } else {
        max = Math.max(max, c - 'a' + 10);
      }
      if (unaryValid) unaryValid = c == '1';
    }
    for (int i = 0; i < second.length(); i++) {
      char c = second.charAt(i);
      if (c >= '0' && c <= '9') {
        max = Math.max(max, c - '0');
      } else {
        max = Math.max(max, c - 'a' + 10);
      }
      if (unaryValid) unaryValid = c == '1';
    }
    for (int i = 0; i < third.length(); i++) {
      char c = third.charAt(i);
      if (c >= '0' && c <= '9') {
        max = Math.max(max, c - '0');
      } else {
        max = Math.max(max, c - 'a' + 10);
      }
      if (unaryValid) unaryValid = c == '1';
    }

    if (unaryValid) return 0;
    return max;
  }

  // Convert a number from a given base to decimal
  private static double toDecimal(String str, int base) {
    double result = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(str.length()-1-i);
      int val = 0;
      if (c >= '0' && c <= '9') {
        val = c - '0';
      } else {
        val = c - 'a' + 10;
      }
      result += val * Math.pow(base, i);
    }
    return result;
  }
}