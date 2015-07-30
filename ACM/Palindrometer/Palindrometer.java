import java.util.*;

public class Palindrometer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] odomChar = input.nextLine().toCharArray();

        while(true) {
            int[] odomInt = new int[odomChar.length];
            if(odomChar.length == 1 && odomChar[0] == '0') break;
            for(int i = 0; i < odomChar.length; i++) {
                odomInt[i] = odomChar[i] - '0';
            }

            int counter = 0;
            boolean palindrome = true;
            do{
                //assumes it is a palindrome unless otherwise specified
                palindrome = true;
                //check digit by digit
                for(int i = 0; i < (odomInt.length/2); i++) {
                    //if finds a difference, knows it is not a plaindrome and gets to work
                    if(odomInt[i] != odomInt[odomInt.length - 1 - i]) {
                        //resets so palindrome will be checked again upon completion
                        palindrome = false;
                        int difference = 0;
                        int left = odomInt[i];
                        int right = odomInt[odomInt.length - 1 - i];
                        //special case when the left is less than right
                        if(left < right) left += 10;
                        difference = left - right;
                        //right spot gets incremented by the difference
                        odomInt[odomInt.length-1-i] += difference;
                        //increments the counter
                        counter += difference * Math.pow(10, i);
                        //goes through and resets digits over 10
                        for(int j = odomInt.length-1; j >=0; j--) {
                            if(odomInt[j] >= 10) {
                                odomInt[j] -= 10;
                                odomInt[j-1]++;
                            }
                        }
                    }
                }
            } while(!palindrome);
                System.out.println(counter);

            odomChar = input.nextLine().toCharArray();
        }
    }
}
