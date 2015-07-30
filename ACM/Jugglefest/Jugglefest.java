import java.util.Scanner;

public class Jugglefest {
    public static boolean listFilled(char[] inputList) {
        boolean filled = true;
        for (char current : inputList) {
            if (current == '\0') {
                filled = false;
                break;
            }
        }

        return filled;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            String jugglePattern = input.nextLine();

            if (jugglePattern.equals("0")) {
                return;
            }

            Scanner patternScanner = new Scanner(jugglePattern);

            int period = patternScanner.nextInt();

            int[] pattern = new int[period];

            int index = 0;
            while (patternScanner.hasNextInt()) {
                pattern[index++] = patternScanner.nextInt();
            }

            char[] output = new char[20];
            char currentChar = 'A';
            int currentIndex = 0;
            boolean isCrash = false;
            while (!listFilled(output)) {
                for (int i = 0; i < output.length; i++) {
                    if (output[i] == '\0') {
                        currentIndex = i;
                        break;
                    }
                }

                while (currentIndex  < 20) {
                    if (output[currentIndex] != '\0') {
                        isCrash = true;
                        break;
                    } 

                    output[currentIndex] = currentChar;
                    currentIndex += pattern[currentIndex % period];
                }
                if (isCrash) {
                    break;
                }
                currentChar++;
            }

            if (isCrash) {
                System.out.println("CRASH");
            } else {
                for (char current : output) {
                    System.out.print(current);
                }
                System.out.println();
            }
        }
    }
}