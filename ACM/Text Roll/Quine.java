import java.util.Scanner;

public class Quine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            String line = input.nextLine().trim();

            if (line.equals("END")) {
                return;
            }

            if (line.equals("") || line.charAt(0) != '\"') {
                System.out.println("not a quine");
                continue;
            }

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("\"");

            String first = "";
            String second = "";

            if (lineScanner.hasNext()) {
                first = lineScanner.next();
            } else {
                System.out.println("not a quine");
                continue;
            }

            if (lineScanner.hasNext()) {
                second = lineScanner.next();
            } else {
                System.out.println("not a quine");
                continue;
            }

            if (first.equals(second.trim())) {
                System.out.println("Quine(" + first + ")");
            } else {
                System.out.println("not a quine");
            }
        }
    }
}