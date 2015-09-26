import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Matches {

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    int numlines = Integer.parseInt(in.readLine());
    for (int t = 0; t < numlines; t++) {
      int n = Integer.parseInt(in.readLine());

      System.out.println(smallestNumber(n) + " " + biggestNumber(n));
    }

  }

  private static String biggestNumber(int n) {
    if (n == 2) return "1";
    if (n == 3) return "7";

    int oneCount = n / 2;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < oneCount; i++) sb.append("1");
    if (n % 2 == 0) {
      return sb.toString();
    }
    return "7" + sb.deleteCharAt(0).toString();
  }

  private static String smallestNumber(int n) {
    HashMap<Integer, String> digitForRemainder = new HashMap<Integer, String>();
    // digitForRemainder.put(1, "10");
    digitForRemainder.put(2, "1");
    digitForRemainder.put(3, "7");
    digitForRemainder.put(4, "4");
    digitForRemainder.put(5, "2");
    digitForRemainder.put(6, "6");
    digitForRemainder.put(7, "8");
    if (n <= 7) return digitForRemainder.get(n);

    if (n == 10) return "22";

    int eightCount = n / 7;
    int remain = n % 7;
    StringBuilder sb = new StringBuilder();
    if (remain == 0) {
      for (int i = 0; i < eightCount; i++) sb.append("8");
      return sb.toString();
    } else if (remain == 1) {
      sb.append("10");
      for (int i = 0; i < eightCount-1; i++) sb.append("8");
      return sb.toString();
    } else {
      ArrayList<String> strings = new ArrayList<String>();
      for (int i = 0; i <= eightCount; i++) {
        // Replace i 8's with zeros
        ArrayList<Character> cList = new ArrayList<Character>();
        for (int j = 0; j < eightCount-i; j++) cList.add('8');
        for (int j = 0; j < i; j++) cList.add('0');
        if (i + remain == 0 || i + remain > 7) continue;
        cList.add(digitForRemainder.get(i+remain).charAt(0));
        Collections.sort(cList);
        // Replace fist digit with nonzero
        if (cList.get(0) == '0') {
          boolean swapped = false;
          for (int r = 1; r < cList.size(); r++) {
            if (cList.get(r) != '0') {
              cList.set(0, cList.get(r));
              cList.set(r, '0');
              swapped = true;
              break;
            }
          }
          // String of only zeros isn't valid
          if (!swapped) continue;
        }
        StringBuilder sb2 = new StringBuilder();
        for (char c : cList) sb2.append(c + "");
        strings.add(sb2.toString());
      }
      String min = strings.get(0);
      for (String str : strings) {
        if (str.compareTo(min) < 0) {
          min = str;
        }
      }
      return min;
    }
  }
}