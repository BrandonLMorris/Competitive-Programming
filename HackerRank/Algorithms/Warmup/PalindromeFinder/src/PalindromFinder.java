/**
 * PalindromeFinder
 * Takes in word, tells weather a palindrome or not
 * Created by bmorris on 9/24/14.
 */
import java.util.*;

public class PalindromFinder {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 000 to exit");

        String word = input.nextLine();

        while(!(word.equals("000"))){
            boolean isPalindrome = true;

            //if(word.length() % 2 == 0){         //case of an even-lettered word
                for(int i = 0; i < word.length()/2; i++){
                    if(word.charAt(i) != word.charAt(word.length()-i-1)){
                        isPalindrome = false;
                    }
                }
           // }
//            else{                               //case of an odd-lettered word
//                for(int i = 0; i < word.length()/2; i++){
//                    if(word.charAt(i) != word.charAt(word.length()-i+1)){
//                        isPalindrome = false;
//                    }
//                }
//            }

            if(isPalindrome){
                System.out.println("The word is a palindrome");
            }
            else {
                System.out.println("The word is NOT a palindrome");
            }

            word = input.nextLine();
        }
    }
}
