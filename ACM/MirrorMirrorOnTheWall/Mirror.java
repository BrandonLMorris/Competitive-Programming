import java.util.*;

public class Mirror {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            char[] line = new StringBuilder(input.nextLine()).reverse().toString().toCharArray();

            if(line[0] == '#') break;

            boolean invalid = false;
            for (int i = 0; i < line.length; i++) {
                if (line[i] == 'd') {
                    line[i] = 'b';
                } else if (line[i] == 'b') {
                    line[i] = 'd';
                } else if (line[i] == 'p') {
                    line[i] = 'q';
                } else if (line[i] == 'q') {
                    line[i] = 'p';
                } else if (line[i] == 'i' || line[i] == 'o' || line[i] == 'v' || line[i] == 'w' || line[i] == 'x') {
                    //do nothing
                } else {
                    //System.out.println("Invalid set off by " + line[i]);
                    invalid = true;
                    break;
                }
            }

            if (invalid) {
                System.out.println("INVALID");
            } else {
                for(char c : line) {
                    System.out.print(c);
                }
                System.out.println();
            }

        }
    }
}

/*
 * b <=> d
 * p <=> q
 * i, o, v, w, x stay same
 */
