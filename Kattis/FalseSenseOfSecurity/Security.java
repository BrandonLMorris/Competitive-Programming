import java.util.*;

public class Security {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
      "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
      "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
      "--..", "..--", ".-.-", "---.", "----"};

    while (in.hasNext()) {
      String str = in.nextLine();
      int[] nums = new int[str.length()];
      StringBuilder fullCode = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == '_') {
          nums[i] = 4;
          fullCode.append(codes[26]);
        } else if (c == ',') {
          nums[i] = 4;
          fullCode.append(codes[27]);
        } else if (c == '.') {
          nums[i] = 4;
          fullCode.append(codes[28]);
        } else if (c == '?') {
          nums[i] = 4;
          fullCode.append(codes[29]);
        } else {
          nums[i] = codes[c - 'A'].length();
          fullCode.append((codes[c-'A']) + "");
        }
      }

      reverse(nums);

      StringBuilder sb = new StringBuilder();

      int i = 0;
      int numCount = 0;
      while (i < fullCode.length()) {
        StringBuilder tmp = new StringBuilder();
        for (int j = 0; j < nums[numCount]; j++) {
          tmp.append(fullCode.charAt(i)+"");
          i++;
        }
        numCount++;
        for (int j = 0; j < codes.length; j++) {
          if (tmp.toString().equals(codes[j])) {
            if (j < 26) {
              sb.append((char)(j+'A'));
            } else if (j == 26)
              sb.append("_");
            else if (j == 27)
              sb.append(",");
            else if (j == 28)
              sb.append(".");
            else if (j == 29)
              sb.append("?");

            break;
          }
        }

      }
      System.out.println(sb.toString());
    }
  }

  static void reverse(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      int tmp = arr[i];
      arr[i] = arr[arr.length-1-i];
      arr[arr.length-1-i] = tmp;
    }
  }
}
