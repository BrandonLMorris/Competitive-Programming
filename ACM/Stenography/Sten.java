import java.util.*;

/*
 *  Read input, counting even odd spaces as you go
 *  Build array list of char
*/

public class Sten {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (;;) {
          ArrayList<Character> bitSet = new ArrayList<Character>();

          for (;;) {
            String line = input.nextLine();
            if (line.equals("*")) break;
            if (line.equals("#")) return;

            int i = 0;
            while (i < line.length()) {
              if (line.charAt(i) == ' ') {
                int counter = 1;
                i++;
                while (line.charAt(i) == ' ') {
                  counter++;
                  i++;
                }
                //bitSet.add((counter % 2 == 0 ? '1' : '0'));
                if (counter % 2 == 0) {
                  bitSet.add('1');
                } else {
                  bitSet.add('0');
                }
              } else {
                i++;
              }
            }

          }


          // Add any padding
          while (bitSet.size() % 5 != 0) bitSet.add('0');


          int[] numSet = new int[bitSet.size()/5];
          for (int i = 0; i < bitSet.size(); i += 5) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
              sb.append(bitSet.get(i+j));
            }
            numSet[i/5] = Integer.parseInt(sb.toString(), 2);
          }


          StringBuilder sb = new StringBuilder();
          for (int i : numSet) {
            if (i == 0) sb.append(" ");
            if (i <= 26 && i >= 1) sb.append((char)('A'+(i-1)));
            if (i == 27) sb.append('\'');
            if (i == 28) sb.append(',');
            if (i == 29) sb.append('-');
            if (i == 30) sb.append('.');
            if (i == 31) sb.append('?');
          }

          System.out.println(sb.toString());

        }
    }
}
