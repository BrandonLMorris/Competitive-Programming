/**
 * Game of Thrones - I
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/26/14.
 */
import java.util.*;
public class GameOfThronesI {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String pali = input.nextLine();
        char[] letters = new char[26];

        for(int i = 0; i < pali.length(); i++){
            letters[pali.charAt(i) - 'a']++;
        }

        int nonPairCounter = 0;                     //counts number of characters lack a pair. if > 1, string cannot be a palindrome
        for(int i = 0; i < letters.length; i++){
            if(letters[i]%2 != 0) nonPairCounter++;
        }

        System.out.println(nonPairCounter>1? "NO" : "YES");
    }
}
