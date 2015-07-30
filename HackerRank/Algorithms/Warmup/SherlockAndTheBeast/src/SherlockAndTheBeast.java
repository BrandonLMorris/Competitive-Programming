/**
 * Sherlock and the Beast
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/26/14.
 */
import java.util.*;

public class SherlockAndTheBeast {

    public static final ArrayList<String> answers = new ArrayList<String>(10000);

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();
            StringBuilder answer = new StringBuilder(n);
            boolean foundDecent = false;
            for(int threes = 0; threes <= n; threes++){
                int fives = n-threes;
                if(threes%5==0 && fives%3==0){
                    foundDecent = true;
                    for(int j = 0; j<fives; j++){
                        //System.out.print("5");
                        answer.append('5');
                    }
                    for(int j = 0; j<threes; j++){
                        //System.out.print("3");
                        answer.append('3');
                    }
                    //System.out.print('\n');
                    System.out.println(answer);
                    break;
                }
            }
            if(!foundDecent) System.out.println("-1");
        }
    }
}
