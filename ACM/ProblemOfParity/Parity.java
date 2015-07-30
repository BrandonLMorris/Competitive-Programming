import java.util.*;

public class Parity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (;;) {
            char[] line = input.nextLine().toCharArray();
            if (line[0] == '#') break;
            int oneCounter = 0;
            for (char c : line) {
                if (c == '1') oneCounter++;
            }
            switch (line[line.length-1]) {
                case 'e':
                    if (oneCounter % 2 == 0)
                        line[line.length-1] = '0';
                    else line[line.length-1] = '1';
                    break;
                case 'o':
                    if (oneCounter % 2 == 0)
                        line[line.length-1] = '1';
                    else line[line.length-1] = '0';
                    break;
            }
            System.out.println(new String(line));
        }
    }
}
