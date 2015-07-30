import java.util.*;

public class DigitSolitaire {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int digits = input.nextInt();
        while(digits != 0) {
            while(digits > 9) {
                String digitsStr = ((Integer)digits).toString();
                System.out.print(digits + " ");
                int counter = Character.getNumericValue(digitsStr.charAt(0));
                for(int i = 1; i < digitsStr.length(); i++) {
                    counter *= Character.getNumericValue(digitsStr.charAt(i));
                }
                digits = counter;
            }

            System.out.println(digits);


            digits = input.nextInt();
        }
    }
}

//Character.getNumericValue(str.charAt(i));