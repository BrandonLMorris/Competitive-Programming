/**
 * The Love-Letter Mystery
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/24/14.
 */
import java.util.*;

public class LoveLetterMystery {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int t = Integer.parseInt(input.nextLine());

        for(int i = 0; i < t; i++){
            int counter = 0;
            String string = input.nextLine();
            for(int j = 0; j < (string.length()/2); j++){
                char frontChar = string.charAt(j);
                char backChar = string.charAt(string.length() - 1 - j);
                while(frontChar != backChar){
                    if(frontChar > backChar){
                        frontChar--;
                        counter++;
                    }
                    else{
                        backChar--;
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        }
    }
}
